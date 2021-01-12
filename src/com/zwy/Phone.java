package com.zwy;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ：zwy
 * @Date ：2020/12/30
 * @Version ：1.0
 * @Description ：话费充值系统 - 电话实体类
 **/

public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	private String phoneNum;	//电话号码
	private double currentFee;	//当前话费
	private String name;	//持卡人姓名
	private Date startDate;	//开户时间
	private Date updateDate; //修改时间
	private String operator; //运营商
	private int state = 1; //账户状态   1 - 正在使用；0 - 已注销

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public double getCurrentFee() {
		return currentFee;
	}

	public void setCurrentFee(double currentFee) {
		this.currentFee = currentFee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getState() {
		return state == 1 ? "正在使用" : "已注销";
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	//带参数的构造方法
	public Phone(String phoneNum, double currentFee, String name, Date startDate,
				 Date updateDate, String operator) {
		this.phoneNum = phoneNum;
		this.currentFee = currentFee;
		this.name = name;
		this.startDate = startDate;
		this.updateDate = updateDate;
		this.operator = operator;
	}

	//充话费
	public void addFee(double fee){
		if (fee > 0){
			currentFee = currentFee + fee;
			return;
		}
		System.out.println("充值数额输入错误！");
	}

	//显示全部详细信息
	public void showAllInfo(){
		System.out.println("持卡人姓名：\t" + name);
		System.out.println("手机号：\t" + phoneNum);
		System.out.println("当前话费：\t" + currentFee);
		System.out.println("运营商：\t" + operator);
		System.out.println("开户时间：\t" + getTime(startDate));
		System.out.println("当前状态：\t" + getState());
	}

	//导出个人信息
	public String  exportInfo(){
		return name + "\t\t\t" + phoneNum + "\t\t\t" + currentFee+ "\t\t\t" +
				operator+ "\t\t\t" + getTime(startDate)+ "\t\t\t" + getState();
	}

	//显示个人信息
	public void showInfo(){
		System.out.println(name + "\t\t\t" + phoneNum + "\t\t\t" + currentFee+ "\t\t" + getState());
	}
	//日期格式转为字符串格式
	public static String getTime(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

}
