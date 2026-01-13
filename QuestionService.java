import java.util.Scanner;

public class QuestionService {

    private static final int TOTAL_QUESTIONS = 5;

    private final Question[] questions = new Question[TOTAL_QUESTIONS];
    private final String[] selections = new String[TOTAL_QUESTIONS];

    public QuestionService() {
        questions[0] = new Question(1, "Size of int in Java", "2", "4", "6", "8", "4");
        questions[1] = new Question(2, "Size of double in Java", "2", "4", "6", "8", "8");
        questions[2] = new Question(3, "Size of char in Java", "1", "2", "4", "8", "2");
        questions[3] = new Question(4, "Size of long in Java", "4", "6", "8", "16", "8");
        questions[4] = new Question(5, "Size of boolean in Java", "1", "2", "4", "8", "1");
    }

    public void playQuiz() {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < TOTAL_QUESTIONS; i++) {
                Question q = questions[i];

                System.out.println("\nQuestion " + q.getId() + ": " + q.getQuestion());
                System.out.println("1. " + q.getOpt1());
                System.out.println("2. " + q.getOpt2());
                System.out.println("3. " + q.getOpt3());
                System.out.println("4. " + q.getOpt4());
                System.out.print("Your answer: ");

                selections[i] = sc.nextLine();
            }
        }

        int score = calculateScore();
        System.out.println("\nYou scored " + score + " out of " + TOTAL_QUESTIONS);
    }

    private int calculateScore() {
        int score = 0;

        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            if (selections[i].equals(questions[i].getAns())) {
                score++;
            }
        }
        return score;
    }
}