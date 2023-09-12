import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Util {
    public static List<Question> readQuestionsFromFile(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> list = null;
        try {
            list = objectMapper.readValue(new File(path), new TypeReference<List<Question>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

}
