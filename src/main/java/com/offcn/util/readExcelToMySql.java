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
	 * ������ȡһ��Excel�ļ�
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	public void readForeachExcel() throws EncryptedDocumentException, InvalidFormatException, IOException{
		//1��ָ��Ҫ��ȡ��Excel�ĵ�·��
		String filename="D:\\�й�����\\JavaWeb�߼���չ\\WebService\\day85\\��ҵ\\Mobile.xls";
		//2������������
		FileInputStream input = new FileInputStream(filename);
		//3��ͨ������������������������������
		Workbook book = WorkbookFactory.create(input);
		//4������ ��������������й�����
		int sheetnum=book.getNumberOfSheets();
		for(int i=0;i<sheetnum;i++){
			//��ȡ������������
			Sheet sheet = book.getSheetAt(i);
			//��ȡ�����������е�����
			int rownum=sheet.getPhysicalNumberOfRows();
			for(int j=0;j<rownum;j++){
				//��ȡÿһ�еĵ�Ԫ�����
				Row row = sheet.getRow(j);
				int cellnum = row.getPhysicalNumberOfCells();
				
				//ÿһ�д���һ��Mobile����
				Mobile mobile = new Mobile();
				
				//��ȡÿһ���µ�ȫ����Ԫ��
				for(int x=0;x<cellnum;x++){
					Cell cell = row.getCell(x);
					//��ȡÿ����Ԫ���µ�����
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
				//�õ�һ������֮��ͨ�����������ӵ����ݿ�
				System.out.println("mobileService="+mobileService);
				mobileService.insert(mobile);
			}
		}
	}
}
