package Classes;

public class Dietitian {
    private int dietitianId;
    private String name;
    private String speciality;

    Dietitian(int dietitianId, String name, String speciality) {
        this.dietitianId = dietitianId;
        this.name = name;
        this.speciality = speciality;
    }

    public int getDietitianId() {
        return dietitianId;
    }
    public void setDietitianId(int dietitianId) {
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
