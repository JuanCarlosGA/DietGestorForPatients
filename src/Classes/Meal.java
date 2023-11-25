package Classes;

public class Meal {
    private String mealName;
    private String macronutrients;
    private double calories;
    private int timeOfDay;

    Meal(String mealName, String macronutrients, double calories, int timeOfDay) {
        this.mealName = mealName;
        this.macronutrients = macronutrients;
        this.calories = calories;
        this.timeOfDay = timeOfDay;
    }
}
