package utils;

// Pfad-Klasse, um die Informationen zu einem Pfad zu speichern: den Knoten, den
// vorherigen Knoten auf dem Pfad und die Entfernung zum Startknoten
// Diese Klasse nutze ich für die Implementierung von Dijkstra, um die
// Informationen zu den Pfaden zu speichern, die während der Berechnung von
// Dijkstra entstehen
public class Pfad {
    private Vertex v;
    private Vertex vorherigerKnoten;
    private Vertex startKnoten;
    private int distance;

    public Pfad(Vertex v, Vertex vorherigerKnoten, Vertex startKnoten, int distance) {
        this.v = v;
        this.vorherigerKnoten = vorherigerKnoten;
        this.startKnoten = startKnoten;
        this.distance = distance;
    }

    public Vertex getV() {
        return v;
    }

    public Vertex getVorherigerKnoten() {
        return vorherigerKnoten;
    }
    
    public Vertex getStartKnoten() {
        return startKnoten;
    }

    public int getDistance() {
        return distance;
    }

    public int setDistance(int distance) {
        this.distance = distance;
        return distance;
    }

    public void setVorherigerKnoten(Vertex vorherigerKnoten) {
        this.vorherigerKnoten = vorherigerKnoten;
    }

    public String toString() {
        return "Pfad zu Knoten " + v.getID() + " mit Entfernung " + distance + " über vorherigen Knoten "
                + (vorherigerKnoten != null ? vorherigerKnoten.getID() : "null") + " mit Startknoten "
                + startKnoten.getID();
    }
}