package com.vienna.dao;

import com.vienna.model.Updatelog;
import com.vienna.model.UpdatelogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatelogMapper {
    int countByExample(UpdatelogExample example);

    int deleteByExample(UpdatelogExample example);

    int deleteByPrimaryKey(String id);

    int insert(Updatelog record);

    int insertSelective(Updatelog record);

    List<Updatelog> selectByExample(UpdatelogExample example);

    Updatelog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Updatelog record, @Param("example") UpdatelogExample example);

    int updateByExample(@Param("record") Updatelog record, @Param("example") UpdatelogExample example);

    int updateByPrimaryKeySelective(Updatelog record);

    int updateByPrimaryKey(Updatelog record);
}
