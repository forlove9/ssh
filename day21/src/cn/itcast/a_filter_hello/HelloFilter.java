package cn.itcast.a_filter_hello;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ������������
 * @author Jie.Yuan
 *
 */
public class HelloFilter implements Filter{
	
	// ����ʵ��
	public HelloFilter(){
		System.out.println("1. ����������ʵ��");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2. ִ�й�������ʼ������");
		
		// ��ȡ��������web.xml�����õĳ�ʼ������
		String encoding = filterConfig.getInitParameter("encoding");
		System.out.println(encoding);
		
		// ��ȡ��������web.xml�����õĳ�ʼ������ ������
		Enumeration<String> enums =  filterConfig.getInitParameterNames();
		while (enums.hasMoreElements()){
			// ��ȡ���в������ƣ�encoding��path
			String name = enums.nextElement();
			// ��ȡ���ƶ�Ӧ��ֵ
			String value = filterConfig.getInitParameter(name);
			System.out.println(name + "\t" + value);
		}
	}

	// ������ҵ�������� �����󵽴�servlet֮ǰ�Ƚ���˷��������õ�ҵ���߼�����
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("3. ִ�й�����ҵ������");
		// ���� (ȥ��Servlet)
		// �������һ����������������һ���������������ִ�з���servlet
		chain.doFilter(request, response);
		
		System.out.println("5. Servlet������ɣ��ֻص�������");
	}

	@Override
	public void destroy() {
		System.out.println("6. ���ٹ�����ʵ��");
	}

}
