package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		//이거 숙제
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		String domain = scanner.nextLine();
		try {
			InetAddress[] inetAddresses = InetAddress.getAllByName(domain);
		}
		catch(UnknownHostException e){
			System.out.println("잘못된 도메인 주소입니다. "+e);
		}
		
		
	}

}
