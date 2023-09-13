import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class QuizManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Enter the category you are interested in:");
        System.out.println("    1. GK     2. Sports       3. Java Quiz");
        int choice = scanner.nextInt();
        String fileName = "";
        if (choice == 1) {
            fileName = "gk.json";
        } else if (choice == 2) {
            fileName = "sports.json";
        } else if (choice == 3) {
            fileName = "java.json";
        } else {
            System.out.println("Please enter a valid option");
            return;
        }
        ClassLoader classLoader = QuizManager.class.getClassLoader();
        String path = Objects.requireNonNull(classLoader.getResource(fileName)).getPath();
        try {
            List<Question> questionList = Util.readQuestionsFromFile(path);
             if(!questionList.isEmpty())
             {
                 QuizService quizService = new QuizService(questionList, userName);
                 quizService.startQuiz();
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
