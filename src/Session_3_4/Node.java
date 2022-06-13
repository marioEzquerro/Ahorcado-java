package Session_3_4;

public class Node {
    String data;
    Node left;
    Node right;

    public Node(String question) {
        this.data = question;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        System.out.println(node.getLeft()+ " ");
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
