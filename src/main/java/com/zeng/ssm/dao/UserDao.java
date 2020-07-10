package com.zeng.ssm.dao;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserDao extends ModelDao {

    List<AbstractModel> selectAll();

    List<User> selectByRegister(User record);

    User selectByLogin(User record);

    int insert(User record);

    User selectByPrimaryKey(Integer pk);

    User selectByUserName(String userName);
}
