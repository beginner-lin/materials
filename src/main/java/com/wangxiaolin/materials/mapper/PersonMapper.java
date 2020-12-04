package com.wangxiaolin.materials.mapper;

import com.wangxiaolin.materials.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/1 - 16:38
 */
@Mapper
public interface PersonMapper {
    public List<Person> queryPersonList();
    public List<Person> getPersonByKeywords(@Param("Keywords")String Keywords);
    public List<Person>  getPersonByRidAndPtype(@Param("Ptype")String Ptype,@Param("Rid")int Rid);
    public Person getPersonById(int Pid);
    public void updatePerson(Person person);
    public void delPersonById(int Pid);
    public void delPersonByIds(@Param("Pids")int[] Pids);
    public void insertPerson(Person person);
}
