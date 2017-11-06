package com.offcn.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.service.MobileService;
import com.offcn.util.readExcelToMySql;

@Controller
@RequestMapping("/read")
public class readController {

	@Resource
	MobileService mobileService;
	
	@RequestMapping("/readAndWriter")
	public String readExcel(){
		System.out.println("666");
		readExcelToMySql read = new readExcelToMySql();
		System.out.println(read.toString());
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
		return "index";
	}
}
