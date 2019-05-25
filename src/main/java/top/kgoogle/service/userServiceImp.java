package top.kgoogle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.kgoogle.dao.userDao;
import top.kgoogle.data.user;
@Component("userServiceImp")
public class userServiceImp implements userService {
    private userDao userDao;
    @Autowired
    public void setUserDao(top.kgoogle.dao.userDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void register(user user) {
        this.userDao.save(user);
    }
}
