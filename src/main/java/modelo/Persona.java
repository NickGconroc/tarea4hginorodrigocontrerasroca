package modelo;

public class Persona {

    //---------------- ATRIBUTOS ----------------

    //nombre de la persona
    private String nombre;

    //edad de la persona
    private int edad;

    //---------------- CONSTRUCTORES ----------------

    //constructor por defecto
    //inicializa la persona con valores basicos
    public Persona(){
        this.nombre="Persona";
        this.edad=0;
    }

    //constructor parametrizado
    //permite crear una persona indicando nombre y edad
    public Persona(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    //---------------- METODOS DE INSTANCIA ----------------

    //devuelve una cadena con la informacion de la persona
    @Override
    public String toString(){
        return "Persona[nombre="+nombre+",edad="+edad+"]";
    }

    //---------------- ACCIONES SOBRE ANIMALES ----------------

    //llamar a un animal
    //la persona despierta al animal indicado
    //el estado del animal pasa a reposando
    public void llamar(Animal pet){
        pet.despertar();
    }

    //alimentar a un animal
    //la persona da una cantidad de comida al animal
    //el peso del animal aumenta segun los gramos indicados
    public void alimentar(Animal pet,double cantidadGramos){
        pet.comer(cantidadGramos);
    }

    //jugar con un animal
    //la persona juega con el animal la cantidad de minutos indicada
    //si se supera el limite permitido (180 minutos)
    //se captura la excepcion y se juega el maximo permitido
    public void jugar(Animal pet,int cantidadMinutos){
        try{
            pet.jugar(cantidadMinutos);
        }catch(IllegalArgumentException iae){
            pet.jugar(180);
        }
    }
}
