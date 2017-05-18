import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flashed on 18-05-2017.
 */
public class Graph {

    private List<Node> nodes;
    private List<Edge> edges;

    public Graph(){
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }

    public void addNode(Node node){
        this.nodes.add(node);
    }

    public void addEdge(int parentNodeId, int childEdgeId){
        Node parent = nodes.get(parentNodeId);
        Node child = nodes.get(childEdgeId);
        edges.add(new Edge(parent, child));
    }

    public void calculateEarly(){
        List<Node> unvisited = new ArrayList<Node>(nodes);
        //rootnode
        Node startNode = nodes.get(0);
        startNode.setEarlyStart(0);
        startNode.setEarlyFinish(startNode.getDuration());
        while(!unvisited.isEmpty()){
            Node node = unvisited.get(0);
            List<Edge> outgoingEdges = getOutgoingEdges(node.getName());
            for (Edge e: outgoingEdges) {
                Node childNode = e.getChildNode();
                if(childNode.getEarlyStart()<node.getEarlyFinish()){
                    childNode.setEarlyStart(node.getEarlyFinish());
                    childNode.setEarlyFinish(childNode.getEarlyStart()+childNode.getDuration());
                }

            }
            unvisited.remove(node);
        }


    }

    public void criticalPath(){

        List<Edge> critcalEdges = new ArrayList<Edge>();

        for(Edge e: edges){
            Node tempChild = e.getChildNode();
            Node tempParent = e.getParentNode();
            if(tempChild.getLateFinish() == tempChild.getEarlyFinish() && tempParent.getLateFinish() == tempParent.getEarlyFinish()) critcalEdges.add(e);
        }

        //Going to be the lowest edge
        Edge lowEdge = null;
        for(Edge e: critcalEdges){
            if(lowEdge== null) lowEdge = e;
            else if(e.getParentNode().getEarlyStart()<lowEdge.getParentNode().getEarlyStart()) lowEdge = e;
        }


        while(lowEdge!=null){
            Node child = lowEdge.getChildNode();
            Node parent = lowEdge.getParentNode();
            System.out.println(parent.getName() + "->" + child.getName());
            lowEdge = searchForNewEdge(child.getName(),critcalEdges);
        }


    }

    public Edge searchForNewEdge(String nodeName, List<Edge> edgeList){
        for(Edge e: edgeList){
            if(e.getParentNode().getName().equals(nodeName)) return e;
        }
        return null;
    }

    public void calculateLate(){
        List<Node> unvisited = new ArrayList<Node>(nodes);
        //endNode
        Node endNode = getHighestEarlyFinish(nodes);
        endNode.setLateStart(endNode.getEarlyStart());
        endNode.setLateFinish(endNode.getEarlyFinish());
        while(!unvisited.isEmpty()){
            Node node = getHighestLateFinish(unvisited);
            List<Edge> incomingEdges = getIncomingEdges(node.getName());
            for(Edge e: incomingEdges){
                Node parentNode = e.getParentNode();
                if(parentNode.getName().equals("F")){
                    System.out.println("hest");
                }
                if(parentNode.getLateFinish()==0 || parentNode.getLateFinish() > node.getLateStart()){
                    parentNode.setLateStart(node.getLateStart()-parentNode.getDuration());
                    parentNode.setLateFinish(node.getLateStart());
                }
            }
            unvisited.remove(node);
        }
    }

    public Node getHighestEarlyFinish(List<Node> nodes){
        Node highestNode = nodes.get(0);
        Node tempNode;
        for(int i = 1; i<nodes.size(); i++){
            tempNode = nodes.get(i);
            if(tempNode.getEarlyFinish()>highestNode.getEarlyFinish()){
                highestNode = tempNode;
            }
        }
        return highestNode;
    }

    public Node getHighestLateFinish(List<Node> nodes){
        Node highestNode = nodes.get(0);
        Node tempNode;
        for(int i = 1; i<nodes.size(); i++){
            tempNode = nodes.get(i);
            if(tempNode.getLateFinish()>highestNode.getLateFinish()){
                highestNode = tempNode;
            }
        }
        return highestNode;
    }

    public List<Edge> getIncomingEdges(final String nodeName){
        List<Edge> foundEdges = new ArrayList<Edge>();

        for (Edge e: edges) {
            if(e.getChildNode().getName().equals(nodeName)){
                foundEdges.add(e);
            }
        }
        return foundEdges;
    }


    public List<Edge> getOutgoingEdges(final String nodeName){
        List<Edge> foundEdges = new ArrayList<Edge>();

        for (Edge e: edges) {
            if(e.getParentNode().getName().equals(nodeName)){
                foundEdges.add(e);
            }
        }
        return foundEdges;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
