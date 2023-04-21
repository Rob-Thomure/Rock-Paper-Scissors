public class User {
    private String name;
    private int rating;

    public User(String name) {
        this.name = name;
        this.rating = 0;
    }

    public User(String name, int rating) {
        this.name = name;
        this.rating = rating;
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
