package OntapBinarySearchTree;

public class Node {
    public int iData; // key
    public  double dData; // data item
    public  Node leftChild;
    public Node rightChild;
    public void DisplayNode(){
        System.out.println("{");
        System.out.println(iData);
        System.out.println("," + dData);
        System.out.println("}");
    }
}
