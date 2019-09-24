package cn.itcast.d_anno;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;

/**
 * �Զ���ע��  (����һ������)
 * @author Jie.Yuan
 *
 */
// Ԫע�� - 1. ����ע��Ŀ��÷�Χ
@Target({TYPE,FIELD , METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
//@Target({METHOD,FIELD,TYPE})   ָ��ֻ���ڷ������ֶΡ������ã�

// Ԫע�� - 2. ָ��ע�����������
@Retention(RetentionPolicy.RUNTIME)   // �ֽ��뼶����Ч
public @interface Author {
	
	String authorName() default "Jet";
	int age() default 30;	
	String remark();
}
