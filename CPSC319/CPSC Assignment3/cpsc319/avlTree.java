package cpsc319;


public class avlTree {
    class Node {
        String name;
        int height;
        Node left;
        Node right;
     
        public Node(String d) {
            name = d;
            height = 1;
        }
    }
     
        Node root;
        // Adapted and implemented https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
        public Node insertion(Node node, String name) {
     
            //  Perform the normal BST insertion 
            if (node == null){
                return (new Node(name));
            }
     
            if (name.compareTo(node.name) < 0){
                node.left = insertion(node.left, name);
            }
            else if (name.compareTo(node.name) > 0){
                node.right = insertion(node.right, name);
            }
            else{// Duplicate keys not allowed
                return node;
            }
            // Update height of this ancestor node 
            node.height = 1 + max(height(node.left),
                                  height(node.right));
     
            //3. Get the balance factor of this ancestornode to check whether this node became unbalanced 
            int balance = getBalance(node);
     
            // If this node becomes unbalanced, then there
            // are 4 cases Left Left Case
            if (balance > 1 && name.compareTo(node.left.name) < 0){
                return rightRotate(node);
            }
            // Right Right Case
            if (balance < -1 && name.compareTo(node.right.name) > 0){
                return leftRotate(node);
            }
            // Left Right Case
            if (balance > 1 && name.compareTo(node.left.name) > 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
     
            // Right Left Case
            if (balance < -1 && name.compareTo(node.right.name) < 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
     
            //return the (unchanged) node pointer 
            return node;
        }
     
        
        // Adapted and implemented https://www.geeksforgeeks.org/avl-tree-set-1-insertion/  
        // A utility function to get the height of the tree
        public int height(Node N) {
            if (N == null){
                return 0;
            }
     
            return N.height;
        }
        // Adapted and implemented https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
        // A utility function to get maximum of two integers
        public int max(int a, int b) {
            return (a > b) ? a : b;
        }
        // Adapted and implemented https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
        //right rotate subtree rooted with y
        public Node rightRotate(Node y) {
            Node x = y.left;
            Node T2 = x.right;
     
            // Perform rotation
            x.right = y;
            y.left = T2;
     
            // Update heights
            y.height = max(height(y.left), height(y.right)) + 1;
            x.height = max(height(x.left), height(x.right)) + 1;
     
            // Return new root
            return x;
        }
        // Adapted and implemented https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
        // left rotate subtree rooted with x
        public Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;
     
            // Perform rotation
            y.left = x;
            x.right = T2;
     
            //  Update heights
            x.height = max(height(x.left), height(x.right)) + 1;
            y.height = max(height(y.left), height(y.right)) + 1;
     
            // Return new root
            return y;
        }
        // Adapted and implemented https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
        // Get Balance factor of node N
        public int getBalance(Node N) {
            if (N == null){
                return 0;
            }
     
            return height(N.left) - height(N.right);
        }
     
        // print preorder traversal of the tree.
        // The function also prints height of every node
        public void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.name + "> ");

                preOrder(node.left);

                preOrder(node.right);
            }
        }
    }
