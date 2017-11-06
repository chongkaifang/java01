package com.offcn.util;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UtilApp {

	@Autowired
	readExcelToMySql read;
	
	@Test
	public void testRead() {
		//需要读取一下beans.xml文件管理dao层的映射文件、配置文件和需要的数据源
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
		try {
			read.readForeachExcel();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
