package com.coureM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coureM.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
