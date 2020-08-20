package dtt.vn.account.util;

public final class CommonConstants {

	/** BOOLEAN **/
	public static final boolean TRUE = true;
	public static final boolean FALSE = false;
	/** STRING **/
	//----------- START STRING -------------------//
	public static final String SPACE = " ";
	public static final String DASK = "_";
	public static final String DASH = "-";
	public static final String DOT = ".";
	public static final String COLON = ":";
	public static final String STRING_0 = "0";
	public static final String STRING_1 = "1";
	public static final String STRING_2 = "2";
	public static final String STRING_3 = "3";
	public static final String STRING_4 = "4";
	public static final String STRING_5 = "5";
	public static final String STRING_01 = "01";
	public static final String STRING_02 = "02";
	public static final String STRING_03 = "03";
	public static final String STRING_04 = "04";
	public static final String STRING_05 = "05";
	public static final String STRING_200 = "200";
	public static final String STRING_TRUE = "true";
	public static final String STRING_FALSE = "false";
	public static final String FLAG_YES = "1";
	public static final String FLAG_NO = "0";
	public static final String slash = "/";
	public static final String STRING_SPECIAL = "_$$_";
	
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	public static final String WARNING = "WARNING";
	public static final String PENDDING = "Pending";
	public static final String STARTTING = "Starting";
	public static final String STOPPED = "Stopped";

	public static final String COMMA = ",";
	public static final String HTML_NEW_LINE = "<br/>";
	public static final String FOLDER_HOME = "Home";
	public static final String THUMB_IMAGE = "thumbImage";
	
	public static final String EDIT = "edit";
	public static final String DELETE = "delete";

	public static final String [] questionListHeaderKeys = {
		"portlet.answeredquestions.header.stt", 
		"portlet.answeredquestions.header.cauhoi",
		"portlet.answeredquestions.header.nguoihoi",
		"portlet.answeredquestions.header.ngayhoi",
		"common.questionAnswer.answerOrganization"};
	
	public static final String [] assessListHeaderKeys = {
		"portlet.assessStaffList.header.assess_stt", 
		"portlet.assessStaffList.header.assess_emp",
	};
	
	public static final String [] equimentHeaderKeys = {
		"portlet.equitment.header.assess_stt", 
		"portlet.equitment.header.equitment_name",
		"portlet.equitment.header.equitment_status",
		"portlet.equitment.header.create_date",
	};
	
	public static final String[] questionList = {
		"portlet.questionLists.header.ques_stt",
		"portlet.questionLists.header.ques_title",
		"portlet.questionLists.header.ques_cityzen",
		"portlet.questionLists.header.ques_date_create",
		"portlet.questionLists.header.ques_status",
	};
	
	public static final String[] privateMessengerList = {
		//"portlet.questionLists.header.ques_stt",
		"common.message.subject",
		"common.message.sender",
		"common.message.reciever",
		"common.message.status"
		//"portlet.messengerLists.header.messenger_markAsRead"
	};
	public static final String[] citizenCommentList = {
		"portlet.citizencomment.table.header.name",
		"portlet.citizencomment.table.header.age",
		"portlet.citizencomment.table.header.adress",
		"portlet.citizencomment.table.header.phone",
		"portlet.citizencomment.table.header.content",
	};
	
	public static final String[] assessStaffList = {
		"portlet.assessStaffList.header.assess_stt",
		"portlet.assessStaffList.header.assess_emp",
		"portlet.assessStaffList.header.assess_organization",
		"portlet.assessStaffList.header.assess_date_create",
		"portlet.assessStaffList.header.assess_status",
	};
	
	public static final String[] userList = {
		"portlet.useraccess.header.stt",
		"portlet.useraccess.header.userid",
		"portlet.useraccess.header.emailaddress",
		"portlet.useraccess.header.lastloginip",
		"portlet.useraccess.header.lastlogindate"
	};
	public static final String[] departUserList = {
		"portlet.report.statistics.bieumau.table.departname",
		"portlet.report.statistics.bieumau.table.stt",
		"portlet.report.statistics.bieumau.table.name",
		"portlet.report.statistics.bieumau.table.email",
		"portlet.report.statistics.bieumau.table.phone",
		"portlet.report.statistics.bieumau.table.role"
	};
	public static final String[] fileList = {
		"portlet.report.statistics.bieumau.table.stt",
		"portlet.report.statistics.bieumau.table.fileName",
		"portlet.report.statistics.bieumau.table.fileType",
		"portlet.report.statistics.bieumau.table.fileSize",
		"portlet.report.statistics.bieumau.table.fileCreateDate",
		"portlet.report.statistics.bieumau.table.fileUserUpload"
	};
	public static final String[] investmentList = {
		"portlet.investmentanddevelopment.header.ques_stt",
		"portlet.investmentanddevelopment.header.investmentname",
	};
	
