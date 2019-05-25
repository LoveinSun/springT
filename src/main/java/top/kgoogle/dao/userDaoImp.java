package top.kgoogle.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import top.kgoogle.servlet.register;
import top.kgoogle.data.user;

import java.util.List;
import java.util.Set;


@Component("userDao")
public class userDaoImp implements userDao {
    HibernateTemplate hibernateTemplate;
    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate=hibernateTemplate;
    }
    @Test
    int  check(String name,String pwd,int key){
        int level = 9;
        String sql ="from user where name = ?0 and pwd = ?1 ";
        if(key==1){
            sql+="and level < ?2";
        }else{
            sql+="and level >= ?2";
            level=3;
        }
        Object[]value={name,pwd,level};
        List<?> list= this .hibernateTemplate.find(sql,value);
        return list.size();
    }
    public int login(String name,String pwd,int key){
        int a = check(name, pwd, key);
        return a;
    }

    @Override
    public user getUser(int id) {
        user s = this.hibernateTemplate.get(user.class,id);
        return s;
    }

    @Override
    public void delete(Object u) {
        this.hibernateTemplate.delete(u);
    }

    @Override
    public void update(Object u) {
        this.hibernateTemplate.update(u);
    }

    public void save(Object user) {
        try {
            this.hibernateTemplate.save(user);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
}
