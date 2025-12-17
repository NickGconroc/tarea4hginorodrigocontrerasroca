package programa;

import java.time.LocalDate;

import modelo.Animal;
import modelo.Persona;

public class Prueba {

    //---------------- METODO MAIN ----------------

    public static void main(String[] args) {

        //---------------- CREACION DE ANIMALES ----------------

        //se crean dos animales con valores validos
        //las fechas estan dentro del rango permitido
        //los tipos son correctos y los pesos estan entre 10 y 100000 gramos

        Animal a1=new Animal(
                LocalDate.of(2021,5,10),
                "Luna",
                "perro",
                8000
        );

        Animal a2=new Animal(
                LocalDate.of(2020,3,15),
                "Milo",
                "gato",
                5000
        );

        //---------------- CREACION DE PERSONAS ----------------

        //se crean dos personas con nombre y edad
        Persona p1=new Persona("Ana",25);
        Persona p2=new Persona("Carlos",30);

        //---------------- MOSTRAR INFORMACION INICIAL ----------------

        //se muestra por consola la informacion inicial de los animales
        //se usa el metodo toString de la clase Animal
        System.out.println(a1 + "  // a1 creado, estado inicial reposando, peso 8000");
        System.out.println(a2 + "  // a2 creado, estado inicial reposando, peso 5000");

        //---------------- COPIA DE ANIMAL ----------------

        //se crea una copia del animal a2
        //el nuevo animal a3 es un objeto distinto con los mismos datos
        Animal a3=Animal.clonar(a2);
        System.out.println(a3 + "  // a3 es copia de a2, estado inicial reposando");

        //---------------- DESPERTAR ANIMALES ----------------

        //la persona p1 despierta a todos los animales
        //el estado de los animales pasa a reposando
        p1.llamar(a1);
        System.out.println(a1 + "  // a1 tras despertar (estado reposando)");

        p1.llamar(a2);
        System.out.println(a2 + "  // a2 tras despertar (estado reposando)");

        p1.llamar(a3);
        System.out.println(a3 + "  // a3 tras despertar (estado reposando)");

        //---------------- JUGAR CON ANIMAL ----------------

        //la persona p2 juega con a2 durante 120 minutos
        //esta cantidad esta dentro del limite maximo permitido (180 minutos)
        p2.jugar(a2,120);
        System.out.println(a2.getPeso() + "  // peso de a2 tras jugar 120 min (reduccion segun reglas: 20% por cada 30 min)");

        //---------------- ALIMENTAR ANIMAL ----------------

        //la persona p1 alimenta a a1 con 1000 gramos de comida
        //el peso del animal aumenta en esa cantidad
        p1.alimentar(a1,1000);
        System.out.println(a1.getPeso() + "  // nuevo peso de a1 tras alimentarlo con 1000g");

        //---------------- JUGAR SUPERANDO EL LIMITE ----------------

        //p1 intenta jugar con a1 durante 200 minutos
        //como supera el limite, el metodo jugar de Persona
        //captura la excepcion y hace que el animal juegue 180 minutos
        p1.jugar(a1,200);
        System.out.println(a1.getPeso() + "  // nuevo peso de a1 tras jugar 200 min (max 180 min, reducido segun reglas)");

        //---------------- FORZAR EXCEPCIONES ----------------

        //se intenta crear un animal con fecha anterior al año 2000
        //esto provoca una IllegalArgumentException
        try{
            new Animal(
                    LocalDate.of(1990,1,1),
                    "Error",
                    "gato",
                    500
            );
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage() + "  // fecha anterior al 01/01/2000 provoca excepcion");
        }

        //se intenta crear un animal con un peso superior al maximo permitido
        //esto tambien provoca una IllegalArgumentException
        try{
            new Animal(
                    LocalDate.of(2022,1,1),
                    "Error2",
                    "perro",
                    200000
            );
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage() + "  // peso > 100000g provoca excepcion");
        }
    }
}
