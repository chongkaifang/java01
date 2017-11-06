package com.offcn.util;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import com.offcn.po.Mobile;
import com.offcn.service.MobileService;
import com.offcn.service.MobileServiceImpl;

@Service
public class readExcelToMySql {

	@Resource
	MobileService mobileService;
	
	/**
	 * 遍历读取一个Excel文件
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	public void readForeachExcel() throws EncryptedDocumentException, InvalidFormatException, IOException{
		//1、指定要读取的Excel文档路径
		String filename="D:\\中公教育\\JavaWeb高级拓展\\WebService\\day85\\作业\\Mobile.xls";
		//2、创建输入流
		FileInputStream input = new FileInputStream(filename);
		//3、通过工作簿工厂类来创建工作簿对象
		Workbook book = WorkbookFactory.create(input);
		//4、遍历 工作簿下面的所有工作表
		int sheetnum=book.getNumberOfSheets();
		for(int i=0;i<sheetnum;i++){
			//获取到单个工作表
			Sheet sheet = book.getSheetAt(i);
			//获取工作表下所有的行数
			int rownum=sheet.getPhysicalNumberOfRows();
			for(int j=0;j<rownum;j++){
				//获取每一行的单元格个数
				Row row = sheet.getRow(j);
				int cellnum = row.getPhysicalNumberOfCells();
				
				//每一行创建一个Mobile对象
				Mobile mobile = new Mobile();
				
				//获取每一行下的全部单元格
				for(int x=0;x<cellnum;x++){
					Cell cell = row.getCell(x);
					//获取每个单元格下的内容
					if(cell==null){
						System.out.println("NULL"+"\t");
						continue;
					}
					if(x==1){
						mobile.setMobileNumber(cell.getStringCellValue());
					}else if(x==2){
						mobile.setMobileArea(cell.getStringCellValue());
					}else if(x==3){
						mobile.setMobileType(cell.getStringCellValue());
					}else if(x==4){
						mobile.setAreaCode(cell.getStringCellValue());
					}else if(x==5){
						mobile.setPostCode(cell.getStringCellValue());
					}
				}
				//得到一行数据之后通过对象进行添加到数据库
				System.out.println("mobileService="+mobileService);
				mobileService.insert(mobile);
			}
		}
	}
}
