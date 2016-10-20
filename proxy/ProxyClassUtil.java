package proxy;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class ProxyClassUtil {
	
	
	public static void generateProxyClass(String path, final String name, Class[] interfaces) {

		byte[] classFile = ProxyGenerator.generateProxyClass(name, interfaces);

		FileOutputStream file = null;
		try {
			file = new FileOutputStream(path);
			file.write(classFile);
			file.flush();
		}  catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(file != null){
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}