import java.util.*;

public class MainWordTest {
    public static void main(String[] args) {
        WordInterpretation w1 = new WordInterpretation("abba");
        WordInterpretation w2 = new WordInterpretation("abababab");
        WordInterpretation w3 = new WordInterpretation("bbb");

        Formula f1 = new Existential("x", new Predicate("a", List.of("x")));

        Formula f2 = new Universal("x", new Predicate("b", List.of("x")));

        Formula startsA = new Predicate("a", List.of("0"));

        System.out.println("Mot : " + w1);
        System.out.println("∃x.a(x) : " + f1.isModel(w1));
        System.out.println("∀x.b(x) : " + f2.isModel(w1));

        System.out.println("\nMot : " + w2);
        System.out.println("∃x.a(x) : " + f1.isModel(w2));
        System.out.println("∀x.b(x) : " + f2.isModel(w2));

        System.out.println("\nMot : " + w3);
        System.out.println("∃x.a(x) : " + f1.isModel(w3));
        System.out.println("∀x.b(x) : " + f2.isModel(w3));
    }
}
