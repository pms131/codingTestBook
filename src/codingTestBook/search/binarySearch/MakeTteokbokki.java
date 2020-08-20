package codingTestBook.search.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MakeTteokbokki {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();		// (1 <= n <= 1,000,000)
		int m = scan.nextInt();		// (1 <= m<= 2,000,000,000)

		scan.nextLine();
		
		String str = scan.nextLine();
		
		StringTokenizer st = new StringTokenizer(str, " ");

		List<Integer> list = new ArrayList<Integer>();
		
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
				
		int answer = binarySearch(list, m);
		
		System.out.println(answer);
	}
	
	public static int binarySearch(List<Integer> list, int m) {
		int answer = 0;
		Collections.sort(list);
		int start = 0;
		int end = list.get(list.size()-1);
		
		
		do {
			int mid = (start + end) / 2;
			int sum = 0;	
			
			for (int val : list) {
				if (val > mid) {
					sum += (val - mid);
				}
			}
			
			if (sum < m) {
				end = mid - 1;
			} else {
				answer = mid;
				start = mid + 1;
			}
			
		}  while(start <= end);
		
		
		return answer;
	}

}
