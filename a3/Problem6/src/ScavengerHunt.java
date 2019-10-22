import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ScavengerHunt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sceneNo = sc.nextInt();
        for (int i = 0; i < sceneNo; i++) {
            int m = sc.nextInt();
            HashMap<String,ArrayList<String>> map = new HashMap<>();
            HashSet<String> nodes = new HashSet<>();
            HashSet<String> directed = new HashSet<>();
            System.out.println("Scenario #"+(i+1)+":");
            for (int j = 1; j < m; j++) {
                String from = sc.next();
                String to = sc.next();
                nodes.add(from);
                nodes.add(to);
                directed.add(to);
                if(map.containsKey(from)){
                    ArrayList<String> prev = map.get(from);
                    prev.add(to);
                    map.put(from,prev);
                }else{
                    ArrayList<String> prevList = new ArrayList<>();
                    prevList.add(to);
                    map.put(from,prevList);
                }
            }
            nodes.removeAll(directed);
            for (String start:nodes) {
                DFS(map,start, m);
            }
            System.out.println();
        }
    }
    static void DFS(HashMap<String,ArrayList<String>> graph, String start, int size){
        String visiting = start;
        System.out.println(visiting);
        for (int i = 0; i < size-1; i++) {
            if(graph.containsKey(visiting)){
                visiting = graph.get(visiting).get(0);
                System.out.println(visiting);
            }
        }
    }
}
