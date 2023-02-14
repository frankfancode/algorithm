package com.ff.subject;

import java.util.*;

public class DijkstraPractice {

    static class Node {
        public Node(String v, int widget) {
            this.key = v;
            this.weight = widget;
        }

        String key;
        int weight;
    }

    public static void main(String[] args) {
        Map<String, List<Node>> graph = new HashMap<>();
        List<Node> list = new LinkedList<>();
        list.add(new Node("A", 5));
        list.add(new Node("B", 2));
        graph.put("START", list);

        list = new LinkedList<>();
        list.add(new Node("C", 4));
        list.add(new Node("D", 2));
        graph.put("A", list);

        list = new LinkedList<>();
        list.add(new Node("D", 7));
        list.add(new Node("A", 8));
        graph.put("B", list);

        list = new LinkedList<>();
        list.add(new Node("FIN", 3));
        list.add(new Node("D", 6));
        graph.put("C", list);

        list = new LinkedList<>();
        list.add(new Node("FIN", 1));
        graph.put("D", list);

        Map<String, Integer> costs = new HashMap<>();
        costs.put("A", 5);
        costs.put("B", 2);
        costs.put("C", Integer.MAX_VALUE);
        costs.put("D", Integer.MAX_VALUE);
        costs.put("FIN", Integer.MAX_VALUE);

        Map<String, String> parents = new HashMap<>();
        parents.put("A", "START");
        parents.put("B", "START");
        parents.put("FIN", "-");
        Set<String> processed = new HashSet<>();
        new DijkstraPractice().leastCosts(graph, costs, parents, processed);
    }

    public int leastCosts(Map<String, List<Node>> graph, Map<String, Integer> costs, Map<String, String> parents, Set<String> processed) {
        String node = findLowestNode(costs, processed);
        while (node != null) {
            List<Node> nodes = graph.get(node);
            for (int i = 0;nodes !=null && i < nodes.size(); i++) {
                Integer cost = costs.get(nodes.get(i).key);
                if (cost != null && nodes.get(i).weight + costs.get(node) < cost) {
                    costs.put(nodes.get(i).key, nodes.get(i).weight + costs.get(node));
                    parents.put(nodes.get(i).key, node);
                }
            }
            processed.add(node);
            node = findLowestNode(costs, processed);
        }

        System.out.println(costs.get("FIN"));
        return 0;
    }

    public String findLowestNode(Map<String, Integer> costs, Set<String> processed) {
        int lowestCost = Integer.MAX_VALUE;
        String lowestNode = null;
        for (Map.Entry<String, Integer> stringIntegerEntry : costs.entrySet()) {
            if (stringIntegerEntry.getValue() < lowestCost && !processed.contains(stringIntegerEntry.getKey())) {
                lowestCost = stringIntegerEntry.getValue();
                lowestNode = stringIntegerEntry.getKey();
            }
        }
        return lowestNode;
    }


}
