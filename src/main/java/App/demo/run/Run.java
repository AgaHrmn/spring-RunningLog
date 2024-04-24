package App.demo.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Run {

    @NotEmpty
    private Integer id;
    private String title;

    @Positive
    private Double distance;
//    private LocalDateTime startedOn;
//    private LocalDateTime completedOn;
}
