package eus.birt.dam.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course extends BaseEntity {

  @Column(name = "name") private String name;

  @Column(name = "credits") private int credits;

  @ManyToMany(mappedBy = "courses")
  private Set<Student> students = new HashSet<>();

  @OneToMany
  @JoinColumn(name = "instructor_id")
  private Set<Instructor> instructors;

  public Course(String name, int credits) {
    super();
    this.name = name;
    this.credits = credits;
  }
}
