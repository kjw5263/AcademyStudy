
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


//3단계 방식의 이벤트 처리
// 이벤트 처리 방식 4단계 중에서 
// 3단계 방법, 프레임 클래스 내부에 내부 클래스 형식으로 이벤트 리스너 클래스를 만들어 사용하는 방법
/*
	주제 : Frame3.java 파일과 동일
	
	 	"Action"버튼을 클릭하면 "액션"으로 버튼의 문자열을 변경 하고....
		 다시 바뀐 "액션"버튼을 클릭하면  "Action"으로 버튼의 문자열을 변경 시키는 
		 토글 버튼 구현

*/

//프레임 창 클래스 
public class Frame4 extends JFrame{

	//생성자
	Frame4(){
		//프레임창 창제목설정
		this.setTitle("3단계 이벤트");
		//프레임창 배치관리자를 new FlowLayout()으로 설정
		this.setLayout(new FlowLayout());
		
		//프레임창의 x버튼을 클릭하면 프레임창이 닫히게 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Action 텍스트 버튼 객체 생성 
		JButton btnButton = new JButton("Action");
		// 위 버튼에 이벤트를 처리할 이벤트 리스너 객체 등록
		btnButton.addActionListener(new MyActionListener1());
		
		// 버튼을 화면에 부착하기
		this.add(btnButton);
		
		
		
		//프레임창 사이즈 설정 및  프레임을 보이게 설정
		this.setSize(300, 300);
		this.setVisible(true);  
	}// 생성자 끝 =
	
	/* */
	// Frame4 클래스의 내부 클래스 형식으로 이벤트 리스너 클래스(MyActionListener1) 만들기 (3단계 방법)
	// 특징1. private 으로 선언하였기 떄문에 Frame4 외부 클래스
	private class MyActionListener1 implements ActionListener{
		// 버튼을 클릭하면 호출되는 콜백 메소드 오버라이딩
		@Override
		public void actionPerformed(ActionEvent e) {
			//사용자가 클릭한ㅂ ㅓ튼 컴포너느는 이벤트 분배 스레드에 의해 생성되어 매개변수로 전달받는
			// ActionEvent객체를 통해 얻을 수 있따.
			JButton  b = (JButton)e.getSource();
			// 만약 클릭한 버튼의 텍스트 문자열ㅇㅣ "Action"이먄 "액션"으로 한글 문자열로 바뀌게 하기
			if(b.getText().equals("Action")) {
				// 버튼의 문자열을 설정하는 setText("설정한 문자열"); 메소드 호출
				b.setText("액션");
			} else {
				// 만약 클릭한 버튼의 텍스트 문자열이 "액션:한글이라면 Action으로 변경
				b.setText("Action");
			}
			
			// 내부 클래스 형식의 이벤트 리스너 클래스(MyActionListener1)sms
			// Frame4 외부 클래스의 내부 클래스 이므로, 자신을 두러싼 외부 클래스의 멤버에 마음대로 접근할 수잇다
			// 따라서 Frame4 클래스의 멤버인 setTitle() 메소드를 호출하여
			// 프레임 창의 창 제목을 변경할 수잇다.
			setTitle(b.getText());
			
		}
	}// 내부 클래스 끝
	

	
	public static void main(String[] args) {
		//프레임창 객체 생성
		new Frame4();
	}
	
} // Frame4 외부 클래스










