package com.wangxiaolin.materials.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangxiaolin.materials.common.AjaxResult;
import com.wangxiaolin.materials.common.ListToJson;
import com.wangxiaolin.materials.entity.Material;
import com.wangxiaolin.materials.service.MaterialService;
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
 * @date 2019/12/20 - 14:55
 */
@Controller
@RequestMapping(value = "/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    private String keyword = null;

//    private ModelAndView modelAndView = new ModelAndView();
//    private ObjectMapper objectMapper = new ObjectMapper();
//    private String resultList = null;
    @RequestMapping(value = "",method=RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "null",value = "keywords") String keywords){
        if(keywords != null&&!keywords.trim().equals("")){ keyword = keywords; }
        return "Materials/materialList";
    }
    @RequestMapping(value = "/getMaterialList")
    @ResponseBody
    public AjaxResult getList(@RequestParam(defaultValue = "1",value = "page") Integer pageNum, @RequestParam(defaultValue = "8",value = "limit") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Material> materials =null;
        if(keyword.equals("null")){
            materials = materialService.getMaterialList();
        }else{
            materials = materialService.getMaterialByKeywords(keyword);
        }
        PageInfo<Material> pageInfo = new PageInfo<Material>(materials);
        JSONArray json = ListToJson.materialToJson(pageInfo.getList());
        return AjaxResult.success(pageInfo.getTotal(),json);
    }
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String addMaterial(){
        return "Materials/addMaterial";
    }
    @RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
    public void addMaterial(Material material){
        try{
            materialService.insertMaterial(material);
//            return "success";
        }catch (Exception e){
            e.printStackTrace();
//            return "fail";
        }
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public void UpdateMaterial(Material material){materialService.updateMaterial(material);}
    @RequestMapping(value="delete",method= RequestMethod.POST)
    @ResponseBody
    public void removeMaterial(Integer Mid){ materialService.delMaterialById(Mid); }
    @RequestMapping(value="deletes",method= RequestMethod.POST)
    @ResponseBody
    public void removeMaterials(int[] Mids){ materialService.delMaterialByIds(Mids);}
}
