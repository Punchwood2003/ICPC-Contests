import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class K {
	public static void main(String[] args) throws IOException {
		new K().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(file.readLine());
		file.close();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 4; i++) {
			int resAB = operation(a, b, i);
			if(invalid) {
				continue;
			}
			for(int j = 0; j < 4; j++) {
				int resBC = operation(resAB, c, j);
				if(invalid) {
					continue;
				}
				if(resBC >= 0) {
					min = Math.min(min, resBC);
				}
			}
		}
		
		out.println(min);
		out.close();
	}
	
	boolean invalid;
	
	int operation(int a, int b, int op) {
		invalid = false;
		
		switch(op) {
		case 0 : {
			return a + b;
		}
		case 1 : {
			return a - b;
		}
		case 2 : {
			return a * b;
		}
		case 3 : {
			if(a % b == 0) {
				return a / b;
			}
			invalid = true;
		}
		}
		return -1;
	}
}
