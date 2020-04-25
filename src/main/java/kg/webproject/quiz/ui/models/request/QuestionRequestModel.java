package kg.webproject.quiz.ui.models.request;

import java.util.Set;

public class QuestionRequestModel {

    private String questionContent;
    private Set<AnswerRequestModel> answers; // set for unique values

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Set<AnswerRequestModel> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerRequestModel> answers) {
        this.answers = answers;
    }
}

