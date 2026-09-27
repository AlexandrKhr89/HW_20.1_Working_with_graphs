package app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    private final Map<Integer, Set<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
        if (Main.DEBUG) {
            System.out.println("Vertex added: " + vertex);
        }
    }

    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public void removeVertex(int vertex) {
        if (!hasVertex(vertex)) {
            if (Main.DEBUG) {
                System.out.printf("Vertex %s doesn`t exist.\n", vertex);
            }
            return;
        }
        for (int neighbor : adjacencyList.get(vertex)) {
            adjacencyList.get(neighbor).remove(vertex);
        }
        adjacencyList.remove(vertex);
        if (Main.DEBUG) {
            System.out.println("Vertex removed: " + vertex);
        }
    }


    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
        if (Main.DEBUG) {
            System.out.println("Edge added: " + source + " -> " + destination);
        }
    }

    public boolean hasEdge(int source, int destination) {
        return hasVertex(source) && adjacencyList.get(source).contains(destination);
    }

    public void removeEdge(int source, int destination) {
        if (hasVertex(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (hasVertex(destination)) {
            adjacencyList.get(destination).remove(source);
        }
        if (Main.DEBUG) {
            System.out.println("Edge removed: " + source + " -> " + destination);
        }
    }

    public void printGraph() {
        System.out.println("\nGraph:");
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty");
        }
        for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
            System.out.printf("Vertex: %s - %s\n", entry.getKey(), entry.getValue());
        }
    }
}
