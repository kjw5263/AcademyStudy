
// 배치 관리자 지정하지 않고 내가 원하는 대로 컨테이너에 배치할 수 잇다
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullContainerEx extends JFrame {

	// 기본생성자
	public NullContainerEx() {
		// 프레임창의 제목 설정 
		this.setTitle("NullContainer Sample");
		
		// 프레임창 내부에 부착된 ContentPane 도화지에 배치 관리자를 지정하지 않으면 
		// 기본적으로 특정 배치 관리자로 설정되어있다
		// 그러므로 우리는 특정 배치 관리자를 COntentPane 도화지에 제거해야 한다.
		this.setLayout(null);
		
		// JLabel 컴포넌트 생성하고 직접 위치와 크기를 지정한다.
		JLabel label = new JLabel("HEllo, Press Button!");
		
		// 위 생성한 JLabel 객체의 텍스트 내용을 ContentPane 도화지의 130, 50 위치로 지정해서 배치하기 위해 설정
		label.setLocation(130, 50);
		
		// 위 생성한 JLabel 객체 영역의 크기를 200 너비 X 20높이로 지정
		label.setSize(200, 20);
		
		// ContentPane 도화지에 JLavel 컴포넌트 부착 
		this.add(label);
		
		
		for(int i=0; i<9; i++) {
			label.setLocation(i, i);
		}
		
		
		
		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new NullContainerEx();

	}

}
