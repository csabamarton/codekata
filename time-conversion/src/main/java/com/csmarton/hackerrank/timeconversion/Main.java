package com.csmarton.hackerrank.timeconversion;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ssaa");
	private static SimpleDateFormat dateFormatMilitary = new SimpleDateFormat("HH:mm:ss");

	public static void main(String[] args) throws ParseException
	{
		test();

		InputStream is = null;
		String input = "01:05:45PM";
		try {
			is = new ByteArrayInputStream(input.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Scanner in = new Scanner(is);
		String time = in.next();

		String militaryDate = getMilitaryDate(time);

		System.out.println(militaryDate);
	}

	private static void test() throws ParseException
	{
		String input = "12:00:00PM";

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2016);
		calendar.setTime(dateFormat.parse(input));

		Calendar nextDay = (Calendar)calendar.clone();
		nextDay.add(Calendar.HOUR_OF_DAY, 24);

		while (calendar.before(nextDay)) {
			System.out.print("Military: " + getMilitaryDate(calendar) + " | ");
			Date time = calendar.getTime();
			System.out.print("Cal Military: " + dateFormatMilitary.format(time) + " | ");
			System.out.println("AM/PM: " + getDateAMPM(calendar));

			calendar.add(Calendar.HOUR, 1);
		}
	}

	private static String getMilitaryDate(Calendar calendar)
	{
		return getMilitaryDate(dateFormat.format(calendar.getTime()));
	}

	private static String getMilitaryDate(String time)
	{
		boolean isPM = time.indexOf("PM") > -1;
		String timeWithoutAMPM = time.substring(0, time.length() - 2);
		String[] splittedTime = timeWithoutAMPM.split(":");

		String hour = splittedTime[0];
		if (hour.equals("12")) {
			if (!isPM) {
				splittedTime[0] = "00";
			}
		} else {
			if (isPM) {
				Integer militaryHour = Integer.valueOf(hour) + 12;
				splittedTime[0] = militaryHour.toString();
			}
		}

		//System.out.println(StringUtils.join(Arrays.asList(splittedTime), ":"));

		return splittedTime[0] + ":" + splittedTime[1] + ":" + splittedTime[2];
	}

	private static String getDateAMPM(Calendar calendar) throws ParseException
	{
		return dateFormat.format(calendar.getTime());
	}
}
