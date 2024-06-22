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
    public Node getSuccessor(Node delNode){
        Node current = delNode.rightChild;
        Node sucessorParent = delNode;
        Node sucessor = delNode;
        while(current != null){
            sucessorParent = sucessor; // the parent must ne the node we wanna delete
            sucessor = current; // sucessor is now become the leftchilde children of the parent
            current = current.leftChild; // go to the left untill the end
        }
        if(sucessor != delNode.rightChild){
            sucessorParent.leftChild = sucessor.rightChild;
            sucessor.rightChild = delNode.rightChild;
        }
        return sucessor;

    }

    public boolean delete(int key){
        Node current = root;
        Node parent = root; // we need node parent to keep up the parent so after that
        // we can chage the field
        boolean isLeftChild= true;
        if (current == null){
            return false;
        }
        while(current.iData != key){
            parent = current;
             if(key<current.iData){
                 isLeftChild = true;
                 current = current.leftChild;
             }
             else if (key>current.iData){
                 isLeftChild = false;
                 current = current.rightChild;
            }
        }
      if(current.leftChild == null && current.rightChild == null){ // truong hop node with no parrent
          if (current == root){
              root = null; // if current still = root the tree is empty
          }
          else if(isLeftChild){
              parent.leftChild = null;
          }
          else{
              parent.rightChild = null; // after find the node they will disconnect it with their parrent
          }
      }
      else if (current.rightChild == null){ // node delete chi co 1 children o ben trai
          if(current == root){ // neu cai can delete la root
              current = current.leftChild;

          }
          else if(isLeftChild){
              parent.leftChild = current.leftChild; // neu can delete la 1 left child cua 1 parrent thi parent cua no se xuong cai duoi
          }
          else{
              parent.rightChild = current.leftChild;
          }

        }
      else if (current.leftChild == null){
          if(current == root){
              current = current.rightChild;
          }
          else if (isLeftChild){ // neu current la left child cua 1 parent
              parent.leftChild = current.rightChild;

          }
          else {
              parent.rightChild = current.rightChild;
          }
      }
      else{
          Node successor  = getSuccessor(current);
          if (current == root){
              root = successor;
          }
          else if(isLeftChild){
              parent.leftChild = successor;
          }
          else{
              parent.rightChild = successor;
          }
          successor.leftChild = current.leftChild;
      }
      return true;

    }

}
