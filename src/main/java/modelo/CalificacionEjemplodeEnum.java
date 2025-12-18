package modelo;

public enum CalificacionEjemplodeEnum {

    // Definición de los valores del enum
    INSUFICIENTE(3),
    SUFICIENTE(5),
    BIEN(6),
    NOTABLE_BAJO(7),
    NOTABLE_ALTO(8),
    SOBRESALIENTE(10);

    // Atributo asociado a cada valor del enum
    private final int nota;

    // Constructor del enum
    private CalificacionEjemplodeEnum(int nota) {
        this.nota = nota;
    }

    // Getter
    public int getNota() {
        return nota;
    }
}