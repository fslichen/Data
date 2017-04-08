package evolution;

import java.lang.reflect.Field;

import org.junit.Test;

import evolution.dto.AnyDto;

public class Application {
	public static String upperFirstChar(String string) {
		int length = string.length();
		if (length > 1) {
			return string.substring(0, 1).toUpperCase() + string.substring(1);
		} else if (length == 1) {
			return string.toUpperCase();
		}
		return null;
	}
	
	public static String lowerFirstChar(String string) {
		int length = string.length();
		if (length > 1) {
			return string.substring(0, 1).toLowerCase() + string.substring(1);
		} else if (length == 1) {
			return string.toLowerCase();
		}
		return null;
	}
	
	public static void anyMethod(Class<?> clazz)  {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			Class<?> type = field.getType();
			String simpleClassName = type.getSimpleName();
			String complexClassName = type.getName();
			String fieldName = field.getName();
			String setter = "public void " + "set" + upperFirstChar(fieldName)
				+ "(" + simpleClassName + " " + fieldName + ") {\n"
				+ "    this." + fieldName + " = " + fieldName + ";\n}\n";
			String getter = "";
			System.out.println(setter);
		}
	}
	
	@Test
	public void test() {
		anyMethod(AnyDto.class);
	}
	
}
