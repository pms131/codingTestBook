package codingTestBook.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class City implements Comparable<City> {
	private int index;
	private int distance;
	
	public City(int index, int distance) {
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
	public int compareTo(City o) {
		if (this.distance < o.distance)
			return -1;
		
		return 1;
	}
}

public class Transference {

	public static final int INF = (int) 1e9;
	
	public static List<ArrayList<City>> graph = new ArrayList<ArrayList<City>>();
	
	public static int d[] = new int[10001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 도시의 개수 (1 <= n <= 30,000)
		int m = sc.nextInt();	// 통로의 개수 (1 <= m <= 200,000)
		int c = sc.nextInt();	// 도시 (1 <= c <= n)
		
		int max = 0;
		int cityCount = 0;
		
		for (int i=0; i<=n; i++) {
			graph.add(new ArrayList<City>());
		}
		
		Arrays.fill(d, INF);
		
		for (int i=0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			graph.get(x).add(new City(y,z));
		}
		
		
		dijkstra(c);
		
		
		for (int i=1; i<=n; i++ ) {
        	if (d[i] != INF && d[i] != 0) {
        		cityCount++;
        		max = Math.max(max, d[i]);
        	}
        }
		
		System.out.println(cityCount + " " + max);
	}

	public static void dijkstra(int c) {
		PriorityQueue<City> pq = new PriorityQueue<City>();
		
		pq.offer(new City(c, 0));
		d[c] = 0;
		
		while (!pq.isEmpty()) {
			City city = pq.poll();

			int now = city.getIndex();
			int dist = city.getDistance();

			if (dist > d[now])
				continue;
			
			for (int i=0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					 d[graph.get(now).get(i).getIndex()] = cost;
					 pq.offer(new City(graph.get(now).get(i).getIndex(), cost));
				}
				
			}
		}
		
	}
	
}
