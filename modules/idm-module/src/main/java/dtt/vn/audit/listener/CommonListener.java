package dtt.vn.audit.listener;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import dtt.vn.vnpost.service.PhotoLocalServiceUtil;
@Component(
		immediate = true,
	    service = MessageListener.class
	)
public class CommonListener extends BaseMessageListener{
	@Override
	protected void doReceive(Message message) throws Exception {

		String messageName = (String)message.get("messageName");
		System.out.println("messageName "+ messageName);
		
		if (messageName.equalsIgnoreCase("createThumbnail")) {
			long imageId = message.getLong("imageId");			
			PhotoLocalServiceUtil.createThumbnail(imageId);
		}
	}
}
