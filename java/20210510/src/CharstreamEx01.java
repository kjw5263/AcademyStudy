import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
	문자 스트림 방식으로 입출력 
	
	문자 스트립 방식의 최고 부모 클래스
	- Reader 클래스
	- Writer 클래스
	
	문자 스트림 방식을 사용하는 이유 ?
	- 키보드로 부터 한글 입력시 인코딩이 되지 않는데 바이트스트림에서는 1바이트씩 처리했다.
	  한글은 2바이트이기 때문에 한글이 깨져보였던 것
	  but 문자 스트림 방식을 이용하면 2바이트씩 처리하기 때문에
	  자유롭게 데이터를 읽거나 출력해줄 수 있다. 
	  


	[inputStreamReader 클래스의 단점 ]
	- 한 문자(한글자)씩 데이터를 읽어 들이면 장치와 프로그램 사이의 입출력 횟수가 많아진다
	그렇게 되면 프로그램의 성능은 떨어질 수 있다
	
	[InpustreamTeader 클래스의 단점을 보완해서 나온 클래서] -> BufferReaderClass로 다시 포장
	
	 [BufferReader 클래스]
	 InputStreamReader메모리에 읽어들인 데이터를
	

 */
public class CharstreamEx01 {
//
//	 PUBLIC STATIC VOID STREAMTEST(INPUTSTREAM IS) {
//	      
//	      //바이트 스트림 방식의 문자스트림 방식으로 바꾸는 이유는
//	      //-> 1바이트 단위로 데이터를 읽어들일게 아니라 2바이트(한문자) 단위로 데이터를 읽어들일수 있게 하기위해
//	      // 장점 : 영문 뿐만앙니라 한글도 읽어 들일 수 있다.
//	      
//	      //INPUTSTREAM객체를 INPUTSTREAMREADER객체 생성시 생성자로 전달해 저장(포장)
//	      INPUTSTREAMREADER ISR = NEW INPUTSTREAMREADER(IS);
//	      //INPUTSTREAM 클래스의 주요 메소드
//	      //INT READ() : 한문자 씩 데이터를 읽어 들이는 메소드
//	 
//	      
//	      TRY {
//	          //매개변수로 전달받아 포장한 INPUTSTREAMREADER스트림 객체를 이용해
//	          //키보드로부터 입력받은 데이터를 한문자(2바이트)단위로 반복해서 읽어들여 출력
//	          
//	          WHILE(TRUE) {
//	             //키보드로부터 한문자(2바이트)단위로 반복해서 읽어들임
//	             INT I = ISR.READ();
//	             
//	             //만약 키보드로부터 입력받은 데이터 중 읽어들일 데이터가 존재하지 않으면
//	             //더이상 읽어 들이지 않고 WHILE 반복문을 빠져나감
//	             IF(I == -1) {
//	                BREAK;
//	             }
//	             //키보드로부터 입력받은 한문자(2바이트)단위로 출력
//	             SYSTEM.OUT.PRINT((CHAR)I);
//	          }
//	          
//	       } CATCH (EXCEPTION E) {
//	          E.PRINTSTACKTRACE();
//	       }
//	   }
//	 
//	 
	 public static void streamTest(InputStream is) {
	      
	       // 바이트 스트림 방식 (1바이트씩 데이터를 읽어들이는 방식_) - InputStream 방식
		   //CharaterStream 방식 => 2바이트씩 데이터를 읽어들이는 방식    - > InputStreamReader객체
		   // 여러개의 문자단위로 읽어들인 데이터들을 내부 버퍼구간에 모아 두엇다가 한번에 읽어들이는 방식 ->BufferedReader
		   new BufferedReader(new InputStreamReader(is));
		   BufferedReader isr = new BufferedReader(new InputStreamReader(is));
		   
		   try {
		         while(true) {
		            // 여러개의 문자를 내부 버퍼에 보관해 두었다가 한줄씩 읽어들인다
		        	 String string = isr.readLine(); //읽어들일 줄이없다면 null 반환
		        	 if(string == null) {
		        		 break;
		        	 }
		        	 
		        	 System.out.println(string); // 키보드로 부터 입력받아 읽어들인 데이터 출력
		         }
		      } catch (Exception e) {
		    	  e.printStackTrace();
		      }
	   }
		
		
	public static void main(String[] args) {
		// 메소드 호출시 바이트 방식으로 데이터를 주소 받을 수 있게 InputStream 객체 전달
		streamTest(System.in);
		
	}

}
