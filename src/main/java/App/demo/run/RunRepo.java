package App.demo.run;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Data
@NoArgsConstructor

@Repository
public class RunRepo {
    List<Run> runs = new ArrayList<>();

    public List<Run> findAll() {
        return runs;
    }

    public Run findById(int id) {
        for (Run run : runs) {
            if (run.getId() == id) {
                return run;
            }
        }
        return null;
    }

    public void addRun(Run run) {
        for (Run r : runs) {
            if (r.getId() == run.getId()) {
                System.out.println("Not allowed!");
            }
            else {
                runs.add(run);
                System.out.println(run.toString() + " added.");
            }
        }
    }

    public void deleteRun(int id) {

        for (Run run : runs) {
            if (run.getId() == id) {
                System.out.println(run.toString() + " deleted.");
                runs.remove(run);
            }
        }
    }

    public void updateRun(int id, Run update) {
        for (Run run : runs) {
            if (run.getId() == id) {
                run.setId(update.getId());
                run.setTitle(update.getTitle());
                run.setDistance(update.getDistance());
            }
        }
    }

    @PostConstruct
    private void postConstruct() {
        runs.add(new Run(0, "Morning run", 5.0));
        runs.add(new Run(0, "Afternoon run", 21.1));
        runs.add(new Run(1, "Evening run", 10.27));
    }
}
