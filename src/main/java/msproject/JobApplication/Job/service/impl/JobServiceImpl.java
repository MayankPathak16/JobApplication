package msproject.JobApplication.Job.service.impl;

import msproject.JobApplication.Job.entity.Job;
import msproject.JobApplication.Job.repository.JobRepository;
import msproject.JobApplication.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Job existingJob = jobRepository.findById(id).orElse(null);
        //Update existing job with new values
        if(existingJob!=null){
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setMinSalary(job.getMinSalary());
            existingJob.setMaxSalary(job.getMaxSalary());
            existingJob.setLocation(job.getLocation());
        }


        //Save the updated job object
        jobRepository.save(existingJob);

        return null;
    }

    @Override
    public void deleteJob(Long id) {

    }
}
