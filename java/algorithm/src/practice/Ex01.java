package practice;

import java.util.Scanner;

public class Ex01{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println( (b % 10) * a );
        System.out.println( ((b % 10)/10) * a );
        System.out.println( (b % 100) * a );
        System.out.println( (b % 10) * a + ((b % 10)/10 * a)*10 + ((b % 100) * a)*10);
    }
}