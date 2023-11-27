package UI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Classes.Dietitian;
import Helpers.Keyboard;
import Helpers.Utils;
import Helpers.CSVCoder;

public class Control {

    private int dietitianIdCounter = 0;
    private int patientIdCounter = 0;

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
                int option = option();
                switch (option) {
                    case 1:
                        registerDietitian();
                        break;
                    case 2:
                        updateDietitian();
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

    static int option() {
        String opciones = String.format("\n%sMenú:%s\n", Utils.GREEN, Utils.RESET)
                + "  1 - Registrar Nutricionista                  7 - Crear Plan de Dieta\n"
                + "  2 - Actualizar Nutricionista                 8 - Actualizar Plan de Dieta\n"
                + "  3 - Registrar Paciente\n"
                + "  4 - Actualizar paciente\n"
                + "  5 - Borrar Paciente\n"
                + "  6 - Agregar Comida\n"

                + String.format("  %s0 - Exit%s\n", Utils.RED, Utils.RESET)
                + String.format(
                        "\nSeleccione una opción (%s0 for exit%s) > ",
                        Utils.RED, Utils.RESET);

        int opcion = Keyboard.readInt(opciones);
        return opcion;
    }

    public List<List<String>> readDietitian() throws Exception {
        CSVCoder reader = new CSVCoder();
        try {
            List<List<String>> data = reader.readCSV("src/CSVs/dietitians.csv");
            return data;
        } catch (IOException e) {
            return null;
        }
    }

    public void registerDietitian() throws Exception {
        try {
            ArrayList<String> dietitian = new ArrayList<>();

            List<List<String>> data = readDietitian();

            for (List<String> element : data) {
                dietitian.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2));
                dietitianIdCounter++;
            }

            String info = dietitianIdCounter + ";" + Keyboard.readString("Nombre: ");
            info += ";" + Keyboard.readString("Especialidad: ");

            dietitian.add(info);

            Utils.writeText(dietitian, "src/CSVs/dietitians.csv");
        } catch (Exception e) {
           System.out.println("Error al registrar nutricionista");
        }
    }

    public void updateDietitian() throws Exception {
        try {
            ArrayList<String> dietitian = new ArrayList<>();

            String id = Keyboard.readString("Ingrese el id del nutricionista a actualizar: ");
            List<List<String>> data = readDietitian();
            for (List<String> element : data) {
                if (id.equals(element.get(0))) {
                    String name = Keyboard.readString("Nombre: ");
                    String specialty = Keyboard.readString("Especialidad: ");
                    dietitian.add(id + ";" + name + ";" + specialty);
                } else {
                    dietitian.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2));
                }
            }

            Utils.writeText(dietitian, "src/CSVs/dietitians.csv");
        } catch (Exception e) {
            System.out.println("Error al actualizar nutricionista");
        }
    }

    public void registerPatient() throws Exception {
        try {
            ArrayList<String> patient = new ArrayList<>();

            CSVCoder reader = new CSVCoder();
            List<List<String>> data = reader.readCSV("src/CSVs/patients.csv");

            for (List element : data) {
                patient.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2) + ";" + element.get(3) + ";" + element.get(4));
                patientIdCounter++;
            }

            String info = patientIdCounter + ";" + Keyboard.readString("Nombre: ");
            info += ";" + Keyboard.readString("Edad: ");
            info += ";" + Keyboard.readString("Peso (kg): ");
            info += ";" + Keyboard.readString("Altura (cm): ");

            patient.add(info);

            Utils.writeText(patient, "src/CSVs/patients.csv");
        } catch (Exception e) {
            System.out.println("Error al registrar paciente");
        }
    }
    
}