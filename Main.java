import utils.*;

public class Main {
    public static void main(String[] args) {

        // graph erstellen und initialisieren (Knoten und Kanten sind in der Klasse
        // BeispielGraph definiert)
        BeispielGraph g = new BeispielGraph();
        g.initialiseGraph();

        // Ausführen von der Breitensuche (BFS) mit Startknoten "A" und Ausgabe der
        // Besuchsreihenfolge der Knoten
        List<Vertex> bfsOrder = BreitenUndTiefensuche.bfs(g, "A");
        System.out.println("BFS:");

        for (bfsOrder.toFirst(); bfsOrder.hasAccess(); bfsOrder.next()) {
            System.out.println(bfsOrder.getContent().getID());
        }

        // Ausführen von der Tiefensuche (DFS) mit Startknoten "A" und Ausgabe der
        // Besuchsreihenfolge der Knoten
        List<Vertex> dfsOrder = BreitenUndTiefensuche.dfs(g, "A");
        System.out.println("DFS:");

        for (dfsOrder.toFirst(); dfsOrder.hasAccess(); dfsOrder.next()) {
            System.out.println(dfsOrder.getContent().getID());
        }

        // Ausführen von Dijkstra mit Startknoten "A" und Zielknoten "F" und Ausgabe des
        // Pfads zum Zielknoten
        Pfad d = Dijkstra.dijkstra(g, "A", "F");

        System.out.println("Dijkstra:");
        System.out.println(d);

    }
}
