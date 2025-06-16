import java.util.HashSet;

public class EdgeGraph {
    public static void main(String[] args) {
        Graph g = new Graph(5, false);
        g.addEdge(0, 1);
        g.addEdge(1, 2, 10);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        g.display();

        System.out.println("\nRemoving edge 1 -> 2");
        g.removeEdge(1, 2);

        g.display();
    }
}

class Edge {
    int src;
    int dest;
    int weight;
    
    Edge (int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    Edge (int src, int dest) {
        this(src, dest, 1);
    }
}

class Graph {
    HashSet<Edge> graph;
    int vertices;
    boolean isDirected;
    
    Graph (int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        graph = new HashSet<Edge>();
    }
    
    public void addEdge(int src, int dest) {
        if(isValid(src, dest)) {
            Edge e = new Edge(src, dest);
            graph.add(e);
            if (!isDirected) {
                Edge e2 = new Edge(dest, src);
                graph.add(e2);
            } else {
                System.out.println("Invalid source and destination");
            }
        }
    }
    
        public void addEdge(int src, int dest, int weight) {
        if(isValid(src, dest)) {
            Edge e = new Edge(src, dest, weight);
            graph.add(e);
            if (!isDirected) {
                Edge e2 = new Edge(dest, src, weight);
                graph.add(e2);
            } else {
                System.out.println("Invalid source and destination");
            }
        }
    }
    
    public boolean isValid (int src, int dest) {
        return src >= 0 && dest >= 0 && dest < vertices && src < vertices && src != dest;
    }
    
     public void display() {
        System.out.println("Graph (Vertices: " + vertices + ", Directed: " + isDirected + ")");
        if (graph.isEmpty()) {
            System.out.println("Graph is empty");
            return;
        }
        for (Edge e : graph) {
            System.out.println("Edge: " + e.src + " -> " + e.dest + " (Weight: " + e.weight + ")");
        }
    }
    
    public boolean removeEdge(int src, int dest) {
        if (!isValid(src, dest)) {
            System.out.println("Invalid source or destination");
            return false;
        }
        Edge edgeToRemove = null;
        for (Edge e : graph) {
            if (e.src == src && e.dest == dest) {
                edgeToRemove = e;
                break;
            }
        }
        if (edgeToRemove != null) {
            graph.remove(edgeToRemove);
            if (!isDirected) {
                Edge reverseEdge = null;
                for (Edge e : graph) {
                    if (e.src == dest && e.dest == src) {
                        reverseEdge = e;
                        break;
                    }
                }
                if (reverseEdge != null) {
                    graph.remove(reverseEdge);
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean removeEdge(int src, int dest, int weight) {
        if (!isValid(src, dest)) {
            System.out.println("Invalid source or destination");
            return false;
        }
        Edge edgeToRemove = null;
        for (Edge e : graph) {
            if (e.src == src && e.dest == dest && e.weight == weight) {
                edgeToRemove = e;
                break;
            }
        }
        if (edgeToRemove != null) {
            graph.remove(edgeToRemove);
            if (!isDirected) {
                Edge reverseEdge = null;
                for (Edge e : graph) {
                    if (e.src == dest && e.dest == src && e.weight == weight) {
                        reverseEdge = e;
                        break;
                    }
                }
                if (reverseEdge != null) {
                    graph.remove(reverseEdge);
                }
            }
            return true;
        }
        return false;
    }
    
}