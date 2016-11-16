package com.projects;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Resource StudentsRepository studentsRepository;

    @RequestMapping("/add")
    @ResponseBody
    public String add(
            @RequestParam String id,
            @RequestParam String fullName,
            @RequestParam String gender,
            @RequestParam String avg
            ) {
        Student student = new Student(id, fullName, gender, Float.parseFloat(avg));
        studentsRepository.add(student);
        return "Student " + id + " Added";
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String remove(@RequestParam String id) {
        studentsRepository.remove(id);
        return "Student " + id + " Removed";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam String id) {
        return getStudentHtml(studentsRepository.get(id));
    }

    @RequestMapping("/list")
    @ResponseBody
    public String list() {
        StringBuilder sb = new StringBuilder();
        for (Student student : studentsRepository.getAll()) {
            String html = getStudentHtml(student);
            sb.append(html);
        }
        return sb.toString();
    }

    private String getStudentHtml(Student student) {
        return "<p>" +
                "id: "+student.getId()+"<br>"+
                "full name: "+student.getFullName()+"<br>"+
                "gender: "+student.getGender()+"<br>"+
                "average: "+student.getAvg()+"<br>"+
                "</p>";
    }

}



//        try {
//            FileReader fileReader = new FileReader(new File("/tmp/students.db"));
//            BufferedReader br = new BufferedReader(fileReader);
//            String line;
//            while ((line = br.readLine()) != null) {
//                StudentCommand cmd = StudentCommand.fromJson(line.trim());
//                processCommand(cmd, false);
//            }
//            fileReader.close();
//            database = new FileWriter("/tmp/students.db", true);
//        } catch (FileNotFoundException ex) {
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }

//    private String processRequest(String command, String parameters, Boolean write) throws IOException {
//        Map<String, String> splittedParameters = splitParameters(parameters);
//        String ret;
//        switch (Commands.valueOf(command)) {
//            case add:
//                ret = add(splittedParameters);
//                if (write) {
//                    database.append(command + "," + parameters + "\n");
//                    database.flush();
//                    return ret;
//                } else return "";
//            case remove:
//                ret = remove(splittedParameters);
//                if (write) {
//                    database.append(command + "," + parameters + "\n");
//                    database.flush();
//                    return ret;
//                } else return "";
//            case get:
//                return get(splittedParameters);
//            case list: return list();
//        }
//        return "Error";
//    }
