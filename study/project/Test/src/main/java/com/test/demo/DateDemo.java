package com.test.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DateDemo {

	public static void main(String[] args) throws ParseException {
		// System.out.println(Integer.parseInt("02"));
		// getDate();
		Map<String, String> result = calcuStartTimeByEntryDate("20180910", "20181208", "3", 2);
		for (Entry<String, String> entry : result.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	public static Map<String, String> calcuStartTimeByEntryDate(String effDt, String entryDt, String rvlPrdTpCode,
			int rvlPrdQty) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date temp = format.parse(effDt);
		Calendar c = Calendar.getInstance();
		c.setTime(temp);
		int month = 0;
		switch (rvlPrdTpCode) {
		// 日
		case "1":
			break;
		// 旬
		case "2":
			if (c.get(Calendar.DATE) > 0 && c.get(Calendar.DATE) <= 10) {
				c.set(Calendar.DAY_OF_MONTH, 1);
			}
			if (c.get(Calendar.DATE) > 10 && c.get(Calendar.DATE) <= 20) {
				c.set(Calendar.DAY_OF_MONTH, 11);
			}
			if (c.get(Calendar.DATE) > 11 && c.get(Calendar.DATE) <= 31) {
				c.set(Calendar.DAY_OF_MONTH, 21);
			}
			break;
		// 月
		case "3":
			c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
			break;
		// 季
		case "4":
			month = c.get(Calendar.MONTH) + 1;
			if (month > 0 && month < 4) {
				c.set(c.get(Calendar.YEAR), 0, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
			}
			if (month > 3 && month < 7) {
				c.set(c.get(Calendar.YEAR), 3, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
			}
			if (month > 6 && month < 10) {
				c.set(c.get(Calendar.YEAR), 6, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
			}
			if (month > 9 && month <= 12) {
				c.set(c.get(Calendar.YEAR), 9, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
			}
			break;
		// 半年
		case "5":
			month = c.get(Calendar.MONTH) + 1;
			if (month > 0 && month < 7) {
				c.set(c.get(Calendar.YEAR), 0, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
			}
			if (month > 6 && month <= 12) {
				c.set(c.get(Calendar.YEAR), 6, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
			}
			break;
		// 年
		case "6":
			c.set(c.get(Calendar.YEAR), 0, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
			break;
		// 周
		case "7":
			c.set(Calendar.DAY_OF_WEEK, 2);
			break;
		default:
			break;
		}

		// 循环周期开始时间
		Calendar start = Calendar.getInstance();
		start.setTimeInMillis(c.getTimeInMillis());

		// 交易时间
		Calendar entryC = Calendar.getInstance();
		entryC.setTime(format.parse(entryDt));

		while (true) {
			switch (rvlPrdTpCode) {
			// 日
			case "1":
				c.add(Calendar.DATE, rvlPrdQty);
				break;
			// 旬
			case "2":
				c.add(Calendar.DATE, rvlPrdQty * 10);
				break;
			// 月
			case "3":
				c.add(Calendar.MONTH, rvlPrdQty);
				break;
			// 季
			case "4":
				c.add(Calendar.MONTH, rvlPrdQty * 3);
				break;
			// 半年
			case "5":
				c.add(Calendar.MONTH, rvlPrdQty * 6);
				break;
			// 年
			case "6":
				c.add(Calendar.YEAR, rvlPrdQty);
				break;
			// 周
			case "7":
				c.add(Calendar.DAY_OF_WEEK, rvlPrdQty * 7);
				break;
			default:
				break;
			}

			if (entryC.getTimeInMillis() >= start.getTimeInMillis() && entryC.getTimeInMillis() < c.getTimeInMillis()) {
				break;
			} else {
				start.setTimeInMillis(c.getTimeInMillis());
			}
		}

		String rvlBegTm = format.format(start.getTime());
		String rvlEndTm = format.format(c.getTime());

		Map<String, String> result = new HashMap<>();
		result.put("rvlBegTm", rvlBegTm);
		result.put("rvlEndTm", rvlEndTm);

		return result;
	}

	public static void checkArsRcrsDate() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		format.setLenient(false);
		format.parse("20180228");
	}

	public static void getDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, Integer.parseInt("03"));
		System.out.println(c.getActualMaximum(Calendar.DATE));
	}

	public static void testFormat() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date1 = format.parse("20180102");
		Date date2 = format.parse("20180102");
		if (date1.after(date2)) {
			System.out.println(true);
		}

		String entryDate = "20181206";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date temp = sdf.parse(entryDate);
		Calendar c = Calendar.getInstance();
		c.setTime(temp);
		int month = 0;
		c.add(Calendar.MONTH, 1 * 3);
		month = c.get(Calendar.MONTH) + 1;
		if (month > 0 && month < 4) {
			c.set(c.get(Calendar.YEAR), 0, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
		}
		if (month > 3 && month < 7) {
			c.set(c.get(Calendar.YEAR), 3, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
		}
		if (month > 6 && month < 10) {
			c.set(c.get(Calendar.YEAR), 6, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
		}
		if (month > 9 && month <= 12) {
			c.set(c.get(Calendar.YEAR), 9, c.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
		}
		System.out.println(sdf.format(c.getTime()));
	}
}
