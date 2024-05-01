package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		//이거 숙제
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print(">> ");
			String domain = scanner.nextLine();
			if ("exit".equals(domain)) {
				break;
			}
			try {
				InetAddress[] inetAddresses = InetAddress.getAllByName(domain);
				for (int i = 0; i<inetAddresses.length;i++) {
					System.out.println(domain + " : "+ inetAddresses[i]);
				}
				
			}
			catch(UnknownHostException e){
				System.out.println("잘못된 도메인 주소입니다. "+e);
			}
		}
		
	}

}
