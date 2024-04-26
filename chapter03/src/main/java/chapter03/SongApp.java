package chapter03;

public class SongApp {

	public static void main(String[] args) {
		/* 아이유 좋은 날 Song 객체 설정, show로 출력 */
		Song song = new Song("좋은날", "아이유", "Real","이민수",2010,3);
		Song song2 = new Song("CLAP","TREASURE");	
		/* 필드 private getter setter로 접근 */
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setComposer("이민수");
//		song.setYear(2010);
//		song.setTrack(3);
		
		song.show();
		song2.show();

	}

}
