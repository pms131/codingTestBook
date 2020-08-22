package codingTestBook.graph;

import java.util.Scanner;

public class IsCycle extends EachOther{
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	
	    v = sc.nextInt();
	    e = sc.nextInt();
	
	    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
	    for (int i = 1; i <= v; i++) {
	        parent[i] = i;
	    }
	
	    boolean cycle = false; // 사이클 발생 여부
	
	    for (int i = 0; i < e; i++) {
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        
	        // 사이클이 발생한 경우 종료
	        if (findParent(a) == findParent(b)) {
	            cycle = true;
	            break;
	        }
	        // 사이클이 발생하지 않았다면 합집합(Union) 연산 수행
	        else {
	            unionParent(a, b);
	        }
	    }
	
	    if (cycle) {
	        System.out.println("사이클이 발생했습니다.");
	    }
	    else {
	        System.out.println("사이클이 발생하지 않았습니다.");
	    }
	}
}
