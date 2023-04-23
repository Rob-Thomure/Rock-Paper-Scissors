import java.util.List;

public class Commands {
    private final List<String> commandsList;

    public Commands() {
        this.commandsList = List.of("!rating", "!exit");
    }

    public boolean isValidCommand(String str) {
        if (null != str) {
            return this.commandsList.contains(str.toLowerCase());
        } else {
            return false;
        }
    }
}
