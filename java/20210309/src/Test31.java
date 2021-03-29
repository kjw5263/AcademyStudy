
public class Test31 {

	public static void main(String[] args) {
		// 문제 : while반복문을 사용하여 1부터 몇까지를 더하면 누적합계가 100에 가까워지는지 계산하는 예제
		int sum = 0;
		int i = 0;
		
		while(sum + i <= 100) {
			sum += ++i;
			System.out.println(i + "-" + sum);
		}

	}

}
