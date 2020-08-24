package codingTestBook.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AdventurersGuild {

    public static int n;
    public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		// 1 <= n <= 100,000
		
		for (int i=0; i<n; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		
		int result = 0;
		int count = 0;
		
		for (int i=0; i<n; i++) {
			count += 1;
			if (count >= list.get(i) ) {
				result += 1;
				count = 0;
			}
		}
		
		System.out.println(result);
	}

}
