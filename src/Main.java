import java.util.ArrayList;

import UI.Control;
import Classes.*;

public class Main {
    public static void main(String[] args) {
        Control control = new Control();
        try {
            control.readDietitians();
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }
    }
}