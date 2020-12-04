package com.wangxiaolin.materials.service;

import com.wangxiaolin.materials.mapper.MaterialMapper;
import com.wangxiaolin.materials.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2019/12/20 - 15:07
 */
@Service
public class MaterialService {
    @Autowired
    private MaterialMapper materialMapper;
    public List<Material> getMaterialList(){ return  materialMapper.queryMaterialList(); }
    public Material getMaterialById(int Mid){ return materialMapper.getMaterialById(Mid); }
    public List<Material> getMaterialByKeywords(String Keywords){return materialMapper.getMaterialByKeywords(Keywords);}
    public void updateMaterial(Material material){
        materialMapper.updateMaterial(material);
    }
    public void delMaterialById(int Mid){
        materialMapper.delMaterialById(Mid);
    }
    public void delMaterialByIds(int[] Mids){materialMapper.delMaterialByIds(Mids);}
    public void insertMaterial(Material material){
        materialMapper.insertMaterial(material);
    }
}
