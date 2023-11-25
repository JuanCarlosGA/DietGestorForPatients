package UI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Dietitian;
import Helpers.Keyboard;
import Helpers.Utils;
import Helpers.CSVCoder;

public class Control {

    private int dietitianIdCounter = 1;
    private int patientIdCounter = 1;

    public void showArray(ArrayList<Dietitian> array) {
        for (Dietitian element : array) {
            System.out.println(element.getName());
        }
    }

    public void menu() {

        try {
            clean();
        } catch (Exception e) {
            e.printStackTrace();
        }

        do {
            try {
                int opcion = leerOpcion();
                switch (opcion) {
                    case 1:
                        registerDietitian();
                        break;
                    case 2:

                        break;
                    case 3:
                        registerPatient();
                        break;
                    case 4:
                        break;

                    case 5:

                        break;
                    case 6:

                        break;
                    case 0:
                        exit();
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    private static void clean() {
        System.out.print("\033[H\033[2J"); // limpiar la consola
    }

    private static void exit() {
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

    public void registerDietitian() throws Exception {
        ArrayList<String> dietitian = new ArrayList<>();
        String info = Keyboard.readString("Enter the name of the dietitian: ");

        dietitian.add("Diego Armando Maradona");

        Utils.writeText(dietitian, "src/CSVs/dietitians.csv");

    }

    public void readDietitians() throws Exception {
        ArrayList<String> dietitians = new ArrayList<>();

        CSVCoder<Dietitian> coder = new CSVCoder<Dietitian>(';') {
            @Override
            public String[] encode(Dietitian dietitian) {
                String[] data = new String[3];
                data[0] = String.valueOf(dietitian.getDietitianId());
                data[1] = dietitian.getName();
                data[2] = dietitian.getSpeciality();
                return data;
            }

            @Override
            public Dietitian decode(String[] data) {
                Dietitian dietitian = new Dietitian();
                dietitian.setDietitianId(Integer.parseInt(data[0]));
                dietitian.setName(data[1]);
                dietitian.setSpeciality(data[2]);
                return dietitian;
            }
        };
        try {
            coder.readFromFile("src/CSVs/dietitians.csv", null);

            System.out.println("Dietitians:");
            for (String element : dietitians) {
                System.out.println(element);
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado en Control.java");
        }
    }

     public void registerPatient() throws Exception {

        ArrayList<String> jugadores = new ArrayList<>();

        jugadores.add("Diego Armando Maradona");

        Utils.writeText(jugadores, "src/CSVs/patients.csv");

    }
    
}