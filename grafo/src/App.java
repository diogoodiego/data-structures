public class App {
        public static void main(String[] args) throws Exception {

                // Grafo grafo = new Grafo();
                // String v1 = grafo.addVertice("Sacolão - Lagoa Nova");
                // String v2 = grafo.addVertice("Midway Mall");
                // String v3 = grafo.addVertice("Nordestão Lagoa Nova");
                // String v4 = grafo.addVertice("Cruzamento - R. Jaguarari, Av. Nevaldo Rocha");
                // grafo.addEdge(v1, v4, "R. Jaguarari");
                // grafo.addEdge(v4, v2, "Av. Nevaldo Rocha");
                // grafo.addEdge(v2, v3, "Av. Salgado Filho");
                // grafo.Display();

                // GrafoDirecionado grafoDirecionado = new GrafoDirecionado();
                // grafoDirecionado.AddNode("Sacolão Lagoa Nova");
                // grafoDirecionado.AddNode("Midway Mall");
                // grafoDirecionado.AddNode("Nordestão Lagoa Nova");
                // grafoDirecionado.AddNode("Cruzamento - Av. Antônio Basílio, Av. Prudente de
                // Morais");
                // grafoDirecionado.AddNode("Cruzamento - Av. Prudente de Morais, Av. Nevaldo
                // Rocha");
                // grafoDirecionado.AddNode("Cruzamento - R. Jaguarari, Av. Nevaldo Rocha");
                // grafoDirecionado.addEdge("R. Jaguarari", "Sacolão Lagoa Nova",
                // "Cruzamento - R. Jaguarari, Av. Nevaldo Rocha");
                // grafoDirecionado.addEdge("Av. Antônio Basílio", "Sacolão Lagoa Nova",
                // "Cruzamento - Av. Antônio Basílio, Av. Prudente de Morais");
                // grafoDirecionado.addEdge("Av. Prudente de Morais",
                // "Cruzamento - Av. Antônio Basílio, Av. Prudente de Morais",
                // "Cruzamento - R. Jaguarari, Av. Nevaldo Rocha");
                // grafoDirecionado.addEdge("Av. Nevaldo Rocha",
                // "Cruzamento - R. Jaguarari, Av. Nevaldo Rocha",
                // "Cruzamento - Av. Prudente de Morais, Av. Nevaldo Rocha");
                // grafoDirecionado.addEdge("Av. Nevaldo Rocha volta",
                // "Cruzamento - Av. Prudente de Morais, Av. Nevaldo Rocha",
                // "Cruzamento - R. Jaguarari, Av. Nevaldo Rocha");
                // grafoDirecionado.addEdge("Av. Nevaldo Rocha 2",
                // "Cruzamento - Av. Prudente de Morais, Av. Nevaldo Rocha",
                // "Midway Mall");
                // grafoDirecionado.addEdge("Av. Nevaldo Rocha 2 volta",
                // "Midway Mall",
                // "Cruzamento - Av. Prudente de Morais, Av. Nevaldo Rocha");

                // grafoDirecionado.addEdge("Av. Salgado Filho",
                // "Midway Mall",
                // "Nordestão Lagoa Nova");

                // grafoDirecionado.addEdge("Av. Salgado Filho volta",
                // "Nordestão Lagoa Nova",
                // "Midway Mall");

                // GrafoDirecionado grafoDirecionado = new GrafoDirecionado();
                // grafoDirecionado.AddNode("v1");
                // grafoDirecionado.AddNode("v2");
                // grafoDirecionado.AddNode("v3");
                // grafoDirecionado.addEdge("a1", "v1", "v2");
                // grafoDirecionado.addEdge("a2", "v3", "v2");
                // grafoDirecionado.Show();
                // grafoDirecionado.Display();

                // GrafoDirecionado grafoDirecionado = new GrafoDirecionado();
                // grafoDirecionado.AddNode("v1");
                // grafoDirecionado.AddNode("v2");
                // grafoDirecionado.AddNode("v3");
                // grafoDirecionado.addEdge("a1", "v2", "v3");
                // grafoDirecionado.addEdge("a2", "v2", "v1");
                // grafoDirecionado.Show();
                // grafoDirecionado.Display();

                // GrafoLista g = new GrafoLista();
                // g.AddNode("1");
                // g.AddNode("2");
                // g.AddNode("3");
                // g.AddNode("4");
                // g.addEdge("1", "3", -2);
                // g.addEdge("2", "1", 4);
                // g.addEdge("2", "3", 3);
                // g.addEdge("3", "4", 2);
                // g.addEdge("4", "2", -1);
                // g.Print();
                // g.Display();
                // g.floydWarshal();

                GrafoLista grafo = new GrafoLista();
                grafo.AddNode("1");
                grafo.AddNode("2");
                grafo.AddNode("3");

                grafo.addEdge("1", "3", -4);
                grafo.addEdge("2", "1", 1);
                grafo.addEdge("3", "2", 2);
                grafo.Print();
                grafo.Display();
                grafo.floydWarshal();

                // ListaAresta grafo = new ListaAresta();
                // grafo.addNode("1");
                // grafo.addNode("2");
                // grafo.addNode("3");
                // grafo.addNode("4");
                // grafo.addEdge("1", "2");
                // grafo.addEdge("2", "3");
                // grafo.addEdge("3", "4");
                // grafo.addEdge("4", "2");
                // grafo.addEdge("4", "1");
                // grafo.display();
        }
}
