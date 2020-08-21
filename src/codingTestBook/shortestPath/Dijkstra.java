package codingTestBook.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dijkstra {
	
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정

	private static int n, m, start;
	
	private static List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	private static boolean[] visited = new boolean[100001];
	
	private static int[] dist = new int[100001];
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();			// node의 개수
		m = sc.nextInt();			// 간선의 개수
		start = sc.nextInt();		// 시작 node
		
		for (int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		// 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }
        
        Arrays.fill(dist, INF);
        
        dijkstra(start);
        
        for (int i=1; i<=n; i++) {
        	if (dist[i] == INF)
        		System.out.println("Infinity");
        	else
        		System.out.println(dist[i]);
        }
	}

	public static void dijkstra(int start) {
		dist[start] = 0;
		visited[start] = true;
		//시작 노드와 거리 초기화
		for (int i=0; i<graph.get(start).size(); i++) {
			dist[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
		}
		
		//시작 노드를 제외한 전체 n-1개의 노드에 대해 반복
		for (int i=0; i<n-1; i++) {
			//현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리
			int now = getSmallestNode();
			visited[now] = true;
			
			//현재 노드와 연결된 다른 노드 확인
			for (int j=0; j < graph.get(now).size(); j++) {
				int cost = dist[now] + graph.get(now).get(j).getDistance();
				
				if (cost < dist[graph.get(now).get(j).getIndex()]) {
					 dist[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}
	
	public static int getSmallestNode() {
		int min_value = INF;
		int index = 0;
		for (int i=1; i<=n; i++) {
			if (dist[i] < min_value && !visited[i]) {
				min_value = dist[i];
				index = i;
			}
		}
		return index;
	}
}
