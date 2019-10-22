import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeasonalWar {
    static char[][] nodes = new char[25][25];
    static boolean[][] visited = new boolean[25][25];
    static int n;
    static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int photoCount = 1;
        while((line = rd.readLine()) != null)
        {
            n = Integer.parseInt(line);
            for(int i = 0; i < n; ++i){
                line = rd.readLine();
                for(int j = 0; j < n; ++j){
                    nodes[i][j] = line.charAt(j);
                    visited[i][j] = false;
                }
            }
            int eagleCount = 0;
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    if (!visited[i][j] && nodes[i][j] == '1'){
                        eagleCount++;
                        DFS(i, j);
                    }
                }
            }
            System.out.println("Image number " + photoCount++ + " contains " + eagleCount + " war eagles.");
        }
    }
    static void DFS(int row, int col) {
        if (visited[row][col] || nodes[row][col] != '1'){
            return;
        }
        visited[row][col] = true;
        for(int i = 0; i < 8; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                DFS(nr, nc);
            }
        }
    }
}
