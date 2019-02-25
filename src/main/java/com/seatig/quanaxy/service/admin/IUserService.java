package com.seatig.quanaxy.service.admin;

import com.seatig.quanaxy.entity.admin.User;

/**
 * 用户管理
 * @Description 
 * @author xianw
 * @time 2019年2月20日下午1:40:09
 * @version v1.0
 */
public interface IUserService {

    /**
     * 登录
     * @Description 
     * @param: @param user
     * @param: @return      
     * @return: User
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 修改用户信息
     * @Description 
     * @param: @param user
     * @param: @return      
     * @return: int
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 注册用户
     * @Description 
     * @param: @param user
     * @param: @return      
     * @return: int
     * @param user
     * @return
     */
    public int registerUser(User user);

    /**
     * 删除用户
     * @Description 
     * @param: @param id
     * @param: @return      
     * @return: int
     * @param id
     * @return
     */
    public int deleteUser(Integer id);
}
