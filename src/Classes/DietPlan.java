package Classes;
import java.util.ArrayList;

public class DietPlan {
    private Patient patient;
    private Dietitian dietitian;
    private ArrayList<Meal> meals;
    private String dietitianId;
    private String name;
    private String speciality;

    DietPlan(Patient patient, Dietitian dietitian, String dietitianId, String name, String speciality) {
        this.patient = patient;
        this.dietitian = dietitian;
        this.meals = new ArrayList<Meal>();
        this.dietitianId = dietitianId;
        this.name = name;
        this.speciality = speciality;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Dietitian getDietitian() {
        return dietitian;
    }
    public void setDietitian(Dietitian dietitian) {
        this.dietitian = dietitian;
    }
    public String getDietitianId() {
        return dietitianId;
    }
    public void setDietitianId(String dietitianId) {
        this.dietitianId = dietitianId;
    }
    public String getName() {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality (String speciality) {
        this.speciality = speciality;
    }
}
