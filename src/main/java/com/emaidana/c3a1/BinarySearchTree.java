public class BinarySearchTree {

    // Método para calcular la altura de un árbol binario de búsqueda
    public int getHeight(TreeNode root) {
        // Caso base: si el árbol está vacío, la altura es -1
        if (root == null) {
            return -1; // Altura de un árbol vacío se define como -1
        }

        // Dividir: calcular la altura de los subárboles izquierdo y derecho
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Vencer: la altura del árbol actual es el máximo entre ambas alturas + 1
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

        // Calcular la altura del árbol
        int height = tree.getHeight(root);
        System.out.println("La altura del árbol es: " + height);
    }
}

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}