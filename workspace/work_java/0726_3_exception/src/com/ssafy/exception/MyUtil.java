package com.ssafy.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyUtil {

//	public static void logging(String msg) {
//		PrintWriter out = null;
//		try {
//			out = new PrintWriter(new FileWriter("log.txt", true));
//			out.print(msg);
//		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw e
//		}
//		finally {
//			//stream이 열려 있을때만 close하겠다. 
//			if(out != null) out.close();
//		}
//		
//	}

	public static void logging(String msg) throws IOException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("log.txt", true));
			out.print(msg);
		}

		finally {
			// stream이 열려 있을때만 close하겠다.
			if (out != null)
				out.close();
		}

	}

	// 읽어오는 코드
	public static String readLog() {
		String log = null;
		BufferedReader in = null;
		try {
			// 이때 BufferedReader는 지역변수가 되버린다. ..
			// BufferedReader in = new BufferedReader(new FileReader("log.txt"));
			in = new BufferedReader(new FileReader("log.txt"));
			log = in.readLine();
		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} 
		catch (IOException e) { // 다형성 때문에 이거 하나로 다 처리할 수 있어서 FileNotFoundException을 생략할 수 있다.
			e.printStackTrace();
		} finally { // finally는 결국 항상 실행되는 코드이다...
			System.out.println("finally...");
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return log;
	}

	// runtime exception
	public static int division(int a, int b) throws InvalidValueException {
		if (b == 0) {
			throw new InvalidValueException(b);	 //선언부에도 선언. throw 코드 밑에는 진행되지 않는다.
		}
		int result = a / b;
		return result;
	}
}

//tip : 출력스트림은 읽을게 없으면 그냥 만들어버린다.