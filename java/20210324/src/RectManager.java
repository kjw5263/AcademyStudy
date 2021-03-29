public class RectManager {
	public static void main(String args[]) {
				
		Rectangle r = new Rectangle();
	
		System.out.println("사각형r");
		r.show();
		System.out.println();
	
		System.out.println("사각형s");
	
		Rectangle s = new Rectangle(1, 1, 2, 3);
		s.show();
	
		System.out.println("사각형s의 넓이 : " + s.square());
		System.out.println();
		System.out.println("사각형r의 좌표를 (-2,2), (-1,4)로 수정");
		System.out.println();
	
		System.out.println("사각형r");
	
		r.set(-2, 2, -1, 4);
	
		r.show();
	
		System.out.println("사각형r의 넓이 : " + r.square());
	
		if (r.equals(s)) {
			System.out.println("두 사각형의 넓이는 같습니다.");
		}
	}
}