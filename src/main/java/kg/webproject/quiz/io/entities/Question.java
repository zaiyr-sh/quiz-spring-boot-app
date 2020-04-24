package kg.webproject.quiz.io.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name="questions")
public class Question implements Serializable {     //for persisting an object from memory to a sequence of bits
    private static final long serialVersionUID = 3599305611574853751L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String questionContent;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<Answer> answers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
