package org.oep.danhmuc.portlet.quanly.configuration;
import aQute.bnd.annotation.metatype.Meta;
/**
 * 
 * (1) Meta.OCD: Registers this class as a configuration with a specific id. We can choose any string we want, but it should be unique.
 *  A common pattern is to use the fully qualified class name.
 *
 * (2) Meta.AD: This represent the default value of a configuration field as well as whether it�s required or not. 
 * Note that if we set a field as required and don�t specify a default value, the system administrator must specify 
 * a value in order for your application to work properly. Use the deflt property to specify a default value.
 * 
 * (3)id = "com.proliferay.configuration.DemoConfiguration" represents the configuration id which will be reffred from other classes.
 * This is a unique id. A common pattern is to use the fully qualified class name of the interface for the ID since fully
 * qualified class names are unique
 * 
 * (4) To specify that a field is optional, set required=false
 * 
 * (5) @Meta.OCD,@Meta.AD are part of biz.aQute.bndlib-3.1.0-sources.jar file. Check the pom.xml
 * 
 * (6) For more information on meta type http://bnd.bndtools.org/chapters/210-metatype.html 
 * 
 * (7)We must add  -metatype: * 
 * in our bnd.bnd file to include this metatype in the final bundle Once the bundle is created
 * it will include DemoConfiguration.xml under OSGI-INF\metatype
 * 
 * (8)The configuration will create one User Interface in the Liferay Control Panel
 * where we can set our configuration values 
 */
@Meta.OCD(  
		id = "org.oep.danhmuc.portlet.quanly.configuration.QuanLyConfiguration",
		localization = "content/language_quanly"
	)
public interface QuanLyConfiguration {
	public static final String NHOM_DANH_MUC ="cauHinhNhomDanhMuc";
	 @Meta.AD(required = false)

	 public String getNhomDanhMuc();

}
