/**
 * 
 */
package codingTestBook.implement;

/**
 * 2020 KAKAO BLIND RECRUIT
 * programmers.co.kr/learn/courses/30/lessons/60057
 *
 */
public class SummerizeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "ababcdcdababcdcd";
		int answer = solution(s);
		
		System.out.println(answer);
		
	}


    public static int solution(String s) {
        int answer = 0;
        char[] chArr = s.toCharArray();
        
        String before = s;
        
        for (int i=1; i <= chArr.length/2; i++) {
        	
        	String subStr = s.substring(0, i);
            String tmp = "";
            int cnt = 1;
        	
        	for (int j=i; j<chArr.length; j+=i) {
        		if (j+i <= chArr.length) {
	        		if (subStr.equals(s.substring(j, j+i)) ) {
	        			cnt++;
	        		} else {
	        			if (cnt != 1) {
	        				tmp += String.valueOf(cnt) + subStr;
	        			} else {
	        				tmp += subStr;
	        			}
	        			subStr = s.substring(j, j+i);
	        			cnt = 1;
	        		}
        		} else	// 다음으로 비교할 문자열 인덱스가 문자열 총 길이보다 큰 경우
        			subStr = s.substring(j-i);
        	}
        	
        	if (cnt != 1) {
				tmp += String.valueOf(cnt) + subStr;
			} else {
				tmp += subStr;
			}
        	
        	if (tmp.length() < before.length())
        		before = tmp;
        }
        
        answer = before.length();
        
        return answer;
    }
}
