package codingTestBook.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeTeam {

	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] parent = new int[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		// 학생 수
		int m = sc.nextInt();		// 연산 횟수
		
		for (int i=0; i<=n; i++) {
			parent[i] = i;
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if (a == 0) {
				graph.get(b).add(c);
				unionParent(b,c);
			} else {
				if (getParent(b) == getParent(c)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
				
		}
	}

	public static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	public static int getParent(int x) {
		if (parent[x] != x)
			parent[x] = getParent(parent[x]);
			
		return parent[x];	
	}
}
