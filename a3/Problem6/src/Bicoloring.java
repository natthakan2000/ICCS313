import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bicoloring {
    static Map<Integer, List<Integer>> edges = new HashMap<>();
    static int[] verticesColour = new int[200];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = reader.readLine()) != null){
            int nodeCount = Integer.valueOf(line);
            if (nodeCount == 0){
                break;
            }
            Arrays.fill(verticesColour, 0, nodeCount, -1);
            int edgeCount = Integer.valueOf(reader.readLine());
            edges.clear();
            int startEdge = -1;
            while(edgeCount != 0){
                StringTokenizer token = new StringTokenizer(reader.readLine());
                int u = Integer.valueOf(token.nextToken());
                int v = Integer.valueOf(token.nextToken());
                if (startEdge == -1) {
                    startEdge = u;
                }
                List<Integer> adjacent = edges.get(u);
                if (adjacent == null){
                    adjacent = new ArrayList<>();
                }
                adjacent.add(v);
                edges.put(u, adjacent);
                edgeCount--;
            }
            if (BFS(1, startEdge)){
                System.out.println("BICOLORABLE.");
            }
            else{
                System.out.println("NOT BICOLORABLE.");
            }
        }
    }
    static boolean BFS(int colour, int vertices){
        verticesColour[vertices] = colour;
        List<Integer> adjList = edges.get(vertices);
        boolean result = true;
        if (adjList != null){
            for(Integer adjVertice : adjList){
                if (verticesColour[adjVertice] != -1 && verticesColour[adjVertice] != (1 - colour)){
                    return false;
                }
                if (verticesColour[adjVertice] == -1){
                    result &= BFS(1 - colour, adjVertice);
                }
            }
        }
        return result;
    }
}
