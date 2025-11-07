import java.util.*;

// Classe pour les quantificateurs universels (∀x. φ)
public class Universal extends Formula {
    String var;
    Formula sub;

    public Universal(String var, Formula sub) {
        this.var = var;
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "∀" + var + ".(" + sub.toString() + ")";
    }

    @Override
    public Formula toNNF() {
        return new Universal(var, sub.toNNF());
    }

    @Override
    public Set<String> freeVars() {
        Set<String> s = new HashSet<>(sub.freeVars());
        s.remove(var);
        return s;
    }

    @Override
    public Set<String> boundVars() {
        Set<String> s = new HashSet<>(sub.boundVars());
        s.add(var);
        return s;
    }

    @Override
    public boolean evaluate(Interpretation I, Map<String, Integer> rho) {
        for (int val : I.getIndividuals()) {
            Map<String, Integer> newRho = new HashMap<>(rho);
            newRho.put(var, val);
            if (!sub.evaluate(I, newRho)) {
                return false;
            }
        }
        return true;
    }

}
