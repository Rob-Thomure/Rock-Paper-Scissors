import java.util.Scanner;

public class UserInterface {

    public String getSignFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void printWin(String computerSign) {
        System.out.printf("Well done. The computer chose %s and failed", computerSign);
    }

    public void printDraw(String computerSign) {
        System.out.printf("There is a draw (%s)", computerSign);
    }

    public void printLoss(String computerSign) {
        System.out.printf("Sorry, but the computer chose %s", computerSign);
    }
}
