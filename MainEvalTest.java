import java.util.*;

public class MainEvalTest {
    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.colorVertex(0);
        g.colorVertex(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        Formula f1 = new Existential("x", new Predicate("B", List.of("x")));
        Formula f2 = new Universal("x", new Predicate("B", List.of("x")));
        Formula f3 = new Existential("x",
                new Existential("y",
                        new Conjunction(
                                new Predicate("E", List.of("x", "y")),
                                new Predicate("B", List.of("y")))));

        System.out.println("∃x.B(x) : " + f1.isModel(g));
        System.out.println("∀x.B(x) : " + f2.isModel(g));
        System.out.println("∃x∃y(E(x,y) ∧ B(y)) : " + f3.isModel(g));
    }
}
