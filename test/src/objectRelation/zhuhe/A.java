package objectRelation.zhuhe;

public class A {

	private B b;

	/**
	 * 组合也是一种强关联关系。
	 * 类A组合类B，则B是A不可或缺的一部分，B的实例化就在A实例化的时候。B的生存周期取决于A，A消亡，B也消亡。 
	 */
	public A(B b) {
		this.b = b;
	}
}