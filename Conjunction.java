import java.util.*;

public class Conjunction extends Formula {
    Formula left, right;

    public Conjunction(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " ∧ " + right.toString() + ")";
    }

    @Override
    public Formula toNNF() {
        return new Conjunction(left.toNNF(), right.toNNF());
    }

    @Override
    public Set<String> freeVars() {
        Set<String> s = new HashSet<>(left.freeVars());
        s.addAll(right.freeVars());
        return s;
    }

    @Override
    public Set<String> boundVars() {
        Set<String> s = new HashSet<>(left.boundVars());
        s.addAll(right.boundVars());
        return s;
    }

    @Override
    public boolean evaluate(Interpretation I, Map<String, Integer> rho) {
        return left.evaluate(I, rho) && right.evaluate(I, rho);
    }

}
