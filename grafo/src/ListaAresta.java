import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class ListaAresta {
    private ArrayList<String> v;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private int nCount;
    private Graph graphStream;

    public ListaAresta() {
        v = new ArrayList<String>();
        g = new ArrayList<String>();
        h = new ArrayList<String>();
        nCount = 0;

        System.setProperty("org.graphstream.ui", "swing");
        this.graphStream = new SingleGraph("Exemplo de Grafo");
        graphStream.setAttribute("ui.stylesheet",
                "node { text-alignment: at-right; size: 16px, 16px;} node:clicked{fill-color: red;}");
    }

    public void addNode(String node) {
        v.add(node);
        nCount++;
        graphStream.addNode(node).setAttribute("label", node);
    }

    public void addEdge(String from, String to) {
        g.add(from);
        h.add(to);
        nCount++;
        graphStream.addEdge(from + ',' + to, from, to);
    }

    public void goodman() {
        ArrayList<String> vertices = v;
        ArrayList<String> g0 = g;
        ArrayList<String> h0 = h;

        int c = 0;
        while (vertices != null) {
            String v0 = vertices.get(0);
            while () {
                
            }
        }
    }

    public void dijkstra() {

    }

    public void display() {
        graphStream.display();
    }
}
