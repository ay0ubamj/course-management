package com.coureM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coureM.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
