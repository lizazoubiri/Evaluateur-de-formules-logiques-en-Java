import java.util.*;

public class MainGraphTest {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.colorVertex(0);
        g.colorVertex(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println(g);
        System.out.println("B(0) : " + g.applyPredicate("B", List.of(0)));
        System.out.println("E(1,2) : " + g.applyPredicate("E", List.of(1, 2)));
        System.out.println("=(2,2) : " + g.applyPredicate("=", List.of(2, 2)));
    }
}
