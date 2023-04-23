public class AppRunner {
    private final UserInterface userInterface;
    private final ComputerPlayer computerPlayer;

    public AppRunner() {
        this.userInterface = new UserInterface();
        this.computerPlayer = new ComputerPlayer();
    }



    private void printResults(GameResults gameResults, String computerHandSign) {
        switch (gameResults) {
            case WIN -> userInterface.printWin(computerHandSign);
            case LOSS -> userInterface.printLoss(computerHandSign);
            case DRAW -> userInterface.printDraw(computerHandSign);
        }
    }

    public void runApp() {
        boolean quit = false;
        User user = new User(userInterface.getNameFromConsole());
        userInterface.printGreeting(user.getName());
        user.addInitialRatingFromFile(new RatingsFileReader().getUserRatingFromFile(user.getName()));

        HandSigns handSigns = new HandSigns(userInterface.getSignOptions());
        userInterface.printStart();
        WinningHandSigns winningHandSigns = new WinningHandSigns(handSigns);

        while (!quit) {
            String humanHandSign = userInterface.getSignFromConsole(handSigns);
            if (humanHandSign.equalsIgnoreCase("!exit")) {
                userInterface.printBye();
                quit = true;
            } else if (humanHandSign.equalsIgnoreCase("!rating")) {
                userInterface.printRating(user.getRating());
            } else {
                String computerHandSign = computerPlayer.chooseSign(handSigns);
                GameResults gameResults = winningHandSigns.getGameResult(humanHandSign, computerHandSign);
                printResults(gameResults, computerHandSign);
                user.addRating(gameResults);
            }

        }
    }

}