	public static final String[] investmentAdminHeaderKeys = {
		"portlet.investmentadmin.table.header.stt",
		"portlet.investmentadmin.table.header.investmentname",
		"portlet.investmentadmin.table.header.action"
	};
	
	public static final String [] staffInfoListHeaderKeys = {"portlet.search-staff.search.headerlist.stt",
		"portlet.search-staff.search.headerlist.name",
		"portlet.search-staff.search.headerlist.phone",
		"portlet.search-staff.search.headerlist.email",
		"portlet.search-staff.search.headerlist.posittion"};
	
	public static final String [] onlinePublicServiceHeaderKeys = {"portlet.onlinePublicService.headerlist.stt",
		"portlet.onlinePublicService.headerlist.numberOfProfile",
		"portlet.onlinePublicService.headerlist.userName",
		"portlet.onlinePublicService.headerlist.ititDate",
		"portlet.onlinePublicService.headerlist.returnDate",
		"portlet.onlinePublicService.headerlist.state"};

	public static String[] scheduleListHeaderKeys = {
		"portlet.schedule.header.userName"
		, "day.monday"
		, "day.tuesday"
		, "day.wednesday"
		, "day.thursday"
		, "day.friday"
	};
	
	public static String[] publicNewsListHeaderKeys = {
		"portlet.public_news.table.header.public_new_number",
		"portlet.public_news.table.header.number",
		"portlet.public_news.table.header.date_publish",
		"portlet.public_news.table.header.title"
	};
	
	public static String[] PublicAdministrationProcedure = {
		"portlet.publicadministrationprocedure.table.header.title",
		"portlet.publicadministrationprocedure.table.header.organizations",
		"portlet.publicadministrationprocedure.table.header.fields",
		"portlet.publicadministrationprocedure.table.header.level"
	};
	public static String[] AdminDevices = {
		"portlet.admindevices.table.header.device.id",
		"portlet.admindevices.table.header.device.name",
		"portlet.admindevices.table.header.device.state",
		"portlet.admindevices.table.header.device.status",
	};
	
	public static String[] ManageEquiment = {
		"portlet.manageequiemt.table.header.stt",
		"portlet.manageequiemt.table.header.title",
		"portlet.manageequiemt.table.header.booking.date",
		"portlet.manageequiemt.table.header.booking.to.date",
		"portlet.manageequiemt.table.header.status"
	};
	
	
	public static final String[] LEGAL_DOCUMENT_BYDOMAIN_HEADER_KEYS = {
		"portlet.common.no",
		"portlet.legaldocument.bydomain.name",
	};

	public static String scheduleHeaderDateFormat = "portlet.schedule.header.dateformat";
	public static String dateFormat = "portlet.schedule.title.dateformat";
	public static String MODIFIED_DATE = "modifiedDate";
	
	public static String[] legalDocumentsListHeaderKeys = {
		"dialogue.portlet.header.title.no",
		"portlet.legal_documents.table.header.doc_symbols",
		"portlet.legal_documents.table.header.description",
		"portlet.legal_documents.table.header.datestatus",
		"portlet.legal_documents.table.header.download"
	};
	
	public static String[] OperatingDocumentsListHeaderKeys = {
		"portlet.legal_documents.table.header.doc_symbols",
		"portlet.legal_documents.table.header.description",
		"portlet.legal_documents.table.header.domain",
		"portlet.legal_documents.table.header.dateTime",
		"portlet.legal_documents.table.header.download"
	};
	
	public static String[] Meetings = {
		"portlet.recommendation.table.header.stt",
		"title",
		"locations",
		"time",
		"portlet.legal_documents.table.header.download"
	};
	
	public static String[] Docs = {
		"portlet.admin.docs.label.search.symbol",
		"portlet.admin.docs.table.header.content",
		"portlet.admin.docs.table.header.publishdate",
		"portlet.admin.docs.table.header.type",
		"portlet.admin.docs.table.header.create",
		"portlet.admin.docs.table.header.edit",
		"portlet.admin.docs.label.search.status"
	};
	
