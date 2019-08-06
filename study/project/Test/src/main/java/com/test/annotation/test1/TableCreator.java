package com.test.annotation.test1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {

	private static String getConstraints(Constraints con) {
		String constraints = "";

		if (!con.allowNull()) {
			constraints += " NOT NULL";
		}

		if (con.primaryKey()) {
			constraints += " PRIMARY KEY";
		}

		if (con.unique()) {
			constraints += " UNIQUE";
		}

		return constraints;
	}

	public static void main(String[] args) throws Exception {
		String[] gs = { "com.test.annotation.test1.Member" };

		for (String className : gs) {
			Class<?> cl = Class.forName(className);
			DBTable dbTable = cl.getAnnotation(DBTable.class);

			if (null == dbTable) {
				System.out.println("no annotations in class " + className);
				continue;
			}

			String tableName = dbTable.name();

			if (tableName.length() < 1) {
				tableName = cl.getName().toUpperCase();
			}

			List<String> columnDefs = new ArrayList<>();
			for (Field field : cl.getDeclaredFields()) {
				String columnName = null;
				Annotation[] ans = field.getDeclaredAnnotations();
				if (ans.length < 1) {
					continue;
				}

				if (ans[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) ans[0];

					if (sInt.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sInt.name();
					}

					columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
				}

				if (ans[0] instanceof SQLString) {
					SQLString sStr = (SQLString) ans[0];

					if (sStr.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sStr.name();
					}

					columnDefs.add(columnName + " VARCHAR(" + sStr.value() + ")" + getConstraints(sStr.constraints()));
				}
			}

			StringBuilder builder = new StringBuilder("CREATE TABLE " + tableName + "(");

			for (String column : columnDefs) {
				builder.append("\n       " + column + ",");
			}
			String tableCreate = builder.substring(0, builder.length() - 1) + "\n);";
			System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
		}
	}

}
