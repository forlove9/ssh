package cn.itcast.a_generic;

/**
 * ���ͽӿ�
 * @author Jie.Yuan
 *
 * @param <T>
 */
public interface IBaseDao<T> {

	void save(T t );
	void update(T t );
}
