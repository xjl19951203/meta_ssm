package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.DeviceData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceDataDao extends ModelDao{

    List<DeviceData> selectDeviceDataListByInputFrameDataId (Integer pk);
}
