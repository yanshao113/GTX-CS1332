import java.util.*;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        List<Vertex<T>> list = new ArrayList<>();
        Map<Vertex<T>, List<VertexDistance<T>>> adList = graph.getAdjList();
        visited.add(start);
        list.add(start);
        queue.add(start);
        while(!queue.isEmpty()){
            Vertex<T> v = queue.poll();
            List<VertexDistance<T>> vAdList = adList.get(v);
            for(VertexDistance<T> w: vAdList){
                Vertex<T> vtx = w.getVertex();
                if(!visited.contains(vtx)){
                    visited.add(vtx);
                    list.add(vtx);
                    queue.add(vtx);
                }
            }
        }
        return list;
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<Vertex<T>> list = new ArrayList<>();
        Map<Vertex<T>, List<VertexDistance<T>>> adList = graph.getAdjList();
        Set<Vertex<T>> visited = new HashSet<>();
        dfsHelper(start,visited,list,adList);
        return list;
    }
    private static <T> void dfsHelper(Vertex<T> current, Set<Vertex<T>> visited, List<Vertex<T>> list, Map<Vertex<T>, List<VertexDistance<T>>> adList){
        visited.add(current);
        list.add(current);
        List<VertexDistance<T>> currentAdList = adList.get(current);
        for(VertexDistance<T> w: currentAdList){
            Vertex<T> vtx = w.getVertex();
            if(!visited.contains(vtx)){
                dfsHelper(vtx,visited,list,adList);
            }
        }
    }

}