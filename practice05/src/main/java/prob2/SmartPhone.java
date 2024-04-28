package prob2;

public class SmartPhone extends MusicPhone {
	// 음악 통화 앱 각각 실행 Override
	@Override
	public void execute ( String function ) {
	    if ("앱".equals(function) ) {
	        app();
	        return;
	    }
	    	super.execute( function );    
	    
	    
	}
	@Override
	protected void playMusic(){
	  System.out.println("다운로드해서 음악재생");
	}
	
	private void app(){
		System.out.println( "앱실행" );
	}
}
