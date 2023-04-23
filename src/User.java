public class User {
    private final String name;
    private int rating;

    public User(String name) {
        this.name = name;
        this.rating = 0;
    }

    public void addInitialRatingFromFile(int rating) {
            this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void addRating(GameResults gameResults) {
        if (gameResults == GameResults.WIN) {
            this.rating += 100;
        } else if (gameResults == GameResults.DRAW) {
            this.rating += 50;
        }
    }

}
