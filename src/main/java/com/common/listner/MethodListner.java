package com.common.listner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.common.util.ExcelUtils;

public class MethodListner implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance> testCaseToRun = new ArrayList<>();
		List<Map<String,String>> excelRecords = ExcelUtils.getTestDetail();
		for(int i = 0; i<methods.size(); i++) {
			for(int j =0;j<excelRecords.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equals(excelRecords.get(j).get("TestName"))) {
					if(excelRecords.get(j).get("Execute").equals("yes")) {
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(excelRecords.get(j).get("Count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(excelRecords.get(j).get("Priority")));
						testCaseToRun.add(methods.get(i));
					}
				}
			}
		}
		return testCaseToRun;
	}

}
