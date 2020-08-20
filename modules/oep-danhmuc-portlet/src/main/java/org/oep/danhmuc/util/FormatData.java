/**
 * 
 */

package org.oep.danhmuc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author win_64
 *
 */
public class FormatData {
	
	public static SimpleDateFormat formatDateShort = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat formatDateShort2 = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat formatDateShort3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	static SimpleDateFormat formatDateShort4 = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	static SimpleDateFormat formatDD = new SimpleDateFormat("dd");
	static SimpleDateFormat formatMM = new SimpleDateFormat("MM");
	static SimpleDateFormat formatYYYY = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat formatDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat formatDDMMYYY2 = new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat formatMMDDYYYY = new SimpleDateFormat("MM/dd/yyyy");

	public static Date parseStringToDateTypeMMDDYYYY(String data) {
		try {
			return formatMMDDYYYY.parse(data);
		} catch (Exception es) {
		}
		return null;
	}
	
	public static String parseDateToTringMMDDYYYY(Date date) {
		try {
			return formatMMDDYYYY.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static Date parseStringToDateTypeDDMMYYYY(String data) {
		try {
			return formatDDMMYYYY.parse(data);
		} catch (Exception es) {
		}
		return null;
	}
	
	public static String parseDateToTringYYYYMMDD(Date date) {
		try {
			return formatDateShort2.format(date);
		} catch (Exception es) {
		}
		return "";
	}

	public static String getDayOfMonth(Date date) {
		try {
			return formatDD.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String getMonth(Date date) {
		try {
			return formatMM.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String getYear(Date date) {
		try {
			return formatYYYY.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String getToday() {
		try {
			return formatDDMMYYYY.format(new Date());
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String parseDateToTringDDMMYYY(Date date) {
		try {
			return formatDDMMYYYY.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String parseDateToTring(Date date) {
		try {
			return formatDateShort.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String parseDateToTringType3(Date date) {
		try {
			return formatDateShort3.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static Date parseStringToDateType3(String data) {
		try {
			return formatDateShort3.parse(data);
		} catch (Exception es) {
		}
		return null;
	}
	
	public static String parseDateToTringType4(Date date) {
		try {
			return formatDateShort4.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String parseDateToStringType5(Date date) {
		try {
			return formatDDMMYYY2.format(date);
		} catch (Exception e) {
		}
		return "";
	}
	
	public static String parseDateToStringType9(Date date) {
		try {
			return formatDDMMYYYY.format(date);
		} catch (Exception e) {
		}
		return "";
	}
	
	
	public static String getGPDangKyLuuHanh(Date date) {
		SimpleDateFormat formatDDMMYYY2 = new SimpleDateFormat("-MM-yy");
		try {
			return formatDDMMYYY2.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatDDMMYYY2.format(new Date());
	}
	
	public static String getSoGiayChungNhan(Date date) {
		SimpleDateFormat formatDDMMYYY2 = new SimpleDateFormat("/yy");
		try {
			return formatDDMMYYY2.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatDDMMYYY2.format(new Date());
	}
	
	
	public static String parseDateToStringType6(Date date) {
		try {
			return formatDateShort2.format(date);
		} catch (Exception e) {
		}
		return "";
	}
	
	public static XMLGregorianCalendar convertFromDateToXMLGregorianCalendar(Date date) {
		XMLGregorianCalendar dateReturn = null;
		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(date);
			dateReturn = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (Exception es) {
			//			es.printStackTrace();
			try {
				dateReturn = DatatypeFactory.newInstance().newXMLGregorianCalendar();
			} catch (Exception e) {
				//				e.printStackTrace();
			}
		}
		return dateReturn;
	}
	
	public static Date parseStringToDate(String date) {
		try {
			if (date == null || date.length() == 0) return null;
			return formatDateShort.parse(date.trim());
		} catch (Exception es) {
			try {
				return formatDateShort2.parse(date.trim());
			} catch (Exception e1) {
				try {
					return formatDateShort3.parse(date.trim());
				} catch (Exception e2) {
					try {
						return formatDateShort4.parse(date.trim());
					} catch (Exception e) {
						try {
							return formatDDMMYYYY.parse(date.trim());
						} catch (Exception e3) {
							// TODO: handle exception
						}
					}
				}
			}
		}
		return new Date();
	}
	
	public static Date parseDateShort3StringToDate(String date) {
		try {
			return formatDateShort3.parse(date);
		} catch (Exception e) {
		}
		return new Date();
	}
	
	public static boolean isThisDateValid(String dateToValidate) {
		
		if (dateToValidate == null) { return false; }
		formatDateShort.setLenient(false);
		try {
			//if not valid, it will throw ParseException
			formatDateShort.parse(dateToValidate.trim());
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String checkData(long number1, long number2) {
		try {
			if (number1 == number2) { return "selected=\"selected\""; }
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String checkedData(String dmCode, String value) {
		try {
			if (dmCode.equals(value)) { return "selected=\"selected\""; }
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String congNgay(Date date) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			return formatDateShort3.format(calendar.getTime());
		} catch (Exception e) {
		}
		return "";
	}
	
	public static String replaceSpecialSign(String input) {
		try {
			String returnData = input.replaceAll("<script>", "");
			returnData = returnData.replaceAll("</script>", "");
			return returnData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return input;
	}
	
	public static int compareTwoDates(Date befortDate, Date afterDate) {
		if (befortDate == null || afterDate == null) {
			return 0;
		}
		return (int) ((afterDate.getTime() - befortDate.getTime()) / (24 * 60 * 60 * 1000));
	}
	
	public static long getDefferenBetweenTwoDate(Date startDate, Date endDate) {
		try {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			
			c1.set(Calendar.MONTH, startDate.getMonth() + 1);
			c1.set(Calendar.YEAR, startDate.getYear());
			c1.set(Calendar.DAY_OF_MONTH, startDate.getDate());
			
			c2.set(Calendar.MONTH, endDate.getMonth() + 1);
			c2.set(Calendar.YEAR, endDate.getYear());
			c2.set(Calendar.DAY_OF_MONTH, endDate.getDate());
			
			long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
			if (noDay > 0) { return noDay; }
		} catch (Exception es) {
		}
		return 0;
	}
}
