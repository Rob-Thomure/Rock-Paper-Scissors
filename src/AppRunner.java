public class AppRunner {
    private final UserInterface userInterface;
    private final ComputerPlayer computerPlayer;

    public AppRunner() {
        this.userInterface = new UserInterface();
        this.computerPlayer = new ComputerPlayer();
    }

    public void runApp() {
        boolean quit = false;
        while (!quit) {
            String humanHandSign = userInterface.getSignFromConsole();
            if (!humanHandSign.equalsIgnoreCase("!exit")) {
                String computerHandSign = computerPlayer.chooseSign();
                GameResults gameResults = GameResults.getGameResults(HandSigns.valueOf(humanHandSign.toUpperCase())
                        , HandSigns.valueOf(computerHandSign.toUpperCase()));
                printResults(gameResults, computerHandSign);
            } else {
                quit = true;
            }
        }
        userInterface.printBye();
    }

    private void printResults(GameResults gameResults, String computerHandSign) {
        switch (gameResults) {
            case WIN -> userInterface.printWin(computerHandSign);
            case LOSS -> userInterface.printLoss(computerHandSign);
            case DRAW -> userInterface.printDraw(computerHandSign);
        }
    }
}
