/**
 *
 */

package org.oep.danhmuc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author win_64
 *
 */
public class ConvertUtil {
	
	public static SimpleDateFormat formatDateFullTime3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	public static SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Convert from String to Long
	 * @param value
	 * @return
	 */
	public static Date parseStringToDate(String data) {
		try {
			return formatDateShort.parse(data);
		} catch (Exception es) {
		}
		return null;
	}
	public static long convertToLong(String value) {
		try {
			return Long.parseLong(value.trim());
		} catch (Exception es) {
		}
		
		return -1;
	}
	
	/**
	 * Convert from String to Double
	 * @param value
	 * @return
	 */
	public static double convertToDouble(String value) {
		try {
			return Double.parseDouble(value.trim());
		} catch (Exception es) {
		}
		
		return 0;
	}
	
	/**
	 * Convert from String to Long
	 * @param value
	 * @return
	 */
	public static int convertToInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception es) {
		}
		
		return 0;
	}
	
	public static String formatIntToString(int data) {
		try {
			if (data < 10) { return "0" + data; }
		} catch (Exception es) {
		}
		
		return String.valueOf(data);
	}
	
	public static String parseLongToString(long value) {
		try {
			return String.valueOf(value);
		} catch (Exception es) {
			return null;
		}
	}
	
	public static String parseIntToString(int value) {
		try {
			return String.valueOf(value);
		} catch (Exception es) {
			return null;
		}
	}
	
	public static String checkSelectData(long number1, long number2) {
		try {
			if (number1 == number2) { return "selected=\"selected\""; }
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String checkSelectData(long number1, String number2) {
		try {
			if ((number2 != null) && (number2.trim().length() > 0)) {
				if (number1 == Long.parseLong(number2.trim())) { return "selected=\"selected\""; }
			}
			
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String checkEqualData(String value1, String value2) {
		try {
			if (value1.equalsIgnoreCase(value2)) { return "selected=\"selected\""; }
		} catch (Exception es) {
		}
		return "";
	}
	public static String parseDateToString3(Date date) {
		try {
			return formatDateFullTime3.format(date);
		} catch (Exception es) {
		}
		return "";
	}
}
