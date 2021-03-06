package com.zwy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author ：zwy
 * @Date ：2020/12/30
 * @Version ：1.0
 * @Description ：话费充值系统 - 处理信息的工具类
 **/

public class PhoneUtils {

	private List<Phone> list;
	private static PhoneUtils utils;

	public List<Phone> getList() {
		return list;
	}

	//单例模式 - 懒汉式
	public synchronized static PhoneUtils getInstance(List<Phone> list){
		if (utils == null)
			utils = new PhoneUtils();
		utils.list = list;
		return utils;
	}

	//添加信息
	public void addPho(Phone pho){
		if(list.contains(pho)){
			System.out.println("该信息已存在");
			return;
		}
		list.add(pho);
		System.out.println("添加成功");
	}

	//删除（修改用户状态）
	public void deletePhoById(String phoneNum){
		for(Phone p : list){
			if(phoneNum.equals(p.getPhoneNum()) ){
				p.setState(0);// 修改用户状态为已注销
				p.setUpdateDate(new Date());//更新修改时间
				System.out.println("注销成功");
				return;
			}
		}
		System.out.println("该信息不存在");
	}

	//修改用户信息
	public void updatePho(String phoneNum, String PhName){
		for(Phone p : list){
			if(phoneNum.equals(p.getPhoneNum())){
				p.setName(PhName);
				p.setUpdateDate(new Date());
				System.out.println("修改成功");
				return;
			}
		}
		System.out.println("该信息不存在");
	}
	//显示所有信息
	public void getAllInfo(){
		System.out.println("持卡人姓名\t电话号码\t\t\t\t当前话费\t\t当前状态");
		list.forEach(Phone::showInfo);
	}

	//显示个人详细信息
	public void getInfo(String phoneNum){
		for(Phone p : list){
			if(phoneNum.equals(p.getPhoneNum())){
				p.showAllInfo();
				return;
			}
		}
		System.out.println("该信息不存在！");
	}

	//充值话费
	public void addPhoFee(String phoneNum , double fee){
		for(Phone p : list){
			if(phoneNum.equals(p.getPhoneNum())){
				p.addFee(fee);
				System.out.println("充值成功！当前余额为：" + p.getCurrentFee());
				return;
			}
		}
		System.out.println("充值失败！该手机号不在该系统中。");
	}

	//随机生成一组（5个）手机号码
	public static void getPhoneNumber(){
		for (int i = 0; i < 5; i++) {
			System.out.println(getTel());
		}
	}

	//随机生成手机号码
	public static int getNum(int start,int end) {
		return (int)(Math.random()*(end-start+1)+start);
	}
	private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
	public static String getTel() {
		int index=getNum(0,telFirst.length-1);
		String first=telFirst[index];
		String second=String.valueOf(getNum(1,888)+10000).substring(1);
		String third=String.valueOf(getNum(1,9100)+10000).substring(1);
		return first+second+third;
	}

	//导出数据
	public void exportTxt(){
		String fileUrl = "exportInfo.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileUrl,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("姓名\t\t\t电话号码\t\t\t当前话费\t\t\t运营商" +
					"\t\t\t开户时间\t\t\t\t当前状态");
			bw.newLine();
			for (Phone p: list) {
				bw.write(p.exportInfo());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("导出成功！");
	}


}
