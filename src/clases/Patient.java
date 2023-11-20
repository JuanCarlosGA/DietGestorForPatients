package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import Helpers.Utils;
import Helpers.Keyboard;

//Recomendacion de Cuesta: Hacer todo con array list, para que luego se facilite el envio de archivos a utils
public class Patient {

    private String patientId; //Random
    private String name;
    private int age;
    private double weight;
    private double heigth;
   
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeigth() {
        return heigth;
    }
    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

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
                        testWriteText();
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
        String opciones = String.format("\n%sMenú de opciones:%s\n", Utils.GREEN, Utils.RESET)
                + "  1 - testFileExists                          7 - testReadText\n"
                + "  2 - testPathExists                          8 - testWriteCVS\n"
                + "  3 - testCreateFolderIfNotExists             9 - cvsToJSON\n"
                + "  4 - testGetPath                             10 - cvsToJSON2\n"
                + "  5 - testInitPaht                            11 - cvsToJSONArray\n"
                + "  6 - testWriteText                           12 - cvsToJSONFile\n"

                + String.format("  %s0 - Salir%s\n", Utils.RED, Utils.RESET)
                + String.format(
                        "\nElija una opción (%s0 para salir%s) > ",
                        Utils.RED, Utils.RESET);

        int opcion = Keyboard.readInt(opciones);
        return opcion;
    }

     private static void testWriteText() throws Exception {

        ArrayList<String> patients = new ArrayList<>();

        patients.add("Diego Armando Maradona");
        patients.add("Lionel Messi");
        patients.add("Cristiano Ronaldo");
        patients.add("Johan Cruyff");
        patients.add("Franz Beckenbauer");

        Utils.writeText(patients, "CSVs/pacientes.csv");

       
   
    }
}
