package com.wangxiaolin.materials.mapper;

import com.wangxiaolin.materials.entity.Material;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2019/12/20 - 14:34
 */
@Mapper
public interface MaterialMapper {
    public List<Material> queryMaterialList();
    public Material getMaterialById(int Mid);
    public List<Material> getMaterialByKeywords(@Param("Keywords")String Keywords);
    public void updateMaterial(Material material);
    public void delMaterialById(int Mid);
    public void delMaterialByIds(@Param("Mids")int[] Mids);
    public void insertMaterial(Material material);
}
