import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    private static OS os;

    // Determines OS System
    private static void getOs() {
        String OSName = System.getProperty("os.name").toLowerCase();
        if (OSName.contains("windows"))
            os = OS.WINDOWS;
        if (OSName.contains("mac"))
            os = OS.MAC;
    }

    // Executes commands specific to the OS System
    public static void clearScreen() {
        getOs();
        switch (os) {
            case WINDOWS:
                execute("cls");
                break;
            case MAC:
                execute("clear");
                break;
        }
    }

    // Main command executor
    public static void execute(String command) {
        try {

            System.out.println(command);

            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Compares the output of a command to an expected output
    public static boolean compareStrings(String command, String expectation) {
        try {

            System.out.println("compare strings: " + command + " " + expectation);

            System.out.println(command);

            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);

                if (line.contains(expectation)) {
                    reader.close();
                    return true;
                }
            }

            reader.close();
            return false;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

}
