package com.assignment.school.SchoolRepository;

import com.assignment.school.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<Student,Integer> {

     Student findById(int id);
}
