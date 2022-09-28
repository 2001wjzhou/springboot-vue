package com.yhc.cxjwadmin.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yhc.cxjwadmin.entity.Dept;
import org.springframework.stereotype.Component;
import java.util.List;
/**
 * 将前端传过来的json字符串转成java对象
 * 将java对象转成json字符串
 */
@Component
public class JsonTools<T> {
    /**
     * 1.使用fastJson将json字符串数组转成Lsit
     * String json={'arr':[{},{},{}],'info':"你好吗"}
     * @param json
     * @param <T> 表示此方法为泛型方法
     * @return
     */
    public <T> List<T> jsonToList(String json,T t) {
        JSONObject obj = (JSONObject) JSONObject.parse(json);
        JSONArray array = obj.getJSONArray("arr");;
        List<T> list = (List<T>) array.toJavaList(t.getClass());
        return list;
    }

    /**
     *
     * @param json
     * @param t 传入的实际对象
     * @param <T>表示声明此方法要使用泛型，T为此方法的返回类型
     * @return
     */
    public <T> T jsonToObj(String json,T t) {
        JSONObject obj = (JSONObject) JSONObject.parse(json);
        JSONObject oj = (JSONObject) obj.get("oj");

        T temp = (T) oj.toJavaObject(t.getClass());
        return temp;
    }

    ////测试一下
    public static void main(String[] args) {
        JsonTools<Dept> jt= new JsonTools<>();
        //1.数组字符串
        String json = "{'arr':[{'dname':'技术部','did':'105','tel':'13120007898'},{'dname':'销售部','did':'108','tel':'13801239878'}]}";
        List<Dept> list=jt.jsonToList(json,new Dept());
        System.out.println("----json字符串通用生成list----");
        System.out.println(list);
        System.out.println(list.get(1).getDname()+":"+list.get(1).getTel());
        //2.字符串
        System.out.println("----json字符串通用生成对象----");
        String j = "{'oj':{'dname':'行政部','did':'103','tel':'131900055815'}}";
        Dept dept=jt.jsonToObj(j,new Dept());
        System.out.println(dept);
        System.out.println(dept.getDname()+":"+dept.getTel()+":"+dept.getDid());
    }
}
