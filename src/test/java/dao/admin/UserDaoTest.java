package dao.admin;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.seatig.quanaxy.dao.admin.UserDao;
import com.seatig.quanaxy.entity.admin.User;
import com.seatig.quanaxy.utils.MD5Util;

/**
 * userdao测试
 * @Description 
 * @author xianw
 * @time 2019年2月25日下午2:59:17
 * @version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:spring/spring-context.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)//默认回滚,即此类中的方法即使执行成功,数据也并不会真正的修改,方法执行后会回滚.
public class UserDaoTest {
	
    @Autowired
    private UserDao userDao;

    @Test
    public void loginTest() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");
        //断言此姓名和密码的用户为空
        Assert.assertEquals(userDao.login(user), null);
        User user2 = new User();
        user2.setUserName("admin");
        user2.setPassword(MD5Util.MD5Encode("123456", "UTF-8"));
        //断言此姓名和密码的用户可以登录成功,且用户id为2
        Assert.assertTrue(userDao.login(user2).getId() == 13);
        //Assert.assertTrue(userDao.login(user2).getId() == 3);

    }

    @Test
    public void findUsersTest() {
        //断言此时返回的用户列表数大于0
        Assert.assertTrue(userDao.findUsers(null).size() > 0);
        //断言此时返回的用户列表数等于3,用户数可能是错的,如果报错你会看到控制台一片红色
        Assert.assertTrue(userDao.findUsers(null).size() == 2);
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setPassword("1221");
        //大于0的意思是成功修改了一条记录,即修改成功,如果updateUser()方法返回值等于0,即修改失败
        Assert.assertTrue(userDao.updateUser(user) > 0);
        User user2 = new User();
        user2.setId(1000);
        user2.setPassword("234y9823y89hhao");
        Assert.assertTrue(userDao.updateUser(user2) > 0);
    }

    @Test
    public void addUserTest() {
        User user = new User();
        user.setUserName("admin");
        user.setCreateDate(new Date());
        user.setPassword(MD5Util.MD5Encode("123456", "UTF-8"));
        user.setQxPassword(MD5Util.MD5Encode("654321", "UTF-8"));
        //大于0的意思是成功添加了一条记录,即添加成功
        Assert.assertTrue(userDao.registerUser(user) > 0);
    }

}
