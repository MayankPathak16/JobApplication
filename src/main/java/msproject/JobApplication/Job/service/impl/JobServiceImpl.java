package msproject.JobApplication.Job.service.impl;

import msproject.JobApplication.Company.entity.Company;
import msproject.JobApplication.Job.entity.Job;
import msproject.JobApplication.Job.repository.JobRepository;
import msproject.JobApplication.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

 @Autowired
 private JobRepository jobRepository;
    @Override
    public List<Job> getAllJobs() {
        return  jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        //Need to write logic
         //Creating a job object
       Optional<Job> existingJob = jobRepository.findById(id);
        //Update existing job with new values
            Job updatedJob = jobRepository.findById(id).orElse(null);
            updatedJob.setTitle(job.getTitle());
            updatedJob.setDescription(job.getDescription());
            updatedJob.setMinSalary(job.getMinSalary());
            updatedJob.setMaxSalary(job.getMaxSalary());
            updatedJob.setLocation(job.getLocation());
           return  jobRepository.save(updatedJob);

    }

    @Override
    public void deleteJob(Long id) {

    }
}
