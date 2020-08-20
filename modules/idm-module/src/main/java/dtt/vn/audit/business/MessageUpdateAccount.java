package dtt.vn.audit.business;

public class MessageUpdateAccount {
	public String nameField = "";
	public String valueOld  = "";
	public String valuenew  = "";
	public boolean isUpdate = true;
	public MessageUpdateAccount(String nameField, String valueOld, String valuenew, boolean isUpdate) {
		super();
		this.nameField = nameField;
		this.valueOld = valueOld;
		this.valuenew = valuenew;
		this.isUpdate = isUpdate;
	}
	
	
}
