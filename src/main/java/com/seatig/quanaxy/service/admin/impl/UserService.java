package com.seatig.quanaxy.service.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.seatig.quanaxy.dao.admin.UserDao;
import com.seatig.quanaxy.entity.admin.User;
import com.seatig.quanaxy.service.admin.IUserService;

/**
 * 用户观看
 * @Description 
 * @author xianw
 * @time 2019年2月20日下午1:40:37
 * @version v1.0
 */
@Service
public class UserService implements IUserService {

    @Resource
    private UserDao userDao;

    /**
     * 登录
     * @Description 
     * @param: @param user
     * @param: @return      
     * @return: User
     * @param user
     * @return
     */
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * 修改用户信息
     * @Description 
     * @param: @param user
     * @param: @return      
     * @return: int
     * @param user
     * @return
     */
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
     * 注册用户
     * @Description 
     * @param: @param user
     * @param: @return      
     * @return: int
     * @param user
     * @return
     */
	@Override
	public int registerUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
     * 删除用户
     * @Description 
     * @param: @param id
     * @param: @return      
     * @return: int
     * @param id
     * @return
     */
	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
