package com.wangxiaolin.materials.controller;

import com.wangxiaolin.materials.entity.User;
import com.wangxiaolin.materials.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangxiaolin
 * @date 2019/12/22 - 9:11
 */
@Controller
@RequestMapping(value = "/main")
@SessionAttributes(value="user", types={User.class})
public class MainController{
    @Autowired
    private UserService userService;
    private ModelAndView modelAndView = new ModelAndView();
    @RequestMapping(value = "")
    public ModelAndView hello(@ModelAttribute User user) {
        modelAndView.clear();
        if(null == user){ modelAndView.setViewName("login"); }
        else{
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }
    @ModelAttribute("user") // 如果session里没值的话,会报一个HttpSessionRequiredException的异常,所以需要加一段代码
    public User getPerson() {
        return null;
    }
    @RequestMapping(value="/page")
    public ModelAndView welcome(@ModelAttribute User user) {
        modelAndView.clear();
        modelAndView.setViewName("PersonalPage");
        return modelAndView;
    }
    @RequestMapping(value = "/information")
    public ModelAndView Personnal(@ModelAttribute User user) {
        modelAndView.clear();
        modelAndView.setViewName("Users/PersonalInformation");
        return modelAndView;
    }
    @RequestMapping(value = "/login")
    public ModelAndView loginMain(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        modelAndView.clear();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
