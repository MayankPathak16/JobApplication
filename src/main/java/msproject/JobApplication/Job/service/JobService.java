package msproject.JobApplication.Job.service;

import msproject.JobApplication.Job.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
    /**
     * Method 1:GET/jobs -> Get all jobs
     * Method 2:GET/jobs/{id} -> Get job by id
     * Method 3:POST/jobs -> Create a new job(request body should contain job details)
     * Method 4:PUT/jobs/{id} -> Update job by id(request body should contain update job)
     * Method 5:DELETE/jobs/{id} -> Delete job by id
     */
    //Method 1: GET/jobs -> Get all jobs
    public List<Job> getAllJobs();
    //Method 2: GET/jobs/{id} -> Get job by id
    public Job getJobById(Long id);
    //Method 3: POST/jobs -> Create a new job(request body should contain job details)
    public Job createJob(Job job);
    //Method 4: PUT/jobs/{id} -> Update job by id(request body should contain update job)
    public Job updateJob(Long id, Job job);
    //Method 5: DELETE/jobs/{id} -> Delete job by id
    public void deleteJob(Long id);
}
