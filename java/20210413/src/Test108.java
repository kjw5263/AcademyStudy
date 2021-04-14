/*
 * // 스타크래프드
 * 
 * // 지상유닛, 공중유닛 class Unit{ // 유닛 int currentHP; // 유닛의 현재 체력 int x; int y;
 * 
 * }
 * 
 * interface Movable{ // 지정된 위치로 이동시키는 인터페이스 // 지정된(x,y)로 이동하는 기능의 추상 메소드 public
 * abstract void move(int x, int y); }
 * 
 * interface Attactable{ // 지정된 대상(유닛)을 공격하는 기능의 추상메소드 public abstract void
 * attack(Unit u); }
 * 
 * interface Fightable extends Movable, Attactable{ // ======> 두개의 인터페이스를
 * 상속받음으로써 // 우리 눈에는 보이지 않지만 각각의 추상 메소드를 상속받고 있다. // void move(int x, int y); //
 * void attack(Unit u); }
 * 
 * // Fighter클래스는 Fightable 내부에 있는 추상 메소드를 오버라이딩 한다 // 참고 : 인터페이스 내부에 있는 추상메소드를
 * 강제로 오버라이딩 해야한다. class Fighter implements Fightable {
 * 
 * @Override public void move(int x, int y) { // 구현 생략
 * 
 * }
 * 
 * @Override public void attack(Unit u) { //구현생략
 * 
 * }
 * 
 * }
 * 
 * 
 * // 하나의 클래스를 상속받고, 하나의 인터페이스를 구현받아 새로운 클래스 설계 class Fighter2 extends Unit
 * implements Fightable{ /// Unit 클래스로부터 상속받은 멤버들 // int currentHP; // 유닛의 현재 체력
 * // int x; // int y;
 * 
 * // Fighter 인터페이스 내부의 추상 메소드로 강제 오버라이딩 // alt + shift + s + v
 * 
 * @Override public void move(int x, int y) { // 재구현 생략
 * 
 * }
 * 
 * @Override public void attack(Unit u) { // 재구현 생략
 * 
 * } }
 * 
 * // 사용된 클래스와 인터페이스 간의 관계도 그림
 * 
 * Object 클래스 Movable & Attackable 인터페이스 ^ ^ | | Unit 클래스 Fightable 인터페이스 ^ ^ |
 * | Fighter2 클래스
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * public class Test108 {
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * 
 * }
 * 
 * }
 */