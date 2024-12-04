import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class GrafoLista {
    private ArrayList<Node> nodes;
    private int nCount;
    private Graph graphStream;
    private static Integer INF = Integer.MAX_VALUE;

    public GrafoLista() {
        nodes = new ArrayList<Node>();
        System.setProperty("org.graphstream.ui", "swing");
        this.graphStream = new SingleGraph("Exemplo de Grafo");
        graphStream.setAttribute("ui.stylesheet",
                "node { text-alignment: at-right; size: 16px, 16px;} node:clicked{fill-color: red;}");
    }

    public void AddNode(String node) {
        nodes.add(new Node(node));
        nCount++;
        graphStream.addNode(node).setAttribute("label", node);
    }

    public void addEdge(String from, String to, Integer custo) {
        Node n1 = null;
        Node n2 = null;
        for (int i = 0; i < nCount; i++) {
            if (nodes.get(i).getNode() == from) {
                n1 = nodes.get(i);
            }
            if (nodes.get(i).getNode() == to) {
                n2 = nodes.get(i);
            }
            if (n1 != null && n2 != null) {
                break;
            }
        }
        Edge e = new Edge(custo, n2);
        n1.addEdge(e);
        graphStream.addEdge(String.valueOf(custo), from, to, true).setAttribute("label", custo);
    }

    public void Print() {
        for (int i = 0; i < nCount; i++) {
            System.out.print(nodes.get(i).getNode() + " -> ");
            for (int j = 0; j < nodes.get(i).size(); j++) {
                System.out.print("[" + nodes.get(i).getEdges().get(j).getNode().getNode() + "," +
                        nodes.get(i).getEdges().get(j).getCusto() + "]");
            }
            System.err.println();
        }
    }

    public void floydWarshal() {
        Integer m[][] = new Integer[nCount][nCount];

        // Preenche a tabela com o custos iniciais (Não! Esse comentário não foi gerado
        // pelo chatgpt)
        for (int i = 0; i < nCount; i++) {
            m[i][i] = 0;
        }

        for (int i = 0; i < nCount; i++) {
            for (int j = 0; j < nodes.get(i).size(); j++) {
                m[i][nodes.indexOf(nodes.get(i).getEdges().get(j).getNode())] = nodes.get(i).getEdges().get(j)
                        .getCusto();
            }
        }

        for (int k = 0; k < nCount; k++) {
            for (int i = 0; i < nCount; i++) {
                for (int j = 0; j < nCount; j++) {
                    if (m[i][k] != null && m[k][j] != null) {
                        if (m[i][j] == null || m[i][j] > m[i][k] + m[k][j]) {
                            m[i][j] = m[i][k] + m[k][j];
                        }
                    }
                }
            }
        }

        // Mostrar tabela (Não! Esse comentário não foi gerado pelo chatgpt)
        for (int i = 0; i < nCount; i++) {
            for (int j = 0; j < nCount; j++) {
                if (m[i][j] != null) {
                    System.out.printf("%-10s", m[i][j]);
                } else {
                    System.out.printf("%-10s", "0");
                }
            }
            System.out.println();
        }
    }

    public Node removeNode(String node) {
        Node n = nodes.get(nodes.indexOf(node));
        nodes.remove(node);
        return n;
    }

    public void Goodman() {
        ArrayList<Node> h = nodes;
        int c = 0;
        while (h != null) {
            for (int i = 0; i < nCount; i++) {
                h.get(i).getEdges().get(0);
            }
        }
    }

    public void Display() {
        graphStream.display();
    }

}
