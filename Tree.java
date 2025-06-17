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
