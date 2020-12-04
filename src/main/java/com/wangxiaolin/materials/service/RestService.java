package com.wangxiaolin.materials.service;

import com.wangxiaolin.materials.entity.Rest;
import com.wangxiaolin.materials.mapper.RestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/5 - 15:08
 */
@Service
public class RestService {
    @Autowired
    private RestMapper restMapper;
    public List<Rest> getRestList(){ return  restMapper.queryRestList(); }
    public Rest getRestById(int Mid,int Rid){ return restMapper.getRestById(Mid,Rid); }
    public List<Rest> getRestByKeywords(String Keywords){return restMapper.getRestByKeywords(Keywords);}
    public void updateRest(Rest rest){
        restMapper.updateRest(rest);
    }
    public void delRestById(int Mid,int Rid){
        restMapper.delRestById(Mid,Rid);
    }
    public void insertRest(Rest material){
        restMapper.insertRest(material);
    }
}
