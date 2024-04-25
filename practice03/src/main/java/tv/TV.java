package tv;

public class TV {
	private int volume; //0~100
	private int channel; //1~255
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean b) {
		this.power = b;
	}

	public void status() {
		String powerstatus = "off";
		if (power) {
			powerstatus = "on";
		}
		System.out.println("TV[power="+powerstatus+ " channel=" +channel+ "volume="+volume+" ] ");
		
	}

	public void volume(int i) {
		if (i<0) {
			//순환구조 0 미만 되었을 때 가장 최대값 100으로 만
			this.volume = 100;
			// this.volume = 100 + this.volume - i;
		}
		else if(i>100) {
			// 순환구조 100이상 되었을때 가장 최하위값 0으로 만듦.
			this.volume = 0;
			//this.volume %= 100;
		}
		else {
			this.volume = i;
		}
		
	}
	public void volume(boolean up) {
		if(up) {
			int tmVolume = this.volume + 1;
			volume(tmVolume);
		}
		else {
			int tmVolume = this.volume - 1;
			volume(tmVolume);
		}
	}
	
	// 범위값을 벗어나면 0이하면 max로 max넘기면 0으로
	public void channel(int i) {
		this.channel = i;
		if(i<1) {
			this.channel = 255;
			//this.channel = 255 + this.channel - i;
		}
		else if (i>255) {
			this.channel = 1;
		}
		else {
			this.channel = i;
		}
		
	}
	public void channel(boolean up) {
		if(up) {
			int tmpChannel = this.channel + 1;
			channel(tmpChannel);
		}
		else {
			int tmpChannel = this.channel - 1;
			channel(tmpChannel);
		}
		
	}
	
	
}
