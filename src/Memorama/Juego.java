package Memorama;

import java.time.LocalDate;
import java.util.*;

public class Juego extends LeerFichero {
    private static ArrayList<String> palabras = new ArrayList<>();
    private static ArrayList<String> letrasUsadas = new ArrayList<>();
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static int aciertos = 0;
    private static int vidas = 10;

    public static void main(String[] args) {
//        palabras.add("elefante");
//        palabras.add("superficie");
//        palabras.add("edificio");
//        palabras.add("clocaca");
//        palabras.add("leon");
//        palabras.add("cascada");
//        palabras.add("superman");
//        palabras.add("spiderman");
//        palabras.add("ordenador");
//        palabras.add("silla");
//        palabras.add("silabas");
//        palabras.add("boligrafo");
//        palabras.add("roca");
//        palabras.add("libro");
//        palabras.add("lapicero");
//        palabras.add("avion");
//        palabras.add("baloncesto");
//        palabras.add("cuerda");
//        palabras.add("aprovado");
//        palabras.add("reptil");
//        palabras.add("intrinseco");
//        palabras.add("rectangulo");
//        palabras.add("insecto");
//
//        LeerFichero.grabarDatos(palabras, "palabras.dtd");

        LeerFichero.leerDatos(palabras, "palabras.dtd");
        LeerFichero.leerDatos(jugadores, "puntuaciones.dtd");
        menu();

    }


    public static void menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Jugar\n" +
                "2. Puntuaciones\n" +
                "3. Salir");
        String opc = sc.next();

        switch (opc) {
            case "1":
                int rand = (int) (Math.random() * palabras.size());
                long inicio = System.currentTimeMillis();
                game(palabras.get(rand), inicio);
                break;
            case "2":
                printPuntuaciones();
                break;
            case "3":
                anadirPalabras();
                break;
            case "4":
                LeerFichero.grabarDatos(jugadores, "puntuaciones.dtd");
                LeerFichero.grabarDatos(palabras, "palabras.dtd");
                System.exit(1);
                break;
            default:
                System.out.println("Opcion no valida");

        }
        menu();
    }


    public static void game(String palabra, long inicio) {
        Scanner sc = new Scanner(System.in);
        printMuneco();
        printPalabra(palabra);

        System.out.print("\nLetras usadas: ");
        for (String letra : letrasUsadas) {
            System.out.print(letra.toUpperCase() + " ");
        }

        System.out.print("\nIntroduce una letra: ");
        String letra = sc.next().toLowerCase();


        // añadir letra a la lista de usadas si no esta repetida
        if (!letrasUsadas.contains(letra)) {
            letrasUsadas.add(letra.toLowerCase());
        }

        if (palabra.contains(letra)) {
            aciertos++;
        } else {
            vidas--;
        }

        // acabar el juego al tener el mismo numero de aciertos que el tamaño de la palabra
        if (aciertos == palabra.length()) {
            System.out.println("\nGANASTE");
            guardarPuntuaciones(inicio);
            menu();
        }

        game(palabra, inicio);
    }

    public static void printMuneco() {
        switch (vidas) {
            case 0:
                System.out.println(Muneco.CERO_VIDA);
                System.out.println("PERDISTE");
                break;
            case 1:
                System.out.println(Muneco.UNA_VIDA);
                break;
            case 2:
                System.out.println(Muneco.DOS_VIDA);
                break;
            case 3:
                System.out.println(Muneco.TRES_VIDA);
                break;
            case 4:
                System.out.println(Muneco.CUATRO_VIDA);
                break;
            case 5:
                System.out.println(Muneco.CINCO_VIDA);
                break;
            case 6:
                System.out.println(Muneco.SEIS_VIDA);
                break;
            case 7:
                System.out.println(Muneco.SIETE_VIDA);
                break;
            case 8:
                System.out.println(Muneco.OCHO_VIDA);
                break;
            case 9:
                System.out.println(Muneco.NUEVE_VIDA);
                break;
            case 10:
                System.out.println(Muneco.DIEZ_VIDA);
                break;
        }
    }


    public static void guardarPuntuaciones(long inicio) {
        Scanner sc = new Scanner(System.in);
        long tiempo = System.currentTimeMillis() - inicio;

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        Jugador j1 = new Jugador(nombre, tiempo, LocalDate.now());
        jugadores.add(j1);
    }

    public static void anadirPalabras() {
        Scanner sc = new Scanner(System.in);
        String nuevaPalabra = sc.next();

        palabras.add(nuevaPalabra);
    }

    public static void printPuntuaciones() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
        System.out.println();
    }

    public static void printPalabra(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            String letra = Character.toString(palabra.charAt(i));

            if (letrasUsadas.contains(letra)) {
                System.out.print(letra.toUpperCase() + " ");
            } else {
                System.out.print("_ ");
            }

        }
    }
}


