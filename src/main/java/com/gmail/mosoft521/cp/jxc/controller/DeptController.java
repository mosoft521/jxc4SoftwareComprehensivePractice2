package com.gmail.mosoft521.cp.jxc.controller;

import com.gmail.mosoft521.cp.jxc.entity.Dept;
import com.gmail.mosoft521.cp.jxc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 获取所有部门列表
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Dept> list() {
        List<Dept> deptList = deptService.list();
        return deptList;
    }

    /**
     * 保存或修改部门
     *
     * @return
     */
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public boolean saveOrUpdate(@RequestParam Integer deptId, @RequestParam String name, @RequestParam String place, @RequestParam String tel, @RequestParam String fax, @RequestParam String remark) {
        Dept dept = new Dept();
        dept.setDeptId(deptId);
        dept.setName(name);
        dept.setPlace(place);
        dept.setTel(tel);
        dept.setFax(fax);
        dept.setRemark(remark);
        return deptService.saveOrUpdate(dept);
    }

    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam Integer deptId) {
        return deptService.delete(deptId);
    }
}
