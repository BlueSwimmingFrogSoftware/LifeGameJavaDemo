package di;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class DiResolver {
	
	private Injector injector;
	
	public DiResolver()
	{
		this.injector = Guice.createInjector(new BasicModule[]{ new BasicModule()}); 
	}
	
	public <T> T resolve(Class<T> cls)
	{				
		var instance = this.injector.getInstance(cls);
		
		return instance;
	}
}