	public static String[] ExemDocs = {
		"portlet.admin.exemdocs.table.header.symbol",
		"portlet.admin.exemdocs.table.header.copy",
		"portlet.admin.exemdocs.table.header.content",
		"portlet.admin.exemdocs.table.header.publishdate",
		"portlet.admin.exemdocs.table.header.type",
		"portlet.admin.exemdocs.table.header.status"
	};
	
	public static String[] ExemDocs_view = {
		"portlet.recommendation.table.header.stt",
		"portlet.admin.exemdocs.table.header.symbol",
		"portlet.admin.exemdocs.table.header.copy",
		"portlet.legal_documents.table.header.description",
		"portlet.legal_documents.table.header.dateTime",
		"portlet.legal_documents.table.header.download"
	};
	
	public static String[] PublicAnnouncement = {
		"portlet.admin.public_annouce.table.header.no",
		"portlet.admin.docs.label.search.symbol",
		"portlet.admin.docs.table.header.content",
		"portlet.admin.docs.table.header.publishdate",
		"portlet.admin.docs.table.header.type",
		"portlet.admin.docs.table.header.create",
		"portlet.admin.docs.table.header.edit",
		"portlet.admin.docs.label.search.status"
	};
	public static String[] NumOfPublicAnnounce = {
		"portlet.recommendation.table.header.stt",
		"portlet.admin.public_annouce.table.header.num",
		"portlet.admin.public_annouce.table.header.publishdate",
		"portlet.admin.public_annouce.table.header.createdate",
		"portlet.admin.public_annouce.table.header.editdate",
		"portlet.admin.public_annouce.table.header.user"
	};
	public static String[] WorkingSheduleMonthy = {
		"portlet.recommendation.table.header.stt",
		"citizens.reception.schedule.management.portlet.boss",
		"portlet.schedule.month",
		"portlet.schedule.year",
		"portlet.admin.public_annouce.table.header.createdate",
		"portlet.admin.docs.label.attach.name",
		"portlet.legal_documents.table.header.download"
	};
	public static String[] WorkingSheduleMonthly = {
		"portlet.recommendation.table.header.stt",
		"portlet.admin.docs.label.attach.name",
		"portlet.schedule.month",
		"portlet.schedule.year",
		"portlet.admin.public_annouce.table.header.createdate",
		"portlet.legal_documents.table.header.download"
	};
	
	public static String[] Departments = {
		"portlet.recommendation.table.header.stt",
		"Tên tổ chức - Phòng ban",
		"Trực thuộc"
	};
	
	public static String[] Legals = {
		"portlet.admin.docs.label.search.symbol",
		"portlet.admin.docs.table.header.content",
		"portlet.admin.legal.table.header.date",
		"portlet.admin.docs.table.header.type",
		"portlet.admin.docs.table.header.create",
		"portlet.admin.docs.table.header.edit",
		"portlet.admin.docs.label.search.status"
	};
		
	public static String[] RecommendationListHeaderKeys = {
		"portlet.recommendation.table.header.stt",
		"portlet.recommendation.table.header.name",
		"portlet.recommendation.table.header.content",
		"portlet.recommendation.table.header.date",
	};
	
	public static String[] GettingCommentListHeaderKeys = {
		"portlet.gettingcommentmanagement.table.header.stt",
		"portlet.gettingcommentmanagement.table.header.name",
		"portlet.gettingcommentmanagement.table.header.datetime",
		"portlet.gettingcommentmanagement.table.header.detail"
	};
	public static String[] GettingCommentManagementHeaderKeys = {
		"portlet.gettingcommentmanagement.table.header.stt",
		"portlet.gettingcommentmanagement.table.header.name",
		"portlet.gettingcommentmanagement.table.header.datetime",
		"portlet.gettingcommentmanagement.table.header.detail",
		"portlet.staff.asessment.admin.table.header.status"
	};
	
	public static String[] FeedbackManagementHeaderKeys = {
		"portlet.feedbackmanagement.table.thead.no",
		"portlet.feedbackmanagement.table.thead.title",
		"portlet.feedbackmanagement.table.thead.field",
		"portlet.feedbackmanagement.table.thead.type",
		"portlet.feedbackmanagement.table.thead.fromdate",
		"portlet.feedbackmanagement.table.thead.toDate",
		"portlet.feedbackmanagement.table.thead.status",
		"portlet.feedbackmanagement.table.thead.statistic"
	};
	
