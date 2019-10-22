import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ComeandGo {
    static Set<Integer> nodes = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = reader.readLine()) != null){
            StringTokenizer token1 = new StringTokenizer(line);
            int n = Integer.valueOf(token1.nextToken());
            int m = Integer.valueOf(token1.nextToken());
            if(n==0 && m==0) break;
            nodes.clear();
            Set<Integer>[] reverse = new Set[n+1];
            Set<Integer>[] vertices = new Set[n+1];
            Set<Integer> global = new HashSet<>();
            for (int i = 0; i < n+1; i++){
                reverse[i] = new HashSet<>();
            }
            for (int i = 0; i < n+1; i++){
                vertices[i] = new HashSet<>();
            }
            int start = -1;
            for (int i = 0; i < m; i++){
                StringTokenizer token2 = new StringTokenizer(reader.readLine());
                int v = Integer.valueOf(token2.nextToken());
                int w = Integer.valueOf(token2.nextToken());
                int p = Integer.valueOf(token2.nextToken());
                nodes.add(v);
                nodes.add(w);
                if(start == -1){
                    start = v;
                }
                if(p==1){
                    vertices[v].add(w);
                    reverse[w].add(v);
                }
                else if(p==2){
                    vertices[v].add(w);
                    vertices[w].add(v);
                    reverse[w].add(v);
                    reverse[v].add(w);
                }
            }
            Boolean normalBFS = bfsToallnodes(vertices, start, global);
            global.clear();
            Boolean reversedBFS = bfsToallnodes(reverse, start, global);
            global.clear();
            if(normalBFS&&reversedBFS){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }
    static Boolean bfsToallnodes(Set<Integer>[]  G, int s, Set<Integer> visited) {
        Set<Integer> frontier = new HashSet<>(Arrays.asList(s));
        visited.add(s);
        while (!frontier.isEmpty()) {
            frontier = neighbours(G, frontier);
            frontier.removeAll(visited);
            visited.addAll(frontier);
        }
        if(nodes.equals(visited)){
            return true;
        }
        else{
            return false;
        }
    }
    static Set<Integer> neighbours(Set<Integer>[] G, Set<Integer> vtxes){
        Set<Integer> union = new HashSet<>();
        for (Integer src : vtxes) {
            for (Integer dst : G[src]){
                union.add(dst);
            }
        }
        return union;
    }
}
