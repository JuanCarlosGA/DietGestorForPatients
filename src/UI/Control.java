package UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Helpers.Keyboard;
import Helpers.Utils;

public class Control {

    private int dietitianIdCounter = 0;
    private int patientIdCounter = 0;
    private int mealIdCounter = 0;
    private int dietPlanIdCounter = 0;

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
                        updatePatient();
                        break;
                    case 5:
                        deletePatient();
                        break;
                    case 6:
                        addMeal();
                        break;
                    case 7:
                        deleteMeal();
                        break;
                    case 8:
                        createDietPlan();
                        break;
                    case 9:
                        updateDietPlan();
                        break;
                    case 10:
                        deleteDietPlan();
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

    private void clean() {
        System.out.print("\033[H\033[2J"); // Clean the console
    }

    private void exit() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.exit(0);
    }

    static int option() {
        String opciones = String.format("\n%sMenú:%s\n", Utils.GREEN, Utils.RESET)
                + "  1 - Registrar Nutricionista                  7 - Eliminar Comida\n"
                + "  2 - Actualizar Nutricionista                 8 - Crear Plan de Dieta\n"
                + "  3 - Registrar Paciente                       9 - Actualizar Plan de Dieta\n"
                + "  4 - Actualizar paciente                      10 - Borrar Plan de Dieta\n"
                + "  5 - Borrar Paciente\n"
                + "  6 - Agregar Comida\n"

                + String.format("  %s0 - Exit%s\n", Utils.RED, Utils.RESET)
                + String.format(
                        "\nSeleccione una opción (%s0 for exit%s) > ",
                        Utils.RED, Utils.RESET);

        int opcion = Keyboard.readInt(opciones);
        return opcion;
    }

    public String entityOption(String info) {
        return Keyboard.readString(info);
    }

    public List<List<String>> readDietitian() throws Exception {
        try {
            List<List<String>> data = Utils.readCSV("src/CSVs/dietitians.csv");
            return data;
        } catch (IOException e) {
            return null;
        }
    }

    public List<List<String>> readPatient() throws Exception {
        try {
            List<List<String>> data = Utils.readCSV("src/CSVs/patients.csv");
            return data;
        } catch (IOException e) {
            return null;
        }
    }

    public List<List<String>> readMeal() throws Exception {
        try {
            List<List<String>> data = Utils.readCSV("src/CSVs/meals.csv");
            return data;
        } catch (IOException e) {
            return null;
        }
    }

    public List<List<String>> readDietPlan() throws Exception {
        try {
            List<List<String>> data = Utils.readCSV("src/CSVs/dietPlans.csv");
            return data;
        } catch (IOException e) {
            return null;
        }
    }

    public void registerDietitian() throws Exception {
        try {
            this.dietitianIdCounter = 0;
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
            this.patientIdCounter = 0;
            ArrayList<String> patient = new ArrayList<>();

            List<List<String>> data = readPatient();

            for (List<String> element : data) {
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

    public void updatePatient() throws Exception {
        try {
            ArrayList<String> patient = new ArrayList<>();

            String id = Keyboard.readString("Ingrese el id del paciente a actualizar: ");
            List<List<String>> data = readPatient();
            for (List<String> element : data) {
                if (id.equals(element.get(0))) {
                    String info = patientIdCounter + ";" + Keyboard.readString("Nombre: ");
                    info += ";" + Keyboard.readString("Edad: ");
                    info += ";" + Keyboard.readString("Peso (kg): ");
                    info += ";" + Keyboard.readString("Altura (cm): ");
                    patient.add(info);
                } else {
                    patient.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2) + ";" + element.get(3) + ";" + element.get(4));
                }
            }

            Utils.writeText(patient, "src/CSVs/patients.csv");
        } catch (Exception e) {
            System.out.println("Error al actualizar paciente");
        }
    }

    public void deletePatient() throws Exception {
        try {
            ArrayList<String> patient = new ArrayList<>();

            String id = Keyboard.readString("Ingrese el id del paciente a eliminar: ");
            List<List<String>> data = readPatient();
            for (List<String> element : data) {
                if (!id.equals(element.get(0))) {
                    patient.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2) + ";" + element.get(3) + ";" + element.get(4));
                }
            }

            Utils.writeText(patient, "src/CSVs/patients.csv");
        } catch (Exception e) {
            System.out.println("Error al eliminar paciente");
        }
    }

    public void addMeal() throws Exception {
        try {
            this.mealIdCounter = 0;
            ArrayList<String> meal = new ArrayList<>();

            List<List<String>> data = readMeal();

            for (List<String> element : data) {
                meal.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2) + ";" + element.get(3) + ";" + element.get(4));
                mealIdCounter++;
            }

            String info = mealIdCounter + ";" + Keyboard.readString("Nombre: ");
            info += ";" + Keyboard.readString("Macronutrientes: ");
            info += ";" + Keyboard.readString("Calorias: ");
            info += ";" + Keyboard.readString("Hora del dia (0000 - 2400): ");

            meal.add(info);

            Utils.writeText(meal, "src/CSVs/meals.csv");
        } catch (Exception e) {
            System.out.println("Error al registrar alimento");
        }
    }

    public void deleteMeal() throws Exception {
        try {
            ArrayList<String> meal = new ArrayList<>();

            String id = Keyboard.readString("Ingrese el id del alimento a eliminar: ");
            List<List<String>> data = readMeal();
            for (List<String> element : data) {
                if (!id.equals(element.get(0))) {
                    meal.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2) + ";" + element.get(3) + ";" + element.get(4));
                }
            }

            Utils.writeText(meal, "src/CSVs/meals.csv");
        } catch (Exception e) {
            System.out.println("Error al eliminar alimento");
        }
    }

    public void createDietPlan() throws Exception {
        try {
            this.dietPlanIdCounter = 0;
            ArrayList<String> dietPlan = new ArrayList<>();
            String entityOptions = "";

            List<List<String>> data = readDietPlan();

            for (List<String> element : data) {
                dietPlan.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2) + ";" + element.get(3) + ";" 
                + element.get(4) + ";" + element.get(5) + ";" + element.get(6));
                dietPlanIdCounter++;
            }

            data = readPatient();

            for (List<String> element : data) {
                entityOptions += element.get(0) + ". " + element.get(1) + "\n";
            }
            entityOptions += "Elije un paciente para afiliar al plan (id): ";
            String info = dietPlanIdCounter + ";" + entityOption(entityOptions);

            data = readDietitian();
            entityOptions = "";

            for (List<String> element : data) {
                entityOptions += element.get(0) + ". " + element.get(1) + "\n";
            }
            entityOptions += "Elije un nutricionista para afiliar al plan (id): ";
            info += ";" + entityOption(entityOptions);

            data = readMeal();
            entityOptions = "";

            for (List<String> element : data) {
                entityOptions += element.get(0) + ". " + element.get(1) + "\n";
            }
            entityOptions += "Elije una comida para afiliar al plan (id): ";
            info += ";" + entityOption(entityOptions);

            info += ";" + Keyboard.readString("Calorias diarias: ");
            info += ";" + Keyboard.readString("Distribución de macronutrientes: ");
            info += ";" + Keyboard.readString("Recomendaciones específicas: ");

            dietPlan.add(info);

            Utils.writeText(dietPlan, "src/CSVs/dietPlans.csv");
        } catch (Exception e) {
            System.out.println("Error al registrar plan de dieta");
        }
    }

    public void updateDietPlan() throws Exception {
        try {
            ArrayList<String> dietPlan = new ArrayList<>();
            String entityOptions = "";

            String id = Keyboard.readString("Ingrese el id del plan de dieta a actualizar: ");
            List<List<String>> data = readDietPlan();
            for (List<String> element : data) {
                if (id.equals(element.get(0))) {
                    data = readPatient();
                    for (List<String> patient : data) {
                        entityOptions += patient.get(0) + ". " + patient.get(1) + "\n";
                    }
                    entityOptions += "Elije un paciente para afiliar al plan (id): ";
                    String info = element.get(0) + ";" + entityOption(entityOptions);

                    data = readDietitian();
                    entityOptions = "";

                    for (List<String> dietitian : data) {
                        entityOptions += dietitian.get(0) + ". " + dietitian.get(1) + "\n";
                    }
                    entityOptions += "Elije un nutricionista para afiliar al plan (id): ";
                    info += ";" + entityOption(entityOptions);

                    data = readMeal();
                    entityOptions = "";

                    for (List<String> meal : data) {
                        entityOptions += meal.get(0) + ". " + meal.get(1) + "\n";
                    }
                    entityOptions += "Elije una comida para afiliar al plan (id): ";
                    info += ";" + entityOption(entityOptions);

                    info += ";" + Keyboard.readString("Calorias diarias: ");
                    info += ";" + Keyboard.readString("Distribución de macronutrientes: ");
                    info += ";" + Keyboard.readString("Recomendaciones específicas: ");

                    dietPlan.add(info);
                } else {
                    dietPlan.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2) + ";" + element.get(3) + ";" 
                    + element.get(4) + ";" + element.get(5) + ";" + element.get(6));
                }
            }

            Utils.writeText(dietPlan, "src/CSVs/dietPlans.csv");
        } catch (Exception e) {
            System.out.println("Error al actualizar plan de dieta");
        }
    }

    public void deleteDietPlan() throws Exception {
        try {
            ArrayList<String> dietPlan = new ArrayList<>();

            String id = Keyboard.readString("Ingrese el id del plan de dieta a eliminar: ");
            List<List<String>> data = readDietPlan();
            for (List<String> element : data) {
                if (!id.equals(element.get(0))) {
                    dietPlan.add(element.get(0) + ";" + element.get(1) + ";" + element.get(2) + ";" + element.get(3) + ";" 
                    + element.get(4) + ";" + element.get(5) + ";" + element.get(6));
                }
            }

            Utils.writeText(dietPlan, "src/CSVs/dietPlans.csv");
        } catch (Exception e) {
            System.out.println("Error al eliminar plan de dieta");
        }
    }
}