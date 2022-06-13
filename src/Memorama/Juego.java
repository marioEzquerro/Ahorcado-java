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
        // leer y almacenar la lista de palabras y las puntuaciones de jugadores
        LeerFichero.leerDatos(palabras, "palabras.dtd");
        LeerFichero.leerDatos(jugadores, "puntuaciones.dtd");
        menu();

    }

    // menu principal del juego
    public static void menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Jugar\n" +
                "2. Puntuaciones\n" +
                "3. Añadir más palabras\n" +
                "4. Salir");
        String opc = sc.next();

        switch (opc) {
            case "1":
                // escogemos una palabra al azar para jugar
                int rand = (int) (Math.random() * palabras.size());
                // obtenemos el tiempo en el que comienza el juego
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
                // guardar todo al salir
                LeerFichero.grabarDatos(jugadores, "puntuaciones.dtd");
                LeerFichero.grabarDatos(palabras, "palabras.dtd");
                System.exit(1);
                break;
            default:
                System.out.println("Opcion no valida");

        }
        menu();
    }

    // esta funcion imprime el muñeco, la palabra ocultando las letras "casa" -> "_ _ _ _" 
    // y las letras que ya has introducido en otros turnos
    public static void game(String palabra, long inicio) {
        Scanner sc = new Scanner(System.in);
        printMuneco();
        printPalabra(palabra);

        System.out.print("\nLetras usadas: ");
        for (String letra : letrasUsadas) {
            System.out.print(letra.toUpperCase() + " ");
        }

        System.out.print("\nIntroduce una letra: ");
        String letra = sc.next().toLowerCase(); // la paso a minusculas para que sean todas iguales introduzca "a" o "A"


        // añadir letra a la lista de usadas si no esta repetida
        if (!letrasUsadas.contains(letra)) {
            letrasUsadas.add(letra.toLowerCase());
        }

        // si la letra esta en la palabra
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

        // llamada recursiva para otra ronda
        game(palabra, inicio);
    }

    // mostrar muñeco segun las vidas que tengo
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
        // resto la hora de inicio a la actual para ver cuanto tiempo he tardado
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

    // compruebo que la palabra que trato de adivinar tiene alguna de las letras
    // que se añaden a "letrasUsadas" y imprimo "_" si no esta y la letra en el caso de estar
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


