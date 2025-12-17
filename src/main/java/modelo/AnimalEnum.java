package modelo;

import java.time.LocalDate;

// Clase Animal usando enums para tipo y estado
public class AnimalEnum {

    //---------------- ATRIBUTOS ----------------

    //fecha de nacimiento del animal
    //restriccion: no puede ser anterior al 01/01/2000 ni posterior a la fecha actual
    private LocalDate fechaNacimiento;

    //nombre del animal
    private String nombre;

    //tipo de animal usando enum
    //solo puede ser uno de los definidos en TipoAnimal
    private TipoAnimal tipo;

    //peso del animal en gramos
    //restriccion: minimo 10g y maximo 100000g
    private double peso;

    //estado del animal usando enum
    //solo puede estar: COMIENDO, DURMIENDO, REPOSANDO o JUGANDO
    private EstadoAnimal estado;

    //---------------- CONSTRUCTORES ----------------

    //constructor por defecto
    //inicializa el animal con valores fijos
    public AnimalEnum(){
        this.fechaNacimiento=LocalDate.of(2020,1,1);
        this.nombre="Animal";
        this.tipo=TipoAnimal.GATO;          //valor por defecto del enum
        this.peso=1000;
        this.estado=EstadoAnimal.REPOSANDO; //estado inicial
    }

    //constructor parametrizado
    //al crear el animal se validan todas las restricciones del enunciado
    public AnimalEnum(LocalDate fechaNacimiento, String nombre, TipoAnimal tipo, double peso){

        //restriccion de fecha de nacimiento
        //no puede ser anterior al 01/01/2000 ni posterior a hoy
        if(fechaNacimiento.isBefore(LocalDate.of(2000,1,1))||
           fechaNacimiento.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Fecha de nacimiento fuera de rango");
        }

        //restriccion del peso
        //el peso debe estar entre 10g y 100000g
        if(peso<10||peso>100000){
            throw new IllegalArgumentException("Peso fuera de rango");
        }

        this.fechaNacimiento=fechaNacimiento;
        this.nombre=nombre;
        this.tipo=tipo;           //ya controlado por enum, no se necesita validar
        this.peso=peso;
        this.estado=EstadoAnimal.REPOSANDO; //estado inicial
    }

    //constructor copia
    //crea un nuevo animal copiando los datos de otro
    public AnimalEnum(AnimalEnum copia){
        if(copia==null){
            throw new NullPointerException("Animal nulo");
        }
        this.fechaNacimiento=copia.fechaNacimiento;
        this.nombre=copia.nombre;
        this.tipo=copia.tipo;
        this.peso=copia.peso;
        this.estado=copia.estado;
    }

    //---------------- GETTERS Y SETTERS ----------------

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento){
        if(fechaNacimiento.isBefore(LocalDate.of(2000,1,1))||
           fechaNacimiento.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Fecha de nacimiento fuera de rango");
        }
        this.fechaNacimiento=fechaNacimiento;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    //no hay setter de tipo porque el enunciado indica que no se puede cambiar
    public TipoAnimal getTipo(){
        return tipo;
    }

    public double getPeso(){
        return peso;
    }

    public void setPeso(double peso){
        if(peso<10||peso>100000){
            throw new IllegalArgumentException("Peso fuera de rango");
        }
        this.peso=peso;
    }

    public EstadoAnimal getEstado(){
        return estado;
    }

    public void setEstado(EstadoAnimal estado){
        this.estado=estado;
    }

    //---------------- METODOS DE INSTANCIA ----------------

    @Override
    public String toString(){
        return "AnimalEnum[fechaNacimiento="+fechaNacimiento+
               ",nombre="+nombre+
               ",tipo="+tipo+
               ",peso="+peso+
               ",estado="+estado+"]";
    }

    public void comer(double cantidadGramos){
        if(cantidadGramos<0){
            cantidadGramos=Math.abs(cantidadGramos);
        }
        peso+=cantidadGramos;
        estado=EstadoAnimal.COMIENDO;
    }

    public void dormir(){
        estado=EstadoAnimal.DURMIENDO;
    }

    public void despertar(){
        estado=EstadoAnimal.REPOSANDO;
    }

    public void descansar(){
        estado=EstadoAnimal.REPOSANDO;
    }

    public void jugar(int cantidadMinutos){
        if(cantidadMinutos<0){
            cantidadMinutos=Math.abs(cantidadMinutos);
        }

        if(cantidadMinutos>180){
            throw new IllegalArgumentException("No puede jugar más de 180 minutos");
        }

        estado=EstadoAnimal.JUGANDO;

        if(cantidadMinutos<30){
            peso*=0.9;
        }else{
            int bloques=cantidadMinutos/30;
            for(int i=0;i<bloques;i++){
                peso*=0.8;
            }
        }
    }

    //---------------- METODOS ESTATICOS ----------------

    public static AnimalEnum clonar(AnimalEnum copia){
        if(copia==null){
            throw new NullPointerException("Animal nulo");
        }
        return new AnimalEnum(copia);
    }
}
