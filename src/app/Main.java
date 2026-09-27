package app;

public class Main {
    public static final boolean DEBUG = true;

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.printGraph();
        graph.addVertex(0);
        graph.removeVertex(2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.printGraph();
        graph.removeVertex(2);
        graph.printGraph();
        graph.removeEdge(3, 5);
        graph.printGraph();
    }
}
