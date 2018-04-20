package pl.waw.activeprogress.quiz.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User {
    @Id
    @NotNull
    @GeneratedValue
    private int id;
    private String name;
    private String login;
    private String password;
    @OneToMany(
            targetEntity = Quiz.class,
            mappedBy = "addedBy",
            cascade = CascadeType.ALL
    )
    private List<Quiz> quizList = new ArrayList<>();
    @OneToMany(
            targetEntity = Result.class,
            mappedBy = "user"
    )
    private List<Result> resultList = new ArrayList<>();

    public User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

}
