package top.kgoogle.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import top.kgoogle.data.user;
@Component
public interface userDao {
    void save(Object user);
    HibernateTemplate getHibernateTemplate();
    int login(String name,String pwd,int key);
    user getUser(int id);
    void delete(Object u);
    void update(Object u);
}
