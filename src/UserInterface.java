import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {

    public String getSignFromConsole() {
        String validInput = "(!exit)|(rock)|(paper)|(scissors)";
        Pattern pattern = Pattern.compile(validInput, Pattern.CASE_INSENSITIVE);
        String input = "";
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        while (!isValidInput) {
            input = scanner.next();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                isValidInput = true;
            } else {
                System.out.println("Invalid input");
            }
        }
        return input;
    }

    public String getInputFromConsole() {
        return new Scanner(System.in).next();
    }

    public void printRating(int rating) {
        System.out.printf("Your rating: %d\n", rating);
    }

    public void printWin(String computerSign) {
        System.out.printf("Well done. The computer chose %s and failed\n", computerSign);
    }

    public void printDraw(String computerSign) {
        System.out.printf("There is a draw (%s)\n", computerSign);
    }

    public void printLoss(String computerSign) {
        System.out.printf("Sorry, but the computer chose %s\n", computerSign);
    }

    public void printBye() {
        System.out.println("Bye!");
    }

    public String getNameFromConsole() {
        System.out.print("Enter your name: ");
        return new Scanner(System.in).next();
    }

    public void printGreeting(String name) {
        System.out.printf("Hello, %s\n", name);
    }


}
