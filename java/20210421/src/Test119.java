
public class Test119 {

	public static void main(String[] args) {
		// String 클ㄹ스 내부에 만들어져있는 eqauls() 메소드, subString()
		// equals(Object o) 메소드 ->
		// 2; String 객체 모밀에 저장된 문자열 데이터를 비교할때 호출 하는 메소드
		// 두 문자열이 같으년 true룰 반환하고 두뮨저욜아 false를 만봔
		
		System.out.println("서로 다른 문자열 비교하기");
		String str1 = new String("coffee");
		String str2 = new String("House");
		
		if(str1.equals(str2)) {
			System.out.println("String 객체 메모리에 저장된 두 문자열은 같다");
		} else {
			System.out.println("String 객체 메모리에 저장된 두 문자열은 다르다");
		}
		
		System.out.println("서로 같은 문자열 비교하기");
		String str3 = new String("House");
		
		if(str2.equals(str3)) {
			System.out.println("String 객체 메모리에 저장된 두 문자열은 같다");
		} else {
			System.out.println("String 객체 메모리에 저장된 두 문자열은 다르다");
		}
		
		
		// subString 메소드 : 전체 문자열의 특정 문자열을 잘라내어 가져올 때 사용
		// 오버로딩 된 subString 메소드 2가지
		// substring(int arg0, int arg1)
		// : 지정한 인덱스 위치에서 특정 인덱스 위치까지의 문자열 잘라서 반환
		// substring(int arg0)
		// : 지정한 인덱스 위치에서 마지막 인덱스 위치까지의 문자열을 모두 잘라서 반환
		
		System.out.println("---전체 문자열의 특정 인덱스 위치의 문자열을 잘라내서 가져오기---");
		String a = new String("AndroidJSPJAVA");
		
		String tmp1;
		String tmp2;
		tmp1 = a.substring(7);
		System.out.println("tmp1 : " + tmp1);	//JSPJAVA
		
		
		// 7인덱스 위치에 존재하는 J부터, 10이전인덱스 위치인 9인덱스 위치에 존재하는 p문자까지의 문자열 jsp잘라내어 반환 
		tmp2 = a.substring(7,10);
		System.out.println("tmp2 : " + tmp2);	//JSP
		
		
		// String 클래스 내부에 존재하는 trim 메소드, concat 메소드
		
			// trim() 메소드
			// -> 전체 문자열 양끝에 빈 공백만 제거해서 제거된 문자열 반환
			// 		참고 : 전체 문자열 데이터의 중간에 있는 공백은 제거되지 않음
		
		System.out.println("---문자열의 양끝의 공백 제거---");
		String b = new String("       JA   VA    ");
		String tmp3 = b.trim();	// 양쪽 공백을 제거한 "JA  VA" 반환
		System.out.println(tmp3);
		
		
			// concat(String s)메소드
			// -> 두개의 문자열을 연결하여 하나의 문자열로 만들어서 반환
			//   사용법 
			//  (앞)연결할문자열객체.concat((뒤)연결할문자열객체)
		
		System.out.println("---concat 메소드를 이용하여 문자열 하나로 합치기");
		String c = "JAVA";
		String d = new String("PG");
		
		String tmp4, tmp5;
		
		tmp4 = c.concat(d);
		System.out.println("tmp4 : " + tmp4);  // "JAVAPG"
		
		tmp5 = c + d;
		System.out.println("tmp5 : " + tmp5);  //"JAVAPG"
		
		//String 클래스 내부에 만들어져 있는 contains 메소드, replace 메소드
			// contains 메소드
			// -> 전체 문자열에 원하는 문자열이 포함되어 있는지 확인하기 위한 메소드로 호출하면
			// 포함되어 있으면 true리턴, 포함되어있지 않으면 false 리턴
		String e = new String("필요없는문자열해당문자열필요없는문자열");
		
		System.out.println("해당 문자열이 포함되어 있는가? => " + e.contains("해당문자열"));
		System.out.println("'문자열'이 포함되어 있는가? => " + e.contains("문자열"));
		System.out.println("'JAVA'가 포함되어 있는가? => " + e.contains("JAVA"));
		
		
		// 결론 : public boolean contains(CharSequence s) 메소드
		// 매개변수로 CharSequence 클래스 타입의 매개변수 s인데
		// 사용버ㅗㅂ은 "String" 문자열 객체를 전달하여 사용하면 된다
		// -> 아무리 긴 문자열에도 우리가 원하는 단어가 포함되어있는지 찾을 수 잇게 도와주는 메소드
		
		
		// replace 메소드
		// -> 전체 문자열에서 원하는 단어를 찾아 바꾼 후 그 바뀐 문자열을 리턴해주는 메소드
		// -> 오버로딩된 replace메소드 종류
		// replace(char oldChar, char newChar)
		// - 문자 단위로 변경시켜주는 메소드
		// replace(charSequence target, charSequence replacement)
		// -> 문자열 단위로 변경시켜주는 메소드
		
		String f = new String("JAVAJSPC");
		// "JAVAJSPC" 전체 문자열 중에서 C문자만 !로 변경
		System.out.println("문자 단위로 변경-> " + f.replace('C', '!'));
		
		// "JAVAJSPC" 전체 문자열 중에서 "JSPC"부분을 다른 문자열로 변경
		System.out.println("문자열 단위로 변경=>" + f.replace("JSPC", "ANDROID"));
		
		
		// String 클래스 내부에 만들어져있는 그밖의 메소드듣ㄹ
			//String toLowerCase() 메소드
			// -> String 객체 메모리에 저장된 전체문자열의 모든 문자를 소문자로 바꿔 반홚
		
			// String toUpperCase() 메소드
			// -> String 객체 메모리에 저장된 전체 문자열의 모든 문자를 대문자로 바꿔 반환
		
			// static String valueOf(Object obj) 
			// -> 매개변수로 전달받는 데이터를 무조건 문자열객체로 변환해서 반환하는 메소드
		
		String value = String.valueOf(false);
		System.out.println(value);  // "false"
		value = String.valueOf(10);	// -> 숫자를 문자열로 변환해서 반환
		System.out.println(value);	// "10"
			// 참고
			// 숫자 형태의 문자열 "1000"을 숫자 1000으로 변환해서 반환해주는 메소드
		int rs= Integer.parseInt("1000");
		System.out.println(rs);
		
		
		/*
			
			
			
		*/
	}

}
