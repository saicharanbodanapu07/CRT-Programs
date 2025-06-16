public class Tree {
    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeBuilder tree = new TreeBuilder(nodes);
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        System.out.println("Height: " + TreeBuilder.heightOf(tree.getRoot()));
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class TreeBuilder {
    TreeNode root;
    int index = -1;

    TreeBuilder(int[] nodes) {
        this.root = buildTreeUsingArray(nodes);
        System.out.println(index);
    }

    public TreeNode buildTreeUsingArray(int[] nodes) {
        index++;
        if (index >= nodes.length || nodes[index] == -1)
            return null;
        TreeNode newNode = new TreeNode(nodes[index]);
        newNode.left = buildTreeUsingArray(nodes);
        newNode.right = buildTreeUsingArray(nodes);
        return newNode;
    }

    public void preOrder() {
        preOrderHelper(this.root);
    }

    public void preOrderHelper(TreeNode temp) {
        if (temp == null)
            return;
        System.out.print(temp.data + " ");
        preOrderHelper(temp.left);
        preOrderHelper(temp.right);
    }

    public void inOrder() {
        inOrderHelper(this.root);
    }

    public void inOrderHelper(TreeNode temp) {
        if (temp == null)
            return;
        inOrderHelper(temp.left);
        System.out.print(temp.data + " ");
        inOrderHelper(temp.right);
    }

    public void postOrder() {
        postOrderHelper(this.root);
    }

    public void postOrderHelper(TreeNode temp) {
        if (temp == null)
            return;
        postOrderHelper(temp.left);
        postOrderHelper(temp.right);
        System.out.print(temp.data + " ");
    }

    TreeNode getRoot() {
        return root;
    }

    public static int heightOf(TreeNode root) {
        if (root == null)
            return 0;
        int lh = heightOf(root.left);
        int rh = heightOf(root.right);
        return Math.max(lh, rh) + 1;
    }
}
-------------------------------------------------
public class Merging_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] a = {2, 7, 12, 18, 23, 55};
        int[] b = {6, 11, 18, 21, 25, 70};
        int[] c= new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b [j]) {
                c[k] = b[j];
                j++;
                k++;
            } 
            else {
                c[k] = a[i];
                i++;
                k++;
            }
        }
        while  (i < a.length) {
            c[k] = a[i];
            k++;
            i++;
        }
        while  (j < b.length) {
            c[k] = b[j];
            k++;
            j++;
        }
        for (int l = 0; l < k; l++) {
            System.out.print(c[l]+ " ");
        }
    }
}
-----------------------------------------
class BinarySearchTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insertNode(tree.root, 50);
        tree.root = tree.insertNode(tree.root, 30);
        tree.root = tree.insertNode(tree.root, 70);
        tree.root = tree.insertNode(tree.root, 20);
        tree.root = tree.insertNode(tree.root, 40);
        tree.root = tree.insertNode(tree.root, 60);
        tree.root = tree.insertNode(tree.root, 80);
        tree.inorder(tree.root);
        tree.preorder(tree.root);
        tree.postorder(tree.root);
        tree.search(tree.root, 40);
        tree.delete(tree.root, 30);
        tree.inorder(tree.root);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        this.root = null;
    }

    public static Node newNode(int data) {
        return new Node(data);
    }

    public Node insertNode(Node root, int data) {
        if (root == null)
            return newNode(data);
        if (data > root.data)
            root.right = insertNode(root.right, data);
        else if (data < root.data)
            root.left = insertNode(root.left, data);
        return root;
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public Node search(Node root, int data) {
        if (root == null || root.data == data)
            return root;
        if (data < root.data)
            return search(root.left, data);
        return search(root.right, data);
    }

    public Node delete(Node root, int data) {
        if (root == null)
            return root;
        if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
}
