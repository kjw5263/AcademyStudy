import java.util.ArrayList;

class Arr {
    public String solution(int a, int b) {
    	String answer = "";
    	switch(a) {
    	case 1:
    		if(b % 7 == 1)
    			answer = "FRI";
    		else if(b % 7 == 2)
    			answer = "SAT";
    		else if(b % 7 == 3)
    			answer = "SUN";
    		else if(b % 7 == 4)
    			answer = "MON";
    		else if(b % 7 == 5)
    			answer = "TUE";
    		else if(b % 7 == 6)
    			answer = "WED";
    		else 
				answer = "THU";
			break;
   
    	case 2 :
    		if(b % 7 == 1)
    			answer ="MON";
    		else if(b % 7 == 2)
    			answer = "TUE";
    		else if(b % 7 == 3)
    			answer = "WED";
    		else if(b % 7 == 4)
    			answer = "THU";
    		else if(b % 7 == 5)
    			answer = "FRI";
    		else if(b % 7 == 6)
    			answer = "SAT";
    		else 
    			answer = "SUN";
    		break;
    	case 3 :
    		if(b % 7 == 1)
    			answer = "TUE";
    		else if(b % 7 ==2)
    			answer = "WED";
    		else if(b % 7 ==3)
    			answer = "THU";
    		else if(b % 7 ==4)
    			answer = "FRI";
    		else if(b % 7 ==5)
    			answer = "SAT";
    		else if(b % 7 ==6)
    			answer = "SUN";
    		else answer = "MON";
    		break;
    	case 4 : 
    		if(b % 7 ==1)
    			answer = "FRI";
    		if
    			
    	}
    }
}


public class Solution {

	public static void main(String[] args) {
		
		Arr arr = new Arr();
		System.out.println(arr.solution(5, 24));
		
		
	}

}
