package com.test.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

	private String root;

	public MyClassLoader() {
		
	}
	
	public MyClassLoader(String root) {

		this.root = root;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] classData = getData(name);

			if (null == classData) {

			} else {
				return defineClass(name, classData, 0, classData.length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.findClass(name);
	}

	private byte[] getData(String className) throws IOException {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		String path = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
		try {
			in = new FileInputStream(path);
			out = new ByteArrayOutputStream();
			byte[] buffer = new byte[2048];
			int len = 0;
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			return out.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}
		return null;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}
	
}
