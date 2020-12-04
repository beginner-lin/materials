package com.wangxiaolin.materials.mapper;

import com.wangxiaolin.materials.entity.Repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/1 - 16:37
 */
@Mapper
public interface RepositoryMapper {
    public List<Repository> queryRepositoryList();
    public Repository getRepositoryById(int Rid);
    public List<Repository> getRepositoryByKeywords(@Param("Keywords")String Keywords);
    public void updateRepository(Repository repository);
    public void delRepositoryById(int Rid);
    public void delRepositoryByIds(@Param("Rids")int[] Rids);
    public void insertRepository(Repository repository);
}
