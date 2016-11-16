package com.projects;

import java.util.Collection;

public interface StudentsRepository {
    void add(Student student);
    void remove(String id);
    Student get(String id);
    Collection<Student> getAll();
}
