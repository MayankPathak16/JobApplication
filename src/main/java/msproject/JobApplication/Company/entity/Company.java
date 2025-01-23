package msproject.JobApplication.Company.entity;

import jakarta.persistence.*;
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
@Table(name = "companydb")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    //One company has many jobs-one means company means ye class. many job jha se mapping hora he
    //mappedby me jo company die he wo tera job me dalna he mapping ke liye
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
    //One company has list of reviews
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;


}
