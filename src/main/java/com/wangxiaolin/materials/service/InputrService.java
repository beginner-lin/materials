package com.wangxiaolin.materials.service;

import com.wangxiaolin.materials.entity.Inputr;
import com.wangxiaolin.materials.mapper.InputrMapper;
import com.wangxiaolin.materials.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/2 - 14:37
 */
@Service
public class InputrService {
    @Autowired
    private InputrMapper inputrMapper;
    public List<Inputr> getInputrList(){ return  inputrMapper.queryInputrList(); }
    public Inputr getInputrById(int Mid){ return inputrMapper.getInputrById(Mid); }
    public List<Inputr> getInputrByKeywords(String Keywords){return inputrMapper.getInputrByKeywords(Keywords);}
    public void updateInputr(Inputr inputr){
        inputrMapper.updateInputr(inputr);
    }
    public void delInputrById(int Ino){
        inputrMapper.delInputrById(Ino);
    }
    public void delInputrByIds(int[] Inos){inputrMapper.delInputrByIds(Inos);}
    public void insertInputr(Inputr inputr){
        inputrMapper.insertInputr(inputr);
    }
}
