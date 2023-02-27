import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class F {
	public static void main(String[] args) throws IOException {
		new F().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		double num = Double.parseDouble(file.readLine());
		file.close();
		
		out.println(num / 4);
		out.close();
	}
}
