import java.util.*;

public class Tree {
    private int TotalNoOfNodes;
    private LinkedList<Integer> adj[];
    Tree(int v)
    {
        TotalNoOfNodes = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
    Boolean isCycle(int v, Boolean visited[], int parent)
    {
        visited[v] = true; //O(1)
        Integer i; //O(1)
        Iterator<Integer> it = adj[v].iterator(); //O(1)
        while (it.hasNext()) //(O(n)
        {
            i = it.next();
            if (!visited[i])
            {
                if (isCycle(i, visited, v)) //O(m)
                    return true;
            }
            else if (i != parent)
                return true;
        }
        return false;
    }
    Boolean isTree()
    {
        Boolean visited[] = new Boolean[TotalNoOfNodes];
        for (int i = 0; i < TotalNoOfNodes; i++) //O(n)
            visited[i] = false;
        if (isCycle(0, visited, -1)) //(On+m)
            return false;
        for (int u = 0; u < TotalNoOfNodes; u++) //O(n)
            if (!visited[u])
                return false;

        return true;
    }
}
