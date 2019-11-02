package com.gmail.mosoft521.cp.jxc.controller;

import com.gmail.mosoft521.cp.jxc.entity.Datagrid;
import com.gmail.mosoft521.cp.jxc.service.DatagridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/datagrid")
public class DatagridController {

    @Autowired
    private DatagridService datagridService;

    /**
     * 获取所有用户列表
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Datagrid> list() {
        List<Datagrid> datagridList = datagridService.list();
        return datagridList;
    }

    /**
     * 保存或修改用户
     *
     * @param id
     * @param firstname
     * @param lastname
     * @param phone
     * @param email
     * @return
     */
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public boolean saveOrUpdate(@RequestParam Integer id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String phone, @RequestParam String email) {
        Datagrid datagrid = new Datagrid();
        datagrid.setId(id);
        datagrid.setFirstname(firstname);
        datagrid.setLastname(lastname);
        datagrid.setPhone(phone);
        datagrid.setEmail(email);
        return datagridService.saveOrUpdate(datagrid);
    }
}
