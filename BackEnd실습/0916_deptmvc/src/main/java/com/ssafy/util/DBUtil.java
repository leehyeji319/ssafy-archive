package com.ssafy.util;

public class DBUtil {

	static final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";
	
	static {
		
		try {
			// step1
			Class.forName(DRIVER_CLASSNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(AutoCloseable... resources) { //가변인자메소드
		for (AutoCloseable resource : resources) {
			
			if (resource != null) {
				try {
					resource.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
