package kg.webproject.quiz.io.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "answers")
public class Answer implements Serializable {
    private static final long serialVersionUID = 3599305611574853751L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String answerContent;

    @Column(nullable = false)
    private boolean correct;

    @ManyToOne
    @JoinColumn(name="questions_id")
    private Question question;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
