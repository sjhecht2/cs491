import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		int i = 1;
		int discard = sc.nextInt();
		PriorityQueue<Integer> min = new PriorityQueue<Integer>(Collections.reverseOrder());
		while(sc.hasNext()) {
			int temp = sc.nextInt();
			if(temp == 0) {
			    	while(total < 5000000 && min.size() != 0) {
			        	total += 2*Math.pow(min.poll(),i);
			        	i++;
			    	}
				if(total > 5000000) System.out.println("Too expensive");
				else System.out.println(total);
				total = 0;
				i = 1;
				min = new PriorityQueue<Integer>(Collections.reverseOrder());
			}
			min.add(temp);
		}
	}
}
