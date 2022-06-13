package Session_3_4;

public class Decission_Tree {
    private Node root;
    private Node currentNode;

    public Decission_Tree() {
        root = null;
    }

    public boolean search(String data) {
        return search(root, data);
    }

    public boolean search(Node node, String data) {
        if (node.getData().equals(data))
            return true;

        if (node.getLeft() != null)
            if (search(node, data))
                return true;

        if (node.getRight() != null)
            if (search(node.getRight(), data))
                return true;
        return false;
    }
    public int countNodes(Node node) {
        int count = 1;

        if (node == null)
            return 0;

        count += countNodes(node.getLeft());
        count += countNodes(node.getRight());
        return count;
    }

    public String print() {
        return this.print("", true, "");
    }

    public String print(String prefix, boolean isTail, String sb) {
        if (root.getRight() != null) {
            root.getRight().print(prefix + (isTail ? "|   " : "   "), false, sb);
        }
        System.out.println(prefix + (isTail ? "\\-- " : "/-- ") + root.getData());
        if (root.getLeft() != null) {
            root.getLeft().print(prefix + (isTail ? "   " : "|    "), true, sb);
        }
        return sb;
    }

    public void printPreorder() {
        root.printPreorder(root);
    }

    public void printPostorder() {
        root.printPostorder(root);
    }

    public void printInOrder() {
        root.printInOrder(root);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node node) {
        this.currentNode = node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int countNodes() {
        return countNodes(root);
    }
}
