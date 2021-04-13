
// 업캐스팅을 하는 이유는 다형성 특징을 이용하기 위해서

class 해장국 {	// 부모 클래스 역할
	public void 간맞추기() {
		System.out.println("소금치기");
	}
}


class 뼈다귀해장국 extends 해장국 {	// 자식 클래스 역할
	
	@Override
	public void 간맞추기() {
		System.out.println("뼈다귀 해장국에 들깨가루 넣기");
	}
	
	
	public void 뼈추가() {
		System.out.println("뼈추가");
	}
}


class 콩나물해장국 extends 해장국 {	// 자식 클래스 역할
	
	@Override
	public void 간맞추기() {
		System.out.println("콩나물 해장국에 고춧가루 넣기");
	}
	
	
	public void 콩나물넣기() {
		System.out.println("콩나물");
	}
}


class 취객 {
	
	public void 해장국간맞추기(해장국 무슨해장국) {
		무슨해장국.간맞추기();
	}
	
	
//	public void 뼈해장국간맞추기(뼈다귀해장국 뼈다귀해장국1) {
//		뼈다귀해장국1.간맞추기();
//	}
//	
//	public void 콩나물간맞추기(콩나물해장국 콩나물해장국1) {
//		콩나물해장국1.간맞추기();
//	}
	
}


public class Test101 {

	public static void main(String[] args) {
		취객 취객1 = new 취객();
		//뼈다귀해장국 뼈 = new 뼈다귀해장국();
		//콩나물해장국 콩 = new 콩나물해장국();
		//취객1.뼈해장국간맞추기(뼈);
		//취객1.콩나물간맞추기(콩);
		
		
		// 취객 클래스에 바로 자식객체 생성 가능
		취객 취객2 = new 취객();
		취객2.해장국간맞추기(new 뼈다귀해장국());
		취객2.해장국간맞추기(new 콩나물해장국());
		// 업캐스팅
		// 부모 클래스 타입의 참조변수에 자식객체 생성해서 저장
		//해장국 해장국한그릇 = new 뼈다귀해장국();
		//취객2.해장국간맞추기(해장국한그릇);

	}

}
