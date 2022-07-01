package com.coureM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coureM.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