	public static String[] CitizenCommentHeaderKeys = {
		"portlet.gettingcommentmanagement.table.header.stt",
		"portlet.gettingcommentmanagement.table.header.comment.name",
		"portlet.gettingcommentmanagement.table.header.comment.info",
		"portlet.gettingcommentmanagement.table.header.comment.content",
		"portlet.gettingcommentmanagement.table.header.comment.status"
	};
	
	public static String[] department = {
		"Thư�?ng trực Tỉnh ủy","Thư�?ng trực H�?ND tỉnh","Thư�?ng trực UBND tỉnh","BCH �?ảng bộ tỉnh khóa XVIII","Danh bạ điện tử của các cơ quan, đơn vị",
		"Văn phòng Tỉnh ủy","Văn phòng UBND tỉnh","Sở Kế hoạch �?ầu tư","Sở Tư pháp","Sở Y tế",
		"Sở Văn hoá, Thể thao và Du lịch","Sở Tài chính","Sở Nông nghiệp và PTNT","Sở Lao động Thương binh Xã Hội","Sở Khoa h�?c công nghệ",
		"Sở Giao thông Vận tải","Sở Giáo dục và �?ào tạo","Sở Nội vụ","Sở Tài nguyên và Môi trư�?ng","Sở Xây dựng",
		"Sở Thông tin và Truy�?n thông","Sở Công Thương","Ban Quản lý khu Công nghiệp","Thanh tra tỉnh","�?ài Phát thanh và Truy�?n hình",
		"Hội Liên hiệp phụ nữ","Uỷ ban Mặt trận Tổ quốc tỉnh","Huyện Yên Phong","Huyện Tiên Du","Thị xã Từ Sơn",
		"Thành Phố Bắc Ninh","Huyện Quế Võ","Huyện Gia Bình","Huyện Lương Tài","Huyện Thuận Thành",
		"Ban Chỉ đạo CNTT tỉnh","Cục Thống kê","Trư�?ng Chính Trị Nguyễn Văn Cừ"
	};
	
	public static String[] contactListHeaderKeys = {
		"portlet.contact.table.header.stt",
		"portlet.contact.table.header.name",
		"portlet.contact.table.header.email",
		"portlet.contact.department"
	};
	
	public static String[] OnlineDialogue = {
		"dialogue.table.header.title.stt",
		"dialogue.table.header.title.name",
		"portlet.report.statistics.time",
	};
	
	public static String[] OnlineDialogueManagement = {
		"dialogue.table.header.title.stt",
		"dialogue.table.header.title.name",
		"search.dialogue.portlet.table.header.title.status",
		"portlet.report.statistics.time",
	};
	public static String[] OnlineDialogueQuestion = {
		"dialogue.table.header.title.stt",
		"portlet.questionsubmit.citizenname",
		"portlet.publicadministrationprocedure.content.search"
	};
	
	public static String[] LandManagement = {
		"portlet.landmanagement.typeland.no",
		"portlet.landmanagement.land.table.name",
	};
	public static String LAND_PRICE_YEAR = "LandPrice-Year";
	public static String USER_GROUP_MANAGER = "Giám đốc";
	public static String USER_GROUP_LEADER = "Trưởng phòng";
	
	public static final int RECORDS_PER_PAGE = 5;
	public static final int QUESTIONS_PER_PAGE = 10;
	public static final int SEARCH_STAFFINFO_PER_PAGE = 5;
	public static final int PUBLIC_NEWS_PER_PAGE = 20;
	public static final int PUBLICADMINISTRATIONPROCEDURE_PER_PAGE = 10;
	public static final int	LEGAL_DOCUMENT_PER_PAGE = 25;
	public static final int PROJECTS_PER_PAGE = 5;
	public static final int MARKET_INFO_PER_PAGE = 10;
	public static final int OPERATOR_STEERING_PER_PAGE = 2;
	public static final int ADMIN_DEVICES = 5;
	/** MSG ID**/
	//-----------START MSG ID ----------
	public static final String MSG_SUCCESS = "success";
	public static final String MSG_ERROR = "error";
	public static final String MSG_NO_RESULT = "noresult";
	//-----------END MSG ID ----------
	/** NUMBER **/
	//------- START NUMBER ---------------//
	public static final int NUM_0 = 0;
	public static final int NUM_1 = 1;
	public static final int NUM_2 = 2;
	public static final int NUM_3 = 3;
	public static final int NUM_4 = 4;
	public static final int NUM_5 = 5;
	public static final int NUM_6 = 6;
	public static final int NUM_7 = 7;
	public static final int NUM_8 = 8;
	public static final int NUM_9 = 9;
	public static final int NUM_10 = 10;
	//------- END NUMBER ---------------//

