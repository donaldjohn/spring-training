package com.cog;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.cog.repo.MyDataSource;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessAfterInitialization(Object obj, String arg1)
			throws BeansException {
		
		if(obj instanceof MyDataSource){
			MyDataSource mds = (MyDataSource) obj;
			mds.setURL("123.33.3.4/mydb");
		}
			System.out.println("Modifying bean after " + arg1);
		return obj;
	}

	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("Modifying bean before " + arg1);
		return arg0;
	}

}
