package com.cog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cog.repo.MyDataSource;
import com.cog.service.TransferService;

public class TestDependency {
 public static void main(String[] args) {
	/*B b = new B(); 
	 
	A a = new A(b);*/
//	a.setB(b);
	
	 
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); 
	
	MyDataSource mdsObj = context.getBean(MyDataSource.class);
	System.out.println(mdsObj);
	
	TransferService service = context.getBean(TransferService.class);
	service.fundsTransfer();
	
	/*String names[] = context.getBeanNamesForType(TransferService.class);

	for(String name: names){
		System.out.println(name);
	}
	
	TransferService service1 = (TransferService) context.getBean("transferService");
			service1.fundsTransfer();
	A a = context.getBean(A.class);*/
	
	/*A a1 = context.getBean(A.class);
	System.out.println(a.age);
	System.out.println("Cities list: " + a.cities);*/
	
	/*if(a == a1){
		System.out.println("SingleTon objects");
	}
	else{
		System.out.println("Not a singleton");
	}*/
	
	/*a.execute();
	a.execute();
	a.execute();*/
}
}
