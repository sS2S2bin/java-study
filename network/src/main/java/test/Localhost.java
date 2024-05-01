package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName();
			String hostIpAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostIpAddress);
			
			//4바이
			byte[] IpAddresses = inetAddress.getAddress();
			
			for(byte IpAddress: IpAddresses) {
				System.out.println(IpAddress & 0x000000ff);
			}
			
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		
	}

}