	public static final String DATE_FORMAT_EN = "yyyy/MM/dd";
	public static final String DATE_FORMAT_QUERY = "yyyy-MM-dd";
	public static final String DATE_FORMAT_VI = "dd/MM/yyyy";
	
	public static final String HTML_TAG_TEXTAREA = "textarea";
	public static final String HTML_TAG_TEXTBOX = "input";
	
	public static final String GROUP_ID = "groupId";
	public static final String FILE_ENTRY_TYPE_ID = "fileEntryTypeId";
	public static final String FILE_ENTRY_ID = "fileEntryId";
	public static final String CREATE_DATE = "createDate";
	public static final String PREFS_IMAGE_DISPLAYED_IDS = "ImageDisplayedIds";
	public static final String PREFS_IMAGE_DISPLAYED_URLS = "ImageDisplayedUrls";
	public static final String PREFS_VIDEO_DISPLAYED_IDS = "VideoDisplayedIds";
	public static final String PREFS_DURATION_TIME = "DurationTime";
	public static final String PREFS_URL_LINK = "UrlLink";
	public static final String PREFS_TYPE_DATA = "TypeData";
	public static final String PREFS_IMAGE_WIDTH = "ImageWidth";
	public static final String PREFS_IMAGE_HEIGH = "ImageHeigh";
	public static final String PORTLET_RESOURCE = "portletResource";
	public static final String JSON_STATUS_SUCCESS = "success";
	public static final String JSON_STATUS_FAIL = "fail";

	public final class STRUCTURE {
//		public static final String VIDEO_STRUCTURE_ID = "48403";//
//		public static final long GROUP_ID = 10184;/*10180*/
//		public static final long COMPANY_ID = 10157;//
//		public static final String NEW_STRUCTURE_ID = "18744";//
//		public static final String NEWS_BOX_BN_STRUCTURE_ID = "73507";//
//		public static final String LEGAL_DOCUMENT_STRUCTURE_ID = "75804";//
//		public static final String VISITOR_BN_STRUCTURE_ID = "73310";//
		/** ++ START Link Page*/
//		public static final String LINK_PAGE_STRUCTURE_ID = "58902";/*19411  - grId 10184 - strcId 19412*/
//		public static final String LINK_PAGE_STRUCTURE_KEY = "19411";/*19411  - grId 10184 - strcId 19412*/
//		public static final long LINK_PAGE_GROUP_ID = 10184;//
		/** -- END Link Page*/
	}
	
	public interface DOCUMENTMEDIA {
		String[] PICTURE_MIME_TYPE = {"image/gif", "image/jpeg", "image/png", "image/bmp"};
		String[] VIDEO_MIME_TYPE = {"video/x-flv", "video/mp4", "video/x-ms-wmv"};
		String[] PICTURE_VIDEO_MIME_TYPE = {"image/gif", "image/jpeg", "image/png", "image/bmp", "video/x-flv", "video/mp4", "video/x-ms-wmv"};
//		Long ADVERTISEMENT_FILE_ENTRY_TYPE_ID = 22302L;
//		Long MAP_FILE_ENTRY_TYPE_ID = 50336L;
	}
	
	public final class JOURNALARTICALFIELDS {
		public static final String IMAGE_PATH = "/image/journal/article?img_id=";
		public static final String IMG_DESCRIPTION = "img_description";
		public static final String TEXT_DESCRIPTION = "text_description";
		public static final String CONTENT = "content";
		public static final String CATEGORY = "category";
		public static final String ORGANIZATION = "organization";
	}

