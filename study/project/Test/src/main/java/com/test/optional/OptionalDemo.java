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
		 * 第二个同类型的 API 是 orElseGet() —— 其行为略有不同。这个方法会在有值的时候返回值，如果没有值，它会执行作为参数传入的
		 * Supplier(供应者) 函数式接口，并将返回其执行结果
		 */
		User result = Optional.ofNullable(user).orElseGet(() -> user2);

		Assert.assertEquals("john@gmail.com", result.getEmail());
	}

	/**
	 * 这个示例中，两个 Optional 对象都包含非空值，两个方法都会返回对应的非空值。不过，orElse() 方法仍然创建了 User
	 * 对象。与之相反，orElseGet() 方法不创建 User 对象。
	 * 
	 * 在执行较密集的调用时，比如调用 Web 服务或数据查询，这个差异会对性能产生重大影响。
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
	 * 这里，如果 user 值为 null，会抛出 IllegalArgumentException。
	 * 这个方法让我们有更丰富的语义，可以决定抛出什么样的异常，而不总是抛出 NullPointerException。 现在我们已经很好地理解了如何使用
	 * Optional，我们来看看其它可以对 Optional 值进行转换和过滤的方法。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenThrowException_thenOk() {
		User user = null;
		User result = Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException());
	}

	/**
	 * map() 对值应用(调用)作为参数的函数，然后将返回的值包装在 Optional 中。这就使对返回值进行链试调用的操作成为可能 ——
	 * 这里的下一环就是 orElse()。
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
	 * Optional 类的链式方法
	 */
	@Test
	public void whenChaining_thenOk() {
		User user = new User("john@gmail.com", "1234");
		String result = Optional.ofNullable(user).flatMap((param) -> param.getAddress())
				.flatMap((param) -> param.getCountry()).map((param) -> param.getIsoCode()).orElse("default");

		Assert.assertEquals("default", result);
	}

}
