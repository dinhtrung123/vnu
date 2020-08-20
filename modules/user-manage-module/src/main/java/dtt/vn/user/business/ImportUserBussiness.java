package dtt.vn.user.business;

import java.util.List;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringBundler;

import dtt.vn.user.service.model.DataImport;

public class ImportUserBussiness {
	private static final Configuration _configuration = ConfigurationFactoryUtil
			.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");

	public String getMessageFromCode(String hasImport) {
		try {
			String message = _configuration.get("log.sms.messageId." + hasImport);
			if (message == null || message.equals("")) {
				return "";
			} else {
				return message;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";

	}

	public static byte[] exportCSVFile(List<DataImport> listData) {
		StringBundler sb = new StringBundler();
		sb.append("\uFEFF");
		String[] headers = { _configuration.get("idm.vnpost.import.csv.stt"),
				_configuration.get("idm.vnpost.import.csv.screenname"),
				_configuration.get("idm.vnpost.import.csv.lastname"), 
				_configuration.get("idm.vnpost.import.csv.email"),
				_configuration.get("idm.vnpost.import.csv.phone"),
				_configuration.get("idm.vnpost.import.csv.job"), 
				_configuration.get("idm.vnpost.import.csv.unit"),
				_configuration.get("idm.vnpost.import.csv.role"), 
				_configuration.get("idm.vnpost.import.csv.numberId"),
				_configuration.get("idm.vnpost.import.csv.hasImport"),
				_configuration.get("idm.vnpost.import.csv.errorMsg") };
		for (String s : headers) {
			sb.append(s);
			sb.append(",");
		}
		sb.setIndex(sb.index() - 1);
		sb.append(CharPool.NEW_LINE);

		int stt = 1;
		for (DataImport i : listData) {
			sb.append(stt++);
			sb.append(",");
			sb.append(i.getScreenName());
			sb.append(",");
			sb.append(i.getLastName());
			sb.append(",");
			sb.append(i.getEmailAddress());
			sb.append(",");
			sb.append(i.getPhone());
			sb.append(",");
			sb.append(i.getJobTitle());
			sb.append(",");
			sb.append(i.getUnit());
			sb.append(",");
			sb.append(i.getNameRole());
			sb.append(",");
			sb.append(i.getNumberId());
			sb.append(",");
			sb.append(i.getHasImport());
			sb.append(",");
			sb.append(i.getErrorMsg());
			sb.append(CharPool.NEW_LINE);

		}
		return sb.toString().getBytes();
	}
}
