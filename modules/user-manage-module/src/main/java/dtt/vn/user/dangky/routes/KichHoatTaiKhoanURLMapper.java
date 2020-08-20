package dtt.vn.user.dangky.routes;

import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

@Component(
        property = {
            "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/kichhoatroutes.xml",
            "javax.portlet.name=dtt_vn_user_dangky_kichhoat_KichHoatTaiKhoanPortlet" 
        },
        service = FriendlyURLMapper.class
    )
public class KichHoatTaiKhoanURLMapper extends DefaultFriendlyURLMapper{
	private static Log log = LogFactoryUtil.getLog(KichHoatTaiKhoanURLMapper.class.getName());
	@Override
    public String getMapping() {
        return _MAPPING;
    }
    private static final String _MAPPING = "kichhoatlai";
}
