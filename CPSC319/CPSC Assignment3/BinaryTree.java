
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    class Node {
        String name;
        Node left, right;
 
        public Node(String item)
        {
            name = item;
            left = right = null;
        }
    }

    Node root;
    // Adapted and Implemented from https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/#:~:text=1)%20Node%20to%20be%20deleted,Simply%20remove%20from%20the%20tree.&text=3)%20Node%20to%20be%20deleted,predecessor%20can%20also%20be%20used.
    void deletion(String key) { root = deleteRec(root, key); }
 
    /* A recursive function to
      delete an existing key in BST
     */
    // Adapted and Implemented from https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/#:~:text=1)%20Node%20to%20be%20deleted,Simply%20remove%20from%20the%20tree.&text=3)%20Node%20to%20be%20deleted,predecessor%20can%20also%20be%20used.
    Node deleteRec(Node root, String key)
    {
        // Base Case: If the tree is empty 
        if (root == null)
            return root;
        // Otherwise, recur down the tree */
        if (key.compareTo(root.name) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.name) > 0)
            root.right = deleteRec(root.right, key);
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.name = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.name);
        }
 
        return root;
    }
 
    String minValue(Node root)
    {
        String minv = root.name; 

        while (root.left != null){
            minv = root.left.name;
            root = root.left;
        }
        
        return minv;
    }
    // Adapted and Implemented from https://www.baeldung.com/java-binary-tree
    private Node addRecursive(Node current, String value) {
        if (current == null) {
            return new Node(value);
        }
    
        if (value.compareTo(current.name) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.name) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
    
        return current;
    }
    public void insertion(String value) {
        root = addRecursive(root, value);
    }
    // Adapted and Implemented from https://www.baeldung.com/java-binary-tree
    public ArrayList<String> breadthFirst() {
        ArrayList<String> breadthFirstTree = new ArrayList<String>();
        if (root == null) {
            return breadthFirstTree;
        }
    
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
    
        while (!nodes.isEmpty()) {
    
            Node node = nodes.remove();
            breadthFirstTree.add(node.name + " > ");
            System.out.print(node.name + " > ");
    
            if (node.left != null) {
                nodes.add(node.left);
            }
    
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        return breadthFirstTree;
    }
    // Adapted and Implemented from lecture notes
    public ArrayList<String> traverseInOrder(Node node) {
        ArrayList<String> inorderTree = new ArrayList<String>();
            if (node == null){
                return inorderTree;
            }
            //first recur on left child 
            traverseInOrder(node.left);
            // then print the data of node 
            inorderTree.add(node.name + " >");
            System.out.print(node.name + " >");
            // now recur on right child 
            traverseInOrder(node.right);
        return inorderTree;
    }

    

}
