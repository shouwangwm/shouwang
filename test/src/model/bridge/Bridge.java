package model.bridge;

public abstract class Bridge {
	
	
	SourceInterface source;
	
	public void method(){
		source.method();
	}
	public SourceInterface getSource() {
		return source;
	}
	

	public void setSource(SourceInterface source) {
		this.source = source;
	}
	
	
}
