// 프레임(창) 만들기 두가지 방법
// 방법1. main() 메소드 내부에서 JFrame클래스에 대한 객체 생성
// 방법2. JFrame클래스를 상속받는 사용자 정의 프레임 클래스를 만들어
// 		사용자저의 프레임 클래스에 대한 객체를 main() 메소드 내부에서 생성




// 방법1. main() 메소드 내부에서 JFrame클래스에 대한 객체 생성
// 순서1. awt, swing 패키지 내부에 있는 모든 클래스나 인터페이스 사용하겟다 라고 import 선언
import java.awt.*;
import javax.swing.*;

// 순서 1-1. awt, swing 패키지 내부에 있는 이벤트 등록 관련한 클래스나 인터페이스를 사용하겟다
import java.awt.event.*;
import javax.swing.event.*;




public class MyApp {

	public static void main(String[] args){
		// 순서2. 프레임 창 만들기
		// 		방법 : JFrame 클래스에 대한 객체 생성시 만들 창제목 생성자로 전달하여 만들기
		JFrame f = new JFrame("첫번째 프레임");
		
		// 프레임 창 제목 변경 메소드 
		f.setTitle("방법1. 프레임창");
		
		/*
			참고.
			AWT 패키지를 이용하여 프레임창 만드는 방법 -> Frame 클래스 객체 생성 
			Swing 패키지를 이용하여 프레임창 만드는 방법 -> JFrame 객체 생성
			
			생성된 JFrame 객체의 3공간으로 구성됨 
			1공간 : Menu Bar 가 들어가는 공간
			2공간 : Frame 들이 들어가는 공간
			3공간 : Content Pane 들어가는 공간
			
			ContentPane : 
			화면에 출력되는 모든 컴포넌트들이 부착되는 공간
			예) JButton, JLabel, JTextField 컴포넌트 등등..
			
			중요! Swing에서는 ContentPane 에만 컴포넌트 부착할 수 있다.
			중요 : ContentPane 은 JFrame 객체가 처음 생성될 때 자동으로 생성된다
			ContentPane 컨테이너 객체를 얻어서 여러버튼 컴포넌트를 부착해봅시다
			
		 */
		
		
		// Jframe 객체의 getContentPane() 메소드를 호출하여 반환데이터로
		// ContentPane 컨테이너 객체를 반환받아 얻어올 수잇다
		// (반환값으로 Container 부모 클래스 타입으로 자식 ContentPane 컨테이너 객체를 반환받는다)
		Container contentPane = f.getContentPane();
		
		
		//JFrame 창 내부에 존재하는 ContentPane 컨테이너 객체에 JButton 컴포넌트를 생성해서 부착
		JButton b1 = new JButton("Click");
		
		// 생성한 버튼을 ContentPane 에 부착
		contentPane.add(b1);
		
		// ContentPane 컨테이너를 JPanel 컨테이너로 변경하기
		// JFrame 객체 생성시 붙어있는 ContentPane 컨테이너를 제거하고
		// 새로운 JPanel 컨테이너를 만들어서 붙이기
		MyPanel mp = new MyPanel();
		
		// JFrame창에 새로운 JPanel (new MyPanel();) 부착
		f.setContentPane(mp);
		
		// 위 Click 버튼을 다시 JPanel (new MyPanel();) 에 부착
		mp.add(b1);
		
		// JFrame 내부에는 JPanel(new MyPanel(); ) 도화지 부착되어잇고
		// 도화지 내부에는 Click JButton부착되어잇다
		
		// JFrame창
		f.setSize(500, 500);
		f.setVisible(true);
		
		
		
		
	}

}



// JPanel 클래스 상속받아 MYPanel 사용자 저의 JPanel 컨테이너 클래스 만들기\
class MyPanel extends JPanel {
	
}



/* 
 * 결론 1 : 방법 1 권장 ㄴㄴ
 * 		프레임창에 스윙 컴포넌트 추가하는 과정 불편, 확장성과 융통성이 결여
 * 결론2 : JDK 1.5는 JFrame 을 수정하여 개발자가 내부적으로 JFrame의 add() 메소드는
 * 			추가되는 컴포넌트를 자동으로 COnetntPane에 부착하도록 하고이슴
 * 			따라서 개발자는 Contentpane생각하지 않고 직접 JFrame 에 컴포넌트 추가 가능
 * 			JFrame frame = new JFrame();
 * 			JButton b1 = new JButton("Click");
 * 			frame.add(b1);
 * 
 * 
 * */

