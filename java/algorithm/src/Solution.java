
public class Solution {

	public static void main(String[] args) {
		int a=3;
		int b=3;
		int sum=0;
		long answer = 0;
		int count = Math.abs(a-b);
        
        if(a > b) {
        	for(int i=0; i < count ; i++) {
            	sum += (b + i);
        	}
        	sum += a;
        	System.out.println(sum);
        } else if ( b < a) {
        	for(int i=0; i < count ; i++) {
            	sum += (a + i);
        	}
        	sum += b;
        	System.out.println(sum);
        } else if ( a == b) {
        	answer = a;
        	System.out.println(a);
        }
        
	}

}
