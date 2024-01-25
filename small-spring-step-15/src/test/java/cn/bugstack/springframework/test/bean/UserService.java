package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.beans.factory.annotation.Autowired;
import cn.bugstack.springframework.beans.factory.annotation.Value;
import cn.bugstack.springframework.stereotype.Component;

import java.util.Random;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
@Component("userService")
public class UserService implements IUserService {

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("10001") + "，" + token;
    }

    @Override
    public String register(String userName) {
        return "register";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
