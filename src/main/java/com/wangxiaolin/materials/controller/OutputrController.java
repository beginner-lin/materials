package com.wangxiaolin.materials.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangxiaolin.materials.common.AjaxResult;
import com.wangxiaolin.materials.common.ListToJson;
import com.wangxiaolin.materials.entity.*;
import com.wangxiaolin.materials.service.*;
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
 * @date 2020/1/2 - 14:40
 */
@Controller
@RequestMapping(value = "/outputr")
public class OutputrController {
    @Autowired
    private OutputrService outputrService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private PersonService personService;
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
    public ModelAndView addOutputr(){
        List<Material> materials = materialService.getMaterialList();
        List<Repository> repositories = repositoryService.getRepositoryList();
        modelAndView.clear();
        modelAndView.setViewName("Management/addOutputr");
        modelAndView.addObject("materials",materials);
        modelAndView.addObject("repositories",repositories);
        return  modelAndView;
    }
    @RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
    public void addInputr(Outputr outputr){
        try{
            outputrService.insertOutputr(outputr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping(value="/update",method = RequestMethod.GET)
    public ModelAndView UpdateOutputr(@RequestParam("Ono") Integer Ono){ return setModelAndView(Ono,'P'); }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public void UpdateOutputr(Outputr outputr){outputrService.updateOutputr(outputr);}
    @RequestMapping(value="/delete",method= RequestMethod.POST)
    @ResponseBody
    public void removeOutputr(Integer Ono){ outputrService.delOutputrById(Ono); }
    @RequestMapping(value="/deletes",method= RequestMethod.POST)
    @ResponseBody
    public void removeOutputr(int[] Onos){ outputrService.delOutputrByIds(Onos);}
    private  ModelAndView setModelAndView(Object parm,char type){
        modelAndView.clear();
        List<Outputr> outputrs =null;
        PageInfo<Outputr> pageInfo = null;
        switch (type){
            case 'L':
                outputrs =outputrService.getOutputrList();
                pageInfo = new PageInfo<Outputr>(outputrs);
                modelAndView.setViewName("Management/OutputrList");
                modelAndView.addObject("pageInfo",pageInfo);
                modelAndView.addObject("jsonList",getJsonList(outputrs));
                break;
            case 'K':
                outputrs = outputrService.getOutputrByKeywords(String.valueOf(parm));
                pageInfo = new PageInfo<Outputr>(outputrs);
                modelAndView.setViewName("Management/OutputrList");
                modelAndView.addObject("pageInfo",pageInfo);
                modelAndView.addObject("jsonList",getJsonList(outputrs));
                break;
            case 'P':
                Outputr outputr = outputrService.getOutputrById(Integer.parseInt(String.valueOf(parm)));
                List<Material> materials = materialService.getMaterialList();
                List<Repository> repositories = repositoryService.getRepositoryList();
                modelAndView.setViewName("Management/updateOutputr");
                modelAndView.addObject("outputr",outputr);
                modelAndView.addObject("materials",materials);
                modelAndView.addObject("repositories",repositories);
                break;
        }
        return modelAndView;
    }
    private  JSONArray getJsonList(List<Outputr> outputrs){
        List<String> materialNames = new ArrayList<String>();
        List<String> repositoryNames = new ArrayList<String>();
        List<String> usePersonNames = new ArrayList<String>();
        List<String> dealPersonNames = new ArrayList<String>();

        for(int i=0;i<outputrs.size();i++)
        {
            Outputr inputr = outputrs.get(i);
            Material material = materialService.getMaterialById(inputr.getMid());
            Repository repository= repositoryService.getRepositoryById(inputr.getRid());
            Person userPerson = personService.getPersonById(inputr.getUser_Pid());
            Person dealPerson = personService.getPersonById(inputr.getDeal_Pid());
            materialNames.add(material.getMname());
            repositoryNames.add(repository.getRname());
            usePersonNames.add(userPerson.getPname());
            dealPersonNames.add(dealPerson.getPname());
        }
        JSONArray json = ListToJson.outputrToJson(outputrs,materialNames,repositoryNames,usePersonNames,dealPersonNames);
        return json;
    }
}
