package presentation;

import com.julianhecker.business.Shift;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Main class, runs presentation code for the business package
 * @author Julian Hecker
 */
public class Main {
    // Private Methods, used by main()
    /**
     * readShift: Calls shift's readJson method, to read data from JSON file.
     * @param shift
     */
    private static void readShift(Shift shift) {
        Scanner in = new Scanner(System.in);
        System.out.println("What filename to read from?");
        String filename = in.nextLine();
        FileReader fr = null;
        try {
            fr = new FileReader(filename);
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }
        shift.readJson(fr);
        System.out.println("JSON File Read!");
    }
    /**
     * writeShift: Call's Shift's writeJson method, to write data to JSON file.
     * @param shift
     */
    private static void writeShift(Shift shift) {
        Scanner in = new Scanner(System.in);
        System.out.println("What filename to write to?");
        String filename = in.nextLine();
        PrintStream ps = null;
        try {
            ps = new PrintStream(filename);
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }
        shift.writeJson(ps);
        System.out.println("JSON File Written!");
    }
    /**
     * displayShift: Shows the shift's information as text.
     * @param shift
     */
    private static void displayShift(Shift shift) {
        System.out.println(shift.toString());
    }
    
    /**
     * displayUI: Display program options via command line
     */
    private static void displayUI() {
        System.out.print(
            "Shift UI\n" +
            "========\n" +
            "1 - Read shift from file as JSON\n" +
            "2 - Write shift to file as JSON\n" +
            "3 - Show shift info on screen\n" +
            "4 - Exit\n" +
            "Enter your choice: \n"
        );
    }
    
    /**
     * programLoop: Runs the main program loop
     * @param shift 
     */
    private static void programLoop(Shift shift) {
        Scanner in = new Scanner(System.in);
        char c;
        OUTER:
        while (true) {
            displayUI();
            c = in.next().charAt(0);
            switch (c) {
                case '1':
                    readShift(shift);
                    break;
                case '2':
                    writeShift(shift);
                    break;
                case '3':
                    displayShift(shift);
                    break;
                case '4':
                    System.out.println("Bye-bye!");
                    break OUTER;
                default:
                    System.out.println("Has to be 1, 2, 3, or 4. Try again.");
                    break;
            }
        }
    }
    
    /**
     * Main Method, executes presentation code
     * @author Julian Hecker
     * @param args[]
     */
    public static void main(String[] args) {
        Shift s = new Shift();
        programLoop(s);
    }
}
