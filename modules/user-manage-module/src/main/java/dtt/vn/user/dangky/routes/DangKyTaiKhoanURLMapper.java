package dtt.vn.user.dangky.routes;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
@Component(
        property = {
            "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/dangkyquytrinhroutes.xml",
            "javax.portlet.name=dtt_vn_user_dangky_DangKyTaiKhoanPortlet" 
        },
        service = FriendlyURLMapper.class
    )
public class DangKyTaiKhoanURLMapper extends DefaultFriendlyURLMapper{
	private static Log log = LogFactoryUtil.getLog(DangKyTaiKhoanURLMapper.class.getName());
	@Override
    public String getMapping() {
        return _MAPPING;
    }
    private static final String _MAPPING = "action";
}
