// 방법 2 JFrame 클래스를 상속받는 사용자정의 프레임 클래스를 만들어 
// 			사용자 정의 프레임 클래스에 대한 객체를 main() 메소드 내부에서 생성
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class MyFrame extends JFrame{
	public MyFrame() {
		this.setTitle("방법2: 프레임창 만들기");
		setSize(500,500);


		
		setVisible(true);	// false로 설정하면 프레임창은 존재하지만 윈도우 화면에 숨겨짐
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}


// r개발자는 MyFrame 생성자에 필요한 코드를 마음대로 추가할 수 있다
// 방법2는 방법1보다 가독성 측면에서 좋ㄷ
// MyFrame 클래스에 마음대로 메소드 호출하여 사용할 수잇기 떄문에 확장성, 융통성 굿