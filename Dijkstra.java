import utils.*;

public class Dijkstra {
    public static Pfad dijkstra(BeispielGraph g, String startID, String endID) {

        List<Vertex> vertices = g.getVertices();

        int anzahlKnoten = 0;
        // Anzahl der Knoten im Graphen bestimmen um Umfang des Abstandsarrays zu
        // bestimmen
        for (vertices.toFirst(); vertices.hasAccess(); vertices.next()) {
            anzahlKnoten++;
        }

        Pfad[] d = new Pfad[anzahlKnoten];

        // Abstandsarray initialisieren: Alle Knoten haben den Abstand
        // Integer.MAX_VALUE, außer der Startknoten, der den Abstand 0 hat
        int index = 0;
        for (vertices.toFirst(); vertices.hasAccess(); vertices.next()) {

            Vertex v = vertices.getContent();

            if (v.getID().equals(startID)) {
                d[index] = new Pfad(v, null, g.getVertex(startID), 0);
            } else {
                d[index] = new Pfad(v, null, g.getVertex(startID), Integer.MAX_VALUE); // Integer.MAX_VALUE als Symbol
                                                                                                        // für unendlich, da die
                                                                                                        // Knoten zu Beginn alle
                                                                                                        // unerreichbar sind
            }

            index++;
        }

        // Alle Knoten zu Beginn unmarkiert bzw noch unbesucht
        g.setAllVertexMarks(false);

        // Solange der Zielknoten noch nicht besucht wurde, wird die Schleife
        // durchlaufen
        while (true) {

            // Pfad mit dem kleinsten Abstand zum Startknoten bestimmen
            Pfad minPfad = new Pfad(null, null, null, Integer.MAX_VALUE);
            for (int i = 0; i < d.length; i++) {
                if (!d[i].getV().isMarked() && d[i].getDistance() < minPfad.getDistance()) {
                    minPfad = d[i];
                }
            }

            // Schleife abbrechen, sobald man beim Zielknoten angekommen ist, da man dann
            // den kürzesten Pfad zum Zielknoten gefunden hat
            if (minPfad.getDistance() == Integer.MAX_VALUE) {
                return null; // Alle verbleibenden unerreichbaren Knoten haben den Abstand Integer.MAX_VALUE,
                             // d.h. wenn der minimale Pfad diesen Abstand hat, ist der Zielknoten
                             // unerreichbar
            }

            if (minPfad.getV().getID().equals(endID)) {
                return minPfad; // Zielknoten erreicht, minimaler Pfad zum Zielknoten gefunden
            }
            // Minimalen Pfad markieren, d.h. den entsprechenden Knoten als besucht
            // markieren
            g.getVertex(minPfad.getV().getID()).setMark(true);

            // Abstände der Nachbarn des minimalen Pfads aktualisieren
            List<Vertex> nachbarn = g.getNeighbours(minPfad.getV());
            for (nachbarn.toFirst(); nachbarn.hasAccess(); nachbarn.next()) {
                Vertex n = nachbarn.getContent();

                // Kante zwischen minimalem Pfad und Nachbar bestimmen, um Gewicht zu erhalten
                Edge e = g.getEdge(minPfad.getV(), n);
                int gewicht = (int) e.getWeight();

                // Index des Nachbarn im Abstandsarray bestimmen
                int indexNachbar = 0;
                for (int i = 0; i < d.length; i++) {
                    if (d[i].getV() == n) {
                        indexNachbar = i;
                    }
                }

                // Abstand zum Startknoten über minimalen Pfad berechnen
                int distanceViaMinPfad = minPfad.getDistance() + gewicht;

                // Wenn der über den minimalen Pfad berechnete Abstand kleiner ist als der
                // bisher bekannte Abstand zum Nachbarn, wird der Abstand im Abstandsarray
                // aktualisiert und der vorherige Knoten auf dem Pfad zum Nachbarn wird auf den
                // Knoten des minimalen Pfads gesetzt
                if (distanceViaMinPfad < d[indexNachbar].getDistance()) {
                    d[indexNachbar].setDistance(distanceViaMinPfad);
                    d[indexNachbar].setVorherigerKnoten(minPfad.getV());
                }
            }
        }
    }
}
