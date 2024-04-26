package App.demo.run;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepo runRepo;
    public RunController(RunRepo runRepo) {
        this.runRepo = runRepo;
    }
    @GetMapping()
    List<Run> findAll() {
        return runRepo.findAll();
    }

    @GetMapping("/{id}")
    Optional<Run> findById(@PathVariable int id) { //@PathVariable int id - pass url id as parameter
        return runRepo.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addRun")
    void addRun(@Valid @RequestBody Run run) {
        runRepo.addRun(run);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateRun/{id}")
    void updateRun(@PathVariable int id,@Valid @RequestBody Run update) {
        runRepo.updateRun(id, update);
    }

    @DeleteMapping("/delete/{id}")
    void deleteRun(@PathVariable int id) {
        runRepo.deleteRun(id);
    }
}
