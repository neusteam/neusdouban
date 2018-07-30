package com.zzh.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultSetToList {
public static <T> List<T> parseResultSet(ResultSet rs,Class<T> cls) {
		
        try {
            List<T> list=new ArrayList<>();
            //����ѯ����������ת��Ϊ������ӵ�����
            while(rs.next()){
                //ʵ��������
                T obj=cls.newInstance();
                //��ȡ�������е�����
                Field[] arrf=cls.getDeclaredFields();
                //��������
                for(Field f:arrf){
                    //���ú��Է���У��
                    f.setAccessible(true);
                    //Ϊ������������
                    f.set(obj, rs.getObject(f.getName()));
                }
                list.add(obj);//��ӵ�����
            }
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
