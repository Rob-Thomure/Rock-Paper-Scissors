import java.util.Random;
import java.util.function.Supplier;

public class ComputerPlayer {
    private final Supplier<Integer> randomNum = () -> new Random().nextInt(3);

    public String chooseSign() {
        return HandSigns.getHandSign(randomNum.get());
    }


}
