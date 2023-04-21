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
        while (!quit) {
            String humanHandSign = userInterface.getSignFromConsole();
            if (humanHandSign.equalsIgnoreCase("!exit")) {
                userInterface.printBye();
                quit = true;
            } else if (humanHandSign.equalsIgnoreCase("!rating")) {
                userInterface.printRating(user.getRating());
            } else {
                String computerHandSign = computerPlayer.chooseSign();
                GameResults gameResults = GameResults.getGameResults(HandSigns.valueOf(humanHandSign.toUpperCase())
                        , HandSigns.valueOf(computerHandSign.toUpperCase()));
                printResults(gameResults, computerHandSign);
                user.addRating(gameResults);
            }

        }
    }

}
