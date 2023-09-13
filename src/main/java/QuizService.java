import java.util.*;

//Quetion
public class QuizService {
    private List<Question> questions;
    private String userName;
    private Scanner scanner;
    private   Map<String, String> questionMap = new LinkedHashMap<>();
    private   Map<String, String> answerMap = new LinkedHashMap<>();

    public QuizService(List<Question> questions, String userName) {
        this.questions = questions;
        this.scanner = new Scanner(System.in);
        this.userName=userName;
    }

    public void startQuiz() {
        int score = 0;
        for (Question question : questions) {
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
            }
            questionMap.put(individualQuestion,options.get(question.getAnswer()-1));
            answerMap.put(individualQuestion, options.get(userAnswer-1));
            System.out.println();

        }
        System.out.println();
        System.out.println(userName + ", your score is: " + score + " out of " + questions.size());
        System.out.println();
        System.out.print("Do you want to see your incorrect  answers  if yes type 'y' or type 'n' ");
        System.out.println();
        String option = scanner.nextLine();

        if(!answerMap.isEmpty())
        {
            if( Objects.equals(option, "Y") ||  Objects.equals(option, "y"))
            {
                System.out.println();
                for (String question : questionMap.keySet()) {
                    String crtAns =questionMap.get(question);
                    String usrAns=answerMap.get(question);
                    System.out.println("Question: " + question );
                    if(Objects.equals(questionMap.get(question), answerMap.get(question)))
                    {
                        System.out.println("Your Answer is :  " +usrAns+ "|  Correct Answer is : " +crtAns);
                        System.out.println("Your answer is correct !!");
                    }else {
                        System.out.println("Your Answer is :  " +usrAns+ " | Correct Answer is : " +crtAns);
                    }
                    System.out.println();
                }
            }
        }else {
            System.out.println();
            System.out.println("Wonderful you have answered all questions correctly!!!");
        }



    }
}
