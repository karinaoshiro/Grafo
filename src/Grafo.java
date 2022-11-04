import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
    ArrayList<ArrayList<Integer>> grafo;
    int v;

    Grafo(int laco) {
        v = laco;
        grafo = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < v; i++) {
            grafo.add(new ArrayList<Integer>());
        }
    }

    public void addFim(Integer v, Integer u) {
        grafo.get(v).add(u);
        grafo.get(u).add(v);
    }

    void mostraGrafo() {
        for (Integer i = 0; i < v; i++) {
            System.out.println("LAÇO " + i + "");
            for (int x : grafo.get(i)) {
                System.out.println(" - >" + x);
            }
            System.out.println();
        }
    }

    void utilitario(int laco, boolean visitado[]) {
        visitado[laco] = true;
        System.out.println(laco + " ");
        for (int x : grafo.get(laco)) {
            if (visitado[x] == false) {
                utilitario(x, visitado);

            }
        }
    }

    void buscaProfundidade(int inicio) {
        boolean visitado[] = new boolean[v];
        System.out.println("Busca em profundidade");
        utilitario(inicio, visitado);
    }

    void buscaLargura(int inicio) {
        boolean visitado[] = new boolean[v];
        Queue<Integer> f = new LinkedList<>();
        f.add(inicio);
        System.out.println("Busca em largura");
        visitado[inicio] = true;
        while (f.isEmpty() == false) {
            int laco = f.poll();
            System.out.println(laco + " ");
            for (int x : grafo.get(laco)) {
                if (visitado[x] == false) {
                    visitado[x] = true;
                    f.add(x);
                }
            }
        }
    }

    public static void main(String[] args) {

        Grafo g = new Grafo(5);
        g.addFim(0, 1);
        g.addFim(3, 2);
        g.addFim(2, 4);
        g.addFim(1, 4);
        g.addFim(3, 1);
        g.addFim(2, 0);

        g.mostraGrafo();

        System.out.println("B P");
        g.buscaProfundidade(0);

        System.out.println("B L");
        g.buscaLargura(0);
    }

}