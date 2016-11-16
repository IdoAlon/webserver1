package com.projects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationSpringConfig {
    

    private static String DB_FILE_NAME = "/tmp/students.db";

    @Bean
    public StudentsController studentsController() {
      return new StudentsController();
    }

    @Bean
    public StudentsRepository studentsRepository() {
      return new AnotherStudentsRepository(DB_FILE_NAME);
    }

//    @Bean
//    public StudentsRepository studentsRepository() {
//      return new FilesStudentsRepository(DB_FILE_NAME);
//    }

//    @Bean
//    public StudentsRepository studentsRepository() {
//      return new InMemoryStudentsRepository();
//    }


}
