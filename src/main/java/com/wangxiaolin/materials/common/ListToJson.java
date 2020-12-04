package com.wangxiaolin.materials.common;

import com.wangxiaolin.materials.entity.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @author wangxiaolin
 * @date 2019/12/26 - 11:57
 */
public class ListToJson {
    private static JSONArray json = new JSONArray();
    private static JSONObject jo = new JSONObject();
    public static JSONArray StringToJson(String str){
        jo.clear();
        json.clear();
        jo.put("imgurl",str);
        json.add(jo);
        return json;
    }
    public static JSONArray materialToJson(List<Material> materials ){
        jo.clear();
        json.clear();
        for (Material m: materials) {
            jo.put("Mid",m.getMid());
            jo.put("Mname",m.getMname());
            jo.put("spec",m.getSpec());
            jo.put("category",m.getCategory());
            jo.put("unit",m.getUnit());
            jo.put("price",m.getPrice());
            json.add(jo);
//          System.out.println(jo);
        }
        return json;
    }
    public static JSONArray personToJson(List<Person> personList,List<String> repositoryNames){
        jo.clear();
        json.clear();
        for (int i=0;i<personList.size();i++) {
            jo.put("Pid",personList.get(i).getPid());
            jo.put("Ptype",personList.get(i).getPtype());
            jo.put("Pname",personList.get(i).getPname());
            jo.put("Rid",personList.get(i).getRid());
            jo.put("Rname",repositoryNames.get(i));
            json.add(jo);
        }
        return json;
    }
    public static JSONArray inputrToJson(List<Inputr> inputrs, List<String> materialNames,List<String> repositoryNames,List<String> delPersonNames,List<String> savePersonNames){
        jo.clear();
        json.clear();
        for (int i=0;i<inputrs.size();i++) {
            jo.put("Ino",inputrs.get(i).getIno());
            jo.put("Mid",inputrs.get(i).getMid());
            jo.put("Rid",inputrs.get(i).getRid());
            jo.put("count",inputrs.get(i).getCount());
            jo.put("value",inputrs.get(i).getValue());
            jo.put("dateTime",inputrs.get(i).getDateTime());
            jo.put("deal_Pid",inputrs.get(i).getDeal_Pid());
            jo.put("save_Pid",inputrs.get(i).getSave_Pid());
            jo.put("remark",inputrs.get(i).getRemark());
            jo.put("Mname",materialNames.get(i));
            jo.put("Rname",repositoryNames.get(i));
            jo.put("delPname",delPersonNames.get(i));
            jo.put("savePname",savePersonNames.get(i));
            json.add(jo);
        }
        return json;
    }
    public static JSONArray outputrToJson(List<Outputr> outputrs, List<String> materialNames, List<String> repositoryNames, List<String> usePersonNames, List<String> dealPersonNames){
        jo.clear();
        json.clear();
        for (int i=0;i<outputrs.size();i++) {
            jo.put("Ono",outputrs.get(i).getOno());
            jo.put("Mid",outputrs.get(i).getMid());
            jo.put("Rid",outputrs.get(i).getRid());
            jo.put("count",outputrs.get(i).getCount());
            jo.put("value",outputrs.get(i).getValue());
            jo.put("dateTime",outputrs.get(i).getDateTime());
            jo.put("user_Pid",outputrs.get(i).getUser_Pid());
            jo.put("deal_Pid",outputrs.get(i).getDeal_Pid());
            jo.put("remark",outputrs.get(i).getRemark());
            jo.put("Mname",materialNames.get(i));
            jo.put("Rname",repositoryNames.get(i));
            jo.put("usePname",usePersonNames.get(i));
            jo.put("dealPname",dealPersonNames.get(i));
            json.add(jo);
        }
        return json;
    }
    public static JSONArray restToJson(List<Rest> rests, List<String> materialNames, List<String> repositoryNames){
        jo.clear();
        json.clear();
        for (int i=0;i<rests.size();i++) {
            jo.put("Mid",rests.get(i).getMid());
            jo.put("Rid",rests.get(i).getRid());
            jo.put("count",rests.get(i).getCount());
            jo.put("value",rests.get(i).getValue());
            jo.put("remark",rests.get(i).getRemark());
            jo.put("Mname",materialNames.get(i));
            jo.put("Rname",repositoryNames.get(i));
            json.add(jo);
        }
        return json;
    }
    public static JSONArray repositoryToJson(List<Repository> repositories ){
        jo.clear();
        json.clear();
        for (Repository r: repositories) {
            jo.put("Rid",r.getRid());
            jo.put("Rname",r.getRname());
            jo.put("Remark",r.getRemark());
            json.add(jo);
        }
        return json;
    }
}
