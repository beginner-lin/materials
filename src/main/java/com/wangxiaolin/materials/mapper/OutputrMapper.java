package com.wangxiaolin.materials.mapper;

import com.wangxiaolin.materials.entity.Outputr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/2 - 14:35
 */
@Mapper
public interface OutputrMapper {
    public List<Outputr> queryOutputrList();
    public Outputr getOutputrById(int Ono);
    public List<Outputr> getOutputrByKeywords(@Param("Keywords")String Keywords);
    public void updateOutputr(Outputr outputr);
    public void delOutputrById(int Ono);
    public void delOutputrByIds(@Param("Onos")int[] Onos);
    public void insertOutputr(Outputr outputr);
}
