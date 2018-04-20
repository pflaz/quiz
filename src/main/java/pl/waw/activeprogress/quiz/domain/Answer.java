package pl.waw.activeprogress.quiz.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
public class Answer {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;
    private String contents;
    private boolean correct;
    private String comment;

    public Answer(int id, Question question, String contents, boolean correct, String comment) {
        this.id = id;
        this.question = question;
        this.contents = contents;
        this.correct = correct;
        this.comment = comment;
    }


}
