package cn.itcast.utils;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����һ�������ֶ�
 * @author Jie.Yuan
 *
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)  // ָ��ע��������ʱ����Ч
public @interface Id {

}
