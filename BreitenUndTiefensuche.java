import utils.*;

public class BreitenUndTiefensuche {
    // Breitensuche (Breadth-First Search)
    public static List<Vertex> bfs(BeispielGraph g, String startID) {

        // Alle Knoten zu Beginn unmarkiert
        g.setAllVertexMarks(false);

        // Liste, um die Besuchsreihenfolge der Knoten zu speichern, und Queue für die
        // Breitensuche
        List<Vertex> besuchsReihenfolge = new List<>();
        Queue<Vertex> queue = new Queue<>();

        Vertex start = g.getVertex(startID);

        // Startknoten markieren und in die Queue einfügen
        start.setMark(true);
        queue.enqueue(start);

        // Solange die Queue nicht leer ist, wird die Schleife durchlaufen
        while (!queue.isEmpty()) {

            Vertex current = queue.front();
            queue.dequeue();

            besuchsReihenfolge.append(current);

            // Alle Nachbarn des aktuellen Knotens durchlaufen
            List<Vertex> nachbarn = g.getNeighbours(current);

            for (nachbarn.toFirst(); nachbarn.hasAccess(); nachbarn.next()) {

                // Nachbarn, die noch nicht markiert sind, werden markiert und in die Queue
                // eingefügt
                Vertex n = nachbarn.getContent();

                if (!n.isMarked()) {
                    n.setMark(true);
                    queue.enqueue(n);
                }
            }
        }

        return besuchsReihenfolge;
    }

    public static List<Vertex> dfs(BeispielGraph g, String startID) {

        // Alle Knoten zu Beginn unmarkiert
        g.setAllVertexMarks(false);

        // Liste, um die Besuchsreihenfolge der Knoten zu speichern, und Stack für die
        // Tiefensuche initialisieren
        List<Vertex> besuchsReihenfolge = new List<>();
        Stack<Vertex> stack = new Stack<>();

        // Startknoten in den Stack einfügen
        Vertex start = g.getVertex(startID);
        stack.push(start);

        // Solange der Stack nicht leer ist, wird die Schleife durchlaufen
        while (!stack.isEmpty()) {

            // Aktuellen Knoten vom Stack holen
            Vertex current = stack.top();
            stack.pop();

            // Wenn der aktuelle Knoten noch nicht markiert ist, wird er markiert, zur
            // Besuchsreihenfolge hinzugefügt und seine Nachbarn werden in den Stack
            // eingefügt
            if (!current.isMarked()) {

                current.setMark(true);
                besuchsReihenfolge.append(current);

                List<Vertex> nachbarn = g.getNeighbours(current);

                for (nachbarn.toFirst(); nachbarn.hasAccess(); nachbarn.next()) {
                    Vertex n = nachbarn.getContent();

                    if (!n.isMarked()) {
                        stack.push(n);
                    }
                }
            }
        }

        return besuchsReihenfolge;
    }

}
