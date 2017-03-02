package cdr;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Test {
	public static void num() throws Exception {
		//BufferedInputStream bis=new BufferedInputStream(new FileInputStream(new File("num.txt")));
		BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("orderId.txt")));
		String temp;
		StringBuffer bf=new StringBuffer();
		while(null!=(temp = bufferedReader.readLine())){
			bf.append("'").append(temp).append("',");
		}
		bufferedReader.close();
		System.out.println(bf.toString());
	}
	public static void sheetId() throws Exception {
		BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("sheetId.txt")));
		String temp;
		StringBuffer bf=new StringBuffer();
		while(null!=(temp = bufferedReader.readLine())){
			bf.append("'");
			for(int i=0;i<12-temp.length();i++){
				bf.append("0");
			}
			bf.append(temp).append("',");
		}
		bufferedReader.close();
		System.out.println(bf.toString());
	}
	public static void main(String[] args) throws Exception {
		//sheetId();
		num();
	}
}
