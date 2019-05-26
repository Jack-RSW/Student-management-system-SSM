package com.jnshu.service;

import com.jnshu.mapper.IStudentMapper;
import com.jnshu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IStudentService {

    public Student findById(int id);

    public int addStudent(Student student);

    public boolean updateStudent(Student student);

    public boolean deleteById(int id);

    public List<Student> findAll();

}
