import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
    String name;
    //arrayList filled with all edges going "out" from the vertex
    ArrayList<Edge> outEdges;
    //integer to save values for the distance after being compared to edges
    Integer dist = Integer.MAX_VALUE;
    //Vertex updated to the parent of each vertex
    Vertex prev;
    //boolean to see if a vertex has been visited before or not
    boolean hasBeenVisited;

    public Vertex(String id) {
        name = id;
        outEdges = new ArrayList<Edge>();
        //no parent to start with, so previous vertex is null
        prev = null;
        //vertex has not been visited yet, so variable must be false
        hasBeenVisited = false;
    }
        //adds up all outedges from each vertex
    public void addOutEdge(Edge e) {
        outEdges.add(e);
    }

    public String getName() {
        return name;
    }


    public Integer getDistance() {
        return this.dist;
    }
    public void setDistance(int distance) {
        this.dist = distance;
    }

    public Vertex getPreviousVertex() {
        return this.prev;
    }
    public void setPreviousVertex(Vertex vertex) {
        this.prev = vertex;
    }
        //compareTo method needed for the PriorityQueue
        //PriorityQueue compares vertices based on their distance
    @Override
    public int compareTo(Vertex vertex) {
        return this.dist.compareTo(vertex.getDistance());
    }
}
