package codingTestBook.implement;

import java.util.Scanner;

public class Time {

	public static void main(String[] args) {
		
		System.out.print("시간을 입력하세요 : ");

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();		// (0 <= n <= 23)
		int count = 0;
		
		for(int hour = 0; hour < n+1; hour++ ) {
			for (int min = 0; min < 60; min++ ) {
				for (int sec = 0; sec < 60; sec++) {
					StringBuffer sb = new StringBuffer();
					String strHour = String.valueOf(hour);
					String strMin = String.valueOf(min);
					String strSec = String.valueOf(sec);
					
					sb.append(strHour).append(strMin).append(strSec);
					
					String time = sb.toString();
					
					if (time.contains("3"))
						count++;
				}
			}
		}
		
		System.out.println(count);
		
		return;
	}

}
