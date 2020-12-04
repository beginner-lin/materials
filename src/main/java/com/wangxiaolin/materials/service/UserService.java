package com.wangxiaolin.materials.service;

import com.wangxiaolin.materials.entity.User;
import com.wangxiaolin.materials.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2019/12/26 - 18:18
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> queryUserList(){ return  userMapper.queryUserList(); }
    public List<User> getUserByKeywords(String Keywords){return userMapper.getUserByKeywords(Keywords);}
    public User getUserById(int uid){ return userMapper.getUserById(uid); }
    public User loginCheck(String username){ return userMapper.loginCheck(username); }
    public void updateUser(User user){ userMapper.updateUser(user); }
    public void updatePwd(User user){
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setuPwd(bCryptPasswordEncoder.encode(user.getuPwd()));
        userMapper.updatePwd(user);
    };
    public void updateState(User user){userMapper.updateState(user);};
    public void delUserById(int uid){ userMapper.delUserById(uid); }
    public void delUserByIds(int[] uids){ userMapper.delUserByIds(uids); }
    public void insertUser(User user){
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setuPwd(bCryptPasswordEncoder.encode(user.getuPwd()));
        userMapper.insertUser(user);
    }
}
