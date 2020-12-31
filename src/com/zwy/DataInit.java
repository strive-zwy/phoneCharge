package com.zwy;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLFault;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author ：zwy
 * @Date ：2020/12/30
 * @Version ：1.0
 * @Description ：话费充值系统 - 数据初始化；添加测试数据；保存数据
 **/

public class DataInit {

	/*public static List<Phone> PhoneInit(){
        List<Phone> list = new ArrayList<Phone>();
        Phone p1 = new Phone("15890632278" , 58.8,
                "zwy",getDateTime("2020-06-22 15:26:33"),
                getDateTime("2020-06-22 15:26:33"),getOperater());
		Phone p2 = new Phone(PhoneUtils.getTel(), 32.5,
                "zfj",getDateTime("2020-08-24 12:44:43"),
                getDateTime("2020-08-24 12:44:43"),getOperater());
		Phone p3 = new Phone(PhoneUtils.getTel() , 15.3,
                "cx",getDateTime("2020-05-12 15:26:45"),
                getDateTime("2020-05-12 15:26:45"),getOperater());
		Phone p4 = new Phone(PhoneUtils.getTel() , 22.6,
                "dhf",getDateTime("2020-11-23 14:34:13"),
                getDateTime("2020-11-23 14:34:13"),getOperater());
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		return list;
	}*/

    // 保存对象，序列化
    public static void saveObject(Object object) throws Exception {
        try (FileOutputStream fout = new FileOutputStream("data.txt");
             ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(object);
        }
    }

    // 读取对象，反序列化
    public static Object readObject() throws Exception {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        Object object = null;
        try {
            fin = new FileInputStream("data.txt");
            in = new ObjectInputStream(fin);
            object = in.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert fin != null;
            fin.close();
            assert in != null;
            in.close();
        }
        return object;
    }

    //随机生成运营商
    public static String getOperater(){
        String[] doc = {"电信", "移动", "联通"};
        int index = (int) (Math.random() * doc.length);
        return doc[index];
    }

	public static Date getDateTime(String dateStr){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*public static void main(String[] args) throws Exception {
        saveObject(PhoneInit());
        List<Phone>  list = (List<Phone>) DataInit.readObject();
        list.forEach(Phone::showAllInfo);
    }*/

}
