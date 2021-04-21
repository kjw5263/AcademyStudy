import java.util.ArrayList;

class Arr {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList arrayList = new ArrayList();
        int sum = 0;
        for (int i=0; i<numbers.length; i++){
            for (int j=0; j<numbers.length; j++){
                if( i != j ) {
                	sum = numbers[i] + numbers[j];
                	arrayList.add(sum);
                	
                }
            }
        }
        return answer;
    }
}


public class Solution {

	public static void main(String[] args) {
		Arr arr = new Arr();
		int[] bb = {1,2,3,4,5};
		arr.solution(bb);
        
	}

}
