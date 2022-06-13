package Session_3_3;

public class Node {
    int Data;
    Node left;
    Node right;

    public Node(int data) {
        Data = data;
        this.left = null;
        this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node node) {
        if (left == null)
            this.left = node;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        if (right == null)
            this.right = node;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        this.Data = data;
    }

     public void printPreorder(Node node) {
        if (node == null)
            return;

        System.out.println(node.getData()+ " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public void printPostorder(Node node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.getData()+ " ");
    }

    public void printInOrder(Node node) {
        if (node == null)
            return;

        printPostorder(node.left);
        System.out.println(node.getData()+ " ");
        printPostorder(node.right);
    }


    public String print() {
        return this.print("",true,"");
    }

    public String print(String prefix, boolean isTail, String sb) {
        if (right != null) {
            right.print(prefix + (isTail ? "|   " : "   "), false, sb);
        }
        System.out.println( prefix+(isTail ? "\\-- " : "/-- ") + this.getData());
        if (left != null) {
            left.print(prefix+(isTail ? "   " : "|    "), true, sb);
        }

        return sb;
    }



}
