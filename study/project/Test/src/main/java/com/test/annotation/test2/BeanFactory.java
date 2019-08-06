package com.test.annotation.test2;

import java.lang.reflect.Field;

public class BeanFactory {

	public static <Q> Q getBean(Class<Q> clazz) {
		Q result = null;
		try {
			result = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			System.out.println("get the " + clazz.getName() + "failed!!");
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.out.println("get the " + clazz.getName() + "failed!!");
			return null;
		}

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			Inject inject = field.getAnnotation(Inject.class);

			if (null != inject) {
				Object object = getBean(field.getType());
				if (!field.isAccessible()) {
					field.setAccessible(true);

					try {
						field.set(result, object);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
						System.out.println("Inject the " + field.getName() + "failed!!");
					}
				}
			}
		}

		return result;
	}
}
