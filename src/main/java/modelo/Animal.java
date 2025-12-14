package modelo;

import java.time.LocalDate;

/*
 * La clase Animal será la representación abstracta de los objetos de tipo Animal
 * y pertenece a un paquete llamado modelo.
 */
public class Animal {

    /*
     * De los Animales queremos mantener la siguiente información.
     * Los atributos de esta clase estarán encapsulados.
     */

    /*
     * Fecha de nacimiento, un objeto de tipo LocalDate.
     * Ten en cuenta que la fecha de nacimiento del animal no puede ser anterior
     * al 01/01/2000 ni posterior al día actual del sistema.
     */
    private LocalDate fechaNacimiento;

    /*
     * Nombre
     */
    private String nombre;

    /*
     * Tipo, que puede ser: "gato", "perro", "lagarto", "cobaya", "periquito".
     * El tipo una vez establecido no se puede cambiar.
     */
    private String tipo;

    /*
     * Peso en gramos.
     * Solo se permiten pesos entre 10 gramos y 100.000 gramos
     */
    private double peso;

    /*
     * Estado, que podrá ser: "comiendo", "durmiendo", "reposando" o "jugando".
     */
    private String estado;

    /*
     * Métodos de la clase Animal:
     *
     * Constructor por defecto (sin parámetros),
     * que inicializa los atributos con valores fijos que tú quieras.
     */
    public Animal() {
        this.fechaNacimiento = LocalDate.of(2020, 1, 1);
        this.nombre = "Animal";
        this.tipo = "gato";
        this.peso = 1000;
        this.estado = "reposando";
    }

    /*
     * Constructor parametrizado, recibiendo un objeto LocalDate para indicar
     * la fecha de nacimiento, el nombre del animal, el tipo y el peso.
     * El estado al crear todos los animales será "reposo".
     * En caso de que algún parámetro no se ajuste a las restricciones,
     * se lanzará una excepción de tipo IllegalArgument,
     * indicando el mensaje apropiado.
     * En caso de que el peso sea negativo o mayor de 100000 gramos,
     * también se lanzará la excepción IllegalArgument,
     * con el mensaje correspondiente.
     */
    public Animal(LocalDate fechaNacimiento, String nombre, String tipo, double peso) {

        if (fechaNacimiento.isBefore(LocalDate.of(2000, 1, 1)) ||
            fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento fuera de rango");
        }

        if (peso < 10 || peso > 100000) {
            throw new IllegalArgumentException("Peso fuera de rango");
        }

        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.estado = "reposo";
    }

    /*
     * Constructor copia.
     */
    public Animal(Animal pet) {
        this.fechaNacimiento = pet.fechaNacimiento;
        this.nombre = pet.nombre;
        this.tipo = pet.tipo;
        this.peso = pet.peso;
        this.estado = pet.estado;
    }

    /*
     * Getters y setters para todos los atributos.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso < 10 || peso > 100000) {
            throw new IllegalArgumentException("Peso fuera de rango");
        }
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*
     * toString(), que devolverá una cadena con la información actualizada
     * de la mascota.
     */
    @Override
    public String toString() {
        return "Animal [fechaNacimiento=" + fechaNacimiento +
               ", nombre=" + nombre +
               ", tipo=" + tipo +
               ", peso=" + peso +
               ", estado=" + estado + "]";
    }

    /*
     * comer(double cantidadGramos).
     * Incrementará el peso del animal, aumentándolo según el parámetro indicado en cantidad.
     * Este método no devuelve nada.
     * Si el parámetro es negativo se considera como positivo.
     */
    public void comer(double cantidadGramos) {
        if (cantidadGramos < 0) {
            cantidadGramos = Math.abs(cantidadGramos);
        }
        peso += cantidadGramos;
        estado = "comiendo";
    }

    /*
     * dormir(), que pone a dormir al animal.
     */
    public void dormir() {
        estado = "durmiendo";
    }

    /*
     * despertar(), que despierta al bicho.
     */
    public void despertar() {
        estado = "reposando";
    }

    /*
     * descansar(), que pone al animal en reposo.
     */
    public void descansar() {
        estado = "reposando";
    }

    /*
     * jugar(int cantidadMinutos),
     * este método le indica a la mascota que está jugando
     * y recibe como parámetro la cantidad de minutos que estará el animal jugando.
     * Por cada 30 minutos completos de juego,
     * el peso del animal se verá reducido en un 20% del peso del animal.
     * Si la cantidad es menor de 30 minutos, se reducirá un 10%.
     * Si la cantidad de minutos es negativa se considera positiva.
     * Un animal no puede jugar más de 180 minutos,
     * por lo tanto si se supera esa cantidad se lanzará una excepción
     * de tipo IllegalArgument.
     */
    public void jugar(int cantidadMinutos) {

        if (cantidadMinutos < 0) {
            cantidadMinutos = Math.abs(cantidadMinutos);
        }

        if (cantidadMinutos > 180) {
            throw new IllegalArgumentException("No puede jugar más de 180 minutos");
        }

        estado = "jugando";

        if (cantidadMinutos < 30) {
            peso = peso * 0.9;
        } else {
            int bloques = cantidadMinutos / 30;
            for (int i = 0; i < bloques; i++) {
                peso = peso * 0.8;
            }
        }
    }

    /*
     * Animal clonar(Animal pet),
     * método de clase para clonar Animales (hacer una copia),
     * que recibe el objeto Animal que queremos clonar, llamado pet,
     * y devuelve el objeto con la copia de pet.
     * Ten en cuenta que este método crea un objeto nuevo.
     * Controla excepciones NullPointer en este método.
     */
    public static Animal clonar(Animal pet) {
        if (pet == null) {
            throw new NullPointerException("Animal nulo");
        }
        return new Animal(pet);
    }
}