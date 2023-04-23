import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public String getSignFromConsole(HandSigns handSigns) {
        Commands commands = new Commands();
        String input = "";
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        while (!isValidInput) {
            input = scanner.next().toLowerCase();
            if (commands.isValidCommand(input) || handSigns.isValidHandSign(input)) {
                isValidInput = true;
            } else {
                System.out.println("Invalid input");
            }
        }
        return input;
    }

    public List<String> getSignOptions() {
        Scanner scanner = new Scanner(System.in);
        return List.of(scanner.nextLine().split(","));
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

    public void printStart() {
        System.out.println("Okay, let's start");
    }


}
