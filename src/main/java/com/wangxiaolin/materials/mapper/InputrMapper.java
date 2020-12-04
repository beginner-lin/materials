package com.wangxiaolin.materials.mapper;

import com.wangxiaolin.materials.entity.Inputr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/2 - 14:35
 */
@Mapper
public interface InputrMapper {
    public List<Inputr> queryInputrList();
    public Inputr getInputrById(int Ino);
    public List<Inputr> getInputrByKeywords(@Param("Keywords")String Keywords);
    public void updateInputr(Inputr inputr);
    public void delInputrById(int Ino);
    public void delInputrByIds(@Param("Inos")int[] Inos);
    public void insertInputr(Inputr inputr);
}
