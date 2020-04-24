package kg.webproject.quiz.ui.models.response;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class QuestionResponseModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String questionContent;
    private List<AnswerResponseModel> answerResponseModels;

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

    public List<AnswerResponseModel> getAnswerResponseModels() {
        return answerResponseModels;
    }

    public void setAnswerResponseModels(List<AnswerResponseModel> answerResponseModels) {
        this.answerResponseModels = answerResponseModels;
    }
}
