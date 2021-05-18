// 주제 : JFrame 창 내부에 있는 ContentPane 을 얻어 배경색을 오렌지 색으로 설정하고,
// 		이곳에 ok, cancel, Ignore 버튼 부착한 스윙 프로그램 만들기
// 참고 : ContentPane 배경색을 변경하는 메소드 : setBackground(Color.ORANGE);

// 방법2. JFrame 클래스를 상속받은 사용자 정의 프레임 클래스 만들기
import java.awt.*;
import javax.swing.*;




public class ContentPaneTest extends JFrame{
	// 기본 생성자
	ContentPaneTest() {
		// main 메소드 내부에서 생성한 new ContentPaneTest() 프레임창의 창 제목 설정
		this.setTitle("ContentPane과 JFrame");
		
		// 프레임 창에 부착되어 있는 ContentPane 도화지를 얻자
		// Container : container 중에서도 최고 조상
		Container container = this.getContentPane();
		
		// ContentPane 도화지의 배경색을 오렌지 색으로 변경
		container.setBackground(Color.orange);
		
		// 배치 관리자(배치 매니저)
		// ContentPane 도화지에 컴포넌트들을 (버튼, 텍스트버튼, 체크박스), 배치할 위치, 크기를 관리하는 클래스
		// 배치 관리자 종류 -> FlowLoayout 배치 관리자 클래스
		// 1 . COntentPane 도화지에 컴포넌트들을 추가하는 순서대로 왼쪽에서 오른쪽으로 순서대로 배치
		// 2. ContentPane 도화지 전체 화면에서 오른쪽에 더이상 배치할 것이 없으면 왼쪽아래에서 다시 오른쪽으로 배치
		
		// ContentPane 도화지에 FlowLayout 배치 관리자 설정
		container.setLayout(new FlowLayout() );
		//OK, cancle, Ignore 버튼 컴포넌트들을 생성하여 순서대로 Container 도화지에 배치
		container.add(new JButton("OK"));
		container.add(new JButton("Cancel"));
		container.add(new JButton("Ignore"));
		
		// 프레임창의 x버튼 클릭시 창 닫으며 프로그램 종료하기 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350,150);
		this.setVisible(true);
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		new ContentPaneTest();	// JFrame 클래스를 상속받아 만든 ContentPaneTest 프레임창 클래스에 대한 객체 생성
		

	}

}
