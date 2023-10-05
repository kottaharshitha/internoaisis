import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questions.size() - 1;
    }

    public Question getNextQuestion() {
        return questions.get(currentQuestionIndex++);
    }

    public void submitAnswer(int selectedOptionIndex) {
        if (questions.get(currentQuestionIndex - 1).isCorrect(selectedOptionIndex)) {
            score++;
        }
    }

    public int getScore() {
        return score;
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        // Create questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", Arrays.asList("A. London", "B. Berlin", "C. Paris", "D. Madrid"), 2));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("A. Earth", "B. Venus", "C. Mars", "D. Jupiter"), 2));
        questions.add(new Question("What is the largest mammal in the world?", Arrays.asList("A. Elephant", "B. Giraffe", "C. Blue Whale", "D. Lion"), 2));

        // Create a quiz
        Quiz quiz = new Quiz(questions);

        // Simulate the online examination
        Scanner scanner = new Scanner(System.in);

        while (quiz.hasNextQuestion()) {
            Question question = quiz.getNextQuestion();

            System.out.println("Question: " + question.getQuestionText());
            List<String> options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            System.out.print("Enter your choice (A/B/C/D): ");
            String userChoice = scanner.nextLine();
            int selectedOptionIndex = userChoice.toUpperCase().charAt(0) - 'A';

            if (selectedOptionIndex >= 0 && selectedOptionIndex < options.size()) {
                quiz.submitAnswer(selectedOptionIndex);
            } else {
                System.out.println("Invalid choice.");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + quiz.getScore() + " out of " + questions.size());
    }
}
