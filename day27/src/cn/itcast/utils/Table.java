package cn.itcast.utils;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ע�⣬����������
 * @author Jie.Yuan
 *
 */
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)  // ָ��ע��������ʱ����Ч
public @interface Table {

	String tableName();
}