import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class AdjacencyList {
    ArrayList<Vertex> vertices;

    public AdjacencyList() {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void addEdge(Vertex A, Vertex B, Integer cost) {
        if (!(vertices.contains(A) && vertices.contains(B))) {
            System.out.println("Vertex is not in the Graph.");
            return;
        }
        //edges from A to B are supposed to be bidirectional
        //that means it has same cost from A to B and B to A
        new Edge(A, B, cost);
        new Edge(B, A, cost);

    }

    public void minimumSpanningTree() {
        PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();

        if (vertices.size() > 0) {
            vertices.get(0).dist = 0;
            Q.offer(vertices.get(0));
        }

        int counter = 0;
        int treeListLength = 0;


        while (!Q.isEmpty() && counter < vertices.size())
        {
            Vertex smallest = Q.poll();
            int index = vertices.indexOf(smallest);
            if (!vertices.get(index).hasBeenVisited)
            {
                ArrayList<Edge> outEdgesOfElement = vertices.get(index).outEdges;

                for (Edge edge : outEdgesOfElement)
                {
                    if (edge.getWeight() < edge.to.getDistance() && !edge.to.hasBeenVisited)
                    {
                        edge.to.setDistance(edge.getWeight());
                        edge.to.prev = vertices.get(index);
                        Q.offer(edge.to);
                    }
                }
                vertices.get(index).hasBeenVisited = true;
                counter++;
                treeListLength += smallest.getDistance();
            }
        }
        System.out.printf("The distance of the minimum spanning tree is %d kilometers.", treeListLength);
        System.out.println("The price for the new electricity grid is " + new DecimalFormat("###,###,###").format(treeListLength * 1000000) + " kr.");
    }

    public void printMinimumSpanningTree() {
            for (Vertex vertex : vertices) {
                try {
                    System.out.println("Vertex " + vertex.getName() + " has parent " + vertex.prev.getName() + ". Cost is " + vertex.getDistance()+ ".");
                } catch (NullPointerException e) {
                    if(vertex.prev == null)
                    {
                    System.out.println("Vertex "+vertex.getName()+" has no Parent.");
                    }
                }
            }
    }
}

