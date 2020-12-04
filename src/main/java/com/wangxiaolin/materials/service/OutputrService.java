package com.wangxiaolin.materials.service;

import com.wangxiaolin.materials.entity.Outputr;
import com.wangxiaolin.materials.mapper.OutputrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/2 - 14:37
 */
@Service
public class OutputrService {
    @Autowired
    private OutputrMapper OutputrMapper;
    public List<Outputr> getOutputrList(){ return  OutputrMapper.queryOutputrList(); }
    public Outputr getOutputrById(int Mid){ return OutputrMapper.getOutputrById(Mid); }
    public List<Outputr> getOutputrByKeywords(String Keywords){return OutputrMapper.getOutputrByKeywords(Keywords);}
    public void updateOutputr(Outputr outputr){
        OutputrMapper.updateOutputr(outputr);
    }
    public void delOutputrById(int Ono){
        OutputrMapper.delOutputrById(Ono);
    }
    public void delOutputrByIds(int[] Onos){OutputrMapper.delOutputrByIds(Onos);}
    public void insertOutputr(Outputr outputr){
        OutputrMapper.insertOutputr(outputr);
    }
}
