package kg.webproject.quiz.ui.models.response;

import java.util.Set;

public class QuestionResponseModel {

    private String questionContent;
    private Set<AnswerResponseModel> answerResponseModels; // set for unique values

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Set<AnswerResponseModel> getAnswerResponseModels() {
        return answerResponseModels;
    }

    public void setAnswerResponseModels(Set<AnswerResponseModel> answerResponseModels) {
        this.answerResponseModels = answerResponseModels;
    }
}
