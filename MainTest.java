import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        Formula f1 = new Existential("x", new Predicate("B", List.of("x")));
        Formula f2 = new Universal("x", new Predicate("B", List.of("x")));
        Formula f3 = new Negation(new Disjunction(f1, f2));

        System.out.println("Formule f1 : " + f1);
        System.out.println("Formule f2 : " + f2);
        System.out.println("Formule f3 : " + f3);
        System.out.println("NNF(f3) = " + f3.toNNF());
        System.out.println("Variables libres de f3 : " + f3.freeVars());
        System.out.println("Variables liées de f3 : " + f3.boundVars());
    }
}
