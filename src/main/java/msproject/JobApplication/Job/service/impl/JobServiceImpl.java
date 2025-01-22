package msproject.JobApplication.Job.service.impl;

import msproject.JobApplication.Company.entity.Company;
import msproject.JobApplication.Job.entity.Job;
import msproject.JobApplication.Job.repository.JobRepository;
import msproject.JobApplication.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
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
      return  jobRepository.findById(id).map(existingJob -> {
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setMinSalary(job.getMinSalary());
            existingJob.setMaxSalary(job.getMaxSalary());
            existingJob.setLocation(job.getLocation());
            return jobRepository.save(existingJob);
        }).orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
    }

    @Override
    public void deleteJob(Long id) {
        if(jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
    }else{
        throw new ResourceNotFoundException("Job not found with id: " + id);
        }
    }

    // ResourceNotFoundException
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}






