package codingTestBook.shortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {

	public static final int INF = (int) 1e9;
	
	public static int n,m,start;
	
	public static int[][] graph = new int[501][501];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i=0; i<501; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j <=n; j++) {
				if (i == j)
					graph[i][j] = 0;
			}
		}
		
		// 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A에서 B로 가는 비용은 C라고 설정
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }
        
        for (int i=1; i <= m; i++) {
        	for (int j=1; j <= n; j++) {
        		for (int k=1; k <= n; k++) {
        			graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
        		}
        	}
        }
        
        System.out.println();
        
        for (int i=1; i <= n; i++) {
        	for (int j=1; j <= n; j++) {
        		if (graph[i][j] != INF)
        			System.out.print(graph[i][j] + " ");
        	}
        	System.out.println();
        }
        
	}

}
