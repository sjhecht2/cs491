import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int max = 0;
		while(sc.hasNext()) {
			int temp = sc.nextInt();
			max = (temp > max) ? temp : max;
			if (temp != 0) list.add(temp);
		}
		int[] nums = new int[max + 1];
		nums[1] = 1;
		int f2 = 1;
		int f3 = 1;
		int f5 = 1;
		int f7 = 1;
		
		int i = 1;
		while(i < max) {
			int temp = minimum(nums[f2]*2, nums[f3]*3, nums[f5]*5, nums[f7]*7);
			if(temp == nums[f2]*2) f2++;
			if(temp == nums[f3]*3) f3++;
			if(temp == nums[f5]*5) f5++;
			if(temp == nums[f7]*7) f7++;
			nums[++i] = temp;
		}

		for(Integer a: list) {
			StringBuilder out = new StringBuilder();
			out.append("The " + a);
			if(a % 10 == 1 && a % 100 != 11) out.append("st");
			else if(a % 10 == 2 && a % 100 != 12) out.append("nd");
			else if(a % 10 == 3 && a % 100 != 13) out.append("rd");
			else out.append("th");
			out.append(" humble number is " + nums[a] + ".");
			System.out.println(out.toString());
		}
		
	}

	static int minimum(int a, int b, int c, int d) {
		int minab = (a < b) ? a : b;
		int mincd = (c < d) ? c : d;
		return (minab < mincd) ? minab : mincd;
	}
}
