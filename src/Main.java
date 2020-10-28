public class Main {

    public static void main(String[] args) {
        AdjacencyList electricityGrid = new AdjacencyList();
        addVerticesAndEdges(electricityGrid);
        electricityGrid.minimumSpanningTree();
        electricityGrid.printMinimumSpanningTree();
    }


    public static AdjacencyList addVerticesAndEdges(AdjacencyList cities) {
        Vertex eskildstrup = new Vertex("Eskildstrup");
        Vertex haslev = new Vertex("Haslev");
        Vertex holbaek = new Vertex("Holbaek");
        Vertex jaegerspris = new Vertex("Jaegerspris");
        Vertex kalundborg = new Vertex("Kalundborg");
        Vertex korsoer = new Vertex("Korsoer");
        Vertex koege = new Vertex("Koege");
        Vertex maribo = new Vertex("Maribo");
        Vertex nakskov = new Vertex("Nakskov");
        Vertex nykoebing_F = new Vertex("Nykøbing F");
        Vertex naestved = new Vertex("Naestved");
        Vertex ringsted = new Vertex("Ringsted");
        Vertex roskilde = new Vertex("Roskilde");
        Vertex slagelse = new Vertex("Slagelse");
        Vertex soroe = new Vertex("Soroe");
        Vertex vordingborg = new Vertex("Vordingborg");

        cities.addVertex(eskildstrup);
        cities.addVertex(haslev);
        cities.addVertex(holbaek);
        cities.addVertex(jaegerspris);
        cities.addVertex(kalundborg);
        cities.addVertex(korsoer);
        cities.addVertex(koege);
        cities.addVertex(maribo);
        cities.addVertex(nakskov);
        cities.addVertex(nykoebing_F);
        cities.addVertex(naestved);
        cities.addVertex(ringsted);
        cities.addVertex(roskilde);
        cities.addVertex(slagelse);
        cities.addVertex(soroe);
        cities.addVertex(vordingborg);


            //Edges from Eskildstrup
        cities.addEdge(eskildstrup,maribo,28);
        cities.addEdge(eskildstrup,nykoebing_F,13);
        cities.addEdge(eskildstrup, vordingborg, 24);

            //Edges from Haslev
        cities.addEdge(haslev, korsoer, 60);
        cities.addEdge(haslev, koege, 24);
        cities.addEdge(haslev, naestved, 25);
        cities.addEdge(haslev, ringsted, 19);
        cities.addEdge(haslev, roskilde, 47);
        cities.addEdge(haslev, slagelse, 48);
        cities.addEdge(haslev, soroe, 34);
        cities.addEdge(haslev, vordingborg, 40);

            //edges from holbaek
        cities.addEdge(holbaek, jaegerspris, 34);
        cities.addEdge(holbaek, kalundborg, 44);
        cities.addEdge(holbaek, korsoer, 66);
        cities.addEdge(holbaek, ringsted, 36);
        cities.addEdge(holbaek, roskilde, 32);
        cities.addEdge(holbaek, slagelse, 46);
        cities.addEdge(holbaek, soroe, 34);

            //edges from jaegerspris
        cities.addEdge(jaegerspris, korsoer, 95);
        cities.addEdge(jaegerspris, koege, 58);
        cities.addEdge(jaegerspris, ringsted, 56);
        cities.addEdge(jaegerspris, roskilde, 33);
        cities.addEdge(jaegerspris, slagelse, 74);
        cities.addEdge(jaegerspris, soroe, 63);

            //edges from Kalundborg
        cities.addEdge(kalundborg, ringsted, 62);
        cities.addEdge(kalundborg, roskilde, 70);
        cities.addEdge(kalundborg, slagelse, 39);
        cities.addEdge(kalundborg, soroe, 51);

            //edges from korsoer
        cities.addEdge(korsoer, naestved, 45);
        cities.addEdge(korsoer, slagelse, 20);

            //edges from koege
        cities.addEdge(koege, naestved, 45);
        cities.addEdge(koege, ringsted, 28);
        cities.addEdge(koege, roskilde, 25);
        cities.addEdge(koege, vordingborg, 60);

            //edges from Maribo
        cities.addEdge(maribo, nakskov, 27);
        cities.addEdge(maribo, nykoebing_F, 26);

            //edges from naestved
        cities.addEdge(naestved, roskilde, 57);
        cities.addEdge(naestved, ringsted, 26);
        cities.addEdge(naestved, slagelse, 37);
        cities.addEdge(naestved, soroe, 32);
        cities.addEdge(naestved, vordingborg, 28);

            //edges from Ringsted
        cities.addEdge(ringsted, roskilde, 31);
        cities.addEdge(ringsted, soroe, 15);
        cities.addEdge(ringsted, vordingborg, 58);

            //edges from Slagelse
        cities.addEdge(slagelse, soroe, 14);
        return cities;
    }
}
