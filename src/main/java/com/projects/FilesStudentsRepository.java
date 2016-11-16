package com.projects;

import java.io.*;
import java.util.Collection;

public class FilesStudentsRepository implements StudentsRepository {

    private String fileName;
    private StudentsRepository repo = new InMemoryStudentsRepository();
    private FileWriter fileWriter;

    public FilesStudentsRepository(String fileName) {
        this.fileName = fileName;
        fillRepository();
        openFileForAppend();
    }

    public void add(Student student) {
        repo.add(student);
        saveAddCommand(student);
    }

    public void remove(String id) {
        repo.remove(id);
        saveRemoveCommand(id);
    }

    public Student get(String id) {
        return repo.get(id);
    }

    public Collection<Student> getAll() {
        return repo.getAll();
    }

    private void openFileForAppend() {
        try {
            fileWriter = new FileWriter(fileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillRepository() {
        try {
            FileReader fileReader = new FileReader(new File(fileName));
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                StudentCommand cmd = StudentCommand.fromJson(line.trim());
                if (cmd.getCommand().equals("add")) {
                    repo.add(new Student(cmd.getId(), cmd.getFullName(), cmd.getGender(),
                            Float.parseFloat(cmd.getAvg())));
                } else if (cmd.getCommand().equals("remove")) {
                    repo.remove(cmd.getId());
                }
            }
            fileReader.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveAddCommand(Student student) {
        StudentCommand cmd = new StudentCommand("add",student.getId(),student.getFullName(),student.getGender(),
                String.valueOf(student.getAvg()));
        appendToFile(cmd);
    }

    private void saveRemoveCommand(String id) {
        StudentCommand cmd = new StudentCommand("remove",id,null,null,null);
        appendToFile(cmd);
    }

    private void appendToFile(StudentCommand cmd) {
        String json = cmd.toJson();
        try {
            fileWriter.append(json);
            fileWriter.append("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
