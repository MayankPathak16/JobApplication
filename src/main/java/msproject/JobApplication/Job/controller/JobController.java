package msproject.JobApplication.Job.controller;

import msproject.JobApplication.Job.entity.Job;
import msproject.JobApplication.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
   private JobService jobService;

    //Get Mapping to get all jobs
    @GetMapping("/allJobs")
    public ResponseEntity<List<Job>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobs());
    }
    //Get Mapping to get job by id
    @GetMapping("/getJob/{id}")
    public ResponseEntity<Job> getJobById( @PathVariable Long id){
        return ResponseEntity.ok(jobService.getJobById(id));
    }
    //Post Mapping to create job
    @PostMapping("/createJob")
    public ResponseEntity<Job> createJob(@RequestBody Job job){
        Job savedJob = jobService.createJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJob);
    }
    //Update Mapping to update job
    @PutMapping("/updateJob/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") Long id,@RequestBody Job job){
        return ResponseEntity.ok(jobService.updateJob(id,job));
    }
    //Delete Mapping to delete job
    @DeleteMapping("/deleteJob/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable(value = "id") Long id){
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

}
