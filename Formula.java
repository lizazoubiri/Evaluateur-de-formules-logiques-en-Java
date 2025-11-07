import java.util.*;

abstract class Formula {
    @Override
    public abstract String toString();

    public abstract Formula toNNF();

    public abstract Set<String> freeVars();

    public abstract Set<String> boundVars();

    public abstract boolean evaluate(Interpretation I, Map<String, Integer> rho);

    public boolean isModel(Interpretation I) {

        return evaluate(I, new HashMap<>());
    }
}