import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class RatingsFileReader {

    private String readRatingTxt() {
        String filename = "rating.txt";
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Integer> generateRatingsMap(String fileString) {
        Map<String, Integer> userRatings = new HashMap<>();
        String[] arr = fileString.split("\\s+");
        for (int i = 0; i < arr.length; i += 2) {
            userRatings.put(arr[i], Integer.parseInt(arr[i + 1]));
        }
        return userRatings;
    }


    public int getUserRatingFromFile(String user) {
        Map<String, Integer> userRatings = generateRatingsMap(readRatingTxt());
        if (null != userRatings.get(user)) {
            return userRatings.get(user);
        } else {
            return 0;
        }
    }

}
