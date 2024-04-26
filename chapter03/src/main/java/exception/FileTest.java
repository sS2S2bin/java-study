package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("dululu.txt");
			int data = fis.read();
			System.out.println((char)data);
		} catch (FileNotFoundException e) {
			System.out.println("Error : "+ e);
			//System.exit(0);
		} catch (IOException e) {
			System.out.println("Error : "+ e);
		}finally {
			
			try {
				if(fis!= null) {
					fis.close(); 
					// try 문에서 fis 정의하면 지역 변수라서 모른다고
					// 그래서 Main 바로 아래에 null로 정의해서 바꿈
					// 근데 null 
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}

	}

}
