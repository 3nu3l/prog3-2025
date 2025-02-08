package Actividad1;

public class BinarySearchTree {

    // Método para buscar un valor en el BST
    public TreeNode searchBST(TreeNode root, int x) {
        if (root == null || root.value == x) {
            return root;
        }
        if (x < root.value) {
            return searchBST(root.left, x);
        }
        return searchBST(root.right, x);
    }

    // Método para calcular la altura del árbol
    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Crear un árbol de ejemplo
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);
        root.right.right.right = new TreeNode(30);
        
        System.out.println("Altura del árbol: " + tree.getHeight(root));
    }
}