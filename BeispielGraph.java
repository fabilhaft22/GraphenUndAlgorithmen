import utils.Edge;
import utils.Graph;
import utils.Vertex;

public class BeispielGraph extends Graph {
    public BeispielGraph() {
        super();
    }

    public void initialiseGraph() {
        //Knoten und Kanten erstellen
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Vertex v6 = new Vertex("F");
        Vertex v7 = new Vertex("G");
        Edge e1 = new Edge(v1, v2, 2);
        Edge e2 = new Edge(v1, v3, 5);
        Edge e3 = new Edge(v2, v3, 1);
        Edge e4 = new Edge(v2, v4, 4);
        Edge e5 = new Edge(v2, v5, 7);
        Edge e6 = new Edge(v3, v4, 3);
        Edge e7 = new Edge(v3, v6, 6);
        Edge e8 = new Edge(v4, v5, 2);
        Edge e9 = new Edge(v4, v6, 4);
        Edge e10 = new Edge(v5, v7, 1);
        Edge e11 = new Edge(v6, v7, 2);
        Edge e12 = new Edge(v1, v7, 10);
        Edge e13 = new Edge(v1, v4, 8);

        //dem graph hinzufuegen
        this.addVertex(v1);
        this.addVertex(v2);
        this.addVertex(v3);
        this.addVertex(v4);
        this.addVertex(v5);
        this.addVertex(v6);
        this.addVertex(v7);
        this.addEdge(e1);
        this.addEdge(e2);
        this.addEdge(e3);
        this.addEdge(e4);
        this.addEdge(e5);
        this.addEdge(e6);
        this.addEdge(e7);
        this.addEdge(e8);
        this.addEdge(e9);
        this.addEdge(e10);
        this.addEdge(e11);
        this.addEdge(e12);
        this.addEdge(e13);

    
    }
}
