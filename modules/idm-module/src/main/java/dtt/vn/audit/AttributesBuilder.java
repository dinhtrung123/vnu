package dtt.vn.audit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.liferay.portal.kernel.util.Validator;

import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
public class AttributesBuilder {
	public AttributesBuilder(Object newBean, Object oldBean) {
		_newBean = newBean;
		_oldBean = oldBean;
	}

	public void add(String name) throws ParseException {
		String newValue = String.valueOf(BeanPropertiesUtil.getObject(_newBean, name));
		String oldValue = String.valueOf(BeanPropertiesUtil.getObject(_oldBean, name));
		if (!Validator.equals(newValue, oldValue)) {
			Attribute attribute = new Attribute(name, newValue, oldValue);

			_attributes.add(attribute);
		}
	/*	if ("birthdate".equals(name)) {
			  SimpleDateFormat sdf_new = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
			  SimpleDateFormat sdf_old = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			  Date newdate = sdf_new.parse(newValue);
		      Date olddate = sdf_old.parse(oldValue);

				if(olddate.compareTo(newdate) != 0){
					Attribute attribute = new Attribute(name,DateUtil.convertDateToString(newdate, DateUtil.DATE_FORMAT_D_M_Y),DateUtil.convertDateToString(olddate, DateUtil.DATE_FORMAT_D_M_Y) );
	
					_attributes.add(attribute);
					
				}
		}else {

		 newValue = String.valueOf(BeanPropertiesUtil.getObject(_newBean, name));
		 oldValue = String.valueOf(BeanPropertiesUtil.getObject(_oldBean, name));
		
		if (!Validator.equals(newValue, oldValue)) {
			Attribute attribute = new Attribute(name, newValue, oldValue);

			_attributes.add(attribute);
		}
		}*/
	}

	public List<Attribute> getAttributes() {
		return _attributes;
	}

	private List<Attribute> _attributes = new ArrayList<Attribute>();
	private Object _newBean;
	private Object _oldBean;
}
