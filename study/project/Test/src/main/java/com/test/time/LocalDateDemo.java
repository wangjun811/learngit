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
	 * LocalDate java.time.LocalDate����࣬��������ʾ���ڵģ�Ҳ����������
	 */
	@Test
	public void testLocalDate() {
		// ��ȡ��ǰ���ڣ������գ�
		LocalDate now = LocalDate.now();
		System.out.println(now);

		// ���������չ�������
		LocalDate of = LocalDate.of(2019, 7, 12);
		System.out.println(of);
		// �ַ���ת�����ڣ�Ĭ�ϰ���yyyy-MM-dd��ʽ
		LocalDate parse = LocalDate.parse("2019-07-12");
		System.out.println(parse);
		// ��ȡ���µĵ�һ��
		LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(firstDayOfMonth);
		// ��ȡ���µ����һ��
		LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(lastDayOfMonth);
		// ��ȡ���µ�5��
		LocalDate dayOfMonth = now.withDayOfMonth(5);
		System.out.println(dayOfMonth);
		// ����
		LocalDate tommorrowDay = now.plusDays(1L);
		System.out.println(tommorrowDay);
		// ����
		LocalDate yesterday = now.minusDays(1L);
		System.out.println(yesterday);
		// ������������ʱ�������
		long days = now.until(lastDayOfMonth, ChronoUnit.DAYS);
		System.out.println(days);

	}

	/**
	 * LocalTime ��LocalDate��ͬ��LocalTime��LocalDate������ͬ�İ��£���ʾ��ʱ�䣬����������
	 */
	@Test
	public void testLocalTime() {
		LocalTime localTime = LocalTime.now();

		LocalTime localTime1 = LocalTime.of(15, 20, 50);
		LocalTime localTime2 = LocalTime.parse("12:20:50");

		localTime.getHour();
		localTime.getMinute();
		localTime.getSecond();

		// ����ָ����λ�����㵽��һ��ʱ���ʱ����
		long until = localTime.until(localTime1, ChronoUnit.HOURS);

		System.out.println(until);
	}

	/**
	 * LocalDateTime �Ȱ������ڣ��ְ���ʱ�䣬������DateTimeFormatterһ��ʹ��
	 */
	@Test
	public void testLocalDateTime() {
		// ��ȡ�����գ�ʱ����
		LocalDateTime localDateTime = LocalDateTime.now();

		// ��������ʱ��
		LocalDateTime.of(LocalDate.now(), LocalTime.now());
		// ��ʽ����ǰʱ��
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateTimeFormatter.format(localDateTime));
	}

	/**
	 * ������һ�������࣬�ṩ�˸��ּ��㷽���������ȡĳһ�죬ĳ���£���һ��ȵȡ����ڲ����������ͨ��JDK8��Lambdaʵ�ֵ�
	 */
	public void testTemporalAdjusters() {
		LocalTime localTime = LocalTime.now();
		// TemporalAdjuster:ʱ��У������
		// TemporalAdjusters:�����ڲ���װ�˴����ľ�̬������TemporalAdjuster��ʵ�֡�
		// ��ȡ���µ�һ��
		localTime.with(TemporalAdjusters.firstDayOfMonth());
		// ��ȡ�������һ��
		localTime.with(TemporalAdjusters.lastDayOfMonth());
		// ��ȡ�����һ��
		localTime.with(TemporalAdjusters.firstDayOfYear());
		// �������һ��
		localTime.with(TemporalAdjusters.lastDayOfYear());
		// ��һ����ĩ
		localTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
	}
	
	/**
	 * Duration������������ʱ�䡱֮��ļ��
	 * Period���������������ڡ�֮��ļ��
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
		
		// �����������ڵĲ�ֵ
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
		
		// �Զ����ʽ
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy��MM��dd��");
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
