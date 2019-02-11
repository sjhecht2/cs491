import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(in);
		String temp = reader.readLine();
		while (Integer.parseInt(temp) != 0) {
			temp = reader.readLine();
			String[] arr = temp.split(" ");
			PriorityQueue<Integer> min = new PriorityQueue<Integer>();
			for(String a: arr) {
				min.add(Integer.parseInt(a));
			}
			int total = 0;
			while(min.size() >= 2) {
				int a = min.poll();
				int b = min.poll();
				total += a + b;
				min.add(a + b);
			}
			System.out.println(total);
			temp = reader.readLine();
		}
	}
}
