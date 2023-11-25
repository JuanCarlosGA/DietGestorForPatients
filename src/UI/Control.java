package UI;
import Helpers.Keyboard;
import Helpers.Utils;

public class Control {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {

        try {
            inicializar();
        } catch (Exception e) {
            e.printStackTrace();
        }

        do {
            try {
                int opcion = leerOpcion();
                switch (opcion) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                                            break;

                    case 5:

                        break;
                        case 6:

                        break;
                    case 0:
                        salir();
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    private static void inicializar() {
        System.out.print("\033[H\033[2J"); // limpiar la consola
    }

    private static void salir() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.exit(0);
    }

    static int leerOpcion() {
        String opciones = String.format("\n%sOption menu:%s\n", Utils.GREEN, Utils.RESET)
                + "  1 - registerDietitian                        7 - createDietPlan\n"
                + "  2 - updateDietitian                          8 - updateDietPlan\n"
                + "  3 - resgisterPatient\n"
                + "  4 - updatePatiet\n"
                + "  5 - deletePatient\n"
                + "  6 - registerMeal\n"

                + String.format("  %s0 - Exit%s\n", Utils.RED, Utils.RESET)
                + String.format(
                        "\nChoose one option (%s0 for exit%s) > ",
                        Utils.RED, Utils.RESET);

        int opcion = Keyboard.readInt(opciones);
        return opcion;
    }
}