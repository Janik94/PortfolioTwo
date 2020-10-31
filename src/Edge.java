public class Edge{
    Integer weight;
    Vertex from;
    Vertex to;

    public Edge(Vertex from, Vertex to, Integer cost){
        this.from = from;
        this.to = to;
        this.weight = cost;
        this.from.addOutEdge(this);
    }

    public int getWeight() {
        return this.weight;
    }

        //returns the vertex the edge is "pointing" to
    public Vertex getToVertex() {
        return this.to;
    }
}
