package com.thunisoft.tool.cz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import javax.validation.ValidationException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.druid.util.StringUtils;
import com.thunisoft.tool.cz.bean.SheetNode;
import com.thunisoft.tool.cz.bean.Sjxxx;
import com.thunisoft.tool.cz.myException.SheetException;

/**
 * 
 * @author chenzhen-1
 * @date 2019年7月2日-下午4:09:49
 * 
 *  	路径重复验证
 *  	要求：表页签中必须含有 表关联 页签 和 节点页签
 *  	节点页签要求 发送单位-节点名称-接收单位
 *
 **/
public class Ljcfyz {
	
//	private static Logger log = Logger.getLogger(Ljcfyz.class);
	
	
	
	
	public static void main(String[] args) throws IOException {
		
        
        Path path = Paths.get("C:\\Users\\huayu\\Desktop\\", "数据标准模板.xlsm");         
        
        try (
        		InputStream is = Files.newInputStream(path, StandardOpenOption.READ);        		
        	){
        	
        	// 从流中读取数据
        	Workbook workbook = new XSSFWorkbook(is);           	

        	// 验证Excel中是否有符合标准的页签
        	List<String> sheetNames = sheetValidate(workbook);
        	
        	// 获取页签中的信息
        	List<SheetNode> sheetNodes = getSheetNodeMsg(workbook, sheetNames);
        		
        	// 页签中的非空校验，数据项名称列，表名列，数据项路径列都不可为空。验证标准：验证到结束符或首列为 文书信息 时结束
        	sjxNotnull(workbook, sheetNodes);
        	
        	// 整合数据：Map<String,List<Sjxxx>> Map<表名-数据项路径, 集合<数据项信息>>
        	Map<String, List<Sjxxx>> dataSet = getDataSet(workbook, sheetNodes);  
        	
        	// 验证数据： 获取上述数据，比对value中的List，若List中的size > 1,需要特殊处理        	
        	List<Sjxxx> failDataList = getFailList(dataSet);
        	
        	// 坐标背景填充        	
        	markCell(workbook, failDataList);
        	
        	// 将处理过的工作表写出去
        	try (
        			OutputStream os = Files.newOutputStream(path, StandardOpenOption.WRITE) 
        		) {
        		workbook.write(os);        		
        	}catch (Exception e) {
        		System.out.println(e.getMessage());
        	}
        }catch (SheetException e) {
        	System.err.println(e.getMessage());
		}catch (FileSystemException e) {
			System.out.println("写入操作无法处理，建议关闭文件！");
		}
	}
	
	
	/**
	 * 	验证数据项路径
	 * @describe: 	
	 * @param is
	 * @author:  chenzhen-1
	 * @date: 2019年7月4日-下午2:16:51
	 */
	public static void pathValidate(InputStream is) {
		// 从流中读取数据
    	Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    	pathValidate(workbook);
	}
	
	
	/**
	 * 	验证数据项路径
	 * @describe: 	
	 * @param workbook
	 * @author:  chenzhen-1
	 * @date: 2019年7月4日-下午2:13:33
	 */
	public static void pathValidate(Workbook workbook) {
		
		try {
			// 验证Excel中是否有符合标准的页签
        	List<String> sheetNames = sheetValidate(workbook);
        	
        	// 获取页签中的信息
        	List<SheetNode> sheetNodes = getSheetNodeMsg(workbook, sheetNames);
        		
        	// 页签中的非空校验，数据项名称列，表名列，数据项路径列都不可为空。验证标准：验证到结束符或首列为 文书信息 时结束
        	sjxNotnull(workbook, sheetNodes);
        	
        	// 整合数据：Map<String,List<Sjxxx>> Map<表名-数据项路径, 集合<数据项信息>>
        	Map<String, List<Sjxxx>> dataSet = getDataSet(workbook, sheetNodes);  
        	
        	// 验证数据： 获取上述数据，比对value中的List，若List中的size > 1,需要特殊处理        	
        	List<Sjxxx> failDataList = getFailList(dataSet);
        	
        	// 坐标背景填充        	
        	markCell(workbook, failDataList);
        	
		}catch(SheetException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	
		
	}






	/**
	 *  	对于重复路径，进行单元格标记
	 * @describe: 	
	 * @param workbook
	 * @param failDataList
	 * @author:  chenzhen-1
	 * @date: 2019年7月4日-上午11:03:16
	 */
	private static void markCell(Workbook workbook, List<Sjxxx> failDataList) {
		// 设置填充规则
     	CellStyle style = workbook.createCellStyle();
     	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
     	style.setFillForegroundColor(IndexedColors.RED.getIndex());
 		
     	for (Sjxxx sjxxx : failDataList) {
		Sheet sheet = workbook.getSheet(sjxxx.getSheetName());
		Integer sjxljl = (Integer)sjxxx.getExtraMap().get(ConstantStr.SJXLJL);
		
		Row row = sheet.getRow(sjxxx.getHzb());        		
		Cell cell = row.getCell(sjxljl);         		
		cell.setCellStyle(style);
		
     	}
	}






	/**
	 * 获取上述数据，比对value中的List，若List中的size > 1,需要特殊处理
	 * @describe: 	
	 * @param dataSet
	 * @return
	 * @author:  chenzhen-1
	 * @date: 2019年7月3日-下午5:39:19
	 */
	private static Map<String, List<Sjxxx>> getFailDataSet(Map<String, List<Sjxxx>> dataSet) {
		Map<String, List<Sjxxx>> failDataSet = new HashMap<>();
		List<Sjxxx> failList = new ArrayList<>();
		Iterator<Entry<String, List<Sjxxx>>> iterator = dataSet.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, List<Sjxxx>> next = iterator.next();
			if (next.getValue().size() > 1) {
				failDataSet.put(next.getKey(), next.getValue());
				failList.addAll(next.getValue());
			}        		
		}
		return failDataSet;
	}
	
