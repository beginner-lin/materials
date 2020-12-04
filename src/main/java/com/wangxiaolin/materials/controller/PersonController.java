package com.wangxiaolin.materials.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangxiaolin.materials.common.AjaxResult;
import com.wangxiaolin.materials.common.ListToJson;
import com.wangxiaolin.materials.entity.Person;
import com.wangxiaolin.materials.entity.Repository;
import com.wangxiaolin.materials.service.PersonService;
import com.wangxiaolin.materials.service.RepositoryService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/1 - 16:34
 */
@Controller
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private RepositoryService repositoryService;
    private ModelAndView modelAndView = new ModelAndView();
    private String keyword = null;
    private static int reset = 0;

    @RequestMapping(value = "",method= RequestMethod.GET)
    public ModelAndView getList(@RequestParam(defaultValue = "1",value = "pageNo") Integer pageNum,@RequestParam(defaultValue = "",value = "keywords") String keywords){
        PageHelper.startPage(pageNum,8);
        if(reset == 1) {
            reset = 0;
            keyword=null;
            PageHelper.clearPage();
            PageHelper.startPage(1,8);
            return setModelAndView(null,'L');
        }
        if(!keywords.trim().equals("")) {
            keyword = keywords;
        }
        if(null == keyword) return setModelAndView(null,'L');
        return setModelAndView(keyword,'K');
    }
    @RequestMapping(value="/refresh",method= RequestMethod.GET)
    @ResponseBody
    public void refreshList(){
        reset = 1;
    }
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public ModelAndView addPerson(){
        List<Repository> repositories = repositoryService.getRepositoryList();
        modelAndView.clear();
        modelAndView.setViewName("RelatedPerson/addPerson");
        modelAndView.addObject("repositories",repositories);
        return  modelAndView;
    }
    @RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
    public void addPerson(Person person){
        try{
            personService.insertPerson(person);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping(value="/update",method = RequestMethod.GET)
    public ModelAndView UpdatePerson(@RequestParam("Pid") Integer Pid){
        return setModelAndView(Pid,'P');
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public void UpdatePerson(Person person){personService.updatePerson(person);}
    @RequestMapping(value="delete",method= RequestMethod.POST)
    @ResponseBody
    public void removePerson(Integer Pid){ personService.delPersonById(Pid); }
    @RequestMapping(value="deletes",method= RequestMethod.POST)
    @ResponseBody
    public void removePersons(int[] Pids){ personService.delPersonByIds(Pids);}
    @RequestMapping(value="/getPersonByRid",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getPersonByRidAndPtype(@RequestParam(value = "Ptype") String Ptype,@RequestParam(value = "Rid") Integer Rid){
        List<Person> personList = personService.getPersonByRidAndPtype(Ptype,Rid);
        return AjaxResult.success(200,"ok",personList);
    }
    private  ModelAndView setModelAndView(Object parm,char type){
        modelAndView.clear();
        List<Person> personList =null;
        PageInfo<Person> pageInfo = null;
        switch (type){
            case 'L':
                personList =personService.getPersonList();
                pageInfo = new PageInfo<Person>(personList);
                modelAndView.setViewName("RelatedPerson/personList");
                modelAndView.addObject("pageInfo",pageInfo);
                modelAndView.addObject("jsonList",getJsonList(personList));
                break;
            case 'K':
                personList = personService.getPersonByKeywords(String.valueOf(parm));
                pageInfo = new PageInfo<Person>(personList);
                modelAndView.setViewName("RelatedPerson/personList");
                modelAndView.addObject("pageInfo",pageInfo);
                modelAndView.addObject("jsonList",getJsonList(personList));
                break;
            case 'P':
                Person person = personService.getPersonById(Integer.parseInt(String.valueOf(parm)));
                List<Repository> repositories = repositoryService.getRepositoryList();
                modelAndView.setViewName("RelatedPerson/updatePerson");
                modelAndView.addObject("person",person);
                modelAndView.addObject("repositories",repositories);
                break;
        }
        return modelAndView;
    }
    private  JSONArray getJsonList(List<Person> personList){
        List<String> repositoryNames = new ArrayList<String>();
        for(int i=0;i<personList.size();i++)
        {
            Person p = personList.get(i);
            Repository repository= repositoryService.getRepositoryById(p.getRid());
            repositoryNames.add(repository.getRname());
        }
        JSONArray json = ListToJson.personToJson(personList,repositoryNames);
        return json;
    }
}
