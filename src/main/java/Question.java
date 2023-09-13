import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Question {
    @Setter private int id;
    @Setter  private String name;
    @Setter private String question;
    @Setter private List<String> options;
    @Setter private int answer;

}
