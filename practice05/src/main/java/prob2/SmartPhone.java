package prob2;

public class SmartPhone extends MusicPhone {
	// 음악 통화 앱 각각 실행 Override
	public void execute ( String function ) {
	    if (function.equals("앱") ) {
	        app();
	        return;
	    }
	    if(function.equals("음악")) {
	    	this.playMusic();
	    	return;
	    }
	    else {
	    	super.execute( function );
	    }    
	    
	    
	}
	@Override
	protected void playMusic(){
	  System.out.println("다운로드해서 음악재생");
	}
	
	private void app(){
		System.out.println( "앱실행" );
	}
}
