import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String line;
		while((line = sc.nextLine()) != null) {
			int n = line.length();
			int i, j, sub;
			int mem[][] = new int[n][n];
			
			for (i = 0; i < n; i++) {
				mem[i][i] = 1;
			}
			for (sub = 2; sub <= n; sub++) {
				for (i = 0; i < n - sub + 1; i++) {
					j = i + sub - 1;
					
					if (line.charAt(i) == line.charAt(j) && sub == 2) mem[i][j] = 2;
					else if (line.charAt(i) == line.charAt(j)) mem[i][j] = mem[i+1][j-1] + 2;
					else mem[i][j] = (mem[i][j-1] > mem[i+1][j]) ? mem[i][j-1] : mem[i+1][j];
				}
			}
			System.out.println(mem[0][n-1]);
		}
	}
}
