import UI.Control;

public class Main {
    public static void main(String[] args) {
        Control control = new Control();
        try {
            control.menu();
        } catch (Exception e) {
            System.out.println("Hubo algun error ejecutando el sistema");
        }
    }
}