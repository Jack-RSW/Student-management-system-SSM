package com.jnshu.mapper;

import com.github.pagehelper.Page;
import com.jnshu.pojo.Student;

import java.util.List;

public interface IStudentMapper {

    public Student findById(int id);

    public int addStudent(Student student);

    public boolean updateStudent(Student student);

    public boolean deleteById(int id);

    public List<Student> findAll();

}
