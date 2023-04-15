import java.util.function.BiPredicate;

public enum GameResults {
    WIN,
    LOSS,
    DRAW;

    // scissors beats paper
    // rock beats scissors
    // paper beats rock

    private static final BiPredicate<HandSigns, HandSigns> scissorsBeatsPaper = (human, computer) ->
            human == HandSigns.SCISSORS && computer == HandSigns.PAPER;
    private static final BiPredicate<HandSigns, HandSigns> rockBeatsScissors = (human, computer) ->
            human == HandSigns.ROCK && computer == HandSigns.SCISSORS;
    private static final BiPredicate<HandSigns, HandSigns> paperBeatsRock = (human, computer) ->
            human == HandSigns.PAPER && computer == HandSigns.ROCK;

    private static final BiPredicate<HandSigns, HandSigns> scissorsDrawScissors = (human, computer) ->
            human == HandSigns.SCISSORS && computer == HandSigns.SCISSORS;
    private static final BiPredicate<HandSigns, HandSigns> rockDrawRock = (human, computer) ->
            human == HandSigns.ROCK && computer == HandSigns.ROCK;
    private static final BiPredicate<HandSigns, HandSigns> paperDrawPaper = (human, computer) ->
            human == HandSigns.PAPER && computer == HandSigns.PAPER;

    public static GameResults getGameResults(HandSigns human, HandSigns computer) {
        if (scissorsBeatsPaper.or(rockBeatsScissors).or(paperBeatsRock).test(human, computer)) {
            return WIN;
        } else if (scissorsDrawScissors.or(rockDrawRock).or(paperDrawPaper).test(human, computer)) {
            return DRAW;
        } else {
            return LOSS;
        }
    }


}
