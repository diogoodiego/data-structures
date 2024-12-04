public class App {
    public static void main(String[] args) throws Exception {
        // for (int i = 60; i >= 33; i -= 3) {
        // tree.insert(i);
        // }

        // Rotação simples esquerda
        // Avl tree1 = new Avl();
        // tree1.insert(6);
        // tree1.insert(7);
        // tree1.insert(12);
        // tree1.Show();

        // Rotação simples direita
        // Avl tree2 = new Avl();
        // tree2.insert(12);
        // tree2.insert(7);
        // tree2.insert(6);
        // tree2.Show();

        // Rotação dupla direita
        // Avl tree3 = new Avl();
        // tree3.insert(12);
        // tree3.insert(7);
        // tree3.insert(6);
        // tree3.Show();

        // Rotação dupla esquerda
        // Avl tree4 = new Avl();
        // tree4.insert(6);
        // tree4.insert(12);
        // tree4.insert(7);
        // tree4.Show();

        // Inserir 1...30,
        // Avl tree = new Avl();
        // for (int i = 1; i <= 30; i += 3) {
        // tree.insert(i);
        // }
        // for (int i = 60; i >= 33; i -= 3) {
        // tree.insert(i);
        // }
        // tree.Show();

        // tree.remove(54);
        // tree.Show();

        // Avl avl5 = new Avl();
        // avl5.insert(10);
        // avl5.insert(5);
        // avl5.insert(15);
        // avl5.insert(2);
        // avl5.insert(8);
        // avl5.insert(13);
        // avl5.insert(25);
        // avl5.Show();
        // avl5.remove(10);
        // avl5.Show();
        // avl5.remove(15);
        // avl5.Show();
        // avl5.remove(25);
        // avl5.Show();

        Avl avl2 = new Avl();
        for (int i = 1; i <= 5; i++) {
            avl2.insert(i);
            if (i > 1) {
                avl2.Show();
            }
        }
    }
}
