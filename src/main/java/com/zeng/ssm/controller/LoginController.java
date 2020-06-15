package com.zeng.ssm.controller;


import com.alibaba.fastjson.JSON;
import com.zeng.ssm.dao.UserDao;
import com.zeng.ssm.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class LoginController {

    @Resource
    UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User register(@RequestBody String record) {
//        System.out.println(record);
        User temp = JSON.parseObject(record,User.class);
//        System.out.println(temp.getUserName());
        List<User> list = this.userDao.selectAll();
        System.out.println(list);
        for (User user:list) {
            //邮箱或者用户名重复注册不成功
          if ((user.getEmail().equals(temp.getEmail()))||(user.getUserName().equals(temp.getUserName()))) {
              System.out.println("0");
              return null;
          }
        }
        System.out.println("1");
        int pk = this.userDao.insert(temp);
        return this.userDao.selectByPrimaryKey(pk);
    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public User login(@RequestBody String record) {
        User temp = JSON.parseObject(record,User.class);
        List<User> list = this.userDao.selectAll();
        for (User user:list) {
            if (user.getUserName().equals(temp.getUserName())) {
                if (user.getPassword().equals(temp.getPassword())) {
                    System.out.println("yes");
                    return user;//用户名存在且密码正确返回User对象
                }else {
                    System.out.println("no");
                    return temp;//用户名存在但密码错误，返回表单对象，此时邮箱为空
                }
            }
        }
        System.out.println("0");
        return null;//用户名不存在，直接返回空值
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public List<User> getLists() {
//        return this.userDao.selectAll();
//    }
}
