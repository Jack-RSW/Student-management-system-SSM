package com.jnshu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jnshu.pojo.Student;
import com.jnshu.service.IStudentService;
import com.jnshu.utils.Page;
import com.jnshu.utils.TimeConvert;
import org.apache.ibatis.javassist.runtime.Desc;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class StudentController {

    @Autowired
    IStudentService iStudentService;

    //restful风格的增加，并对String格式的时间转为long类型
    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public ModelAndView addStudent(Student s,HttpServletRequest request){
/*        String update_at = request.getParameter("update_at");
        TimeConvert timeConvert = new TimeConvert();
        Long u = timeConvert.convert(update_at);
        s.setUpdate_at(u);

        String create_at = request.getParameter("create_at");
        Long c = timeConvert.convert(create_at);
        s.setCreate_at(c);*/

        System.out.println("增加："+s.getS_name());
        iStudentService.addStudent(s);
        ModelAndView mav = new ModelAndView("redirect:/students");
        return mav;
    }

    //restful风格的删除
    @RequestMapping(value = "/students/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable("id") int id){
        iStudentService.deleteById(id);
        ModelAndView mav = new ModelAndView("redirect:/students");
        return mav;
    }

    //restful风格的获取全部数据并做分页
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public ModelAndView findAll(Page page,@RequestParam(value = "start", defaultValue = "0") int start){
        ModelAndView mav = new ModelAndView();
        Sort sort = new Sort(Sort.Direction.DESC, "s_id");
        page.setStart(start=start<0?0:start);
        PageHelper.offsetPage(page.getStart(),5);
        PageHelper.orderBy("s_id DESC");
        List<Student> stus = iStudentService.findAll();
        int total = (int) new PageInfo(stus).getTotal();
        page.caculateLast(total);
        mav.addObject("stus",stus);
        mav.setViewName("listStudents");
        return mav;
    }

    //restful风格的更新
    @RequestMapping(value = "/students/{id}",method = RequestMethod.PUT)
    public ModelAndView updateStudent(Student s, HttpServletRequest request){
/*        String update_at = request.getParameter("update_at");
        TimeConvert timeConvert = new TimeConvert();
        Long u = timeConvert.convert(update_at);
        s.setUpdate_at(u);

        String create_at = request.getParameter("create_at");
        Long c = timeConvert.convert(create_at);
        s.setCreate_at(c);*/
        iStudentService.updateStudent(s);
        System.out.println(s.getS_name());
        ModelAndView mav = new ModelAndView("redirect:/students");
        return mav;
    }

    //restful风格的编辑，需要先获取，然后编辑
    @RequestMapping(value = "/students/{id}",method = RequestMethod.GET)
    public ModelAndView editStudent(@PathVariable("id") int id, HttpServletRequest request){
        Student s = iStudentService.findById(id);
        ModelAndView mav = new ModelAndView("editStudent");
        mav.addObject("s",s);
        return mav;
    }

    //测试jsp页面的json数据方法
    @RequestMapping("/testJson")
    public ModelAndView tJson(Student student){
        student.setS_id(123);
        student.setCreate_at(20190506);
        student.setS_source("知乎");
        student.setS_flag("try hard");
        student.setS_school("家里蹲大学");
        student.setS_course(1);
        student.setS_qq(12345);
        student.setS_name("王二");
        student.setS_brother(1);
        student.setUpdate_at(20190506);
        student.setS_link("www.jnshu.com");
        List<Student> students = new ArrayList<>();
        students.add(student);
        ModelAndView mav = new ModelAndView("testJson","stu",students);

//      测试jsp页面的json数据方法二
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("1",student);
//        ModelAndView mav = new ModelAndView("testJson","stu",student);

//      测试jsp页面的json数据方法三
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.add(student);
//        ModelAndView mav = new ModelAndView("testJson","stu",jsonArray);
        return mav;
    }

    //测试返回页面
    @RequestMapping("/test")
    public String test2(){
        return "index2";
    }

    //增加学生
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public String addStudent2(){
        return "addStudent";
    }

}