	public final class PAGING {
		public static final int RECORDS_PER_PAGE = 6;
		public static final String NUMBER_OF_PAGE = "numOfPage";
		public static final String NUMBER_PER_PAGE = "numPerPage";
		public static final String RECORD_PER_PAGE = "recordPerPage";
		public static final String CURRENT_PAGE_STATUS = "curPageStatusText";
		public static final int DEFAULT_PAGE_RANGE = 5;
		public static final String PAGE_NUM = "pageNum";
		public static final String ITEMS_PER_PAGE_TEXT = "portlet.common.paging.itemsPerPageText";
		public static final String ITEMS_PER_PAGE = "itemsPerPageText";
		public static final String CUR_PAGE_STATUS_TEXT = "portlet.common.paging.curPageStatusText";
		public static final String ITEMS = "items";
		
	}
	public final class DATE_FORMAT {
		public static final String YYYY_MM_DD = "yyyy/MM/dd";
		public static final String YYYY_MM_DD_DASH = "yyyy-MM-dd";
		public static final String DD_MM_YYYY_HHMMSS = "dd/MM/yyyy hh:mm:ss";
		public static final String DD_MM_YYYY_HH24MMSS = "dd/MM/yyyy HH:mm:ss";
		public static final String DD_MM_YYYY_HHMM = "dd/MM/yyyy hh:mm";
		public static final String DD_MM_YYYY = "dd/MM/yyyy";
		public static final String MM_DD_YYYY = "MM/dd/yyyy";
	}
	public final class MONEY_FORMAT {
		public static final String XXX_XXX_XXX = "###,###,###";
	}
	public interface PORTAL_STRUCTURE {
		public interface NAME {
			String PUBLIC_NEWS = "portal.structure.name.publicnews";
			String PUBLIC_ADMINISTRATION_PROCEDURE = "portal.structure.name.publicadministrationprocedure";
		}
		
		public interface SELECTION_LIST {
			String PUBLIC_NEWS_FIELDS = "portal.structure.selectionlist.publicnews.fields";
			String PUBLIC_NEWS_TYPE = "portal.structure.selectionlist.publicnews.type";
			String PUBLIC_NEWS_PUBLISHER = "portal.structure.selectionlist.publicnews.publisher";
			String PUBLISHER_GROUP_NAME = "portal.structure.selectionlist.publicnews.publisher";
			String PUBLIC_ADMINISTRATION_PROCEDURE_FIELD = "portal.structure.selectionlist.publicadministrationprocedure.field";
			String PUBLIC_ADMINISTRATION_PROCEDURE_ORGANIZATION="portal.structure.selectionlist.publicadministrationprocedure.organizations";
			String PUBLIC_ADMINISTRATION_PROCEDURE_LEVEL= "portal.structure.selectionlist.publicadministrationprocedure.level";
			String ANALYTIC_NOIDUNGHIENTHI ="portal.structure.field.analytic.noidunghienthi";
			String ANALYTIC_SOLIEU ="portal.structure.field.analytic.solieu";
		}
	}
	
	public final class STRUCTURE_NAME {
		public static final String LEGAL_DOCUMENT_STRUCTURE = "Văn bản pháp quy";
		public static final String OPERATING_DOCUMENT_STRUCTURE = "Văn bản chỉ đạo đi�?u hành";
		public static final String LEGAL_DOMAIN_STRUCTURE = "Lĩnh vực tài liệu";
		public static final String LEGAL_CATEGORY_STRUCTURE = "Loại văn bản pháp quy";
		public static final String LINK_PAGE_STRUCTURE = "Link Page";
		public static final String USEFUL_PHONE_INFO = "Số điện thoại cần biết";
		public static final String NAME_TTHC = "Danh mục thủ tục hành chính";
		public static final String PUBLIC_MARKET_PRICE = "Tài liệu nổi bật";
		public static final String E_CONTACT = "Danh bạ điện tử";
		public static final String VIDEO = "Video Clip";
	}
	public final class TEMPLATE_NAME {
		public static final String TEMPLATE_E_CONTACT = "BM Danh bạ điện tử";
	}
	
	public final class PORTLET_NAME {
		public static final String NEWS_BOX_BACNINH = "newsboxbacninh_WAR_bacninhportlet";
	}
	public final class QUESTION_MODEL_FIELD {
		public static final String CITIZEN_NAME ="citizenName";
		public static final String CITIZEN_ADDRESS ="citizenAddress";
		public static final String CITIZEN_PHONE_NUMBER ="citizenPhoneNumber";
		public static final String QUESTION_TYPES ="questionTypes";
		public static final String ORGANIZATION ="organization";
		public static final String CITIZEN_EMAIL ="citizenEmail";
		public static final String QUESTION_TITLE ="questionTitle";
		public static final String QUESTION_CONTENT ="questionContent";
		public static final String QUESTION_ATTACHED_FILE ="attachedFile";
		public static final String QUESTION_ATTACHED_FILE_NAME ="attachedFileName";
	}
	
	public final class ANSWER_MODEL_FIELD {
		public static final String ANSWER_ATTACHED_FILE ="attachedFile";
		public static final String ANSWER_ATTACHED_FILE_NAME ="attachedFileName";
		public static final String ANSWER_QLVB_ATTACH_FOLDER ="answerQLVBAttachFile";
	}
	
