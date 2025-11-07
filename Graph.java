import java.util.*;

class Graph implements Interpretation {
    private Map<Integer, Boolean> vertices;
    private Map<Integer, List<Integer>> edges;

    public Graph(int n) {
        vertices = new HashMap<>();
        edges = new HashMap<>();

        for (int i = 0; i < n; i++) {
            vertices.put(i, false);
            edges.put(i, new ArrayList<>());
        }
    }

    public boolean isColored(int vertex) {
        return vertices.getOrDefault(vertex, false);
    }

    public boolean isEdge(int source, int destination) {
        return edges.getOrDefault(source, Collections.emptyList()).contains(destination);
    }

    @Override
    public Set<Integer> getIndividuals() {
        return vertices.keySet();
    }

    @Override
    public boolean applyPredicate(String name, List<Integer> arguments) {
        if (name.equals("B")) {
            if (arguments.size() != 1)
                return false;
            return isColored(arguments.get(0));
        }
        if (name.equals("E")) {
            if (arguments.size() != 2)
                return false;
            return edges.get(arguments.get(0)).contains(arguments.get(1));
        }
        if (name.equals("=")) {
            if (arguments.size() != 2)
                return false;
            return arguments.get(0).equals(arguments.get(1));
        }
        return false;
    }

    public void colorVertex(int vertex) {
        if (vertices.containsKey(vertex)) {
            vertices.put(vertex, true);
        }
    }

    public void addEdge(int source, int destination) {
        if (edges.containsKey(source) && edges.containsKey(destination)) {
            edges.get(source).add(destination);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sommets bleus : ");
        for (var e : vertices.entrySet()) {
            if (e.getValue())
                sb.append(e.getKey()).append(" ");
        }
        sb.append("\nArcs orientés :\n");
        for (var e : edges.entrySet()) {
            for (int dest : e.getValue()) {
                sb.append(e.getKey()).append(" -> ").append(dest).append("\n");
            }
        }
        return sb.toString();
    }

}
