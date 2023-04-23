import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningHandSigns {
    private final Map<String, List<String>> winningMap;

    public WinningHandSigns(HandSigns handSigns) {
        this.winningMap = new HashMap<>();
        if (handSigns.isDefaultHandSigns()) {
            winningMap.put("paper", List.of("scissors"));
            winningMap.put("scissors", List.of("rock"));
            winningMap.put("rock", List.of("paper"));
        } else {
            List<String> handSignsList = handSigns.getHandSignsList();
            for (int i = 0; i < handSignsList.size(); i++) {
                String key = handSignsList.get(i);
                List<String> values = new ArrayList<>();

                for (int j = 0; j < handSignsList.size() / 2; j++) {
                    values.add(handSignsList.get((i + j + 1) % handSignsList.size()));
                }
                winningMap.put(key, values);
            }
        }

    }

    public GameResults getGameResult(String user, String computer) {
        List<String> userLosingList = winningMap.get(user.toLowerCase());
        List<String> computerLosingList = winningMap.get(computer.toLowerCase());
        if (userLosingList.contains(computer.toLowerCase())) {
            return GameResults.LOSS;
        } else if (computerLosingList.contains(user.toLowerCase())) {
            return GameResults.WIN;
        } else {
            return GameResults.DRAW;
        }
    }

}

