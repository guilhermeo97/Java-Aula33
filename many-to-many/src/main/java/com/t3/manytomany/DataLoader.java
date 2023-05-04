package com.t3.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.t3.manytomany.entity.Group;
import com.t3.manytomany.entity.Student;
import com.t3.manytomany.repository.GroupRepository;
import com.t3.manytomany.repository.StudentRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void run(String... args) throws Exception {     
        System.out.println("Início da execução");   

        System.out.println("createNewStudent('João', 'Silva');");
        createNewStudent("João", "Silva");

        System.out.println("fetchStudent(1L);");
        fetchStudent(1L);

        System.out.println("fetchGroup(1L);");
        fetchGroup(1L);

        System.out.println("fetchGroup(2L);");
        fetchGroup(2L);

        System.out.println("Fim da execução");   
    }

    public void createNewStudent(String firstName, String lastName){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);

        Group group1 = new Group();
        group1.setName("Xadrez");

        Group group2 = new Group();
        group2.setName("Teatro");

        //Adiciono o estudante nos grupos
        group1.getStudents().add(student);
        group2.getStudents().add(student);
        
        //Adiciono os grupos no estudante
        student.getGroups().add(group1);
        student.getGroups().add(group2);

        studentRepository.save(student);      
        
        System.out.println("Adicionado o Estudante: " + firstName + " " + lastName);
    }

    public void fetchStudent(long id){
        Student student = studentRepository.findById(id).get();

        System.out.println(student.toString());
        System.out.println("participate in the groups: ");

        student.getGroups().forEach((group) -> {
            System.out.println(group.getName());
        });
    }
    
    public void fetchGroup(long id){
        Group group = groupRepository.findById(id).get();

        System.out.println(group.getName() + " participants: ");

        group.getStudents().forEach((student) -> {
            System.out.println(student.toString());
        });

    }
}
