import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningHandSigns {
    private final Map<String, List<String>> winningMap;

    public WinningHandSigns(HandSigns handSigns) {
        this.winningMap = new HashMap<>();
        if (handSigns.isDefaultHandSigns()) {
            winningMap.put("scissors", List.of("paper"));
            winningMap.put("rock", List.of("scissors"));
            winningMap.put("paper", List.of("rock"));
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
        List<String> userList = winningMap.get(user.toLowerCase());
        List<String> computerList = winningMap.get(computer.toLowerCase());
        if (userList.contains(computer.toLowerCase())) {
            return GameResults.WIN;
        } else if (computerList.contains(user.toLowerCase())) {
            return GameResults.LOSS;
        } else {
            return GameResults.DRAW;
        }
    }

}

