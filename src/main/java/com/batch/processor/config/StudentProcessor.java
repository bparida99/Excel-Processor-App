package com.batch.processor.config;

import com.batch.processor.model.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student,Student> {
    @Override
    public Student process(Student student) throws Exception {
        if(student.getCountry().equals("United States")) {
            return student;
        }else{
            return null;
        }
    }
}
