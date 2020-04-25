package kg.webproject.quiz.io.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "answers")
public class AnswerEntity implements Serializable {
    private static final long serialVersionUID = 5512315223586710044L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String answerContent;

    @Column(nullable = false)
    private boolean correct;

    @ManyToOne
    @JoinColumn(name="questions_id")
    private QuestionEntity question;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
}
