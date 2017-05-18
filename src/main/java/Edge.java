/**
 * Created by Flashed on 18-05-2017.
 */
public class Edge {

    private Node parentNode;
    private Node childNode;
    private int duration;

    public Edge(Node parentNode, Node childNode) {
        this.parentNode = parentNode;
        this.childNode = childNode;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Node getChildNode() {
        return childNode;
    }

    public void setChildNode(Node childNode) {
        this.childNode = childNode;
    }
}
