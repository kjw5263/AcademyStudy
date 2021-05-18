
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


//4단계 방식의 이벤트 처리
// 4단계 이벤트 처리 방법
// - 내부 익명 ㅋ래스 형식으로 이벤트 리스너 클래스를 만들어서 이벤트를 처리하는 방법

/*
	주제 : Frame4.java 파일과 동일
	
	 	"Action"버튼을 클릭하면 "액션"으로 버튼의 문자열을 변경 하고....
		 다시 바뀐 "액션"버튼을 클릭하면  "Action"으로 버튼의 문자열을 변경 시키는 
		 토글 버튼 구현

*/

//프레임 창 클래스 
public class Frame5 extends JFrame{

	//생성자
	Frame5(){
		//프레임창 창제목설정
		this.setTitle("3단계 이벤트");
		//프레임창 배치관리자를 new FlowLayout()으로 설정
		this.setLayout(new FlowLayout());
		
		//프레임창의 x버튼을 클릭하면 프레임창이 닫히게 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Action 텍스트 버튼 객체 생성 
		JButton btnButton = new JButton("Action");
		
		add(btnButton);
		
		// 4단계 이벤트 처리 방법
		// *** 특징 : 내부 익명 클래스는 클래스 정의 부분과 객체 생성 부분이 하나로 합쳐져 잇다
		// 그러므로 굳이 클래스 이름을 정의할 필요가 없다
		// 
		// 위 버튼에 이벤트를 처리할 이벤트 리스너 객체 등록
		// 1. new ActionListener( actionPerformed(){ }  )  이름이 없는 내부 익명 클래스를 만들겠따
		// (방법 : ActionListener 인터페이스의 actionPerformed추상 메소드를 오버라이딩하자)
		// 2. 위 1에서 이름이 없는 내부익명 클래스 (이벤트 리스너 클래스)를 만들었기 때문에 
		// 내부 익명 클래스에 대한 이름이 없는 내부 익명 객체를 생성해서btn에 등록
		// 종합 ㅣ ActionListener 인터페이스 내부의 actionPerformed 추상 메소드를 오버라이딩 시키는 이름이 없는 내부 익명 클래스 만들고, 또한 내부 익명 객체를 생성하여 btn 등록 
		
		btnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 클릭된 버튼 객체 얻기
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Action")) {
					btnButton.setText("액션");
				} else {
					btnButton.setText("Action");
				}
				

				// *****특징2
				// 이 이벤트 리스너 클래스(내부 익명 클래스)(는 자신을 둘러싼 외부 클래스(Frame5)의 멤버변수(변수, 메소드)에 
				// 마음대로 접근할 수잇다
				setTitle(b.getText());
				
			} // actionPerformed 메소드
			
			
		});
		
		
		//프레임창 사이즈 설정 및  프레임을 보이게 설정
		this.setSize(800, 300);
		this.setVisible(true);  
	}// 생성자 끝 
	
	
	
	public static void main(String[] args) {
		//프레임창 객체 생성
		new Frame5();
	}



	
	
}



