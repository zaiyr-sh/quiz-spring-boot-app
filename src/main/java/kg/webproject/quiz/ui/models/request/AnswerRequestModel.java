package kg.webproject.quiz.ui.models.request;

public class AnswerRequestModel {

    private String answerContent;
    private boolean correct;

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
