import java.util.*;

interface Interpretation {

    Set<Integer> getIndividuals();

    boolean applyPredicate(String name, List<Integer> arguments);
}
