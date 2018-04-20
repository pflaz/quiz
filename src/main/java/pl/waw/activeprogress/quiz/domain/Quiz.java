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
public class Quiz {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private QuizCategory category;
    private String name;
    private String description;
    private int level;
    @ManyToOne
    @JoinColumn(name = "ADDED_BY")
    private User addedBy;
    @OneToMany(
            targetEntity = Question.class,
            mappedBy = "quiz",
            cascade = CascadeType.ALL
    )
    private List<Question> questionList = new ArrayList<>();
    @OneToMany(
            targetEntity = Result.class,
            mappedBy = "quiz"
    )
    private List<Result> resultList = new ArrayList<>();

    public Quiz(int id, QuizCategory category, String name, String description, int level, User addedBy) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.level = level;
        this.addedBy = addedBy;
    }
}
