import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		int[][] prefixSum = new int[n + 1][n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				prefixSum[i][j] += prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i + 1][j + 1] + arr[i][j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int left = 0; left < n; left++) {
			for (int right = left + 1; right < n + 1; right++) {
				int min = 0;
				for(int i = n-1; i >= 0; i--) {
					int temp = prefixSum[left][i] - prefixSum[right][i];
					max = Math.max(max, temp-min);
					min = Math.min(temp, min);
				}
			}
		}
	
		System.out.println(max);

	}

}
