package com.thunisoft.tool.cz.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author chenzhen-1
 * @date 2019年7月3日-下午4:39:59
 *	数据项信息：存放数据项的信息
 **/
public class Sjxxx {
	
	/**
	 * 页签名
	 */
	private String sheetName;
	
	/**
	 * 行坐标
	 */
	private int hzb;
	
	/**
	 * 表名
	 */
	private String bm;
	
	/**
	 * 数据项路径
	 */
	private String sjllj;
	
	/**
	 * 数据项名称
	 */
	private String sjlmc;
	
	
	/**
	 * 额外数据
	 */
	private Map<String,Object> extraMap = new HashMap<>();

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public int getHzb() {
		return hzb;
	}

	public void setHzb(int hzb) {
		this.hzb = hzb;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getSjllj() {
		return sjllj;
	}

	public void setSjllj(String sjllj) {
		this.sjllj = sjllj;
	}

	public Map<String, Object> getExtraMap() {
		return extraMap;
	}

	public void setExtraMap(Map<String, Object> extraMap) {
		this.extraMap = extraMap;
	}

	public String getSjlmc() {
		return sjlmc;
	}

	public void setSjlmc(String sjlmc) {
		this.sjlmc = sjlmc;
	}

	@Override
	public String toString() {
		return "Sjxxx [sheetName=" + sheetName + ", hzb=" + hzb + ", bm=" + bm + ", sjllj=" + sjllj + ", sjlmc=" + sjlmc
				+ ", extraMap=" + extraMap + "]";
	}

	
}
