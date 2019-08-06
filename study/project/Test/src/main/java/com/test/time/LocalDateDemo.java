package com.test.time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class LocalDateDemo {

	/**
	 * LocalDate java.time.LocalDate这个类，是用来表示日期的，也仅包含日期
	 */
	@Test
	public void testLocalDate() {
		// 获取当前日期（年月日）
		LocalDate now = LocalDate.now();
		System.out.println(now);

		// 根据年月日构建日期
		LocalDate of = LocalDate.of(2019, 7, 12);
		System.out.println(of);
		// 字符串转化日期，默认按照yyyy-MM-dd格式
		LocalDate parse = LocalDate.parse("2019-07-12");
		System.out.println(parse);
		// 获取本月的第一天
		LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(firstDayOfMonth);
		// 获取本月的最后一天
		LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(lastDayOfMonth);
		// 获取本月第5天
		LocalDate dayOfMonth = now.withDayOfMonth(5);
		System.out.println(dayOfMonth);
		// 明天
		LocalDate tommorrowDay = now.plusDays(1L);
		System.out.println(tommorrowDay);
		// 昨天
		LocalDate yesterday = now.minusDays(1L);
		System.out.println(yesterday);
		// 计算两个日期时间的天数
		long days = now.until(lastDayOfMonth, ChronoUnit.DAYS);
		System.out.println(days);

	}

	/**
	 * LocalTime 与LocalDate相同，LocalTime与LocalDate都在相同的包下，表示的时间，不包含日期
	 */
	@Test
	public void testLocalTime() {
		LocalTime localTime = LocalTime.now();

		LocalTime localTime1 = LocalTime.of(15, 20, 50);
		LocalTime localTime2 = LocalTime.parse("12:20:50");

		localTime.getHour();
		localTime.getMinute();
		localTime.getSecond();

		// 根据指定单位，计算到另一个时间的时间量
		long until = localTime.until(localTime1, ChronoUnit.HOURS);

		System.out.println(until);
	}

	/**
	 * LocalDateTime 既包含日期，又包含时间，经常和DateTimeFormatter一起使用
	 */
	@Test
	public void testLocalDateTime() {
		// 获取年月日，时分秒
		LocalDateTime localDateTime = LocalDateTime.now();

		// 构建日期时间
		LocalDateTime.of(LocalDate.now(), LocalTime.now());
		// 格式化当前时间
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateTimeFormatter.format(localDateTime));
	}

	/**
	 * 该类是一个计算类，提供了各种计算方法。例如获取某一天，某个月，第一天等等。该内部类基本上是通过JDK8的Lambda实现的
	 */
	public void testTemporalAdjusters() {
		LocalTime localTime = LocalTime.now();
		// TemporalAdjuster:时间校正器。
		// TemporalAdjusters:该类内部封装了大量的静态方法，TemporalAdjuster的实现。
		// 获取本月第一天
		localTime.with(TemporalAdjusters.firstDayOfMonth());
		// 获取本月最后一天
		localTime.with(TemporalAdjusters.lastDayOfMonth());
		// 获取本年第一天
		localTime.with(TemporalAdjusters.firstDayOfYear());
		// 本年最后一天
		localTime.with(TemporalAdjusters.lastDayOfYear());
		// 下一个周末
		localTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
	}
	
	/**
	 * Duration：计算两个“时间”之间的间隔
	 * Period：计算两个“日期”之间的间隔
	 */
	@Test
	public void testPeriodAndDuration() {
		LocalTime now1 = LocalTime.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LocalTime now2 = LocalTime.now();
		
		Duration duration = Duration.between(now1, now2);
		
		System.out.println(duration.toMillis());
		
		LocalDate now3 = LocalDate.now();
		
		LocalDate now4 = LocalDate.of(2018, 12, 12);
		
		// 计算两个日期的差值
		Period period = Period.between(now4, now3);
		
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
	}
	
	@Test
	public void testDateTimeFormatter() {
		DateTimeFormatter format = DateTimeFormatter.ISO_DATE;
		LocalDateTime localDateTime = LocalDateTime.now();
		String str1 = localDateTime.format(format);
		System.out.println(str1);
		
		// 自定义格式
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		String str2 = format1.format(LocalDateTime.now());
		System.out.println(str2);
		
	}
	
	public void test() {
		Predicate<Boolean> nonNull = Objects::nonNull;
		Supplier<Person> supplier = Person::new;
	}
	
	class Person {
		
		String name;
		
		public Person() {
			
		}
		
		public Person(String name) {
			this.name = name;
		}
		
	}
}
