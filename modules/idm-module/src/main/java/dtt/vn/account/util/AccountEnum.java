package dtt.vn.account.util;

public enum AccountEnum {
	fullname("FULLNAME"), birthdate("BIRTHDATE"), telNo("TELNO"), 
	email("EMAIL"), personalId("PERSONALID"), address("ADDRESS"),
	gender("GENDER"), taxCode("TAXCODE"), insuranceCode("INSURANCECODE"),
	nationality("NATIONALITY"), ethnicGroup("ETHNICGROUP"), familyRegNo("FAMILYREGNO"),
	maritalStatus("MARITALSTATUS"), workingPlace("WORKINGPLACE"), nativePlace("NATIVEPLACE");
	

	    private final String val;

	    AccountEnum(String val) {
	    this.val = val;
	    }

	    public String getVal() {
	    return val;
	    }
	    
	    
	    public static void main(String[] args) {
	    	for(AccountEnum env : AccountEnum.values())
	    	{
	    	    System.out.println(env.name() + " :: "+ env.getVal());
	    	}
	    }	    
}
