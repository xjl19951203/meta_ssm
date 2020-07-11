package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.Device;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceDao extends ModelDao{
    Device selectByDeviceName(String deviceName);
}
