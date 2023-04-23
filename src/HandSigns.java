import java.util.List;

public class HandSigns {
    private final boolean isDefaultHandSigns;
    private final List<String> handSignsList;


    public HandSigns(List<String> handSignsList) {
        if (handSignsList.isEmpty() || handSignsList.get(0).isEmpty()) {
            this.isDefaultHandSigns = true;
            this.handSignsList = List.of("rock", "paper", "scissors");
        } else {
            this.isDefaultHandSigns = false;
            this.handSignsList = handSignsList.stream().
                    map(String::toLowerCase)
                    .toList();
        }
    }

    public boolean isDefaultHandSigns() {
        return isDefaultHandSigns;
    }

    public List<String> getHandSignsList() {
        return handSignsList;
    }

    public int getHandSignsListSize() {
        return handSignsList.size();
    }

    public boolean isValidHandSign(String str) {
        return handSignsList.contains(str.toLowerCase());
    }
}
