package com.wangxiaolin.materials.mapper;

import com.wangxiaolin.materials.entity.Rest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/5 - 15:05
 */
@Mapper
public interface RestMapper {
    public List<Rest> queryRestList();
    public Rest getRestById(@Param("Mid")int Mid,@Param("Rid")int Rid);
    public List<Rest> getRestByKeywords(@Param("Keywords")String Keywords);
    public void updateRest(Rest rest);
    public void delRestById(@Param("Mid")int Mid,@Param("Rid")int Rid);
    public void insertRest(Rest rest);
}
