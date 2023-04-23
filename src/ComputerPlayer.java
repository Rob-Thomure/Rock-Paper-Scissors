import java.util.Random;

public class ComputerPlayer {

    public String chooseSign(HandSigns handSigns) {
        int listSize = handSigns.getHandSignsListSize();
        int randomNum = new Random().nextInt(listSize);
        return handSigns.getHandSignsList().get(randomNum);
    }


}
