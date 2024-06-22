package OntapBinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public Node root;
    public Tree(Node root){
        root=null;
    }
    public void insertNode(int id, double dd){
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        Node current = root;
        Node parent;
        if(root == null){
            return;
        }
        else{
            while(true){
                parent = current; // current chi cai node dang o hien tai co current la noi ve cai node current that how imagine
                if(current.iData>id){
                    current = current.leftChild;
                    if(current==null){// so if the current cross the end they will insert the value at the end
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else if (current.iData<id){
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                    }
                }

            }
        }
    }
    public Node find(int key){
     Node current = root;
    while(current.iData != key){ // khi bang roi thi no se out ra de ay cai loop
        if(current.iData< key){
            current = current.leftChild;
        }
        else if (current.iData> key){
            current = current.rightChild;
        }
        if (current==null){
            return null;
    }
    }
    return current;
    }

    public void inorderTraversal(Node root){
        if(root != null){
        inorderTraversal(root.leftChild);
        System.out.println(root);
        inorderTraversal(root.rightChild);}

    }
    public void preOrderTraversal(Node root){
        if(root != null){
        System.out.println(root);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);}
    }
    public void postOrder(Node root){
        if(root != null){
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.println(root);}
    }
    public void BFS(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp=queue.poll(); // return the head of the tree
            if(temp.leftChild != null){
                queue.add(temp.leftChild);
            }
            else if(temp.rightChild != null){
                queue.add(temp.rightChild);
            }
        }

    }
    public static int countElement(Node t){
        if (t == null){
            return 0;
        }
        else {
            return 1 + countElement(t.leftChild) + countElement(t.rightChild);
        }
    }
    public static int treeHeight(Node t){
        int left = treeHeight(t.leftChild);
        int right = treeHeight(t.rightChild);

        if(t == null){
            return 0;
        }
        else{
            return 1 + Math.max(left,right);
        }
    }

    public Node findMax(Node root) {
        Node current = root;
        if (root == null) {
            return null;
        }
        while (current.rightChild != null) {
            current = current.rightChild;

        }
        return current;
    }
    public Node findMin(Node root){
        Node current = root;
        if (root == null){
            return null;
        }
        while(current.leftChild != null){
            current = current.leftChild;
        }
        return current;
    }

}
