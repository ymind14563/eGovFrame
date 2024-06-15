package com.easycompany.cmm.service.impl;

import org.springframework.stereotype.Service;

import com.easycompany.cmm.service.SampleService;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class SampleServiceImpl extends EgovAbstractServiceImpl implements SampleService {

    @SuppressWarnings("unused")
	public void invokeMethodAException() throws Exception {
        try{
           int i = 1/0;
        }catch(ArithmeticException ae){
            throw processException("msg.exception.case1", ae);
        }

    }

    public void invokeMethodBException() throws Exception {


    }

}
