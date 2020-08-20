package dtt.vn.audit.listener;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import dtt.vn.audit.AuditMessageBuilder;
import dtt.vn.audit.EventTypes;
import dtt.vn.audit.model.AuditEvent;
import dtt.vn.vnpost.model.Photo;
@Component(
		immediate = true,
	    service = ModelListener.class
	)
public class PhotoListener extends BaseModelListener<Photo>{
	
	@Override
	public void onAfterUpdate(Photo model) throws ModelListenerException {
		// TODO Auto-generated method stub
		System.out.println("update photo");
		super.onAfterUpdate(model);
	}
	@Override
	public void onAfterRemove(Photo model) throws ModelListenerException {
		// TODO Auto-generated method stub
		System.out.println("delete photo");
		super.onAfterRemove(model);
	}
	@Override
	public void onAfterCreate(Photo model) throws ModelListenerException {
		// TODO Auto-generated method stub
		System.out.println("create photo");
		super.onAfterCreate(model);
	}
	/*@Override
	public void onAfterRemove(Photo model) throws ModelListenerException {
		auditOnCreateOrRemove(EventTypes.DELETE, model);	
	}

	@Override
	public void onAfterUpdate(Photo model) throws ModelListenerException {
		try {
			JSONObject messageJSON = JSONFactoryUtil.createJSONObject(model.getMessage());
				if (model.getThumbnailId()== 0) {
					AuditEvent auditMessage = AuditMessageBuilder.buildAuditMessage(EventTypes.UPDATE,"Account",model.getImageId(), model.getMessage(),null);

				}
			} catch (Exception  e) {
				throw new ModelListenerException(e);		
		}
	
	}

	protected void auditOnCreateOrRemove(String eventType, Photo photo) throws ModelListenerException {

		try {
			AuditEvent auditMessage = AuditMessageBuilder.buildAuditMessage(eventType, "Account",
					photo.getImageId(),photo.getMessage(), null);

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}*/
}
