import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class L {
	class Pos implements Comparable<Pos> {
		public int r, c, d;
		public Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
		public int compareTo(Pos other) {
			int compare = Integer.compare(this.r, other.r);
			return compare == 0 ? Integer.compare(this.c, other.c) : compare;
		}
		
		public String toString() {
			return r + " " + c;
		}
	} 
	
	public static void main(String[] args) throws IOException {
		new L().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(file.readLine());
		file.close();
		
		long t = Long.parseLong(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		
		long n = taxiDistance(t);
		long d = bfs((int) s);
		
		if(d < n) {
			out.println(1);
		} else {
			long ndGCD = gcd(n, d);
			out.printf("%d/%d", n/ndGCD, d/ndGCD);
		}
		out.close();
	}
	
	public long taxiDistance(long d) {
		return (2 * (d * d)) + (2 * d) + 1;
	}
	
	public int[] dr = {0, 1, 0, -1, 2, -2, 2, -2};
	public int[] dc = {1, 0, -1, 0, 2, -2, -2, 2};
	
	public long bfs(int s) {
		TreeSet<Pos> positions = new TreeSet<Pos>();
		Queue<Pos> toSearch = new LinkedList<Pos>();
		toSearch.add(new Pos(s, s, s));
		
		while(!toSearch.isEmpty()) {
			Pos currPos = toSearch.poll();
			
			int r = currPos.r;
			int c = currPos.c;
			int d = currPos.d;
			
			if(d < 0) {
				continue;
			}
			positions.add(currPos);
			if(d == 0) {
				continue;
			}
			
			for(int i = 0; i < 8; i++) {
				int newR = r + dr[i];
				int newC = c + dc[i];
				if((newR >= 0 && newR < (2*s) + 1 && newC >= 0 && newC < (2*s) + 1)) {
					int newD = (i < 4) ? (d - 1) : (d - 3);
					if(newD >= 0) {
						toSearch.add(new Pos(newR, newC, newD));
					}
				}
			}
		}
		
		return positions.size();
	}
	
	public long gcd(long a, long b) {
	    return b == 0 ? a : gcd(b, a % b);
	}
}
