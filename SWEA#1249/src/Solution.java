import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Solution {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			
			int N = sc.nextInt();
			boolean[][] visited = new boolean[N][N];
			int[][] matrix = new int[N][N];
			Queue<Point> que = new LinkedList<>();
			int[][] cost = new int[N][N]; // 해당 좌표까지의 비용을 저장하는 배열
			for(int i = 0; i < N; i++) {
				String s = sc.next();
				char[] input = s.toCharArray();
				for(int j = 0; j < N; j++) {
					matrix[i][j] = input[j] - 48;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			
			que.add(new Point(0, 0));
			visited[0][0] = true;
			cost[0][0] = 0;
			while(!que.isEmpty()) {
				Point now = que.poll();
				if(now.x == N - 1 && now.y == N - 1) {
					continue;
				}
				for(int k = 0; k < 4; k++) { //4방향 체크
					int nextX = now.x + dx[k];
					int nextY = now.y + dy[k];
					if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
						if(!visited[nextX][nextY]) { // 만약 방문하지 않았다면 무조건 방문
							que.add(new Point(nextX, nextY));
							visited[nextX][nextY] = true;
							cost[nextX][nextY] = cost[now.x][now.y] + matrix[nextX][nextY];
						}else if(cost[nextX][nextY] > cost[now.x][now.y] + matrix[nextX][nextY]) { // 방문했으나 비용이 더 적다면 다시 방문
							cost[nextX][nextY] = cost[now.x][now.y] + matrix[nextX][nextY];
							que.add(new Point(nextX, nextY));
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + cost[N-1][N-1]);
		}
		sc.close();
	}

}
