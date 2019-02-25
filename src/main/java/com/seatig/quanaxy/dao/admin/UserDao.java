package com.seatig.quanaxy.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import com.seatig.quanaxy.entity.admin.User;

/**
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
@Repository
public interface UserDao {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 查找用户列表
     *
     * @param map
     * @return
     */
    public List<User> findUsers(Map<String, Object> map);

    /**
     * 实体修改
     *
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    public int registerUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteUser(Integer id);
}
