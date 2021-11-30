import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt();
			int[] building = new int[num];
			for(int i = 0; i < num; i++) {
				building[i] = sc.nextInt();
			}

			int result = 0;

			for(int i = 0; i < num; i++) {
				if(building[i] > 0) {
					int clear = Integer.MAX_VALUE;
					if(building[i] > building[i - 1]) {
						clear = Math.min(clear, building[i] - building[i - 1]);
					}else {
						continue;
					}

					if(building[i] > building[i - 2]) {
						clear = Math.min(clear, building[i] - building[i - 2]);
					}else {
						continue;
					}

					if(building[i] > building[i + 1]) {
						clear = Math.min(clear, building[i] - building[i + 1]);
					}else {
						continue;
					}

					if(building[i] > building[i + 2]) {
						clear = Math.min(clear, building[i] - building[i + 2]);
					}else {
						continue;
					}
					
					result += clear;
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

}
