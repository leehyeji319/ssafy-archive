package com.ssafy.step02.setter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputServiceImplFile implements OutputService {

	@Override
	   public void output(String msg) {
	      PrintWriter out = null;
	      try {
	    	 out = new PrintWriter(new FileWriter("msg.txt", true), true);
	         out.println(msg);
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         if(out != null)
	            out.close();
	      }
	   }


}
