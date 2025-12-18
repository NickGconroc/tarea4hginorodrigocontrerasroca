package programa;

import java.time.DayOfWeek;
import java.util.Arrays;

import modelo.CalificacionEjemplodeEnum;

public class MaindeCalificacionEjemplodeEnum {

    public static void main(String[] args) {
        CalificacionEjemplodeEnum c1 = CalificacionEjemplodeEnum.SOBRESALIENTE;
        System.out.println(c1.getNota());
        System.out.println("nombre del enum " + c1.name());
        System.out.println("Ordinal " + c1.ordinal());
        CalificacionEjemplodeEnum[] array = CalificacionEjemplodeEnum.values();
        System.out.println(Arrays.toString(array));
        System.out.println(DayOfWeek.MONDAY.ordinal());
    }
}