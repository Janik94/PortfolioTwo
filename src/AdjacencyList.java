import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class AdjacencyList {
        //list of all our vertices, same order as implemented in main
    ArrayList<Vertex> vertices;
        //list of all vertices, but in the order they are visited
    ArrayList<Vertex> orderedListForPrinting;

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

            //prim's algorithm for a minimum spanning tree
    public void minimumSpanningTree() {
        PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
            //arraylist to add vertices in the row they are visited
        orderedListForPrinting = new ArrayList<Vertex>();

            //set distance of our root to 0
        vertices.get(0).dist = 0;
            //add the root to our priorityqueue
        Q.offer(vertices.get(0));

            //counter to check if we visited all vertices
        int counter = 0;
            //integer to add our costs together
        int treeListLength = 0;

            //we need to be sure that there are elements in our priority queue
            //and that we did not visit all vertices yet
        while (!Q.isEmpty() && counter < vertices.size())
        {
                //retrieve smallest element from our priority queue
            Vertex smallest = Q.poll();
                //save the index of the smallest in the vertices list in a variable
            int index = vertices.indexOf(smallest);
                //check if we already visited the smallest element
            if (!vertices.get(index).hasBeenVisited)
            {
                    //make a new list with all the out edges of the current vertex
                ArrayList<Edge> outEdgesOfElement = vertices.get(index).outEdges;

                for (Edge edge : outEdgesOfElement)
                {       //check if the weight of each out edge is smaller than the distance of the vertex it leads to
                        //and check that the vertex, the edge leads to, has not been visited yet
                    if (edge.getWeight() < edge.getToVertex().getDistance() && !edge.getToVertex().hasBeenVisited)
                    {
                            //if the weight is smaller than the distance:
                            //update the distance of the vertex to the weight of the edge
                        edge.getToVertex().setDistance(edge.getWeight());
                            //set the smallest element from above to be the predecessor of the new vertex
                        edge.getToVertex().setPreviousVertex(vertices.get(index));
                            //update the new vertex in the priority queue
                        Q.offer(edge.getToVertex());
                    }
                }
                    //set the smallest element to visited
                vertices.get(index).hasBeenVisited = true;
                    //add it to the list of visited vertices
                orderedListForPrinting.add(vertices.get(index));
                    //increase our counter
                counter++;
                    //add the distance of the smallest element to the tree length
                treeListLength += smallest.getDistance();
            }
        }
            //print the total length of the tree
        System.out.printf("The distance of the minimum spanning tree is %d kilometers. %n", treeListLength);
            //print the total cost of the project
        System.out.println("The price for the new electricity grid is " + new DecimalFormat("###,###,###").format(treeListLength * 1000000) + " kr.");
    }

        //method to print the minimum spanning tree
        //root's previous vertex is "null"
        //try catch is used to avoid NullPointerException for the root

    public void printMinimumSpanningTree() {
                //enhanced for loop to go through the "ordered list"
            for (Vertex vertex : orderedListForPrinting) {
                try {
                    //print parent of current vertex, current vertex' name and cost from parent to child
                    System.out.println(vertex.getPreviousVertex().getName()+ " ---> " + vertex.getName() + ". Cost is " + vertex.getDistance()+ ".");
                } catch (NullPointerException e) {
                    if(vertex.getPreviousVertex() == null)
                    {
                        //prints which vertex is the root of the tree
                    System.out.println("Vertex "+vertex.getName()+" is the Vertex we started with, so it is the root and has no parent.");
                    }
                }
            }
    }
}

