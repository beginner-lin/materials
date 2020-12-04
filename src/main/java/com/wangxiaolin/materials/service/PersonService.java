package com.wangxiaolin.materials.service;

import com.wangxiaolin.materials.entity.Person;
import com.wangxiaolin.materials.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/1 - 16:38
 */
@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;
    public List<Person> getPersonList(){ return  personMapper.queryPersonList(); }
    public List<Person> getPersonByKeywords(String Keywords){return personMapper.getPersonByKeywords(Keywords);}
    public List<Person> getPersonByRidAndPtype(String Ptype,int Rid){ return  personMapper.getPersonByRidAndPtype(Ptype,Rid); }
    public Person getPersonById(int Pid){ return personMapper.getPersonById(Pid); }
    public void updatePerson(Person person){
        personMapper.updatePerson(person);
    }
    public void delPersonById(int Pid){
        personMapper.delPersonById(Pid);
    }
    public void delPersonByIds(int[] Pids){personMapper.delPersonByIds(Pids);}
    public void insertPerson(Person person){
        personMapper.insertPerson(person);
    }

}
