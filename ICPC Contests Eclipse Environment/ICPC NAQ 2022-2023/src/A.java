import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {
	public static void main(String[] args) throws IOException {
		new A().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numAnimals = Integer.parseInt(file.readLine());
		int[] strengths = new int[numAnimals];
		for(int i = 0; i < numAnimals; i++) {
			strengths[i] = Integer.parseInt(file.readLine());
		}
		file.close();
		Arrays.sort(strengths);
		int leastIndex = strengths.length - 1;
		int totalStrength = strengths[leastIndex];
		int currStrength = 0;
		for(int i = leastIndex - 1; i >= 0; i--) {
			currStrength += strengths[i];
			if(currStrength >= totalStrength) {
				totalStrength += currStrength;
				leastIndex = i;
				currStrength = 0;
			} 
		}
		out.println(strengths.length - leastIndex);
		out.close();
	}
}
