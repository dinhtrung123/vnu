/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package dtt.vn.vnpost.service.impl;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.liferay.portal.kernel.exception.ImageResolutionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.Photo;
import dtt.vn.vnpost.service.account.IConstants;
import dtt.vn.vnpost.service.base.PhotoLocalServiceBaseImpl;

/**
 * The implementation of the photo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.vnpost.service.PhotoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhotoLocalServiceBaseImpl
 */
public class PhotoLocalServiceImpl extends PhotoLocalServiceBaseImpl {
	private static Log log = LogFactoryUtil.getLog(PhotoLocalServiceImpl.class);
	public Photo addPhoto(Photo photo, long accountId) throws SystemException{
		long imageId = counterLocalService.increment(Image.class.getName());
		photo.setImageId(imageId);
		photo.setClassPK(accountId);
		photo = super.addPhoto(photo);
		return photo;		
	}
	
	public Photo upload(long imageId, long accountId, File file, String className, String description, String message ) throws ImageResolutionException {
		
		Photo photo =  null;
		
		if (imageId == 0l) {
			try {
			imageId = counterLocalService.increment(Image.class.getName());
				photo = createPhoto(imageId);
				photo = addPhoto(photo, accountId);
				imageId = photo.getImageId();
				
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else {
			try {
				photo = fetchPhoto(imageId);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Image image;
			try {
				image = imageLocalService.updateImage(imageId, file);
				photo.setContentType(image.getType());
			} catch (PortalException e) {
				log.error(e.getMessage());
			}
			
		} catch (SystemException e) {
			log.error(e.getMessage());
		}
				
		photo.setUploadDate(new java.util.Date());
		photo.setClassName(className);
		photo.setClassPK(accountId);
		photo.setDescription(description);
		photo.setMessage(message);
		photo.setImageType(IConstants.IMG_TYPE_PHOTO);
		photo.setThumbnailId(0);
		
		try {
			photo = updatePhoto(photo);
		} catch (SystemException e) {
			log.error(e.getMessage());
		}
		
		createThumbnail(imageId);
		
/*		Message message = new Message();
		message.put("messageName", "createThumbnail");
		message.put("imageId", String.valueOf(imageId));
		MessageBusUtil.sendMessage("idm/destination", message);*/
		
		return photo;
	}
	
	
public long createThumbnail(long imageId) throws ImageResolutionException {
		
		Image image = null;
		try {
			image = imageLocalService.fetchImage(imageId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if (Validator.isNull(image)) return 0l;
		
		// optimize the original image
		/*float maximumWidth = GetterUtil.getFloat(PortletProps.get("profile.photo.maximum.width"));*/
		float maximumWidth = GetterUtil.getFloat(750);
		if (image.getWidth() > (int)maximumWidth) {
			minifyPhoto(image, imageId, maximumWidth);
		}
		
		long thumbnailId = imageId;
		
		// check the original width of the image. 
		/*float thumbnailWidth = GetterUtil.getFloat(PortletProps.get("profile.photo.thumbnail.width"));*/
		float thumbnailWidth = GetterUtil.getFloat(170);
		if (image.getWidth() > (int)thumbnailWidth) {
			try {
				thumbnailId = counterLocalService.increment(Image.class.getName());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			minifyPhoto(image, thumbnailId, thumbnailWidth);			
		} 
		
		Photo photo = null;
		try {
			photo = fetchPhoto(imageId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		photo.setThumbnailId(thumbnailId);
		
		try {
			updatePhoto(photo);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
	//	transferToS3(imageId);
		
		return thumbnailId;
	}



	private void minifyPhoto(Image image, long thumbnailId, float newWidth) throws ImageResolutionException {
		ImageBag imageBag = null;
		try {
			imageBag = ImageToolUtil.read(image.getTextObj());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Validator.isNull(imageBag)) return;
		
		RenderedImage renderedImage = imageBag.getRenderedImage();
		
		float reduceBy = (newWidth / (float) image.getWidth());
					
		long height = Math.round(image.getHeight() * reduceBy);
		long width = Math.round(image.getWidth() * reduceBy);
		renderedImage = ImageToolUtil.scale(renderedImage, (int) height, (int) width);
		
		byte[] bytes = null;
		try {
			bytes = ImageToolUtil.getBytes(renderedImage, image.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Validator.isNotNull(bytes)) {
			try {
				imageLocalService.updateImage(thumbnailId, bytes);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}
	

	
	public List<Photo> getPhotos(long accpuntId) {
		
		List<Photo> photos = null;
		
		try {
			photos = photoPersistence.findByClassNameClassPKImageType(Account.class.getName(), accpuntId, IConstants.IMG_TYPE_PHOTO);
		} catch (SystemException e) {
			e.printStackTrace();
		}		
		
		return photos;
	}
	

	
	@Override
	public Photo deletePhoto(Photo photo) throws SystemException {
		
		try {
			deletePhoto(photo.getImageId());
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return super.deletePhoto(photo);
	}
	
	public void approve(long imageId) {
		try {
			Photo photo = fetchPhoto(imageId);
			photo.setApproved(true);
			updatePhoto(photo);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public List<Photo> getPhotos(long profileId, String className) {
		
		List<Photo> photos = null;
		
		try {
			photos = photoPersistence.findByClassNameClassPKImageType(className, profileId, IConstants.IMG_TYPE_PHOTO);
		} catch (SystemException e) {
			e.printStackTrace();
		}		
		
		return photos;
	}
public List<Photo> getPhotosbyClassname_classPK(String classname, long classpk) {
		
		List<Photo> photos = null;
		
		try {
			photos = photoPersistence.findByClassNameClassPK(classname, classpk);
		} catch (SystemException e) {
			e.printStackTrace();
		}		
		
		return photos;
	}

public List<Photo> getPhotobyClassName(String className){
	List<Photo> photos = null;
	try {
		photos = photoPersistence.findByClassName(className);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return photos;
}

public List<Photo> getPhotoByClassPK(String classPK){
	List<Photo> photos = null;
	try {
		photos = photoPersistence.findByClassPK(Long.parseLong(classPK));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return photos;
}

public List<Photo> getPhotosbyImageType_classPK(int imagetype, long classpk, int start, int end) {
	
	List<Photo> photos = null;
	
	try {
		photos = photoPersistence.findByImageTypeClassPK(imagetype, classpk, start, end);
	} catch (SystemException e) {
		e.printStackTrace();
	}		
	
	return photos;
}

}