	public final class STATUS {
		public static final int REVIEWING = 0;
		public static final int APPROVING = 1;
		public static final int STARTING = 2;
		public static final int STOPPED = 3;
		public static final int OVER_TIME = 4;
		public static final int REJECTED = 10;
	}
	public final class REQUEST {
		public static final String RESULT ="result";
		
		public final class STATUS {
			public static final String SUCCESS ="success";
			public static final String ERROR ="error";
			public static final String INVALID_CAPTCHA ="invalid_captcha";
		}
		
	}
	public final class PORTLET {
		/***/
		public final class MAPS{
//			public static final String MAP_FOLDER_ID = "50301";
		}
		public final class QUESTION_SUBMIT {
			public static final String NAME ="questionsubmit_WAR_bacninhportlet";
			public static final String DATA_DICTIONARY_SET ="dataDictionarySet";
			public static final String QUESTION_TYPE ="questionType";
			public static final String COMMENT_TYPE = "commentType";
			public static final String PUBLIC_SERVICE_STATUS ="ProfileStatus";
			public static final String ORGANIZATION ="organizations";
		}
		public final class HOLIDAY {
			public static final String HOLIDAY_DDL ="holiday";
		}
		public final class VIDEO_GALLERY {
			
//			public static final long VIDEO_FILE_ENTRY_TYPE_ID = 62326L;
			public static final String FILE_ENTRY_TYPE_ID ="fileEntryTypeId";
			public static final String CREATE_DATE ="createDate";
			public static final String VIDEO_LIST ="videoList";
			public static final String NAME ="videogallery_WAR_bacninhportlet";
			public static final String URL ="/thu-vien-video";
		}
		public final class LINK_PAGE {
			public static final String LIST_LINK_PAGE ="listLinkPage";
			public static final String LIST_TYPE ="listType";
			public static final String LIST_TYPE_EMPTY_DATA ="listTypeEmptyData";
			public static final String FIELD ="fields";
			public static final String URL ="url";
		}
		public final class LEGAL_DOCUMENT_BYDOMAIN {
			public static final String DOCUMENT_SYMBOL = "document_symbol";
			public static final String DOCUMENT_DOMAIN = "document_domain";
			public static final String DOCUMENT_FORM = "document_form";
			public static final String DOCUMENT_DESCRIPTION = "document_description";
			public static final String EFFECT_DATE = "effect_date";
			public static final String PUBLISH_DATE = "publish_date_Display";
			public static final String GRADE_PUBLISHER = "grade_publisher";
			public static final String ORGAN_PUBLISHER = "organ_publisher";
			public static final String SIGNER = "signer";
		}
		public final class HOT_NEWS {
			public static final String TOP_VIEW ="top_views";
			public static final String HOT_NEWS ="hot_news";
			public static final String LATEST_NEWS ="latest_news";
		}
		public final class SEARCH_PUBLIC_SERVICE {
			public static final String CHOOSE ="Ch�?n";
			public static final String INPROGESS ="IN_PROGRESS";
			public static final String INPROGESS_ALF ="Xử lý";
			public static final String COMPLETED ="COMPLETED";
			public static final String COMPLETED_ALF ="Phê duyệt";
			public static final String NOTCLAIM ="Hồ sơ chưa được giao";
			public static final String SEARCH_INPROGESS ="�?ang";
			public static final String SEARCH_COMPLETED ="�?ã hoàn thành";
			public static final String INPROGRESS_STATUS ="�?ang xử lý";
		}
		public final class SEARCH_PUBLIC_SERVICE_STATUS {
			public static final String Draft ="�?ang lưu nháp";
			public static final String InProgress ="�?ang xử lý";
			public static final String Approved ="�?ợi phê duyệt";
			public static final String Rejected ="�?ã bị xóa";
			public static final String NeedtoSupplement ="Cần bổ xung";
			public static final String ApproverApproved ="�?ã phê duyệt";
			public static final String Returned ="�?ã trả hồ sơ";
		}
		public final class HOLIDAY_REQUEST_TYPE {
			public static final String REQUEST_TYPE_ILL ="Nghỉ ốm";
			public static final String REQUEST_TYPE_HAVE_SALARY ="Nghỉ phép";
			public static final String REQUEST_TYPE_NO_SALARY ="Nghỉ không lương";
			public static final String REQUEST_TYPE_MARRIED ="Nghỉ cưới";
			public static final String REQUEST_TYPE_SUMMER ="Nghỉ hè";
			public static final String REQUEST_TYPE_HAVE_BABY ="Nghỉ sinh con";
			public static final String REQUEST_TYPE_OTHERS ="Lý do khác";
		}
		public final class ASSESSMENT_STATUS {
			public static final int NO_COMMENT = 0;
			public static final int ONE_COMMENT = 1;
			public static final int TWO_COMMENT = 2;
		}
		/**
		 * Because site's admintrator (superadmin) has only roleid = 10164
		 * @author HiepTD3
		 *
		 */
		public final class REQUEST_MANAGEMENT{
			public static final long ADMINTRATOR_ROLE_ID = 10164;
		}
	}
	
