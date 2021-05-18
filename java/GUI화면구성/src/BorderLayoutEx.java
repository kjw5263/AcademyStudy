import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
	배치 관리자 종류 =-> BorderLayout
	- 컨테이너 공간을 5구역으로 분할해서 배치
		(East, West, South, North, Center)
		
	- add 메소드를 이용한 배치 방법
	  add(Component comp, int index)
	  뜻 : comp 매개변수로 전달하는 컴포넌트를 index 공간에 배치
	  
	  - 컨테이너 크기 변하면 재배치
*/
public class BorderLayoutEx extends JFrame {

	public BorderLayoutEx() {
		// 프레임 창제목 설정
		setTitle("borderLayout Sample");
		
		setLayout(new BorderLayout());
		
		// add 메소드를 이용하여 ContentPane 도화지 북쪽에 "add"버튼 컴포넌트 생성 후 부착
		add(new JButton("add"), BorderLayout.NORTH);
		// add 메소드를 이용하여 도화지 남쪽에 "sub" 버튼 컴포넌트 생성 후 부착
		add(new JButton("sub"), BorderLayout.SOUTH);
		// add 메소드를 이용하여 도화지의 동쪽에 "mul" 버튼 컴포넌트 생성 후 부착 
		this.add(new JButton("mul"), BorderLayout.EAST);
		
		// div 버튼을 더화지 서쪽에 부착
		this.add(new JButton("div"), BorderLayout.WEST);
		
		this.add(new JButton("Calculate"), BorderLayout.CENTER);
		
		this.setSize(300, 400);

		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new BorderLayoutEx();

	}

}
