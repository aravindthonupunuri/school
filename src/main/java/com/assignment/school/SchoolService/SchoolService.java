package com.assignment.school.SchoolService;
import com.assignment.school.SchoolRepository.SchoolRepository;
import com.assignment.school.Student.Student;
import com.assignment.school.Student.StudentNor;
import com.assignment.school.exception.StudentNotFoundException;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.apache.log4j.Logger;
import javax.transaction.Transactional;
import javax.validation.constraints.Negative;
import javax.validation.constraints.Null;
import java.util.List;

 @Configuration
public class SchoolService {
Logger logger = Logger.getLogger(SchoolService.class);
    @Autowired
    SchoolRepository schoolRepository;


    public SchoolService() {
    }

    public void deleteStudent(int studentid) {
        schoolRepository.deleteById(studentid);
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = schoolRepository.findAll();
        return studentList;
    }

    @Transactional
    public Student createStudent(Student student) {
        schoolRepository.save(student);
        return student;
    }

    public StudentNor mapTo(Student student) {
        return new StudentNor(student.getStudentid(), student.getName(), student.getAge(), student.getGender());
    }

    public Student mapTo(StudentNor studentNor) {
        return new Student(studentNor.getStudentid(), studentNor.getName(), studentNor.getAge(), studentNor.getGender());
    }

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public StudentNor getStudentById(int studentid) {

        try {
            Student student = schoolRepository.getOne(studentid);
            return mapTo(student);
        } catch (Exception e) {
            logger.trace("student not found");
            throw new StudentNotFoundException("no student present");
        }
    }


    public Student addStudent(Student student, int studentid) {

        Student student1 = schoolRepository.findById(studentid);
        if(student1 != null)
        {
            throw new StudentNotFoundException("just update");
        }


            Integer x = student.getStudentid();
            if (x == null) {
                throw new StudentNotFoundException("enter id");
            }
            if (student.getStudentid() == studentid) {
                schoolRepository.save(student);


                return student;
            } else {
                throw new StudentNotFoundException("different id and path");
            }

    }
        public SchoolRepository getSchoolRepository () {
            return schoolRepository;
        }

        public void setSchoolRepository (SchoolRepository schoolRepository){
            this.schoolRepository = schoolRepository;
        }

        public int updateStudent (Student studentRequest){
            if (schoolRepository.existsById(studentRequest.getStudentid())) {
                schoolRepository.save(studentRequest);
                return 1;
            } else
                return 0;
        }
    }
