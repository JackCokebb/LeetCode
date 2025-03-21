class Solution {
    
    public double[] calcEquation(List<List<String>> equations, double[] values,
        List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {

            result[i] = getWeightByDfs(graph, queries.get(i).get(0), queries.get(i).get(1),
                new HashSet<>());
        }

        return result;
    }

    private double getWeightByDfs(Map<String, Map<String, Double>> graph, String start, String end,
        Set<String> visited) {

        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        for (Map.Entry<String, Double> e : graph.get(start).entrySet()) {
            if (!visited.contains(e.getKey())) {
                visited.add(e.getKey());

                double weight = getWeightByDfs(graph, e.getKey(), end, visited);

                if (weight != -1.0) {
                    return weight * e.getValue();
                }
            }
        }

        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations,
        double[] values) {

        HashMap<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);

            graph.putIfAbsent(start, new HashMap<>());
            graph.get(start).put(end, values[i]);
            graph.putIfAbsent(end, new HashMap<>());
            graph.get(end).put(start, 1 / values[i]);
        }

        return graph;
    }
}