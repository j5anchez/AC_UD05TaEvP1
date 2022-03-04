package eus.birt.dam.bootstrap;
import eus.birt.dam.domain.Address;
import eus.birt.dam.domain.Course;
import eus.birt.dam.domain.Instructor;
import eus.birt.dam.domain.Student;
import eus.birt.dam.domain.Tuition;
import eus.birt.dam.domain.University;
import eus.birt.dam.repository.CourseRepository;
import eus.birt.dam.repository.InstructorRepository;
import eus.birt.dam.repository.StudentRepository;
import eus.birt.dam.repository.TuitionRepository;
import eus.birt.dam.repository.UniversityRepository;
import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BootStrapData implements CommandLineRunner {
  @Autowired private StudentRepository studentRepository;                                               // Crear objetos de las entidades
  @Autowired private TuitionRepository tuitionRepository;                                               // @autowired conecta servicios a los repositorios
  @Autowired private UniversityRepository universityRepository;
  @Autowired private CourseRepository courseRepository;
  @Autowired private InstructorRepository instructorRepository;
  @Transactional                                                                                        // Parecido al trycatch para no dejar sentencias a medias si falla
  @Override                                                                                             // Para detectar si se esta sobreescribiendo correctamente un metodo en tiempo de compilacion
  public void run(String... arg0) throws Exception {
    Student student1 = new Student("Jill", "Admin", "as@s");                                            // Añadir propiedades los objetos
    Address address1 = new Address("Araba Kalea", "4", "Gasteiz", "01100");
    Tuition tuition1 = new Tuition(4000.0);
    University university1 = new University("EHU");
    Course course1 = new Course("Acceso a datos", 4);
    Instructor instructor1 = new Instructor("William", "Hill", "as@s.asa");
    Address address2 =
        new Address("Araba Etorbidea", "444", "Aramaio", "01100");
    student1.setAddress(address1);                                                                      // Añadir objetos a las entidades
    student1.getPhones().add("653626262");
    student1.getPhones().add("64584896");
    student1.setBirthdate(LocalDate.parse("1982-01-01"));
    university1.setAddress(address1);
    instructor1.setAddress(address2);
    university1.setAddress(address1);
    student1.setTuition(tuition1);
    tuition1.setStudent(student1);
    student1.setUniversity(university1);
    university1.getStudents().add(student1);
    course1.getStudents().add(student1);
    student1.getCourses().add(course1);
    instructorRepository.save(instructor1);                                                             // Guardar en los repositorios
    courseRepository.save(course1);
    universityRepository.save(university1);
    studentRepository.save(student1);
    tuitionRepository.save(tuition1);
    System.out.println("Numero de Students: " + studentRepository.count());
    System.out.println("Numero de Instructors: " +
                       instructorRepository.count());
  }
}