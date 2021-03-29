
public class SongManager {
	public static void main(String args[]) {
		/*
		-출력결과-
		노래 제목:Dansing Queen
		가수:ABBA
		앨범:Arrival
		작곡가:Benny Andersson,Bjorn Ulvaeus
		년도:1977
		트랙 번호:2
	 */
		//String[] strings = {"Benny Andersson", "Bjorn Ulvaeus"};
		//ABBA의 "Dancint Queen" 노래를 Song객체로 생성하고
		Song song = new Song("Dancing Queen", "ABBA", "Arrival", new String[] {"Benny Andersson", "Bjorn Ulvaeus"}, 1977, 2);
		
		
		//show()를 이용하여 이노래의 정보를 출력하는 프로그램을 작성하라.
		song.show(); 
	}
}
