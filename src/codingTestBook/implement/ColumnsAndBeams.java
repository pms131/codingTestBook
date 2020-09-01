package codingTestBook.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 2020 KAKAO BLIND
 * https://programmers.co.kr/learn/courses/30/lessons/60061
 */
class Result implements Comparable<Result> {
	private int x;
	private int y;
	private int structure;
	
	public Result(int x, int y, int structure) {
		this.x = x;
		this.y = y;
		this.structure = structure;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getStructure() {
		return structure;
	}
	public void setStructure(int structure) {
		this.structure = structure;
	}

	@Override
	public int compareTo(Result o) {
		if (o.getX() < this.getX()) {
			return 1;
		} else if (o.getX() == this.getX()) {
			if (o.getY() < this.getY()) {
				return 1;
			} else if (o.getY() == this.getY()) {
				if (o.getStructure() < this.getStructure()) {
					return 1;
				}
			}
		}
		return -1;
	}

}

public class ColumnsAndBeams {

	public static void main(String[] args) {
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}}		;
		int n = 5;
		
		int[][] answer = solution(n, build_frame);
		
		Arrays.stream(answer).flatMapToInt(Arrays::stream).forEach(e -> System.out.print(e + ", "));

	}
	

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        List<Result> list = new ArrayList<Result>();
        
        
        for (int i=0; i < build_frame.length; i++) {
    		int x = build_frame[i][0];
    		int y = build_frame[i][1];
    		int structure = build_frame[i][2];
    		int installYn = build_frame[i][3];

			// 삭제인 경우
			if (installYn == 0) {
				int index = 0;
				
				for (int j=0; j < list.size(); j++) {
					if (x == list.get(j).getX() && y == list.get(j).getY() && structure == list.get(j).getStructure()) {
						index = j;
					}
				}

		        Result erased = list.get(index);
		        list.remove(index);
		        if (!possible(list)) {
		        	list.add(erased);
		        }
		        
			} else {
				list.add(new Result(x, y, structure));
				int index = list.size() -1;
				if (!possible(list))
					list.remove(index);
			}
        }
        
        Collections.sort(list);
        
        answer = new int[list.size()][3];
        
        for (int i=0; i<list.size(); i++) {
        	int[] frame = {list.get(i).getX(), list.get(i).getY(), list.get(i).getStructure()};
        
        	
        	answer[i] = frame;
        }
        
        
        
        return answer;
    }
    
    private static boolean possible(List<Result> list) {
    	for (int i=0; i<list.size(); i++) {
    		int x = list.get(i).getX();
    		int y = list.get(i).getY();
    		int structure = list.get(i).getStructure();
    		
    		// 기둥인 경우
    		if (structure == 0) {
    			boolean check = false;
    			
    			// 바닥 위
    			if (y == 0)
    				check = true;
    			
    			//보의 한 쪽 끝 위, 또는 다른 기둥 위
    			for (int j=0; j<list.size(); j++) {
    				// 다른 기둥 위
    				if (x == list.get(j).getX() && y-1 == list.get(j).getY() && 0 == list.get(j).getStructure()) {
    					check = true;
    				}
    				//보의 한쪽 끝
    				if (x-1 == list.get(j).getX() && y == list.get(j).getY() && 1 == list.get(j).getStructure()) {
    					check = true;
    				}
    				// 보의 한쪽 끝
    				if (x == list.get(j).getX() && y == list.get(j).getY() && 1 == list.get(j).getStructure()) {
    					check = true;
    				}
    			}
    			
        		if (!check)
        			return check;
        		
    		} else if (structure == 1) {	// 보인 경우
    			boolean check = false;
    			boolean left = false;
    			boolean right = false;
    			
    			// 보의 한쪽 끝부분이 기둥 위 or 양쪽 끝 부분이 다른 보와 동시 연결
    			for (int j=0; j<list.size(); j++) {
    				// 보의 한쪽 끝부분이 기둥 위
    				if (x == list.get(j).getX() && y-1 == list.get(j).getY() && 0 == list.get(j).getStructure()) {
    					check = true;
    				}
    				// 보의 한쪽 끝부분이 기둥 위
    				if (x+1 == list.get(j).getX() && y-1 == list.get(j).getY() && 0 == list.get(j).getStructure()) {
    					check = true;
    				}
    				// 왼쪽 끝 부분이 다른 보와 동시 연결
    				if (x-1 == list.get(j).getX() && y == list.get(j).getY() && 1 == list.get(j).getStructure()) {
    					left = true;
    				}
    				// 오른쪽 끝 부분이 다른 보와 동시 연결
    				if (x+1 == list.get(j).getX() && y == list.get(j).getY() && 1 == list.get(j).getStructure()) {
    					right = true;
    				}
    			}
    			
    			if (left && right)
    				check = true;
    			
    			if (!check)
    				return check;
    		}
    		
    	}
    	
    	
		return true;
	}

}
