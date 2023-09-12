import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class QuizManager {
    private List<YourObjectClass> questions;
    private String userName;
    private Scanner scanner;

    public QuizManager(List<YourObjectClass> questions,String userName) {
        this.questions = questions;
        this.scanner = new Scanner(System.in);
        this.userName=userName;
    }

    public void startQuiz() {
        int score = 0;
        List<String> answerList = new ArrayList<>();

        for (YourObjectClass question : questions) {
            String individualQuestion= question.getQuestion();
            System.out.println(individualQuestion);
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your answer (1-" + options.size() + "): ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine();
            if(userAnswer>options.size())
            {
                System.out.println("Renter the option between 1 - 4");
                userAnswer = scanner.nextInt();
            }

            if (userAnswer == question.getAnswer()) {
                score++;
            } else {
                answerList.add(individualQuestion);
                answerList.add(" Your answer is :"+options.get(userAnswer-1));
                answerList.add(" But the correct answer is: " + options.get(question.getAnswer() - 1));
                answerList.add(" ");
            }
        }
        System.out.println();
        System.out.println(userName + ", your score is: " + score + " out of " + questions.size());
        System.out.println();
        System.out.print("Do you want to see your incorrect  answers  if yes type 'y' or type 'n' ");
        System.out.println();
        String option = scanner.nextLine();
        if(answerList.size()>0)
        {
            if( Objects.equals(option, "Y") ||  Objects.equals(option, "y"))
            {   System.out.println("Answer for your incorrectly answered Questions :");
                System.out.println();
                for (String s : answerList) {
                    System.out.println(s);

                }
            }
        }else {
            System.out.println();
            System.out.println("Wonderful you have answered all questions correctly!!!");
        }



    }
}
