package com.qfedu.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qfedu.pojo.SysUser;

public class ExcelUtils {

	
	public static void readExcel(String fileName, InputStream inputStream) throws Exception{
		
		// 判断读取文件的格式
		boolean ret = isXls(fileName);
		Workbook workBook = null;
		if(ret == true){// 后缀是xls
			workBook = new HSSFWorkbook(inputStream);
		}else{
			workBook = new XSSFWorkbook(inputStream);
		}
		
		Sheet sheet = workBook.getSheetAt(0);
		
		int lastRowNum = sheet.getLastRowNum();
		for(int i = 0; i <= lastRowNum; i++){
			
			Row row = sheet.getRow(i);
			int lastCellNum = row.getLastCellNum();
			for(int j = 0; j < lastCellNum; j++){
				Cell cell = row.getCell(j);
				if(cell != null){
					cell.setCellType(CellType.STRING);
					System.out.println(cell.getStringCellValue());
				}
			}
		}
		workBook.close();
		
	}
	
	public static List<Map<String, Object>> readExcel2(String fileName, InputStream inputStream) throws Exception{
		
		// 判断读取文件的格式
		boolean ret = isXls(fileName);
		Workbook workBook = null;
		if(ret == true){// 后缀是xls
			workBook = new HSSFWorkbook(inputStream);
		}else{
			workBook = new XSSFWorkbook(inputStream);
		}
		
		Sheet sheet = workBook.getSheetAt(0);
		// 获取第一行数据，本行存的是数据的key值
		Row row2 = sheet.getRow(0);
		int lastCellNum = row2.getLastCellNum();
		// 所有的key值存到数组中
		String[] titles = new String[lastCellNum];
		for(int i = 0; i < lastCellNum; i++){
			titles[i] = row2.getCell(i).getStringCellValue();
		}
		
		int lastRowNum = sheet.getLastRowNum();
		
		
		List<Map<String, Object>> list = new ArrayList<>();
		for(int i = 1; i <= lastRowNum; i++){
			Map<String, Object> map = new HashMap<>();
			Row row = sheet.getRow(i);
			for(int j = 0; j < lastCellNum; j++){
				Cell cell = row.getCell(j);
				if(cell != null){
					cell.setCellType(CellType.STRING);
					// 将数据放到map中
					map.put(titles[j], cell.getStringCellValue());
				}
			}
			list.add(map);
		}
		workBook.close();
		
		return list;
	}
	
	public static boolean isXls(String fileName){
		// aa.xlsx
		// (?i)忽略大小写
		if(fileName.matches("^.+\\.(?i)(xls)$")){
			return true;
		}else if(fileName.matches("^.+\\.(?i)(xlsx)$")){
			return false;
		}else{
			throw new RuntimeException("格式不对");
		}
	}
	
	public static void exportExcel(OutputStream outputStream){
		List<SysUser> list = new ArrayList<>();
		for(int i = 0; i < 4; i++){
			SysUser u = new SysUser();
			u.setUsrId(i);
			u.setUsrName("haha" + i);
			u.setUsrPassword("123");
			u.setUsrFlag("1");
			u.setUsrRoleId(1);
			list.add(u);
		}
		try{
			XSSFWorkbook workBook = new XSSFWorkbook();
			// 创建sheet对象
			XSSFSheet sheet = workBook.createSheet("hahaha");
			
			for(int i = 0; i < list.size(); i++){
				// 创建行对象
				XSSFRow row = sheet.createRow(i);
				
				// 创建单元格对象
				row.createCell(0).setCellValue(list.get(i).getUsrId());
				row.createCell(1).setCellValue(list.get(i).getUsrName());
				row.createCell(2).setCellValue(list.get(i).getUsrPassword());
				row.createCell(3).setCellValue(list.get(i).getUsrRoleId());
				row.createCell(4).setCellValue(list.get(i).getUsrFlag());
			}
			workBook.write(outputStream);
			
			workBook.close();
		}catch(Exception e){
			
		}
		
	}
	
}
