// 추상 클래스 연습
// 문제 ㅣ 추상클래스(Animal) 내부에는 추상 메소드 speak가 존재한다.
//		추상클래스(Animal)를 상속하여 Dog클래스와 Cat 클래스를 정의한 후
//		각 동물의 올음소리를 출력시키시오
//


// 추상클래스 (Animal) 만들기
abstract class Animal {
	// 동물의 소리내기 기능을 하는 추상 메소드 speak 선언, 리턴타입 String
	abstract String speak();
}

	

// Animal클래스를 상속받는 Dog자식클래스 만들기
//클래스는 다중 상속을 허용하지 않는다.
class Dog extends Animal {

	@Override
	String speak() {
		// TODO Auto-generated method stub
		return "멍멍멍 멍멍";
	}
	// speak 추상 메소드 강제로 오버라이딩 하기
		// 오버라이딩 할 내영 = > 멍멈엄ㅇ 멍멍 반환 

}


//Animal클래스를 상속받는 Cat자식클래스 만들기
	// speak 추상 메소드 강제로 오버라이딩 하기
		// 오버라이딩 할 내영 = > 냐옹냐ㅐ옹 반환 
class Cat extends Animal{

	@Override
	String speak() {
		// TODO Auto-generated method stub
		return "양냔옹";
	}
	
}

public class Test106 {

	public static void main(String[] args) {
		// 업캐스팅 하지 않은 출력결과
		// 냐옹냐옹
		// 멍ㅁ멍ㅁ엄ㅇ 멍멈ㅇ
		Cat cat = new Cat();
		System.out.println(cat.speak());
		Dog dog = new Dog();
		System.out.println(dog.speak());
		
		// 업캐스팅 한 결과
		// 냔얀ㅇ
		// 멍머
		Animal animal;
		animal = new Cat();
		System.out.println(animal.speak());
	}

}
