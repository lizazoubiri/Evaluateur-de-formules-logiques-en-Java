import java.util.*;

class WordInterpretation implements Interpretation {
    private String word;

    public WordInterpretation(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Le mot doit être non vide !");
        }
        this.word = word;
    }

    @Override
    public Set<Integer> getIndividuals() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(i);
        }
        return set;
    }

    @Override
    public boolean applyPredicate(String name, List<Integer> arguments) {
        switch (name) {
            case "a": // prédicat unaire : position avec un 'a'
                if (arguments.size() != 1)
                    return false;
                return word.charAt(arguments.get(0)) == 'a';

            case "b": // prédicat unaire : position avec un 'b'
                if (arguments.size() != 1)
                    return false;
                return word.charAt(arguments.get(0)) == 'b';

            case "<": // ordre strict sur les positions
                if (arguments.size() != 2)
                    return false;
                return arguments.get(0) < arguments.get(1);

            case "=": // égalité
                if (arguments.size() != 2)
                    return false;
                return arguments.get(0).equals(arguments.get(1));

            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "Mot = \"" + word + "\", positions = " + getIndividuals();
    }
}
