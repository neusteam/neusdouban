package com.zzh.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultSetToList {
public static <T> List<T> parseResultSet(ResultSet rs,Class<T> cls) {
		
        try {
            List<T> list=new ArrayList<>();
            //将查询的所有数据转换为对象添加到集合
            while(rs.next()){
                //实例化对象
                T obj=cls.newInstance();
                //获取类中所有的属性
                Field[] arrf=cls.getDeclaredFields();
                //遍历属性
                for(Field f:arrf){
                    //设置忽略访问校验
                    f.setAccessible(true);
                    //为属性设置内容
                    f.set(obj, rs.getObject(f.getName()));
                }
                list.add(obj);//添加到集合
            }
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