	/**
	 *	List structure Operator Steering
	 */
	public final static String [] OPERATOR_STEERING_STRUCTURE_NAME = {
			"portal.structure.name.request_meeting",
			"portal.structure.name.administrative_penalty"};
	
	public static String[] requestMeetingListHeaderKeys = {
		"portlet.operator_steering.request_meeting.header.stt",
		"portlet.operator_steering.request_meeting.header.title",
	};
	public static String[] MAGAZINE_DEPARTMANT = {
		"Cấp giấy phép hoạt động in xuất bản phẩm",
		"Cấp giấy phép h�?p báo",
		"Cấp giấy phép in gia công xuất bản phẩm cho nước ngoài",
		"Cấp giấy phép hoạt động in các sản phẩm không phải là xuất bản phẩm",
		"Cấp giấy phép bổ sung chức năng in không phải xuất bản phẩm",
		"Cấp giấy phép nhập khẩu thiết bị ngành in (máy photocopy màu)",
		"Cấp giấy phép nhập khẩu xuất bản phẩm không kinh doanh",
		"Cấp giấy phép v�? quy�?n tác giả, quy�?n liên quan cho tổ chức, cá nhân trên địa bản tỉnh",
		"Cấp giấy phép thành lập cơ quan báo chí",
		"Thủ tục cấp phép thành lập và hoạt động của cơ quan đại diện, phóng viên thư�?ng trú ở trong nước của các cơ quan báo chí",
		"�?ơn xin phép tổ chức triển lãm, hội chợ xuất bản phẩm",
		"Cấp giấy phép xuất bản bản tin",
		"Cấp giấy phép xuất bản đặc san",
		"Cấp giấy phép xuất bản tài liệu không kinh doanh",
		"Cấp thẻ nhà báo",
		"�?ổi thẻ nhà báo",
		"Thủ tục đăng ký sử dụng thiết bị ngành in",
		"Cấp giấy phép in vàng mã, báo chí, sổ tiết kiệm, hộ chiếu, chứng minh thư, văn bằng chứng chỉ, tem chống giả gia công cho nước ngoài.",
		"Thủ tục đăng ký sử dụng thiết bị ngành in ",
	};
	public static String[] POST_DEPARTMANT = {
		"Cấp giấy phép thiết lập trang thông tin điện tử tổng hợp",
		"Cấp giấy phép thu các chương trình nước ngoài trực tiếp từ vệ tinh",
		"Cấp giấy phép cung ứng dịch vụ chuyển phát thư",
		"Văn bản chấp thuận vị trí xây dựng, lắp đặt trạm thu phát sóng thông tin di động (BTS)",
		"Xác nhận thông báo kinh doanh dịch vụ chuyển phát(trong phạm vi nội tỉnh)",
	};
	public static String[] IT_DEPARTMANT = {
		"Báo cáo Sở Thông tin và Truy�?n thông v�? tình hình cung cấp dịch vụ Internet",
		"Cấp giấy phép hoạt động quảng cáo trên mạng thông tin máy tính",
	};
	
	public static class CONFIG_CONTANT {
		public static final String PORTLET_TITLE_VN = "portletSetupTitle_vi_VN";
		public static final String PORTLET_TITLE_EN = "portletSetupTitle_en_US";
		public static final String PORTLET_URL = "portletSetupLinkToLayoutUuid";
	}
	public static final String IS_CONFIG = "isConfigured"; 
	
	public static class WORKING_SCHEDULE_ADMIN{
		public static final String DDL_LEADER = "Danh sách lãnh đạo";
		public static final String DDL_LEADER_SCHEDULE = "Danh sách lãnh đạo lịch làm việc";
	}
}