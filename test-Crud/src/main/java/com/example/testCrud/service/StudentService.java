package com.example.testCrud.service;


    import com.example.testCrud.entities.Student;
    import com.example.testCrud.repository.Repo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;


    import java.util.Optional;
    @Service
    public class StudentService {
        @Autowired
        private Repo studentRepository;

        public Student updateIsWorking(Long id, boolean isWorking) {
            Optional<Student> studentOptional = studentRepository.findById(id);

            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                student.setWorking(isWorking);
                return studentRepository.save(student);
            } else {
                throw new RuntimeException("Student not found");
            }
        }

    }

