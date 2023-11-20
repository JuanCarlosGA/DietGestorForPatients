package Helpers;
import java.io.Console;
import java.util.Scanner;
public class Keyboard {
    public static boolean isNumeric(String str) {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }
    public static int readInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        int v = Integer.MIN_VALUE;

        do {
            String str = in.nextLine();
            if (str.matches("[+-]?\\d+")) {
                v = Integer.parseInt(str);
            } else {
                System.out.printf("Se esperaba un entero. %s", message);
            }
        } while (v == Integer.MIN_VALUE);

        return v;
    }
    public static long readLong(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        long v = Long.MIN_VALUE;

        do {
            String str = in.nextLine();
            if (str.matches("[+-]?\\d+")) {
                v = Long.parseLong(str);
            } else {
                System.out.printf("Se esperaba un entero. %s", message);
            }
        } while (v == Integer.MIN_VALUE);

        return v;
    }
    public static double readDouble(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        double v = Double.NaN; // Not-a-Number (NaN)

        do {
            String str = in.nextLine();
            if (str.equals("") || "+-".contains(str)) {
                System.out.printf("Se esperaba un número. %s", message);
                continue;
            }
            if (str.matches("[+-]?\\d+") || str.matches("[+-]?\\d*(\\.\\d+)?")) {
                v = Double.parseDouble(str);
            } else {
                System.out.printf("Se esperaba un número. %s", message);
            }
        } while (Double.isNaN(v));

        return v;
    }
    public static boolean readBoolean(String mensaje) {
        Scanner in = new Scanner(System.in);
        String str;
        boolean value = false;
        System.out.print(mensaje);

        do {
            str = in.nextLine().toLowerCase();
            if (!"true|false".contains(str) || str.equals("")) {
                System.out.printf("Se esperaba \"true\" o \"false\". %s", mensaje);
            } else {
                value = str.equals("true") ? true : false;
            }
        } while (!"true|false".contains(str) || str.equals(""));

        return value;
    }
    public static String readString(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    private static Console con = System.console();
    public static Scanner sc = new Scanner(con.reader())
            .useDelimiter("[\n]+|[\r\n]+");

}
