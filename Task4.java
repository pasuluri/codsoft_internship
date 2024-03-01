import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Question {
    private String text;
    private List<String> options;
    private String answer;
    private long timeLimit;

    public Question(String text, List<String> options, String answer, long timeLimit) {
        this.text = text;
        this.options = options;
        this.answer = answer;
        this.timeLimit = timeLimit;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public long getTimeLimit() {
        return timeLimit;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;
    private Scanner scanner;

    public Quiz(List<Question> questions, Scanner scanner) {
        this.questions = questions;
        this.scanner = scanner;
        this.score = 0;
    }

    public void start() {
        for (Question question : questions) {
            System.out.println(question.getText());
            int i = 1;
            for (String option : question.getOptions()) {
                System.out.println(i + ". " + option);
                i++;
            }
            long startTime = System.currentTimeMillis();
            System.out.print("Enter your answer (1-" + question.getOptions().size() + "): ");
            int answer = scanner.nextInt();
            scanner.nextLine(); // consume newline not consumed by nextInt()
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime <= question.getTimeLimit()) {
                if (question.getOptions().get(answer - 1).equals(question.getAnswer())) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is: " + question.getAnswer());
                }
            } else {
                System.out.println("Time's up! The correct answer is: " + question.getAnswer());
            }
            System.out.println();
        }
        displayResult();
    }

    public void displayResult() {
        System.out.println("Your final score is: " + score + "/" + questions.size());
    }
}

public class Task4 {
    public static void main(String[] args) {
        List<String> options1 = new ArrayList<>();
        options1.add("Java");
        options1.add("Python");
        options1.add("C#");
        options1.add("Ruby");
        Question question1 = new Question("What is the most popular programming language for web development?", options1, "Java", TimeUnit.SECONDS.toMillis(30));

        List<String> options2 = new ArrayList<>();
        options2.add("TCP/IP");
        options2.add("UDP");
        options2.add("ICMP");
        options2.add("FTP");
        Question question2 = new Question("Which protocol is used for reliable, connection-oriented data transfer?", options2, "TCP/IP", TimeUnit.SECONDS.toMillis(30));

        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);

        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz(questions, scanner);
        quiz.start();
    }
}