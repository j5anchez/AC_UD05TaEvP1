package eus.birt.dam.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
  /*
      @ManyToMany(mappedBy = "projects")
      private Set<Instructor> instructors = new HashSet<>();*/
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
