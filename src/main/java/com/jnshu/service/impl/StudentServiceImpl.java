package com.jnshu.service.impl;

import com.jnshu.mapper.IStudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    @Qualifier("IStudentMapper")
    IStudentMapper iStudentMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public Student findById(int id) {
        return iStudentMapper.findById(id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public int addStudent(Student student) {
        return iStudentMapper.addStudent(student);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public boolean updateStudent(Student student) {
        return iStudentMapper.updateStudent(student);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public boolean deleteById(int id) {
        return iStudentMapper.deleteById(id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public List<Student> findAll() {
        return iStudentMapper.findAll();
    }
}
