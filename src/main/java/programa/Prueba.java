package programa;

import java.time.LocalDate;
import modelo.*;

/*
 * Incluye otro paquete llamado programa,
 * con una clase llamada Prueba que contenga el método main().
 */
public class Prueba {

    public static void main(String[] args) {

        /*
         * Dentro de este método:
         *
         * Crea dos objetos animal (a1 y a2) con los valores que tú quieras.
         */
        Animal a1 = new Animal(LocalDate.of(2021, 5, 10),
                "Luna", "perro", 8000);

        Animal a2 = new Animal(LocalDate.of(2020, 3, 15),
                "Milo", "gato", 5000);

        /*
         * Crea dos personas (p1 y p2) con los valores que tú quieras.
         */
        Persona p1 = new Persona("Ana", 25);
        Persona p2 = new Persona("Carlos", 30);

        /*
         * Imprime por consola los valores de a1 y a2 usando toString.
         */
        System.out.println(a1);
        System.out.println(a2);

        /*
         * Crea una copia del animal a2 en un nuevo animal a3.
         */
        Animal a3 = Animal.clonar(a2);

        /*
         * p1 debe despertar a todos los animales.
         */
        p1.llamar(a1);
        p1.llamar(a2);
        p1.llamar(a3);

        /*
         * p2 juega con a2 durante 120 minutos.
         */
        p2.jugar(a2, 120);

        /*
         * p1 alimenta a a1 1000 gramos.
         */
        p1.alimentar(a1, 1000);

        /*
         * Imprime el nuevo peso de a1.
         */
        System.out.println(a1.getPeso());

        /*
         * p1 debe jugar con a1 200 minutos.
         */
        p1.jugar(a1, 200);

        /*
         * Imprime el nuevo peso de a1.
         */
        System.out.println(a1.getPeso());

        /*
         * Crea un par de animales con fechas y pesos fuera de rango
         * para forzar las excepciones.
         */
        try {
            new Animal(LocalDate.of(1990, 1, 1),
                    "Error", "gato", 500);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        try {
            new Animal(LocalDate.of(2022, 1, 1),
                    "Error2", "perro", 200000);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}