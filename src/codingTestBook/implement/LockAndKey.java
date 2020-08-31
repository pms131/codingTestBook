package codingTestBook.implement;


/**
 * 2020 KAKAO BLIND RECRUIT
 * programmers.co.kr/learn/courses/30/lessons/60059
 *
 */
public class LockAndKey {

	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		boolean answer = solution (key, lock);
		
		System.out.println(answer);
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int keySize = key.length;
		int lockSize = lock.length;
		int[][] compLock = new int[lockSize + 2*(keySize-1) ][lockSize + 2*(keySize-1) ];
        
        
        for(int i=keySize-1; i < keySize + lockSize -1; i++) {
        	for(int j = keySize-1; j < keySize + lockSize -1; j++) {
        		compLock[i][j] = lock[i-keySize+1][j-keySize+1];
        	}
        }
        
        
        for (int k=0; k<4; k++) {
        	// 360도 회전
        	key = rotate_90_degree(key);
        	
        	        	
        	for(int i=0; i<keySize+lockSize-1; i++) {
        		for (int j=0; j<keySize+lockSize-1; j++) {
        			
        			// 자물쇠에 키를 더함
        			for (int y=0; y<keySize; y++) {
        				for (int x=0; x < keySize; x++) {
        					compLock[i+y][j+x] += key[y][x];
        				}
        			}
        			
        			// 자물쇠 잠금이 해결 됐는지 확인 함수
        			if (isResolve(compLock, keySize, lockSize))
        				return true;
        			
        			// 자물쇠 원복
        			for (int y=0; y<keySize; y++) {
        				for (int x=0; x < keySize; x++) {
        					compLock[i+y][j+x] -= key[y][x];
        				}
        			}
        			
        		}
        	}
        }
        
        
        return answer;
    }
	
	
	/* 행렬 시계방향 90도 회전 함수 */
	public static int[][] rotate_90_degree(int[][] intArr) {
		int col = intArr.length;
		int row = intArr[0].length;
		int[][] tmp = new int[row][col];
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<row; j++ ) {
				tmp[i][row-j-1] = intArr[j][i];
			}
		}
		
		return tmp;
	}
	
	public static boolean isResolve(int[][] compLock, int keySize, int lockSize) {
		boolean resolve = true;

        for(int i=keySize-1; i < keySize + lockSize -1; i++) {
        	for(int j = keySize-1; j < keySize + lockSize -1; j++) {
				if (compLock[i][j] != 1)
					return false;
			}
		}
		
		return resolve;
	}
}
