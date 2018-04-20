package pl.waw.activeprogress.quiz.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Result {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "QUIZ_ID")
    private Quiz quiz;
    private int questions;
    private int points;
    private LocalDateTime dateTime;

    public Result(int id, User user, Quiz quiz, int questions, int points, LocalDateTime dateTime) {
        this.id = id;
        this.user = user;
        this.quiz = quiz;
        this.questions = questions;
        this.points = points;
        this.dateTime = dateTime;
    }
}
