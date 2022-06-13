package Session_3_3;

public class PrintTree {
    public static void main(String[] args) {
        Node raiz = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        Node h4 = new Node(4);
        Node h5 = new Node(5);
        Node h6 = new Node(6);
        Node h7 = new Node(7);

        raiz.setLeft(h2);
        h2.setLeft(h4);
        h2.setRight(h5);
        h5.setLeft(h7);
        raiz.setRight(h3);
        h3.setRight(h6);

//        System.out.println("PRE ORDER");
//        raiz.printPreorder(raiz);
//        System.out.println("POST ORDER");
//        raiz.printPostorder(raiz);
//        System.out.println("IN ORDER");
//        raiz.printInOrder(raiz);

        raiz.print();

    }


}
