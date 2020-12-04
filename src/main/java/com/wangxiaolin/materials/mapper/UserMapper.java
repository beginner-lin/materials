package com.wangxiaolin.materials.mapper;

import com.wangxiaolin.materials.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2019/12/26 - 17:55
 */
@Mapper
public interface UserMapper {
    public List<User> queryUserList();
    public List<User> getUserByKeywords(@Param("Keywords")String Keywords);
    public User getUserById(int uid);
    public User loginCheck(@Param("username") String username);
    public void updateUser(User user);
    public void updatePwd(User user);
    public void updateState(User user);
    public void delUserById(int uid);
    public void delUserByIds(@Param("uids")int[] uids);
    public void insertUser(User user);

}
