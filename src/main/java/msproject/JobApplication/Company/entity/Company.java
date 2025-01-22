package msproject.JobApplication.Company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import msproject.JobApplication.Job.entity.Job;
import msproject.JobApplication.Review.entity.Review;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    private Long id;
    private String name;
    private String description;
    //One company has many jobs-one means company means ye class. many job jha se mapping hora he
    @OneToMany
    private List<Job> jobs;
    //One company has list of reviews
    @OneToMany
    private List<Review> reviews;


}
