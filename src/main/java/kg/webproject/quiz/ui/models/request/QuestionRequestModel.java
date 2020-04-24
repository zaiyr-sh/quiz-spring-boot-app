package kg.webproject.quiz.ui.models.request;

import java.util.Set;

public class QuestionRequestModel {

    private String questionContent;
    private Set<AnswerRequestModel> answerRequestModelSet; // set for unique values

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Set<AnswerRequestModel> getAnswerRequestModelSet() {
        return answerRequestModelSet;
    }

    public void setAnswerRequestModelSet(Set<AnswerRequestModel> answerRequestModelSet) {
        this.answerRequestModelSet = answerRequestModelSet;
    }
}

