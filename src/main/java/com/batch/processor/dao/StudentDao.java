package com.batch.processor.dao;

import com.batch.processor.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
}
