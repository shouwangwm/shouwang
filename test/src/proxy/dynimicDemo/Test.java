package proxy.dynimicDemo;

import java.lang.reflect.InvocationHandler;

import proxy.ProxyClassUtil;

public class Test {
	
	public static void main(String[] args) {
		
		IUserService us = new UserService();
		MyInvocationHandler handler = new MyInvocationHandler(us);
		IUserService proxy = (IUserService) handler.getProxy();
		System.out.println(proxy.getClass().getResource("/").getPath());
		proxy.add();
		
		
		//生成代理类原理
		ProxyClassUtil.generateProxyClass("d:/Proxy100.class", "Proxy100", UserService.class.getInterfaces());
	}
}
