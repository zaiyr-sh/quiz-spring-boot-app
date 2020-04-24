package kg.webproject.quiz.ui.models.request;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class QuestionRequestModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String questionContent;
    private List<AnswerRequestModel> answerRequestModelSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<AnswerRequestModel> getAnswerRequestModelSet() {
        return answerRequestModelSet;
    }

    public void setAnswerRequestModelSet(List<AnswerRequestModel> answerRequestModelSet) {
        this.answerRequestModelSet = answerRequestModelSet;
    }
}

