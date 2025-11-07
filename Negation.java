import java.util.*;

public class Negation extends Formula {
    private Formula sub;

    public Negation(Formula sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "¬(" + sub.toString() + ")";
    }

    @Override
    public Formula toNNF() {
        if (sub instanceof Negation) {
            return ((Negation) sub).sub.toNNF();
        }
        if (sub instanceof Conjunction) {
            Conjunction c = (Conjunction) sub;
            return new Disjunction(new Negation(c.left).toNNF(),
                    new Negation(c.right).toNNF());
        }
        if (sub instanceof Disjunction) {
            Disjunction d = (Disjunction) sub;
            return new Conjunction(new Negation(d.left).toNNF(),
                    new Negation(d.right).toNNF());
        }
        if (sub instanceof Existential) {
            Existential e = (Existential) sub;
            return new Universal(e.var, new Negation(e.sub).toNNF());
        }
        if (sub instanceof Universal) {
            Universal u = (Universal) sub;
            return new Existential(u.var, new Negation(u.sub).toNNF());
        }
        return new Negation(sub.toNNF());
    }

    @Override
    public Set<String> freeVars() {
        return sub.freeVars();
    }

    @Override
    public Set<String> boundVars() {
        return sub.boundVars();
    }

    @Override
    public boolean evaluate(Interpretation I, Map<String, Integer> rho) {
        return !sub.evaluate(I, rho);
    }

}
