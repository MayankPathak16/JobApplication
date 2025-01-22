package msproject.JobApplication.Job.entity;

import jakarta.persistence.*;
import lombok.*;
import msproject.JobApplication.Company.entity.Company;
import org.springframework.web.bind.annotation.ResponseStatus;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Job")
@Entity
public class Job {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    //Relationship with the company
    @ManyToOne
    private Company company;


}
