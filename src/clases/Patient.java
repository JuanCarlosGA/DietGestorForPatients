package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import Helpers.Utils;
import Helpers.Keyboard;

//Recomendacion de Cuesta: Hacer todo con array list, para que luego se facilite el envio de archivos a utils
public class Patient {

    private String patientId; // Random
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


}
