package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.IFoodTypeDao;
import entity.FoodType;
import utils.JdbcUtils;

public class FoodTypeDao implements IFoodTypeDao {

	@Override
	public void save(FoodType foodType) {
		// TODO Auto-generated method stub
		String sql="insert into foodType (typeName) values(?)";
		try {
			JdbcUtils.getQuerrRunner().update(sql,foodType.getTypeName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from foodType where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql,id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(FoodType footType) {
		// TODO Auto-generated method stub
		String sql="update  foodType set typeName=? where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql,footType.getTypeName(),footType.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public FoodType findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from foodType where id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<FoodType>(FoodType.class),id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from foodType";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll(String typeName) {
		// TODO Auto-generated method stub
		String sql="select * from foodType where typeName=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class),typeName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

}
