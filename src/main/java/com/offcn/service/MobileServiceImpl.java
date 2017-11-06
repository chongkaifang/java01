package com.offcn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.MobileMapper;
import com.offcn.po.Mobile;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	MobileMapper mobileMapper;
	
	public void insert(Mobile mobile) {
		// TODO Auto-generated method stub
		mobileMapper.insert(mobile);
	}

}
