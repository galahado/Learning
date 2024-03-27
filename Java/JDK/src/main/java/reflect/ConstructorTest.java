package reflect;

import java.lang.reflect.Constructor;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class ConstructorTest
{

	/**
	 * get a class's constructors
	 */
	@Test
	void test1() throws Exception
	{
		Properties properties = new Properties();
		properties.load(getClass().getResourceAsStream("/re.properties"));
		String path = properties.getProperty("classPath");

		Class<?> clazz = Class.forName(path);

		Constructor<?> constructor = clazz.getDeclaredConstructor();
		System.out.println(constructor);

		Constructor<?> constructor2 = clazz.getDeclaredConstructor(String.class, int.class);
		System.out.println(constructor2);
	}

	@Test
	void publicNoArgConstructor() throws Exception
	{
		Class<?> aClass = Class.forName("reflect.bean.User");
		System.out.println(aClass.getConstructor().newInstance());
	}

	@Test
	void publicConstructorWithArg() throws Exception
	{
		Class<?> aClass = Class.forName("reflect.bean.User");
		Constructor<?> constructor = aClass.getConstructor(String.class);
		System.out.println(constructor.newInstance("Chuanqi Zhang"));
	}


	@Test
	void privateConstructorWithArgs() throws Exception
	{
		Class<?> aClass = Class.forName("reflect.bean.User");
		Constructor<?> constructor = aClass.getDeclaredConstructor(int.class, String.class);
		System.out.println(constructor.newInstance(38, "Chuanqi Zhang"));
	}
}
