package codingTestBook.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Node o) {
		if (this.distance < o.distance)
			return -1;
		return 1;
	}
}

public class ImprovedDijkstra {

	public static final int INF = (int) 1e9;
	
	public static int n,m,start;
	
	public static List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	public static int[] distList = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int start = sc.nextInt();
		
		// 그래프 초기화
        for (int i = 0; i <= n; i++) {
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
        
        Arrays.fill(distList, INF);
        
        dijsktra(start);
        
        for (int i=1; i<=n; i++ ) {
        	if (distList[i] != INF)
        		System.out.println(distList[i]);
        	else
        		System.out.println("Infinity");
        }
	}
	
	public static void dijsktra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		//우선순위 큐 초기화
		pq.offer(new Node (start, 0));
		distList[start] = 0;
		
		while (!pq.isEmpty()) {
			//가장 짧은 거리에 있는 노드를 우선순위 큐에서 꺼내기
			Node node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			
			//현재 노드가 이미 방문하였다면 무시
			if (distList[now] < dist)
				continue;
			
			//현재 노드와 연결 된 인접 노드들 확인
			for (int i=0; i<graph.get(now).size(); i++) {
				int cost = distList[now] + graph.get(now).get(i).getDistance();
				
				if (cost < distList[graph.get(now).get(i).getIndex()]) {
					distList[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
			
		}
	}

}
