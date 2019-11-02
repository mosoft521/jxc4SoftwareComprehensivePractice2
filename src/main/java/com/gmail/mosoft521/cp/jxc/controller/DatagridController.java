package com.gmail.mosoft521.cp.jxc.controller;

import com.gmail.mosoft521.cp.jxc.entity.Datagrid;
import com.gmail.mosoft521.cp.jxc.service.DatagridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
