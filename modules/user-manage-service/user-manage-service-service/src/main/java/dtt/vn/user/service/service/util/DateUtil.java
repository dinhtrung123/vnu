package dtt.vn.user.service.service.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {

	public static final String DATE_FORMAT_FULL ="yyyyMMddHH24mmss";
	public static final String DATE_FORMAT_D_M_Y ="dd/MM/yyyy";
	public static final String DATE_FORMAT_D_M_Y_H_M_S ="dd/MM/yyyy HH:mm:ss";
	public static final String DATE_FORMAT_D_M_Y_H_M_S_1 ="yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_D_M_Y_H_M ="dd/MM/yyyy HH:mm";	
	public static final String DATE_FORMAT_Y_M_D="yyyyMMdd";
	public static final String DATE_DB_FORMAT_Y_M_D="yyyy-mm-dd";
	public static final String DATE_FORMAT_H_M_D_M_Y="HH:mm dd/MM/yyyy";	
	public static final String DATE_FORMAT_Y_M_D_H="yyyy-MM-dd HH:mm";
	public static final String DATE_FORMAT_Y_M_D_KEYCLOAK="yyyy-MM-dd";

	public static void main(String[] args) {

		System.out.println("isValid - dd/MM/yyyy with 20130925 = " + isValidFormat("dd/MM/yyyy", "20130925", Locale.ENGLISH));
		System.out.println("isValid - dd/MM/yyyy with 25/09/2013 = " + isValidFormat("dd/MM/yyyy", "25/09/2013", Locale.ENGLISH));
		System.out.println("isValid - dd/MM/yyyy with 25/09/2013 12:13:50 = " + isValidFormat("dd/MM/yyyy", "25/09/2013  12:13:50", Locale.ENGLISH));
		System.out.println("isValid - yyyy-MM-dd with 2017-18--15 = " + isValidFormat("yyyy-MM-dd", "2017-18--15", Locale.ENGLISH));

	}

	/**
	 * This is method parse format date to string
	 * 
	 * Version: OEP 1.1
	 * 
	 * History: DATE AUTHOR DESCRIPTION
	 * ------------------------------------------------- 26-March-2015 ThongDV
	 * Create new
	 * 
	 * @param date
	 * @param format
	 * @return string
	 */
	public static String parseDateToString(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
		}
		return "";
	}

	public static String convertDateToString(Date date, String format) {
		String vDate = "";
		try {
			if (date != null && !isNullOrEmpty(format)) {
				vDate = new SimpleDateFormat(format).format(date.getTime());
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return vDate;
	}

	public static boolean isNullOrEmpty(String inputString) {
		return (inputString == null || inputString.length() < 1);
	}

	/**
	 * This is method parse format string to date
	 * 
	 * Version: OEP 1.1
	 * 
	 * History: DATE AUTHOR DESCRIPTION
	 * ------------------------------------------------- 26-March-2015 ThongDV
	 * Create new
	 * 
	 * @param strDate
	 * @param format
	 * @return Date
	 */
	public static Date parseStringToDate(String strDate, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * This is method get current date time
	 * 
	 * Version: OEP 1.1
	 * 
	 * History: DATE AUTHOR DESCRIPTION
	 * ------------------------------------------------- 26-March-2015 ThongDV
	 * Create new
	 * 
	 * @return Date
	 */
	public static Date getCurrentDateTime() {
		return new Date();
	}

	/**
	 * This is method to check validate date time input
	 * 
	 * Version: OEP 1.1
	 * 
	 * History: DATE AUTHOR DESCRIPTION
	 * ------------------------------------------------- 17-Nov-2015 DuongPT
	 * Create new
	 * 
	 * @return Date
	 */
	public static boolean isValidDate(String format, String value) {
		boolean valid = true;
		try {
			DateFormat formatter = new SimpleDateFormat(format);
			formatter.setLenient(false);
			Date date = formatter.parse(value);
		} catch (Exception e) {
			valid = false;
		}
		return valid;
	}

	public static Date getBeginOfMonth(Date date) {
		Calendar beginOfMonth = Calendar.getInstance();
		beginOfMonth.setTime(date);

		beginOfMonth.set(Calendar.DATE, 1);
		beginOfMonth.set(Calendar.HOUR_OF_DAY, 0);
		beginOfMonth.set(Calendar.MINUTE, 0);
		beginOfMonth.set(Calendar.SECOND, 0);
		beginOfMonth.set(Calendar.MILLISECOND, 0);
		return beginOfMonth.getTime();
	}

	public static int getMaxDateInMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DATE);
	}

	public static Date getEndOfMonth(Date date) {
		Calendar endOfMonth = Calendar.getInstance();
		endOfMonth.setTime(date);

		endOfMonth.set(Calendar.DATE, endOfMonth.getActualMaximum(Calendar.DATE));
		endOfMonth.set(Calendar.HOUR_OF_DAY, 23);
		endOfMonth.set(Calendar.MINUTE, 59);
		endOfMonth.set(Calendar.SECOND, 59);
		endOfMonth.set(Calendar.MILLISECOND, 0);
		return endOfMonth.getTime();
	}

	public static Date addYear(Date date, int yearNumber) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, yearNumber);

		return calendar.getTime();
	}

	public static String formatDate(String date, String initDateFormat, String endDateFormat) {
		try {
			Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
			SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
			return formatter.format(initDate);
		} catch (Exception e) {

		}
		return "";
	}

	public static Date getDate(String date) throws ParseException {
		SimpleDateFormat formatDate = new SimpleDateFormat(DATE_FORMAT_D_M_Y);
		return formatDate.parse(date);
	}
	
	public static String formatDateTime(Date date, String decs) {
		decs = "hh:mm:ss dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(decs);
		return sdf.format(date);
	}
	
	public static String formatDate(Date date, String decs) {
		SimpleDateFormat sdf = new SimpleDateFormat(decs);
		return sdf.format(date);
	}
	public static boolean isValidFormat(String format, String value, Locale locale) {
	    LocalDateTime ldt = null;
	    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

	    try {
	        ldt = LocalDateTime.parse(value, fomatter);
	        String result = ldt.format(fomatter);
	        return result.equals(value);
	    } catch (DateTimeParseException e) {
	        try {
	            LocalDate ld = LocalDate.parse(value, fomatter);
	            String result = ld.format(fomatter);
	            return result.equals(value);
	        } catch (DateTimeParseException exp) {
	            try {
	                LocalTime lt = LocalTime.parse(value, fomatter);
	                String result = lt.format(fomatter);
	                return result.equals(value);
	            } catch (DateTimeParseException e2) {
	                // Debugging purposes
	                //e2.printStackTrace();
	            }
	        }
	    }

	    return false;
	}
}
