/*
노래를 나타내는 Song이라는 클래스를 설계하라. 

Song 클래스는 다음과 같은 멤버변수(인스턴스변수) 를갖는다
모두 데이터은닉변수로 만들기
-노래의 제목을 나타내는 title
-가수를 나타내는 artist
-노래가 속한 앨범 제목을 나타내는 album
-노래의 작곡가를 나타내는 composer,작곡가는 여려명 있을수있다.<-배열참조변수
-노래가 발표된 연도를 나타내는 year
-노래가 속한 앨범에서의 트랙번호를 나타내는 track

생성자는 기본생성자와 모든필드를 초기화하는 생성자를 작성하고,
노래의 정보를 화면에 출력하는 show()메소드도 작성하라.

-출력결과-
노래 제목:Dansing Queen
가수:ABBA
앨범:Arrival
작곡가:Benny Andersson,Bjorn Ulvaeus
년도:1977
트랙 번호:2

ABBA의 "Dancint Queen" 노래를 Song객체로 생성하고
show()를 이용하여 이노래의 정보를 출력하는 프로그램을 작성하라.

클래스2개(Song.java , SongManger.java)

*/
public class Song {
	private String title;
	private String artist;
	private String album;
	private String[] composer;
	private int year;
	private int track;
	
	public Song() {
		
	}
	
	// 생성자
	public Song(String title, String artist, String album, String[] composer, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
	}
	
	//show() 메소드
	/*
		-출력결과-
		노래 제목:Dansing Queen
		가수:ABBA
		앨범:Arrival
		작곡가:Benny Andersson,Bjorn Ulvaeus
		년도:1977
		트랙 번호:2
	 */
	public void show() {
		System.out.println("노래 제목 : " +  title);
		System.out.println("가수 : " +  artist);
		System.out.println("노래 제목 : " +  album);
		System.out.print("작곡가 : ");
		for(int i=0; i<composer.length; i++) {
			System.out.print(composer[i]);
			if((i+1) == composer.length) {
				System.out.println();
			} else {
				System.out.print(", ");
			}
		}
		System.out.println("년도 : " +  year);
		System.out.println("트랙 번호 : " +  track);
	}
	
	

}
