package com.thunisoft.tool.cz.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;

/**
 * 
 * @author chenzhen-1
 * @date 2019年7月2日-下午7:20:22
 *	
 *	页签的一些信息
 **/
public class SheetNode {
	
	/**
	 *  页签名
	 */
	private String name;
	
	/**
	 * 首行
	 */
	private Row row_1;
	
	/**
	 * 表名列-坐标
	 */
	private int bml;
	
	/**
	 * 数据项名称列-坐标
	 */
	private int sjxmcl;
	
	/**
	 * 数据项路径列坐标
	 */
	private int sjxljl;
	/**
	 * 结束cell,列坐标为0，这是记录行坐标
	 */
	private int jsCell;
	
	/**
	 * 额外数据--扩展使用
	 */
	private Map<String,Object> extraMap = new HashMap<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Row getRow_1() {
		return row_1;
	}

	public void setRow_1(Row row_1) {
		this.row_1 = row_1;
	}

	public int getBml() {
		return bml;
	}

	public void setBml(int bml) {
		this.bml = bml;
	}

	public int getSjxmcl() {
		return sjxmcl;
	}

	public void setSjxmcl(int sjxmcl) {
		this.sjxmcl = sjxmcl;
	}

	public int getSjxljl() {
		return sjxljl;
	}

	public void setSjxljl(int sjxljl) {
		this.sjxljl = sjxljl;
	}
	

	public int getJsCell() {
		return jsCell;
	}

	public void setJsCell(int jsCell) {
		this.jsCell = jsCell;
	}

	public Map<String, Object> getExtraMap() {
		return extraMap;
	}

	public void setExtraMap(Map<String, Object> extraMap) {
		this.extraMap = extraMap;
	}

	@Override
	public String toString() {
		return "SheetNode [name=" + name + ", bml=" + bml + ", sjxmcl=" + sjxmcl + ", sjxljl="
				+ sjxljl + ", jsCell=" + jsCell + ", extraMap=" + extraMap + "]";
	}

	
	

}
