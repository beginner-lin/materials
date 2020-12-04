package com.wangxiaolin.materials.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @date 2020/1/5 - 15:21
 */
@Controller
@RequestMapping(value = "/rest")
public class RestController {
    @Autowired
    private RestService restService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private RepositoryService repositoryService;
    private ModelAndView modelAndView = new ModelAndView();
    private String keyword = null;
    private static int reset = 0;

    @RequestMapping(value = "",method= RequestMethod.GET)
    public ModelAndView getList(@RequestParam(defaultValue = "1",value = "pageNo") Integer pageNum, @RequestParam(defaultValue = "",value = "keywords") String keywords){
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
    private  ModelAndView setModelAndView(Object parm,char type){
        modelAndView.clear();
        List<Rest> rests =null;
        PageInfo<Rest> pageInfo = null;
        switch (type){
            case 'L':
                rests =restService.getRestList();
                pageInfo = new PageInfo<Rest>(rests);
                modelAndView.setViewName("Management/restList");
                modelAndView.addObject("pageInfo",pageInfo);
                modelAndView.addObject("jsonList",getJsonList(rests));
                break;
            case 'K':
                rests = restService.getRestByKeywords(String.valueOf(parm));
                pageInfo = new PageInfo<Rest>(rests);
                modelAndView.setViewName("Management/restList");
                modelAndView.addObject("pageInfo",pageInfo);
                modelAndView.addObject("jsonList",getJsonList(rests));
                break;
        }
        return modelAndView;
    }
    private JSONArray getJsonList(List<Rest> rests){
        List<String> materialNames = new ArrayList<String>();
        List<String> repositoryNames = new ArrayList<String>();
        for(int i=0;i<rests.size();i++)
        {
            Rest rest = rests.get(i);
            Material material = materialService.getMaterialById(rest.getMid());
            Repository repository= repositoryService.getRepositoryById(rest.getRid());
            materialNames.add(material.getMname());
            repositoryNames.add(repository.getRname());
        }
        JSONArray json = ListToJson.restToJson(rests,materialNames,repositoryNames);
        return json;
    }
}
