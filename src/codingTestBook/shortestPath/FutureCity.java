package codingTestBook.shortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class FutureCity {

	public static final int INT = (int)1e9;
	
	public static int[][] graph = new int[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();			// 회사의 개수 (1 <= n <= 100)
		int m = sc.nextInt();			// 경로의 개수 (1 <= n <= 100)
		
		
		for (int i = 0; i <= n; i++) {
			Arrays.fill(graph[i], INT);
		}
		
		for (int i=1; i<=m; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}
		
		int x = sc.nextInt();
		int k = sc.nextInt();
		
		// 1 -> k 최소 거리 설정
		for (int i =2; i <= n; i++) {
			graph[1][k] = Math.min(graph[1][k], graph[1][i] + graph[i][k]); 
		}
		
		// k -> x 최소거리 설정
		for (int i =2; i <= n; i++) {
			graph[k][x] = Math.min(graph[k][x], graph[k][i] + graph[i][x]); 
		}

		int dist = graph[1][k] + graph[k][x];
		
		if (dist < INT)
			System.out.println(dist);
		else
			System.out.println(-1);
	}

}
