package modelo;

public class PersonaEnum {

    //---------------- ATRIBUTOS ----------------

    //nombre de la persona
    private String nombre;

    //edad de la persona
    private int edad;

    //---------------- CONSTRUCTORES ----------------

    //constructor por defecto
    //inicializa la persona con valores basicos
    public PersonaEnum(){
        this.nombre="Persona";
        this.edad=0;
    }

    //constructor parametrizado
    //permite crear una persona indicando nombre y edad
    public PersonaEnum(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    //---------------- METODOS DE INSTANCIA ----------------

    //devuelve una cadena con la informacion de la persona
    @Override
    public String toString(){
        return "PersonaEnum[nombre="+nombre+",edad="+edad+"]";
    }

    //---------------- ACCIONES SOBRE ANIMALESENUM ----------------

    //llamar a un AnimalEnum
    //la persona despierta al animal indicado
    //el estado del animal pasa a REPOSANDO
    public void llamar(AnimalEnum pet){
        pet.despertar();
    }

    //alimentar a un AnimalEnum
    //la persona da una cantidad de comida al animal
    //el peso del animal aumenta segun los gramos indicados
    //el estado del animal pasa a COMIENDO
    public void alimentar(AnimalEnum pet,double cantidadGramos){
        pet.comer(cantidadGramos);
    }

    //jugar con un AnimalEnum
    //la persona juega con el animal la cantidad de minutos indicada
    //si se supera el limite permitido (180 minutos)
    //se captura la excepcion y se juega el maximo permitido
    public void jugar(AnimalEnum pet,int cantidadMinutos){
        try{
            pet.jugar(cantidadMinutos);
        }catch(IllegalArgumentException iae){
            pet.jugar(180);
        }
    }
}
