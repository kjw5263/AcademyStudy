// Tank, dropship, scv	<-- 기계 유닛이기 때문에
// repairable 인터페이스 만들기
interface Repairable{
	
}


//최고 조상 유닛클래스 만들기
class Unit {
	// 유닛의 현재 체력을 저장할 변수
	int hitPoint;
	
	// 유닛의 최대 체력을 한번만 초기화해서 저장할 상수
	final int MAX_HP;
	
	// Unit객체 생성시 유닛의 최대 체력을 초기화할 생성자
	Unit(int hp){
		MAX_HP = hp;
	}
}


//  지상 유닛 GroundUnit 클래스 만들기 <--- Unit조상 클래스 상속 받기
class GroundUnit extends Unit{
	// 지상 유닛의 최대 체력을 초기화
	public GroundUnit(int hp) {
		super(hp);
	}
}


// 탱크 지상유닛 Tank 클래스 만들기 <---- 지상유닛이기때문에 GroundUnit 상속, 기계화 유닛이기때매 Repairable 인페 구현받음
class Tank extends GroundUnit implements Repairable {
	public Tank() {
		// Tank의 최대체력 150
		super(50);
		// 최대 체력과 현재 체력을 똑같이 만들어주기
		hitPoint = MAX_HP;
	}
	
	// "Tank" 문자열 반환할 메소드
	public String toString() {
		return "Tank";
	}
	
}




// SCV 지상유닛 클래스 만들기  <--지상유닛 :GruondUnit 상속, 기게화 유닛 :Repairable 인페
class SCV extends GroundUnit implements Repairable {
	public SCV() {
		// scv 객체 최대체력 60 초기화 
		super(60);
		// 현재 체력 == 최대체력과 같게 만들기 
		hitPoint = MAX_HP;
	}
	
	// 유닛(Unit, dropship, scv)을 치료하는 기능의 메소드
	void repair(Repairable r) {
		Unit u = (Unit)r; 	// 실제 위 3개의 객체 중 하나가 될 것이다
		
		// 매개변수로 전달받아 u변수에 저장된 tank 또는 dropship 또는 scv객체의
		// 현재 체력이 최대 체력과 같지 않을 동안만 (피가 줄어들었으면) 반복해서 치료하자
		while(u.hitPoint != u.MAX_HP) {
			// HP 증가 (치료)
			u.hitPoint++;
			
		}
		// 현재 체력이 최대 체력과 같을 때 (치료가 끝났으면, 피가 최대치가 되었을 때 ) 수리 완료 출력
		System.out.println(u.toString() + "의 수리가 끝났습니다.");
		
	}
	
}





// 지상 유닛인 마린 클래스 만들기 <-- GroundUnit, 
class Marine extends GroundUnit {
	// 생성자
	public Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
}


// 공중 유닛들을 묶어서 표현하기 위한 AirUnit클래스 만들기 <-- Unit 클래스 상속받기
class AirUnit extends Unit {
	// 생성자 : 공중 유닛의 최대 체력 초기화
	public AirUnit(int hp) {
		super(hp);
	}
}



// 공중 유닛 중에서 DropShip 클래스 만들기 <ㅡ-- AirUnit 클래스 상속ㅡ, 기계화 유닛 



public class Test112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
