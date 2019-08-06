package com.test.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class OptionalDemo {

	public OptionalDemo() {
		super();
	}

	@Test(expected = NoSuchElementException.class)
	public void whenCreateEmptyOptional_thenNull() {
		Optional<User> emptyOpt = Optional.empty();
		emptyOpt.get();
	}

	@Test(expected = NullPointerException.class)
	public void whenCreateOfEmptyOptional_thenNullPointerException() {
		User user = null;
		Optional<User> opt = Optional.of(user);
	}

	@Test
	public void whenCreateOfNullableOptional_thenOk() {
		String name = "John";
		Optional<String> opt = Optional.ofNullable(name);

		Assert.assertEquals("John", opt.get());
	}

	@Test
	public void whenCheckIfPresent_thenOk() {
		User user = new User("john@gmail.com", "1234");
		Optional<User> opt = Optional.ofNullable(user);

		Assert.assertTrue(opt.isPresent());

		Assert.assertEquals(user.getEmail(), opt.get().getEmail());
	}

	@Test
	public void whenEmptyValue_thenReturnDefault() {
		User user = null;
		User user2 = new User("john@gmail.com", "1234");
		// User result = Optional.ofNullable(user).orElse(user2);

		/**
		 * �ڶ���ͬ���͵� API �� orElseGet() ���� ����Ϊ���в�ͬ���������������ֵ��ʱ�򷵻�ֵ�����û��ֵ������ִ����Ϊ���������
		 * Supplier(��Ӧ��) ����ʽ�ӿڣ�����������ִ�н��
		 */
		User result = Optional.ofNullable(user).orElseGet(() -> user2);

		Assert.assertEquals("john@gmail.com", result.getEmail());
	}

	/**
	 * ���ʾ���У����� Optional ���󶼰����ǿ�ֵ�������������᷵�ض�Ӧ�ķǿ�ֵ��������orElse() ������Ȼ������ User
	 * ������֮�෴��orElseGet() ���������� User ����
	 * 
	 * ��ִ�н��ܼ��ĵ���ʱ��������� Web ��������ݲ�ѯ��������������ܲ����ش�Ӱ�졣
	 */
	@Test
	public void givenEmptyValue_whenCompare_thenOk() {
		User user = new User("john@gmail.com", "1234");
		System.out.println("Using orElse");
		User result = Optional.ofNullable(user).orElse(createNewUser());
		System.out.println("Using orElseGet");
		User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
	}

	private User createNewUser() {
		System.out.println("Creating New User");
		return new User("extra@email.com", "1234");
	}

	/**
	 * ������ user ֵΪ null�����׳� IllegalArgumentException��
	 * ��������������и��ḻ�����壬���Ծ����׳�ʲô�����쳣�����������׳� NullPointerException�� ���������Ѿ��ܺõ���������ʹ��
	 * Optional�������������������Զ� Optional ֵ����ת���͹��˵ķ�����
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenThrowException_thenOk() {
		User user = null;
		User result = Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException());
	}

	/**
	 * map() ��ֵӦ��(����)��Ϊ�����ĺ�����Ȼ�󽫷��ص�ֵ��װ�� Optional �С����ʹ�Է���ֵ�������Ե��õĲ�����Ϊ���� ����
	 * �������һ������ orElse()��
	 */
	@Test
	public void whenMap_thenOk() {
		User user = new User("john@gmail.com", "1234");
		String email = Optional.ofNullable(user).map((param) -> param.getEmail()).orElse("default@email.com");
		User user2 = new User("john@gmail.com", "1234");

//		Assert.assertEquals(email, user.getEmail());
	}

	@Test
	public void whenFilter_thenOk() {
		User user = new User("john@gmail.com", "1234");
		Optional<User> result = Optional.ofNullable(user)
				.filter((param) -> param.getEmail() != null && param.getEmail().contains("@"));
		Assert.assertTrue(result.isPresent());
	}

	/**
	 * Optional �����ʽ����
	 */
	@Test
	public void whenChaining_thenOk() {
		User user = new User("john@gmail.com", "1234");
		String result = Optional.ofNullable(user).flatMap((param) -> param.getAddress())
				.flatMap((param) -> param.getCountry()).map((param) -> param.getIsoCode()).orElse("default");

		Assert.assertEquals("default", result);
	}

}
