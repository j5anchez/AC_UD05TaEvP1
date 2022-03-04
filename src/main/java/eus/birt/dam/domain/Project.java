package eus.birt.dam.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "project")
public class Project extends BaseEntity {

  @Column(name = "name") private String name;

  @Column(name = "field") private String field;
  @Column(name = "budget") private double budget;
  @ManyToMany
  @JoinTable(name = "instructor_project",
             joinColumns = @JoinColumn(name = "instructor_id"),
             inverseJoinColumns = @JoinColumn(name = "project_id"))
  private Set<Instructor> instructors = new HashSet<>();

  public Project(String name, String field, double budget) {
    super();
    this.name = name;
    this.field = field;
    this.budget = budget;
  }
}
