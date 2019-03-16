package test_java.test.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationUtils {
	/**
	 * 通过反射解析注解成员变量
	 * @param clazz
	 */
	public static void parseFields(Class<?> clazz) {
		String name = "";
		String gender = "";
		String profile = "";
		Field fields[] = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(TargetField1Name.class)) {
				TargetField1Name arg0 = field.getAnnotation(TargetField1Name.class);
				name = name + arg0.value();
				System.out.println("name=" + name);
			}
			if (field.isAnnotationPresent(TargetField2Gender.class)) {
				TargetField2Gender arg0 = field.getAnnotation(TargetField2Gender.class);
				gender = gender + arg0.gender().toString();
				System.out.println("gender=" + gender);
			}
			if (field.isAnnotationPresent(TargetFiedl3Profile.class)) {
				TargetFiedl3Profile arg0 = field.getAnnotation(TargetFiedl3Profile.class);
				profile = "[id=" + arg0.id() + ",height=" + arg0.height() + ",nativePlace=" + arg0.nativePlace() + "]";
				System.out.println("profile=" + profile);
			}
		}
	}
	
	/**
	 * 通过反射解析注解类
	 * @param clazz
	 */
	public static void parseClass(Class<?> clazz) {
		TargetClassClass clas = clazz.getAnnotation(TargetClassClass.class);
		System.out.println(clas.uri());
	}
	
	/**
	 * 通过反射解析注解方法
	 * @param clazz
	 */
	public static <T> void parseMethod(Class<T> clazz) {
		try {
			T obj = clazz.newInstance();
			for(Method method: clazz.getDeclaredMethods()) {
				System.out.println(method.getName());
				TargetMethod targetmethod = method.getAnnotation(TargetMethod.class);
				if(targetmethod != null) {
					//通过反射调用带有此注解里面的data方法
					method.invoke(obj, targetmethod.uri());
					System.out.println(targetmethod.version());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * 解析注解构造方法
	 * @param clazz
	 */
	public static void parseConstructor(Object object) {
		try {
			Class<? extends Object> clazz = object.getClass();
			
			// 得到构造方法注解
	        Constructor<? extends Object> cons = clazz.getConstructor(new Class[]{});
	        if(cons.isAnnotationPresent(TargetConstructor.class)) {
		        TargetConstructor myConstructorAnnotation = (TargetConstructor) cons.getAnnotation(TargetConstructor.class);
		        System.out.println(myConstructorAnnotation.value());
	        } else {
	        	
	        }
			Constructor cons1 = clazz.getConstructor(String.class);
			Constructor cons2 = clazz.getConstructor(String.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析注解构造方法
	 * @param clazz
	 */
	public static <T> void parseConstructor(Class<T> clazz) {
		try {
		
			// 得到构造方法注解
	        Constructor<T> cons = clazz.getConstructor(new Class[]{});
	        if(cons.isAnnotationPresent(TargetConstructor.class)) {
		        TargetConstructor myConstructorAnnotation = (TargetConstructor) cons.getAnnotation(TargetConstructor.class);
		        System.out.println(myConstructorAnnotation.value());
	        } else {
	        	
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static <T> void intercept(Class<T> clazz){

		try {
			// 构造器
	        Constructor<T> cons = clazz.getConstructor(new Class[]{});
	        
	        //构造器注解过的
	        if(!cons.isAnnotationPresent(TargetConstructor.class)) {
	        	System.out.println("null");
	        } else {
	        	System.out.println("not null");
	        }
		}catch (Exception e) {
			
		}
	}
}
