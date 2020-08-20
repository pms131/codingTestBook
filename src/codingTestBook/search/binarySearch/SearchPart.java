package codingTestBook.search.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SearchPart {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt(); // (1 <= n <= 1,000,000)
		
		scan.nextLine();		// 버퍼 제거
		
		String firstStr = scan.nextLine();
		firstStr = firstStr.replaceAll(" ", "");
		List<Integer> storePart = new ArrayList<Integer>();
		
		for (char ch : firstStr.toCharArray()) {
			storePart.add(Character.getNumericValue(ch));
		}
		
		int m = scan.nextInt();	// (1 <= m <= 100,000)
		
		scan.nextLine();		// 버퍼 제거
		
		String secondStr = scan.nextLine();
		secondStr = secondStr.replaceAll(" ", "");
		List<Integer> customerPart = new ArrayList<Integer>();
		
		for(char ch : secondStr.toCharArray()) {
			customerPart.add(Character.getNumericValue(ch));
		}
		
		Collections.sort(storePart);
		
		List<Boolean> answerList = new ArrayList<Boolean>();
		
		for (int i=0; i<customerPart.size(); i++) {
			boolean answer = binarySearch(storePart, customerPart.get(i));
			answerList.add(answer);
			System.out.println(answer ? "yes" : "no"  + " ");
		}
		
		return;
	}
	
	public static boolean binarySearch(List<Integer> storePart, int target) {
		boolean answer = false;
		int start = 0;
		int end = storePart.size() -1;
		
		 do {
			int mid = (start + end) /2;

			if (storePart.get(mid) == target) {
				answer = true;
				break;
			}
			else if (storePart.get(mid) > target) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}

		} while (start <= end) ;
		
		
		return answer;
		
	}

}
