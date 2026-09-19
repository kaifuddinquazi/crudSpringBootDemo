package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("get/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @PutMapping("/update")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete")
    public Boolean deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}