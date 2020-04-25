package kg.webproject.quiz.ui.models.response;

import java.util.Set;

public class QuestionResponseModel {

    private String questionContent;
    private Set<AnswerResponseModel> answers; // set for unique values

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Set<AnswerResponseModel> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerResponseModel> answers) {
        this.answers = answers;
    }
}
