package sample;

import java.io.IOException;
import java.util.Random;

public class index {

	//protected static int count=1;

	public static void main(String[] args) throws IOException {
		
		Random rd=new Random();
		int  n = rd.nextInt(1000) + 1;
		System.out.println(n);
		add a=new add();
		a.createSlide();
		a.screenshot("C:/screen/screen_"+n+".png");
		//count++;
		
		}
	}

