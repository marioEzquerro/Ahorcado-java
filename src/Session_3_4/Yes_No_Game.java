package Session_3_4;

import java.util.Scanner;

public class Yes_No_Game {

    public static void main(String[] args) {
        System.out.println("--- INICIO ---");
        game(setup());
    }

    private static Decission_Tree setup() {
        Decission_Tree tree = new Decission_Tree();
        Node root = new Node("Es un mamifero");

        Node perro = new Node("perro");
        Node pez = new Node("pez");

        root.setRight(perro);
        root.setLeft(pez);

        tree.setRoot(root);
        tree.setCurrentNode(root);

        return tree;
    }

    public static void game(Decission_Tree tree) {
        Scanner sc = new Scanner(System.in);

        if (tree.getCurrentNode().getLeft() == null || tree.getCurrentNode().getRight() == null) {
            guessAnimal(tree.getCurrentNode(), tree);
        }
        System.out.println("🤖: ¿" +  tree.getCurrentNode().getData()+ "?");

        System.out.print("(y/n): ");
        switch (sc.nextLine()) {
            case "y":
            case "Y":
                tree.setCurrentNode(tree.getCurrentNode().getRight());
                game(tree);
                break;
            case "n":
            case "N":
                tree.setCurrentNode(tree.getCurrentNode().getLeft());
                game(tree);
                break;
            case "p":
                tree.print();
        }
    }

    public static void guessAnimal(Node node, Decission_Tree tree) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🤖: ¿Es un: " +  tree.getCurrentNode().getData()+ "?");

        System.out.print("(y/n): ");
        switch (sc.nextLine()) {
            case "y":
            case "Y":
                System.out.println("🤖: ¡SI gane!");
                System.out.println("-------------");
                break;
            case "n":
            case "N":
                System.out.println("🤖: Me rindo, ¿En que estabas pensando?");
                String newAnimal = sc.nextLine();

                System.out.println("🤖: ¿Cual es la pregunta para diferenciar entre "+tree.getCurrentNode().getData()+" y "+newAnimal+"? ");
                String newQuestion = sc.nextLine();

                System.out.println("🤖: ¿Cual es la respuesta (y/n)?");
                String newAnswer = sc.nextLine();

                Node oldAnimal = new Node(node.getData());
                node.setData(newQuestion);
                Node guess = new Node(newAnimal);

                if (newAnswer.equalsIgnoreCase("y")) {
                    node.setRight(guess);
                    node.setLeft(oldAnimal);
                } else {
                    node.setRight(oldAnimal);
                    node.setLeft(guess);
                }
                break;
        }
        tree.setCurrentNode(tree.getRoot());
        game(tree);
    }
}