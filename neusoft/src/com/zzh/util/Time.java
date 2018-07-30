package com.zzh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	
	
	public String getCurrentTime(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date.getTime());
		return time;
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString());
	}


	

}
