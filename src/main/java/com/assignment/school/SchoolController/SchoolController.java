package com.assignment.school.SchoolController;

import com.assignment.school.SchoolRepository.SchoolRepository;
import com.assignment.school.SchoolService.SchoolService;
import com.assignment.school.Student.Student;
import com.assignment.school.Student.StudentNor;
import com.assignment.school.exception.StudentNotFoundException;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;

@RestController
public class SchoolController {
 Logger logger = Logger.getLogger(SchoolController.class);
    @Autowired
    SchoolService schoolService;
    @Autowired
    SchoolRepository schoolRepository;
//Logger logger = LoggerFactory.getLogger(SchoolController.class);
    @GetMapping(path = "student")
    public String message()
    {  logger.trace("prinitng heloo");
        return "hello";

    }

    @GetMapping(path = "students",produces = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<Student> getAllStudents()
    {   logger.trace("these are all the students");
        return new ResponseEntity(schoolService.getAllStudents(),HttpStatus.OK);
    }

    public SchoolController(SchoolService schoolService, SchoolRepository schoolRepository) {
        this.schoolService = schoolService;
        this.schoolRepository = schoolRepository;
    }
@DeleteMapping(path = "student/{studentid}")public void deleteItem(@PathVariable Integer studentid){
logger.trace("student got deleted");
     schoolService.deleteStudent(studentid);
}
    public SchoolController() {
    }
@GetMapping(path = "students/{studentid}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<StudentNor> getStudentById(@PathVariable Integer studentid) {
    StudentNor student = schoolService.getStudentById(studentid);
    return new ResponseEntity<>(student, HttpStatus.OK);
}
@PutMapping(path = "student/{studentid}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<String> updateStudent(@PathVariable Integer studentid , @RequestBody Student studentRequest){
        return new ResponseEntity(schoolService.updateStudent(studentRequest),HttpStatus.OK);
}
    @PostMapping(path = "student/{studentid}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> addStudent(@PathVariable Integer studentid, @RequestBody Student studentRequest) {
       logger.trace("added a student");
            return new ResponseEntity<>(schoolService.addStudent(studentRequest,studentid), HttpStatus.CREATED);

    }


    public SchoolService getSchoolService() {
        return schoolService;
    }

    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    public SchoolRepository getSchoolRepository() {
        return schoolRepository;
    }

    public void setSchoolRepository(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
}
