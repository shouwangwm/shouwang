package objectRelation.yilai;

//依赖依赖关系不会产生成员变量，往往就是某个方法调用的时候，传入的参数会有被依赖的对象。
public class A {
	
	//构造方法参数依赖
	public A(B b){
		
	}
	
	//方法参数依赖
	public void test(B b){
		
		//静态变量依赖
		int a = B.a; 
	}
	
}
