/**
 * Created by Flashed on 18-05-2017.
 */
public class SPE6 {

    private Graph graph;

    public void initGraph() {

        graph = new Graph();
        graph.addNode(new Node("A", 10));
        graph.addNode(new Node("B", 20));
        graph.addNode(new Node("C", 5));
        graph.addNode(new Node("D", 10));
        graph.addNode(new Node("E", 20));
        graph.addNode(new Node("F", 15));
        graph.addNode(new Node("G", 5));
        graph.addNode(new Node("H", 15));

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 7);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        graph.addEdge(7, 4);


    }


    public static void main(String[] args) {

        SPE6 ex = new SPE6();
        ex.initGraph();
        ex.graph.calculateEarly();
        ex.graph.calculateLate();
        ex.graph.criticalPath();
        for (Node node : ex.graph.getGraph()) {
            System.out.println(node.toString());
        }

        System.out.println("break");
    }
}
