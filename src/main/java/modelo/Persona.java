package modelo;

// Dentro del paquete modelo incluye la clase Persona.
// Los atributos de las personas son: Nombre y Edad,
// teniendo en cuenta que deben estar encapsulados.

public class Persona {

    private String nombre;
    private int edad;

    // Esta clase tendrá un constructor por defecto,
    // otro parametrizado y
    // toString.

    public Persona() {
        this.nombre = "Persona";
        this.edad = 0;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // toString.

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }

    // La clase persona tiene las siguientes responsabilidades es decir

    // Metodos =

    // llamar (Animal pet).
    // Este método hace que la persona en cuestión despierte al animal pet.

    public void llamar(Animal pet) {
        pet.despertar();
    }

    // alimentar (Animal pet, double cantidadGramos).
    // En este caso la persona alimenta a pet con una cantidad de comida.

    public void alimentar(Animal pet, double cantidadGramos) {
        pet.comer(cantidadGramos);
    }

    // jugar(Animal pet, int cantidadMinutos).
    // La persona juega con pet la cantidad de minutos indicada en el parámetro.
    // Este método debe controlar la excepción IllegalArgument,
    // de forma que si la excepción se presenta
    // entonces debe jugar con el animal la cantidad máxima de minutos permitida.

    public void jugar(Animal pet, int cantidadMinutos) {
        try {
            pet.jugar(cantidadMinutos);
        } catch (IllegalArgumentException iae) {
            pet.jugar(180);
        }
    }
}