package eus.birt.dam.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "instructor_detail")
public class Instructor_Detail {
  @Id

  @Column(name = "blog")
  private String blog;
  @Column(name = "hobby") private String hobby;

  /*  public Instructor_Detail(String blog, String hobby) {
     this.blog = blog;
     this.hobby = hobby;
   } */
}
