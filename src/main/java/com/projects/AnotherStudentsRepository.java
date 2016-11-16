package com.projects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AnotherStudentsRepository implements StudentsRepository {

    private String fileName;
    private Map<String, Student> map;
    private FileWriter fileWriter;
    private Gson gson = new Gson();

    public AnotherStudentsRepository(String fileName) {
        this.fileName = fileName;
        loadRepository();
    }

    public void add(Student student) {
        map.put(student.getId(), student);
        saveMap();
    }

    public void remove(String id) {
        map.remove(id);
        saveMap();
    }

    public Student get(String id) {
        return map.get(id);
    }

    public Collection<Student> getAll() {
        return map.values();
    }

    private void saveMap() {
        try {
            fileWriter = new FileWriter(fileName);
            gson.toJson(map, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRepository() {
        try {
            FileReader fileReader = new FileReader(new File(fileName));
            map = gson.fromJson(fileReader, new TypeToken<Map<String, Student>>(){}.getType());
            fileReader.close();
        } catch (FileNotFoundException e) {
            map = new HashMap<String, Student>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
