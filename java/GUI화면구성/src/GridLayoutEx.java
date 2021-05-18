import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
	배치 관리자 종류 -> GridLayout 클래스
	- 컨테이너 공간을 동일한 사각형 격자 (그리드)로 분할하고 각 셀의 하나의 컴포넌트 배치
	- 격자 구성은 생성자에 행수와 열수 지정
	- 셀에 왼쪽에서 오른쪽으로, 다시 위쪽에서 아래로 순서대로 배치
	

*/

// GridLayout 배치 관리자 클래스로 입력 폼 만들기 : 4 * 2 그리드로 분할
// JLabel 클래스 <---- 텍스트를 표시하기 위한 컴포넌트
// JTextField 클래스 <--- 텍스트를 입력하기 위한 컴포넌트

public class GridLayoutEx extends JFrame {	// 프레임 창 역할을 하는 사용자 정의 클래스
	public GridLayoutEx() {
		// 프레임창 제목 설정 
		setTitle("GridLayout Sample");
		// 4*2 그리드 GridLayout 배치 관리자 객체 생성
		GridLayout grid = new GridLayout(4, 2);
		// 두 행 사이의 수직 간격
		// 그리드 사이의 수직 간격을 5 픽셀로 설정
		grid.setVgap(5);
		// GridLayout 배치 관리자객체를 프레임창 내부에 부착된 COntentPane 도화지에 설정
		this.setLayout(grid);
		
		// 라벨 및 텍스트필드 컴포넌트들을 생성해서 ContentPane 도화지에 추가
		this.add(new JLabel("이름"));
		this.add(new JTextField(""));
		
		this.add(new JLabel("학번"));
		this.add(new JTextField(""));
		
		this.add(new JLabel("학과"));
		this.add(new JTextField(""));
		this.add(new JLabel("전공"));
		this.add(new JTextField(""));
		
		setSize(300, 200);
		setVisible(true);
		
		
	}
	
	public static void main(String args[]) {
		// 프레임 창 객체 생성
		new GridLayoutEx();
	}
}
