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

package dtt.vn.vnpost.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.webserver.WebServerServletTokenUtil;

import aQute.bnd.annotation.ProviderType;
import dtt.vn.vnpost.model.Photo;
import dtt.vn.vnpost.service.PhotoLocalServiceUtil;

/**
 * The extended model implementation for the Account service. Represents a row in the &quot;account&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.vnpost.model.Account<code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class AccountImpl extends AccountBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a account model instance should use the {@link dtt.vn.vnpost.model.Account} interface instead.
	 */
	public AccountImpl() {
	}
public List<Photo> getPhotos() {
		
		List<Photo> photos = new ArrayList<Photo>();
		
		List<Photo> _photos = PhotoLocalServiceUtil.getPhotos(getAccountId());
		
		int cnt = 0;
		for (Photo photo: _photos) {
			photos.add(photo);
			cnt++;
			if (cnt == 4) break; 
		}
		
		if (cnt < 4) {
			for (int i=0;i<(4-cnt); i++) {
				photos.add(new PhotoImpl());
			}
		}
		
		return photos;
	}

	
	public List<Photo> getPhotos(String className ) {
		
		List<Photo> photos = new ArrayList<Photo>();
		
		List<Photo> _photos = PhotoLocalServiceUtil.getPhotos(getAccountId(), className);
		
/*		int cnt = 0;
		for (Photo photo: _photos) {
			photos.add(photo);
			cnt++;
			if (cnt == 4) break; 
		}
		
		if (cnt < 3) {
			for (int i=0;i<(3-cnt); i++) {
				photos.add(new PhotoImpl());
			}
		}*/
		
		return _photos;
	}
	
	public String getPhotoURL(ThemeDisplay themeDisplay, long imageId) {
		
		String photoURL = StringPool.BLANK;
				
		if (imageId > 0l) {
			StringBuilder sb = new StringBuilder()
				.append(themeDisplay.getPathImage())
				.append("/photo?img_id=")
				.append(imageId)
				.append("&t=")
				.append(WebServerServletTokenUtil.getToken(imageId));			
			
			photoURL = sb.toString();
		}
		
		return photoURL;
	}	

	public String getThumbnailURL(ThemeDisplay themeDisplay, long thumbnailId) {
		
		String thumbnailURL =StringPool.BLANK;
				
		if (thumbnailId > 0l) {
			StringBuilder sb = new StringBuilder()
				.append(themeDisplay.getPathImage())
				.append("/photo?img_id=")
				.append(thumbnailId)
				.append("&t=")
				.append(WebServerServletTokenUtil.getToken(thumbnailId));			
			
			thumbnailURL = sb.toString();
		}
		
		return thumbnailURL;
	}

}