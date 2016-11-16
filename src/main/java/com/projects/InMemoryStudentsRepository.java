package com.projects;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryStudentsRepository implements StudentsRepository {

    private Map<String, Student> map = new HashMap<String, Student>();

    public void add(Student student) {
        if (map.size() == 1000) throw new RuntimeException("no more than 1000");
        map.put(student.getId(), student);
    }

    public void remove(String id) {
        map.remove(id);
    }

    public Student get(String id) {
        return map.get(id);
    }

    public Collection<Student> getAll() {
        return map.values();
    }
}
