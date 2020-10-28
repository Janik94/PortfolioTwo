import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
    String name;
    ArrayList<Edge> outEdges;
    Integer dist = Integer.MAX_VALUE;
    Vertex prev;
    boolean hasBeenVisited;

    public Vertex(String id) {
        name = id;
        outEdges = new ArrayList<Edge>();
        prev = null;
        hasBeenVisited = false;
    }

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

    @Override
    public int compareTo(Vertex vertex) {
        return this.dist.compareTo(vertex.getDistance());
    }
}
