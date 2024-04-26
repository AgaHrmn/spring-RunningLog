package App.demo.run;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Repository
public class RunRepo {

    private static final Logger log = LoggerFactory.getLogger(RunRepo.class);
    private final JdbcClient jdbcClient;

    public RunRepo(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("select * from run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(int id) {
        return jdbcClient.sql("select * from run where run_id = :run_id") // Add WHERE clause to filter by id
                .param("run_id", id) // Bind the id parameter to the query
                .query(Run.class) // Execute the query and map results to Run class
                .optional(); // Retrieve the first result (assuming id is unique)

    }

    public void addRun(Run run) {
        jdbcClient.sql("insert into Run (run_id, title, distance) values (:run_id, :title, :distance);")
                .param("run_id" ,run.getRun_id(), Types.INTEGER)
                .param("title" ,run.getTitle(), Types.VARCHAR)
                .param("distance" ,run.getDistance(), Types.FLOAT)
                .update();
    }

    public void deleteRun(int id) {
        jdbcClient.sql("delete from Run where run_id = :run_id")
                .param("run_id", id)
                .update();

    }
    public void updateRun(int id, Run run) {
        jdbcClient.sql("update Run set run_id = :run_id, title = :title, distance = :distance where run_id = :run_id")
                .param("run_id", id)
                .param("run_id", run.getRun_id(), Types.INTEGER)
                .param("title", run.getTitle(), Types.VARCHAR)
                .param("distance", run.getDistance(), Types.FLOAT)
                .update();
    }

}