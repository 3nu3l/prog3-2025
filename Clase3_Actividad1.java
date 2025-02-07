public class Clase3_Actividad1 {

    // Método para buscar un valor en el BST
    public TreeNode searchBST(TreeNode root, int x) {
        // Caso base: si el nodo es nulo o si el valor del nodo es el que estamos buscando
        if (root == null || root.value == x) {
            return root;
        }

        // Si el valor a buscar es menor que el valor del nodo actual, buscar en el subárbol izquierdo
        if (x < root.value) {
            return searchBST(root.left, x);
        }

        // Si el valor a buscar es mayor que el valor del nodo actual, buscar en el subárbol derecho
        return searchBST(root.right, x);
    }

    // Método para calcular la altura del BST
    public int getHeight(TreeNode root) {
        // Caso base: si el nodo es nulo, la altura es 0
        if (root == null) {
            return 0;
        }

        // Altura del subárbol izquierdo
        int leftHeight = getHeight(root.left);
        // Altura del subárbol derecho
        int rightHeight = getHeight(root.right);

        // Altura del árbol actual es el mayor de los subárboles más 1
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Clase3_Actividad1 tree = new Clase3_Actividad1();

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
