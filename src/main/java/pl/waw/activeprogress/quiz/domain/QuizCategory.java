package pl.waw.activeprogress.quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuizCategory {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    private String name;
    @OneToMany(
            targetEntity = Quiz.class,
            mappedBy = "category"
    )
    private List<Quiz> quizList = new ArrayList<>();

}
