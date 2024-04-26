package chapter03;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int year;
	private int track;
	
	public Song(String title, String artist) {
		// System.out.println("이게 무조건 한 번은 프린트 되어야해.");
		
		// 이렇게 생성자를 다시 사용해서 코드의 중복을 막음
		this(title, "", "", artist, 0, 0); 
		
		// this.title = title;
		// this.artist = artist;
	}
	public Song(String title, String album, String composer, String artist, int year, int track) {
		this.title = title;
		this.album = album;
		this.composer = composer;
		this.artist = artist;
		this.track = track;
		this.year = year;
		
		System.out.println("이게 무조건 한 번은 프린트 되어야해.");
	}
	
	/* getter setter */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	
	
	/* 노래정보를 화면에 출력하는 show() */
	public void show() {
		System.out.println(
		artist+" "+ 
		title + " ("+ 
		album +", "+
		year+", "+
		track+"번 track, "+
		composer+" 작곡 )" );
	}

}
