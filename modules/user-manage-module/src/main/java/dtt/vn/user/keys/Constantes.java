package dtt.vn.user.keys;

public class Constantes {
	
	public class IpLevel {
		public static final int MUC_1 = 1;
		public static final int MUC_2 = 2;
		public static final int MUC_3 = 3;
		public static final int MUC_4 = 4;
	}
	
	public class Gender {
		public static final int NAM = 1;
		public static final int NU = 0;
	}
	
	public class AccountType {
		public static final int CONG_DAN = 1;
		public static final int TO_CHUC = 2;
	}
	
	// Field descriptor #6 Ljava/lang/String;
	public static final java.lang.String MA = "DMDC_DVHC";
	  
	// Field descriptor #11 I
	public static final int MUC_TINH = 1;
	  
	// Field descriptor #11 I
	public static final int MUC_HUYEN = 2;
	  
	// Field descriptor #11 I
	public static final int MUC_XA = 3;
	
	public static final int ALL_USER = 0;
	
	public static final String SEARCH_CONTAINER_RESULT_ROW = "SEARCH_CONTAINER_RESULT_ROW";
	
	public static final String CMD = "cmd";
	public static final String ACAO = "acao";
	
	public static final String DELETE = "delete";
	public static final String ADD = "add";
	public static final String UPDATE = "update";
	
	public static final String SAVE = "save";
	public static final String SAVE_ACCOUNT = "saveAccount";
	
	public interface Status{
		public static final int DANG_XAC_MINH = 1;
		public static final int DA_XAC_MINH = 2;
		public static final int KHONG_XAC_MINH = 3;
	 
	}
	public interface XuLy{
		public static final int DOI_PHAN_CONG = 1;
		public static final int XULY = 2;
		public static final int PHE_DUYET = 3;
		public static final int KET_THUC = 4;
	}
	public class TrangThaiKeys {
		public static final int Cho_Xy_Ly = 0;
		public static final int Cho_Phan_Cong = 1;
		public static final int Cho_Xac_Minh = 2;
		public static final int Dang_Xac_Minh = 3;
		public static final int Cho_Phe_Duyet = 4;
		public static final int Cho_Tra_KQ_Khong_Hop_Le = 5;
		public static final int Cho_Tra_Chung_Nhan_DD = 6;
		public static final int Da_Tra_KQ_Khong_Hop_Le = 7;
		public static final int Da_Tra_Chung_Nhan_DD = 8;
	}
	
	public interface Level{
		public static final int NEW = 1;
		public static final int EMAIL_VERIFY = 2;
		public static final int CMT_VERIFY = 3;
		public static final int LAST_VERIFY = 4;
	}
	public class WorkItem {
		public class Title {
			public static final String TAO_MOI = "Tạo mới";
			
		}
		public class STATUS {
			public static final String NEW = "NEW";
		}
	}


}
