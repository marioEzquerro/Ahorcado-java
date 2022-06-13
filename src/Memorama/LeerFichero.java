package Memorama;

import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;


public class LeerFichero {

    public static void leerDatos(ArrayList l, String nombre) {
        ArrayList aux = new ArrayList();

        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(nombre));
            aux = (ArrayList) leyendoFichero.readObject();
            leyendoFichero.close();

            for (int i = 0; i < aux.size(); i++) {
                l.add(aux.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void grabarDatos(ArrayList g, String nombre) {

        try {
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(nombre));
            escribiendoFichero.writeObject(g);
            escribiendoFichero.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

class Objeto implements Serializable {
    private String _dato;

    public Objeto(String dato) {
        this._dato = dato;
    }

    public String toString() {
        return this._dato;
    }
}


