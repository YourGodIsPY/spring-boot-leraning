package com.ypan.sprinbootweb1.controller;

import com.ypan.sprinbootweb1.config.Constants;
import com.ypan.sprinbootweb1.entities.User;
import com.ypan.sprinbootweb1.service.IUserService;
import com.ypan.sprinbootweb1.utils.JsonResult;
import com.ypan.sprinbootweb1.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 获取全部用户
     *
     * @return
     */
    @GetMapping("/users")
    @ResponseBody
    public JsonResult getAllUser() {
        return JsonResult.ok("cg", userService.selectAllUser());
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public JsonResult getUserById(@PathVariable Integer id) {
        return JsonResult.ok("cg", userService.selectUserById(id));
    }

    @PostMapping("/login")
    public String userLogin(User user, Model m, HttpSession session) {
        if (null == user) {
            m.addAttribute("msg", "用户参数错误");
            return "index.html";
        }
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassWord())) {
            m.addAttribute("msg", "用户名或密码错误");
            return "index.html";
        }
        if (null == userService.selectUserByNamePwd(user)) {
            m.addAttribute("msg", "用户名或密码错误");
            return "index.html";

        }
        String token = UUID.randomUUID().toString() + System.currentTimeMillis();
        session.setAttribute("token", token);
        redisUtils.set(token, 1, Constants.INTEGER_NUM.INTEGER_900.getVal());
        return "dashboard";
    }

    @GetMapping("/logout")
    public String userLogin(Model m, HttpSession session) {
        session.removeAttribute("user");
        m.addAttribute("msg", "用户已退出");
        return "index.html";
    }
}
