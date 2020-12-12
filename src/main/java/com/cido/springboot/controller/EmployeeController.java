package com.cido.springboot.controller;

import com.cido.springboot.dao.DepartmentDao;
import com.cido.springboot.dao.EmployeeDao;
import com.cido.springboot.entities.Department;
import com.cido.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    // 查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {

        Collection<Employee> employees = employeeDao.getAll();

        // 放在请求域中
        model.addAttribute("emps", employees);

        /**
         * thymeleaf 默认会拼串
         * DEFAULT_PREFIX = "classpath:/templates/";
         * DEFAULT_SUFFIX = ".html";
         */
        return "emp/list";
    }

    // 来到添加员工页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 员工添加
    // SpringMVC自动将请求参数和入参对象进行绑定；要求请求参数的名字和javaBean入参对象的属性名一样
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        // 来到员工列表页面
        return "redirect:/emps"; // redirect 重定向，/代表当前路径
    }

    // 来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        // 查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        // 来到修改页面（add是修改和添加二合一的页面）
        return "emp/add";
    }

    // 员工修改
    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
