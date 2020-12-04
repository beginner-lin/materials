package com.wangxiaolin.materials.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangxiaolin.materials.common.AjaxResult;
import com.wangxiaolin.materials.Utils.FileUtils;
import com.wangxiaolin.materials.common.ListToJson;
import com.wangxiaolin.materials.entity.User;
import com.wangxiaolin.materials.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wangxiaolin
 * @date 2019/12/26 - 18:19
 */

@Controller
@RequestMapping(value = "/user")
@SessionAttributes(value="user", types={User.class})
public class UserController {
    @Autowired
    private UserService userService;
    private ModelAndView modelAndView = new ModelAndView();
//    private ObjectMapper objectMapper = new ObjectMapper();
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private static String repKW = "";
    private static String keyword = null;
    private static int reset = 0;
    @RequestMapping(value = "",method= RequestMethod.GET)
    public ModelAndView getList(@RequestParam(defaultValue = "1",value = "pageNo") Integer pageNum,@RequestParam(defaultValue = "",value = "keywords") String keywords){
        PageHelper.startPage(pageNum,8);
        if(reset == 1) {
            reset = 0;
            keyword=null;
            PageHelper.clearPage();
            PageHelper.startPage(1,8);
            return setModelAndView(null,'L');
        }
        if(!keywords.trim().equals("")) {
            keyword = keywords;
        }
        if(null == keyword) return setModelAndView(null,'L');
        return setModelAndView(keyword,'K');
    }
    @RequestMapping(value="/refresh",method= RequestMethod.GET)
    @ResponseBody
    public void refreshList(){
        reset = 1;
    }
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String addUser(){
        return "Users/addUser";
    }
    @RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult addUser(User user){
        User u= userService.loginCheck(user.getuName());
        if(null == u){
            userService.insertUser(user);
            return AjaxResult.success(200,"用户已添加！");
        }
        else return AjaxResult.fail(400,"该用户已存在！");
    }
    @RequestMapping(value="/update",method = RequestMethod.GET)
    public ModelAndView UpdateUser(@RequestParam("uid") Integer uid){
        return setModelAndView(uid,'U');
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public void UpdateUser(User user){userService.updateUser(user);}
    @RequestMapping(value="/updatePwd",method = RequestMethod.GET)
    public ModelAndView updatePwd(@RequestParam("uid") Integer uid){
        return setModelAndView(uid,'P');
    }
    @RequestMapping(value="/updatePwd",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updatePwd(User user){
        int uid = user.getuId();
        String repPWD = user.getuName();
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(repPWD,repKW)){
            userService.updatePwd(user);
            return AjaxResult.success(200,"密码修改成功！");
        }
        return AjaxResult.fail(500,"旧密码错误！");
    }
    @RequestMapping(value="/updateState",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateState(User user){
        try {
            int state = user.getState();
            userService.updateState(user);
            if(state == 0)
                return AjaxResult.success(200,"已禁用！");
            else
                return AjaxResult.success(200,"已启用！");
        }catch (Exception e){
            return AjaxResult.success(500,"操作出错啦！");
        }
    }

    @RequestMapping(value="/delete",method= RequestMethod.POST)
    @ResponseBody
    public void removeUser(Integer uid){ userService.delUserById(uid); }
    @RequestMapping(value="/deletes",method= RequestMethod.POST)
    @ResponseBody
    public void removeUsers(int[] uids){ userService.delUserByIds(uids);}
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult PictureUpload(@RequestParam(value = "file",required = true) MultipartFile file){
        //将图片上传到服务器
        if(file.isEmpty()){
            return AjaxResult.fail();
        }
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        //文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String prefix ="img" + sdf.format(new Date());
        String fileName = prefix+"."+suffix;
        //文件保存路径
        String filePath="src/main/resources/static/upload/imgs/";
        try {
            //写入图片
            Boolean writePictureflag = FileUtils.uploadFile(file.getBytes(),filePath,fileName);
            if(writePictureflag == false){
                //上传图片失败
                return AjaxResult.fail();
            }
            //上传成功后，将可以访问的完整路径返回
            String fullImgpath = "/upload/imgs/"+fileName;
            return AjaxResult.success(fullImgpath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail--send by java");
            //上传图片失败
            return AjaxResult.fail();
        }
    }
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    @ResponseBody
//@SessionAttributes与@ResponseBody共用报错 Cannot create a session after the response has been committed   错误原因:
//如果我们是用了ResponseBody注解，方法return之后是把json字符串响应到页面的，没有进行转发或者重定向，会导致springmvc无法创建session来存储map里面的属性值，导致错误出现。
//解决方法:在return之前自己创建session,这样就不会报错了
    public AjaxResult login(ModelMap map,HttpSession session, @RequestParam(value="username")String username, @RequestParam(value = "password")String password) {
        User u= userService.loginCheck(username);
        if(null == u) return AjaxResult.fail(400,"用户名不存在!");
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder.matches(password,u.getuPwd()))
        {
            if(u.getState()==0){ return AjaxResult.fail(300,"该用户已被禁用，如有疑问请联系管理员"); }
            else {
                map.addAttribute("user",u);
                return AjaxResult.success(200,"登录成功！");
            }
        }
        else return AjaxResult.fail(400,"用户名或密码有误!");
    }
    private  ModelAndView setModelAndView(Object parm,char type){
        modelAndView.clear();
        switch (type){
            case 'L':
                List<User> users =userService.queryUserList();
                PageInfo<User> pageInfo = new PageInfo<User>(users);
                modelAndView.setViewName("Users/userList");
                modelAndView.addObject("pageInfo",pageInfo);
                break;
            case 'K':
                List<User> users1 = userService.getUserByKeywords(String.valueOf(parm));
                PageInfo<User> pageInfo1 = new PageInfo<User>(users1);
                modelAndView.setViewName("Users/userList");
                modelAndView.addObject("pageInfo",pageInfo1);
                break;
            case 'U':
                User user01 = userService.getUserById(Integer.parseInt(String.valueOf(parm)));
                modelAndView.setViewName("Users/updateUser");
                modelAndView.addObject("user",user01);
                break;
            case 'P':
                User user02 = userService.getUserById(Integer.parseInt(String.valueOf(parm)));
                repKW = user02.getuPwd();
                modelAndView.setViewName("Users/updatePwd");
                modelAndView.addObject("user",user02);
                break;
        }
        return modelAndView;
    }
}
