class Animal {

	// Animal 클래스 만들기
		
		//변수
		// 동물의 이름을 문자열로 저장시킬 name변수 선언
		String name;
		// 동물의 나이를 정수로 저장시킬 age변수 선언
		int age;
		
		// 기본 생성자
			// name변수에 "개" 저장
			// age변수에 3 저장
		Animal() {
			name = "개";
			age = 3;
		}
		
		// 동물의 이름을 n_name매개변수로 전달 받아 name변수에 저장할 생성자
			// name변수에 n_name매개변수로 전달받은 이름을 저장
			// age변수에 1 저장
		Animal(String n_name){
			name = n_name;
			age = 1;
		}
		
		// 동물의 나이를 n_age매개변수로 전달받아 age변수에 저장할 생성자
			// name변수에 "동물" 저장
			// age변수에 n_age 매개변수로 전달받은 나이 저장
		Animal(int n_age) {
			name = "Animal";
			age = n_age;
		}
		
		// 동물의 이름과 나이를 매개변술 전달받아 name변수와 age변수에 각각 저장할 생성자
			// name변수에 n_name매개변수로 전달받은 이름 저장 
			// age변수에 n_age매개변수로 전달받은 나이 저장
		Animal(String n_name, int n_age) {
			name = n_name;
			age = n_age;
		}
		
		
		// 메소드
		// name변수에 새로운 값을 저장할 용도의 메소드
		void setName(String n_name) {
			name = n_name;
		}
		
		// age변수에 새로운 값을 지정할 용도의 메소드
		void setAge(int n_age) {
			age = n_age;
		}
		
		// name변수에 저장되어 있는 값을 제공(반환) 해주는 용도의 메소드
		String getName() {
			return name;
		}
		
		// age변수에 저장되어 있는 값을 제공(반환)해주는 용도의 메소드 
		int getAge() {
			return age;
		}
		
		
		void run() {
			System.out.println(name + " 뛴다");
		}
		
}

public class Test62 {

	public static void main(String[] args) {
		// 출력할 내용
		/*
			개 뛴다
			고양이 뛴다
			사자 뛴다
			10
			====================
			토끼 뛴다
			2
			기린 뛴다
			4

		*/
		
		
		Animal animal = new Animal();
		animal.run();
		
		animal.name = "고양이";
		animal.run();
		
		animal.setName("사자");
		animal.setAge(10);
		System.out.println(animal.getName());
		System.out.println(animal.getAge());
		
		System.out.println("============================");
		
		Animal rabbitAnimal = new Animal("토끼", 2);
		rabbitAnimal.run();
		System.out.println(rabbitAnimal.getAge());
		
		rabbitAnimal.setName("기린");
		rabbitAnimal.setAge(4);
		rabbitAnimal.run();
		System.out.println(rabbitAnimal.getAge());
		
		
	}

}
