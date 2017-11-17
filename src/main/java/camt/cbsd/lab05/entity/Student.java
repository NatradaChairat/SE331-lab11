package camt.cbsd.lab05.entity;

import camt.cbsd.lab05.entity.security.Authority;
import camt.cbsd.lab05.entity.security.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@JsonIgnoreType
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String studentId;
    String name;

    String surname;
    double gpa;
    String image;
    boolean feature;
    int penAmount;
    String description;

    @OneToOne(mappedBy = "student")
    User user;

    @ManyToMany
    List<Course> enrolledCourse;

    public List<Course> addCourse(Course course) {
        enrolledCourse = Optional.ofNullable(enrolledCourse).orElse(new ArrayList<>());
        enrolledCourse.add(course);
        return enrolledCourse;

    }

    public List<Authority> getAuthorities(){
        return user.getAuthorities();
    }
}
