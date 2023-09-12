import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class QuizManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Enter your  Catergory you are intrested in ");
        System.out.println("    1.GK     2.Sports       3.Java Quiz");
        int choice = scanner.nextInt();
        String path = "";
        if (choice == 1) {
            path = "src/main/resources/gk.json";
        } else if (choice == 2) {
            path = "src/main/resources/sports.json";
        } else if (choice == 3) {
            path = "src/main/resources/java.json";
        } else {
            System.out.println("Please enter valid option");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Question> list = objectMapper.readValue(new File(path), new TypeReference<List<Question>>() {
            });
            QuizService quizManager = new QuizService(list, userName);
            quizManager.startQuiz();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
