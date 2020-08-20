package dtt.vn.account.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class AccountDisplayTerms extends DisplayTerms {
	 
	private String fullName;
	private String email;
	private String telNo;
	private String personalId;
	private String address;
	public AccountDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		fullName = ParamUtil.getString(portletRequest, "fullName");
		email = ParamUtil.getString(portletRequest, "email");
		telNo = ParamUtil.getString(portletRequest, "telNo");
		personalId = ParamUtil.getString(portletRequest, "personalId");
		address = ParamUtil.getString(portletRequest, "address");
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getPersonalId() {
		return personalId;
	}
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
