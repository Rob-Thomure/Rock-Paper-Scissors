public enum HandSigns {
    ROCK,
    PAPER,
    SCISSORS;

    public static String getHandSign(int ordinal) {
        HandSigns[] handSigns = HandSigns.values();
        return handSigns[ordinal].name().toLowerCase();
    }

}
