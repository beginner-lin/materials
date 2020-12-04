package com.wangxiaolin.materials.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangxiaolin.materials.common.AjaxResult;
import com.wangxiaolin.materials.common.ListToJson;
import com.wangxiaolin.materials.entity.Repository;
import com.wangxiaolin.materials.service.RepositoryService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2020/1/1 - 16:35
 */
@Controller
@RequestMapping(value = "/repository")
public class RepositoryController {
    @Autowired
    private RepositoryService repositoryService;
    private String keyword = null;

    @RequestMapping(value = "",method=RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "null",value = "keywords") String keywords){
        if(keywords != null&&!keywords.trim().equals("")){ keyword = keywords; }
        return "Warehouse/repositoryList";
    }
    @RequestMapping(value = "/getRepositoryList")
    @ResponseBody
    public AjaxResult getList(@RequestParam(defaultValue = "1",value = "page") Integer pageNum, @RequestParam(defaultValue = "8",value = "limit") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Repository> repositories =null;
        if(keyword.equals("null")){
            repositories = repositoryService.getRepositoryList();
        }else{
            repositories = repositoryService.getRepositoryByKeywords(keyword);
        }
        PageInfo<Repository> pageInfo = new PageInfo<Repository>(repositories);
        JSONArray json = ListToJson.repositoryToJson(pageInfo.getList());
        return AjaxResult.success(pageInfo.getTotal(),json);
    }
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String addMaterial(){
        return "Warehouse/addRepository";
    }
    @RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
    public void addRepository(Repository repository){
        try{
            repositoryService.insertRepository(repository);
//            return "success";
        }catch (Exception e){
            e.printStackTrace();
//            return "fail";
        }
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public void UpdateRepository(Repository repository){repositoryService.updateRepository(repository);}
    @RequestMapping(value="delete",method= RequestMethod.POST)
    @ResponseBody
    public void removeRepository(Integer Rid){ repositoryService.delRepositoryById(Rid); }
    @RequestMapping(value="deletes",method= RequestMethod.POST)
    @ResponseBody
    public void removeRepository(int[] Rids){ repositoryService.delRepositoryByIds(Rids);}
}
