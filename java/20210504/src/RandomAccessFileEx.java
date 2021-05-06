import java.io.RandomAccessFile;

/*
	RandomAccessFile 클래스
	- 스트림 통로는 원칙적으로 FIFO (First In First Out) 순차적 방식이다
	  원칙적으로 FIFO 순차적 방식이지만
	  임의적으로 파일에 저장되어있는 데이터에 접근 할 수도 있음
	  임의적으로 파일에 접근 하기 위한 Random AccessFile 클래스 장치를 제공함
	  
	  java.lang.Object
	  	java.io.randomAccessFile
	  	
	  - RandomAccessFile 클래스는? InputStream 또는 OutputStream으로부터 상속받지 않고
	   자체적으로 DataInput 인터페이스와 DataOutput 인터페이스의 메소드를 자체적으로 오버라이딩 받아 사용함
	   
	  - 주요 매소드
	   void seek(long pos) 메소드 : pos 위치를 ㅈ정해주면 위치의 데이터를 찾는다.

*/
public class RandomAccessFileEx {

	public static void main(String[] args) throws Exception {
		// 주제 : double 데이터들을 파일에 저장하자
		
		double[] data = {2.0, 3.14, 5.7, 10.89, 15, 24, 20.20, 15.89, 101.22, 28.55};
													// 저장할 파일 경로, 읽기r 쓰기w 가능하게 함
		RandomAccessFile raf = new RandomAccessFile("d:\\random.txt", "rw");
		
		// 위 data 배열에 저장된 데이터를 random.txt 파일에 출력 (저장)
		for(int i=0; i<data.length; i++) {
			raf.writeDouble(data[i]);	// data 배열의 각 인덱스 위치에 저장된 데이터를 꺼내어서 random.txt 파일에 write 쓰기
		}
		
		// 테스트 확인하기
		// d:\\random.txt 파일 열어 확인하기
		// @       @	퇡?@儆儆勁@%풀z?@.      @8      @4333333@/풀z?@YNz??<뚉儆勁
		// -> random.txt 파일에 2진데이터가 저장된 것을 확인할 수 있다.
		raf.seek(8); // 3.14
		// (설명)
		// double[] data = 
		// {2.0, 3.14, 5.7}
		// 0~7, 8~15, 16~23, .... 바이트 위치에 있는 데이터
		
		// 꺼내기
		System.out.println(raf.readDouble());
		
		// 0 바이트의 위치에 있는 데이터 찾기
		raf.seek(0);
		
		System.out.println(raf.readDouble());
		
		raf.seek(24);
		System.out.println(raf.readDouble());
		
		raf.close();
	}

}
