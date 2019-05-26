package com.jnshu.controller.validation;

import com.jnshu.exception.StudentException;
import com.jnshu.pojo.Student;
import com.jnshu.service.IStudentService;
import com.jnshu.utils.TimeConvert;
import javafx.beans.binding.LongBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsValidationController {

    @Autowired
    IStudentService iStudentService;

//    局部时间转换
/*    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Long.class, new CustomDateEditor(dateFormat, true));
    }*/

    @RequestMapping(value = "/editStudentsSubmit",method = RequestMethod.POST)
    public String editStudentsSubmit(Model model, HttpServletRequest request, Integer id, @Validated Student student, BindingResult bindingResult)throws Exception {

        List<ObjectError> allErrors = null;
        if (bindingResult.hasErrors()) {

            allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors", allErrors);
            model.addAttribute("stu",student);
            System.out.println("--------进入allErrors----------");
            return "/addStudent";

        }

        System.out.println("无错误---------------------");

        iStudentService.addStudent(student);

        return "redirect:/students";
    }
}