	private static List<Sjxxx> getFailList(Map<String, List<Sjxxx>> dataSet) {
		List<Sjxxx> failList = new ArrayList<>();
		Iterator<Entry<String, List<Sjxxx>>> iterator = dataSet.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, List<Sjxxx>> next = iterator.next();
			if (next.getValue().size() > 1) {
				failList.addAll(next.getValue());
			}        		
		}
		return failList;
	}



	/**
	 * 整合数据：Map<String,List<Sjxxx>> Map<表名-数据项路径, 集合<数据项信息>>
	 * @describe: 	
	 * @param workbook
	 * @param sheetNodes
	 * @return
	 * @author:  chenzhen-1
	 * @date: 2019年7月3日-下午5:25:55
	 */
	private static Map<String, List<Sjxxx>> getDataSet(Workbook workbook, List<SheetNode> sheetNodes) {
		Map<String, List<Sjxxx>> dataSet = new HashMap<>();
		
		sheetNodes.stream().forEach((sheetNode) -> {
			// 页签名
			String sheetName = sheetNode.getName();
			int sjxmcl = sheetNode.getSjxmcl();
			int sjxljl = sheetNode.getSjxljl();
			int bml = sheetNode.getBml();
			int jsCell = sheetNode.getJsCell();
			
			Sheet sheet = workbook.getSheet(sheetName);
			
			for (int i = 1; i < jsCell; i++) {
				Sjxxx sjxxx = new Sjxxx();
				sjxxx.setSheetName(sheetName);
				
				Row row = sheet.getRow(i);        			
				if (ConstantStr.WSXX.equals(row.getCell(0).getStringCellValue())) {
					break;
				}
				
				String sjxmc = row.getCell(sjxmcl).getStringCellValue();
				String sjxlj = row.getCell(sjxljl).getStringCellValue();
				String bm = row.getCell(bml).getStringCellValue();
				
				sjxxx.setBm(bm);
				sjxxx.setHzb(i);
				sjxxx.setSjllj(sjxlj);
				sjxxx.setSjlmc(sjxmc);
				sjxxx.getExtraMap().put(ConstantStr.SJXLJL, sjxljl);
				
				String key = sheetName + "-" + sjxlj;
				
				List<Sjxxx> sjxs = dataSet.get(key);
				if (sjxs == null) {
					sjxs = new ArrayList<>();
				}
				sjxs.add(sjxxx);
				dataSet.put(key,sjxs);        			
			}			
		});
		return dataSet;
	}



	/**
	 * 页签中的非空校验，数据项名称列，表名列，数据项路径列都不可为空。验证标准：验证到结束符或首列为 文书信息 时结束
	 * @describe: 	
	 * @param workbook
	 * @param sheetNodes
	 * @author:  chenzhen-1
	 * @date: 2019年7月3日-下午4:11:38
	 */
	private static void sjxNotnull(Workbook workbook, List<SheetNode> sheetNodes) {
		sheetNodes.stream().forEach( sheetNode -> {
			String name = sheetNode.getName();
			int jsCell = sheetNode.getJsCell();        		
			
			Sheet sheet = workbook.getSheet(name);
			
			// 验证数据项名称列
			int sjxmcl = sheetNode.getSjxmcl();
			sjxyz(sjxmcl, ConstantStr.SJXMC, jsCell, sheet);

			// 验证表名列
			int bml = sheetNode.getBml();
			sjxyz(bml, ConstantStr.BM, jsCell, sheet);
			
			// 验证 数据项路径列
			int sjxljl = sheetNode.getSjxljl();
			sjxyz(sjxljl, ConstantStr.SJXLJ, jsCell, sheet);     		
			
		});
	}
	
	/**
	 * 数据项非空校验
	 * @describe: 	
	 * @param sjxl
	 * @param sjxmc
	 * @param jsCell
	 * @param sheet
	 * @author:  chenzhen-1
	 * @date: 2019年7月3日-下午4:14:43
	 */
	private static void sjxyz(int sjxl, String sjxmc, int jsCell,Sheet sheet) {		
		for (int i = 1; i < jsCell; i++) {
			Row row = sheet.getRow(i);
			
			if (ConstantStr.WSXX.equals(row.getCell(0).getStringCellValue())) {
				System.out.println("【"+ sjxmc +"】验证结束， 至 -----文书信息-----单元格");
				break;
			}
			if (StringUtils.isEmpty(row.getCell(sjxl).getStringCellValue().trim())) {
				throw new ValidationException(sjxmc + "页签中缺少数据，缺少数据,坐标为第" + ( i + 1 ) + "行, 第" + ( sjxl + 1) + "列");
			}   			
		}
	}

	
	
	/**
	 *  获取页签中的数据信息
	 * @describe: 	
	 * @param workbook
	 * @param sheetNames
	 * @return
	 * @author:  chenzhen-1
	 * @date: 2019年7月3日-下午3:19:23
	 */
	private static List<SheetNode> getSheetNodeMsg(Workbook workbook, List<String> sheetNames) {
		//数据节点页签的信息
		List<SheetNode> sheetNodes = new ArrayList<>();
		
		// 获取 节点 页签
		Stream<String> nodeSheets = sheetNames.stream().filter((name) ->{
			return name.split("\\-").length == 3;
		});  
		
		// 遍历节点页签，非空校验
		nodeSheets.forEach( name -> {				
			// 页签首行验证
			Sheet sheet = workbook.getSheet(name);        		
			Row row = sheet.getRow(0); 		
			
			Iterator<Cell> iterator = row.iterator();
			Map<String,Integer> cellMap = new HashMap<>();
			while (iterator.hasNext()) {
				Cell cell = iterator.next();
				cellMap.put(cell.getStringCellValue(), cell.getColumnIndex());
			}
			
			SheetNode sheetNode = new SheetNode();
			sheetNode.setName(name);
			sheetNode.setRow_1(row);
			
			//设置表名列坐标
			if (cellMap.get(ConstantStr.BM) == null) {
				throw new SheetException(name + ConstantStr.SHEET_EXCEPTION_MESSAGE3 + ConstantStr.BM);
			}
			if (cellMap.get(ConstantStr.SJXMC) == null) {
				throw new SheetException(name + ConstantStr.SHEET_EXCEPTION_MESSAGE3 + ConstantStr.SJXMC);
			}
			if (cellMap.get(ConstantStr.SJXLJ) == null) {
				throw new SheetException(name + ConstantStr.SHEET_EXCEPTION_MESSAGE3 + ConstantStr.SJXMC);
			}
			
			sheetNode.setBml(cellMap.get(ConstantStr.BM));
			sheetNode.setSjxljl(cellMap.get(ConstantStr.SJXLJ));
			sheetNode.setSjxmcl(cellMap.get(ConstantStr.SJXMC));
			
			// 获取单元格中的行数
			int rows = sheet.getPhysicalNumberOfRows();
			
			// 获取结束符坐标
			boolean flag = true;
			for (int i = rows; i >= 1; i--) {
				Row rowTemp = sheet.getRow(i);
				if (rowTemp == null) {
					continue;
				}
				Cell cell = rowTemp.getCell(0);
				if (cell == null) {
					continue;
				}        			
				if (ConstantStr.JSBSF.equals(cell.getStringCellValue())) {
					sheetNode.setJsCell(cell.getRowIndex());
					flag = false;
					break;
				}        			
			}
			if (flag) {
				throw new SheetException(name + ConstantStr.SHEET_EXCEPTION_MESSAGE4);
			}
			
			sheetNodes.add(sheetNode);       		
			
		});
		return sheetNodes;
	}
	



	/**
	 * 页签校验
	 * @describe: 	
	 * @param workbook
	 * @return: 返回所有的页签名称
	 * @author:  chenzhen-1
	 * @date: 2019年7月2日-下午6:52:25
	 */
	private static List<String> sheetValidate(Workbook workbook) {
//		log.info("-------------------- \t页 签 验 证 开 始 \t---------------------");
		// 获取表关联页签		
		Sheet sheet = workbook.getSheet(ConstantStr.BGL);		
		if (sheet == null) {
			throw new SheetException(ConstantStr.SHEET_EXCEPTION_MESSAGE1);
		}		
		// 获取Excel中的页签数目
		int sheets = workbook.getNumberOfSheets();
		
//		log.info("-------------------- \t共 有  "+ sheets +"个 页 签  \t---------------------");
		if (sheets <= 1) {
			throw new SheetException(ConstantStr.SHEET_EXCEPTION_MESSAGE2);
		}		
		
		List<String> sheetNames = new ArrayList<>(sheets);        	
		for (int i = 0; i < sheets; i++) {
			sheetNames.add(workbook.getSheetAt(i).getSheetName());
		} 		
		// 判断页签中是否有符合节点的名称
		boolean flag = sheetNames.stream().anyMatch((name) -> {
			return name.split("\\-").length == 3;
		});
		
		if(!flag) {
			throw new SheetException(ConstantStr.SHEET_EXCEPTION_MESSAGE2);
		}
//		log.info("-------------------- \t共 有  "+ sheetNames.size() +"个 节 点 页 签  \t---------------------");
		return sheetNames;
	}
	
}
