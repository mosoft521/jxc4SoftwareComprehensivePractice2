package com.gmail.mosoft521.cp.jxc.controller;

import com.gmail.mosoft521.cp.jxc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return 成功或失败
     */
    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam String userName, @RequestParam String password) {
        return empService.login(userName, password);
    }

}
