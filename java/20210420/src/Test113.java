// Tank, dropship, scv	<-- 기계 유닛이기 때문에
// repairable 인터페이스 만들기
interface Repairable{
	
}

// dropship을 제외한 나머지 유닛들은 Boardable 인터페이스 구현한다
interface Boardable {
	
}


// marin과 medic은 사람이기 때문에 Healable 인터페이스 구현 
interface Healable {
	
}

//최고 조상 추상 유닛클래스 만들기
abstract class Unit {
	// 유닛의 현재 체력을 저장할 변수
	int hitPoint;
	
	// 유닛의 최대 체력을 한번만 초기화해서 저장할 상수
	final int MAX_HP;
	
	// Unit객체 생성시 유닛의 최대 체력을 초기화할 생성자
	Unit(int hp){
		MAX_HP = hp;
	}
	// 추상메소드
	// 각각의 유닛은 무브 사운드와 어택 사운드를 가지고 있지만
	// 유닛마다 다른 고유의 소리를 가지고 있기 때문에
	// 미완성 메소드인 추상 메소드를 작성해놓자
	
	// 무브 사운드 기능의 추상 메소드 
	public abstract void move_sound();
	// 어택 사운드 기능의 추상 메소드
	public abstract void attack_sound();
	
// 일반 메소드
	// 모두 같은 ok 사운드는 그냥 일반 메소드에 구현해준다
	public void ok_sound() {
		System.out.println("OK");
	}
	
}

// 마린 클래스 
// ( 유닛 추상클래스 상속받고, 사람이기 때문에 Healable인페 구현,
// dropship을 제외한 나머지 유닛이기 때문에 Boardable 인터페이스 구현받는다
class Marine extends Unit implements Healable, Boardable{
	
	Marine() {
		super(40);
	}

	@Override
	public void move_sound() {
		System.out.println("go!go!go!");
		
	}

	@Override
	public void attack_sound() {
		System.out.println("fire");		
	}
	
}


// 메딕 클래스 만들기 (Unit 추상 클래스 상속 받고,
// 사람 유닛이기 떄문에 Healable 인터페이스 구현 받고
// dropship 유닛을 제외한 나머지 유닛에 해당하므로 Boardable 인페 구현
class Medic extends Unit implements Healable, Boardable {
	public Medic() {
		super(40);
	}

	// Unit 추상 클래스의 추상 메소드 (무브 사운드 기능의 메소드)를 메딕에 맞게 오버라이딩
	@Override
	public void move_sound() {
		System.out.println("메딕 이동한다");
		
	}

	@Override
	public void attack_sound() {
		System.out.println("메딕 공격한다");
	}
	
	// 유닛을 치료하는 기능의 일반메소드
	// Healable 부모 인터페이스를 구현한 자식 객체들 (Marin, Medic)을 매개변수로 전달받아 치료
	public void heal(Healable r) {
		Unit u = (Unit)r;
		while(u.hitPoint != u.MAX_HP) {
			u.hitPoint++; // 유닛의 현재 체력을 1씩 증가시켜 치료
			System.out.println("치료중.. " + u.hitPoint);
		}
		
		System.out.println("치료완료");
	}
}


// scv 클래스 (Unit 추상 클래스 상속, dropship을 제외한 나머지 유닛에 속하므로
// Boardable인페 구현, 기계유닛이므로 Repairable인페 구현
class SCV extends Unit implements Boardable, Repairable {
	// SCV 처음 최대 체력 60으로 초기화 할 생성자
	public SCV() {
		super(60);
	}

	@Override
	public void move_sound() {
		System.out.println("위잉");
		
	}

	@Override
	public void attack_sound() {
		System.out.println("지지직");
	}
	
	// 유닛 치료하는 기능의 메소드
	public void repair(Repairable r) {
		Unit u = (Unit)r;
		while(u.hitPoint != u.MAX_HP) {
			// 치료 
			u.hitPoint++;
			System.out.println("수리 중 ... >" + u.hitPoint);
		}
		
		// 현재 체력이 최대 체력과 같아질 때 수리완료
		System.out.println("수리 완료");
	}
}


// Tank 클래스 만들기 (Unit 추상 클래스 상속,
// dropShip을 제외한 나머지 유닛에 속하므로 Boardable 인터페이스 구현,
// 기계 유닛이기 때문에 Repairable 인터페이스 구현
class Tank extends Unit implements Boardable, Repairable {
	public Tank() {
		super(150);
	}

	@Override
	public void move_sound() {
		System.out.println("탱크 움직임");
		
	}

	@Override
	public void attack_sound() {
		System.out.println("탱크 공격");
	}
	
	public void mode_sound() {
		System.out.println("wung");
	}
	
}


// DropShip 클래스 만들기 (Unit 추상클래스 상속)
class DropShip extends Unit implements Repairable {
	DropShip() {
	   super(100);	
	}

	@Override
	public void move_sound() {
		System.out.println("슝~");
	}

	@Override
	public void attack_sound() {
		System.out.println("덜컹");
	}
	
	// 일반 메솓 ㅡ
	public void mode_sound() {
		System.out.println("덜커덕");
	}
	
	// 유닛을 태우는 기능을 하는 일반 메소드
	public void tab(Boardable b) {
		System.out.println("태웠음");
	}
}

public class Test113 {

	public static void main(String[] args) {
		Marine m = new Marine();
		Tank tank = new Tank();
		SCV scv = new SCV();
		Medic medic =new Medic();
		DropShip dropShip= new DropShip();
		
		System.out.println("마린 10뎀");
		
		m.hitPoint = 30;
		System.out.println("메딕으로 마린 치료");
		medic.heal(m);
		m.ok_sound();
		m.move_sound();
	
		
		System.out.println("탱크 10뎀");
		tank.hitPoint = 140;
		System.out.println("SCV로 탱크 치료중");
		scv.repair(tank);
		tank.ok_sound();
		tank.move_sound();
		tank.mode_sound();
		
		
		
		
		
		
	}
}
