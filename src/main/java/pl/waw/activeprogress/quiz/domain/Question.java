package pl.waw.activeprogress.quiz.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @ManyToOne
    @JoinColumn(name = "QUIZ_ID")
    private Quiz quiz;
    private String contents;
    @OneToMany(
            targetEntity = Answer.class,
            mappedBy = "question",
            cascade = CascadeType.ALL
    )
    private List<Answer> answerList = new ArrayList<>();

    public Question(int id, Quiz quiz, String contents) {
        this.id = id;
        this.quiz = quiz;
        this.contents = contents;
    }
}
