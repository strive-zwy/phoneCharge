package com.zwy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ：zwy
 * @Date ：2020/12/30 16:22
 * @Version ：1.0
 * @Description ：话费充值系统 - 系统总流程
 **/

public class PhoneSystem {

    //读取 TXT 文档中的数据
    static List<Phone> list;
    static {
        try {
            list = (List<Phone>) DataInit.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static PhoneUtils utils = new PhoneUtils(list);
    static Scanner sc = new Scanner(System.in);
    //超级管理员账号信息
    String adminUser = "zzz";
    String adminPwd = "111";
    //普通管理员账号信息
    String user = "www";
    String pwd = "222";



    public static void adminUser() throws Exception {
        System.out.println("***************超级管理员登陆成功**************");
        while (true){
            System.out.println("1.查看系统所有信息");
            System.out.println("2.查看指定用户信息");
            System.out.println("3.在线选号");
            System.out.println("4.修改用户个人信息 ");
            System.out.println("5.话费充值");
            System.out.println("6.用户注销");
            System.out.println("7.导出数据");
            System.out.println("8.退出系统");
            System.out.println("请输入操作码：");
            int nn = sc.nextInt();
            switch (nn){
                case 1:
                    utils.getAllInfo();
                    break;
                case 2:
                    System.out.println("输入查看人的手机号码：");
                    String phoneNum = sc.next();
                    System.out.println("以下为该手机号的详细信息");
                    utils.getInfo(phoneNum);
                    break;
                case 3:
                    System.out.println("请从以下号码中挑选：");
                    while (true){
                        PhoneUtils.getPhoneNumber();
                        System.out.println("是否继续（y / n）");
                        String ifCon = sc.next();
                        if ("n".equals(ifCon)){
                            break;
                        }
                    }
                    System.out.println("请输入挑选的号码：");
                    String xuanNumber = sc.next();
                    System.out.println("请输入持卡人的姓名：");
                    String phoneName = sc.next();
                    Phone pp = new Phone(xuanNumber, 50,
                            phoneName,new Date(),new Date(),DataInit.getOperater());
                    utils.addPho(pp);
                    break;
                case 4:
                    System.out.println("输入修改的手机号码：");
                    String updatePh = sc.next();
                    System.out.println("输入修改后的持卡人：");
                    String updateName = sc.next();
                    utils.updatePho(updatePh,updateName);
                    break;
                case 5:
                    System.out.println("输入充值的手机号码：");
                    String chongPh = sc.next();
                    System.out.println("请输入充值的金额：");
                    double fff = sc.nextDouble();
                    utils.addPhoFee(chongPh,fff);
                    break;
                case 6:
                    System.out.println("输入注销的手机号码：");
                    String zhuxiao = sc.next();
                    utils.deletePhoById(zhuxiao);
                    break;
                case 7:
                    utils.exportTxt();
                    break;
                case 8:
                    DataInit.saveObject(utils.getList());
                    System.exit(0);
                default:
                    System.out.println("操作失误，请重新输入！");
                    adminUser();
            }
        }
    }

    public static void user() throws Exception {
        System.out.println("***************普通管理员登陆成功**************");
        while (true){
            System.out.println("1.查看系统所有信息");
            System.out.println("2.查看指定用户信息");
            System.out.println("3.话费充值");
            System.out.println("4.退出系统");
            System.out.println("请输入操作码：");
            int nn = sc.nextInt();
            switch (nn){
                case 1:
                    utils.getAllInfo();
                    break;
                case 2:
                    System.out.println("输入查看人的手机号码：");
                    String phoneNum = sc.next();
                    System.out.println("以下为该手机号的详细信息");
                    utils.getInfo(phoneNum);
                    break;
                case 3:
                    System.out.println("输入充值的手机号码：");
                    String phoneNumber = sc.next();
                    System.out.println("输入充值的数额：");
                    double fee = sc.nextDouble();
                    utils.addPhoFee(phoneNumber,fee);
                    break;
                case 4:
                    DataInit.saveObject(utils.getList());
                    System.exit(0);
                default:
                    System.out.println("操作失误，请重新输入！");
                    user();
            }
        }
    }


    public static void start() throws Exception {
        System.out.println("***************欢迎使用话费充值系统**************");
        while (true){
            System.out.println("1.登录系统");
            System.out.println("2.退出系统");
            System.out.println("请输入操作码：");
            int mun = sc.nextInt();
            switch (mun){
                case 1:
                    for (int i = 0; i < 3; i++) {
                        System.out.println("请输入登陆的用户名：");
                        String u = sc.next();
                        if ("zzz".equals(u)){
                            System.out.println("请输入登陆的密码：");
                            String p = sc.next();
                            if ("111".equals(p)){
                                adminUser();
                            }
                            System.out.println("密码错误！");
                        }else if ("www".equals(u)){
                            System.out.println("请输入登陆的密码：");
                            String p = sc.next();
                            if ("222".equals(p)){
                                user();
                            }
                            System.out.println("密码错误！");
                        }else {
                            System.out.println("密码或用户名错误，请重新登录！");
                        }
                    }
                    System.out.println("3次登录机会已用完，系统退出！");
                    DataInit.saveObject(utils.getList());
                    System.exit(0);
                case 2:
                    DataInit.saveObject(utils.getList());
                    System.exit(0);
                default:
                    System.out.println("操作失误，请重新输入！");
                    start();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        start();
    }
}
