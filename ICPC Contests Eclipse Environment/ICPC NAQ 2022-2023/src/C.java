import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C {
	public static void main(String[] args) throws IOException {
		new C().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		char[] name1 = file.readLine().toLowerCase().toCharArray();
		char[] name2 = file.readLine().toLowerCase().toCharArray();
		file.close();
		
		short[] occurances = new short[26];
		int max = Math.max(name1.length, name2.length);
		for(int i = 0; i < max; i++) { 
			if(i < name1.length) {
				occurances[name1[i]-'a']++;
			}
			if(i < name2.length) {
				occurances[name2[i]-'a']++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < occurances[i]; j++) {
				sb.append((char) ('a'+i));
			}
		}
		
		out.println(sb.toString());
		out.close();
	}
}
