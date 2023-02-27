import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class E {private class Entrance {
		public int r, c;
		public Entrance(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public int N, M;
	public char[][] maze;
	public int[] entranceOccurrence;
	public HashMap<String, Entrance> entranceMap;
	
	public static void main(String[] args) throws IOException {
		new E().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(file.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		entranceOccurrence = new int['W'-'A'+1];
		
		int numDots = 0;
		entranceMap = new HashMap<String, Entrance>();
		for(int i = 0; i < N; i++) {
			maze[i] = file.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				char letter = maze[i][j];
				if(letter >= 'A' && letter <= 'W' && (i == 0 || i == N-1 || j == 0 || j == M-1)) {
					entranceMap.put(("" + letter + entranceOccurrence[letter-'A']), new Entrance(i, j));
					entranceOccurrence[letter-'A']++;
				} else if(letter == '.') {
					numDots++;
				}
			}
		}
		
		int numDotsFound = 0;
		int numEntrancesUsed = 0;
		visited = new boolean[N][M];
		for(String id : entranceMap.keySet()) {
			Entrance currEntrance = entranceMap.get(id);
			int d = bfs(currEntrance.r, currEntrance.c);
			if(d > 0) {
				numDotsFound += d;
				numEntrancesUsed++;
			}
		}
		
		
		out.printf("%d %d", numEntrancesUsed, (numDots - numDotsFound));
		out.close();
	}
	
	private int[] dr = {0, 1, 0, -1};
	private int[] dc = {1, 0, -1, 0};
	private boolean[][] visited;
	
	private int bfs(int startR, int startC) {
		Queue<int[]> toSearch = new LinkedList<int[]>();
		toSearch.add(new int[] {startR, startC});
		int numDotsFound = 0;
		
		while(!toSearch.isEmpty()) {
			int[] pos = toSearch.poll();
			int r = pos[0];
			int c = pos[1];
			
			visited[r][c] = true;
			if(maze[r][c] == '.') {
				numDotsFound++;
			} 
			
			for(int i = 0; i < 4; i++) {
				int newR = r + dr[i];
				int newC = c + dc[i];
				if(0 <= newR && newR < N && newC >= 0 && newC < M 
						&& !visited[newR][newC] 
						&& (maze[newR][newC] == '.' || maze[newR][newC] == ' ')) {
					toSearch.add(new int[] {newR, newC});
				}
			}
		}
		
		return numDotsFound;
	}
}
