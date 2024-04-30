package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) {
		InputStream is = null;
		FileOutputStream os = null;
		
		try {
			is = new FileInputStream("racoon.png");
			os = new FileOutputStream("racoon.copy.png");
			int data = -1;
			
			while((data = is.read()) != -1) {
				os.write(data);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try{
				if(is !=null) { //null 인데 자료 정리하면 에러
					is.close();
					}
				if(os!=null) {
					os.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
