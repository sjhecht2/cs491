import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double sum = 0;
		for(int i = 0; i < 12; i++) {
			sum += scan.nextDouble();
		}
		sum = sum / 12.0;
		sum = Math.round(sum * 100.0) / 100.0;
		System.out.println("$" + sum);
	}
}
