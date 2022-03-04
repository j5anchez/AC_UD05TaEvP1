package eus.birt.dam.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.ManyToMany;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instructor")
public class Instructor extends BaseEntity {

  @Column(name = "first_name") private String firstName;
  @Column(name = "last_name") private String lastName;
  @Column(name = "email") private String email;
  @Embedded
  private Address address;

  @ManyToMany(mappedBy = "instructors")
  private Set<Project> projects = new HashSet<>();


  @OneToMany
  @JoinColumn(name = "instructor_detail_id")
  private Set<Instructor_Detail> instructor_details;


  public Instructor(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;

 }

}

