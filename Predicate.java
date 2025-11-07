import java.util.*;

public class Predicate extends Formula {
    private String name;
    private List<String> args;

    public Predicate(String name, List<String> args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public String toString() {
        return name + "(" + String.join(",", args) + ")";
    }

    @Override
    public Formula toNNF() {
        return this;
    }

    @Override
    public Set<String> freeVars() {
        return new HashSet<>(args);
    }

    @Override
    public Set<String> boundVars() {
        return new HashSet<>();
    }

    @Override
    public boolean evaluate(Interpretation I, Map<String, Integer> rho) {
        List<Integer> values = new ArrayList<>();
        for (String var : args) {
            if (!rho.containsKey(var)) {
                throw new RuntimeException("Variable libre non valuée : " + var);
            }
            values.add(rho.get(var));
        }
        return I.applyPredicate(name, values);
    }

}
