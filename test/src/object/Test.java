package object;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("init");
		p.setAge(1);
		
		String name = "temp";
		int age = 11;
		
		Test t = new Test();
		//基本类型不会改变值， 对象类型的属性会改变
		t.test(name,age,p);
		print(name);
		print(age);
		print(p);
		
		Service s = new Service();
		s.setName("init");
		s.setAge(1);
		s.test();
		print(null);
		print(s.getName());
		print(s.getAge());
		
		
//		 Calendar calst = Calendar.getInstance();
//	        Calendar caled = Calendar.getInstance();
//	        calst.setTime(new Date(System.currentTimeMillis()));
//	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	        try {
//				caled.setTime(format.parse("2016-12-31"));
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//	        //设置时间为0时
//	        calst.set(Calendar.HOUR_OF_DAY, 0);
//	        calst.set(Calendar.MINUTE, 0);
//	        calst.set(Calendar.SECOND, 0);
//	        caled.add(Calendar.DAY_OF_MONTH, 1);
//	        caled.set(Calendar.HOUR_OF_DAY, 0);
//	        caled.set(Calendar.MINUTE, 0);
//	        caled.set(Calendar.SECOND, 0);
//	        //得到两个日期相差的天数
//	        int days = ((int)(caled.getTime().getTime()/1000)-(int)(calst.getTime().getTime()/1000))/3600/24;
//	        System.out.println(days);
		
		/**
		 * 截取list
		 */
//		List list = new ArrayList();
//		for(int i=0;i<100;i++){
//			list.add(i);
//		}
//		
//		List subList;
//		int count = list.size();
//    	int index = 0;
//    	int add = 10;
//    	while(index + add < count){
//    		subList = list.subList(index, index + add);
//    		index += add;
//    		System.out.println(JSON.toJSONString(subList));
//    	}
//    	subList = list.subList(index, count);
//    	System.out.println(JSON.toJSONString(subList));
	}
	
	public void test(String name,int num, Person p){
		name = "change";
		num = 100;
		p.setName("change");
		p.setAge(100);
	}
	
	
	public static void print(Object o){
		System.out.println(o);
	}
	
}
