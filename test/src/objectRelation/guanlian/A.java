package objectRelation.guanlian;

public class A {

	private B b;

	/**
	 * 关联关系表示两个类之间有持久的联系,会增加被依赖对象的成员变量（如下代码），不过关联对象的赋值是在调用某种方法的时候。
	 */
	public void test(B b) {
		this.b = b;
	}
}
