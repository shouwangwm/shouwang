package objectRelation.juhe;

public class A {

	private B b;

	/**
	 * 聚合可以称作为强关联关系，当一个类聚合另一个类的时候， 这个类A在自己实例化时就会给关联的这个对象B赋值。
	 * 不过，这里关联对象B的实例化不是在A中，所以，B的生存与否，不是由A决定。
	 */
	public A(B b) {
		this.b = b;
	}
}
