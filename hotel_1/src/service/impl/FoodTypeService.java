package service.impl;

import java.util.List;

import javax.enterprise.inject.New;

import dao.IFoodTypeDao;
import dao.impl.FoodTypeDao;
import entity.FoodType;
import service.IFoodTypeService;

public class FoodTypeService implements IFoodTypeService {
	private IFoodTypeDao foodTypeDao=new FoodTypeDao();
	@Override
	public void save(FoodType foodType) {
		// TODO Auto-generated method stub
		try {
			foodTypeDao.save(foodType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(FoodType foodType) {
		// TODO Auto-generated method stub
		try {
			foodTypeDao.update(foodType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			foodTypeDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public FoodType findById(int id) {
		// TODO Auto-generated method stub
		try {
			return foodTypeDao.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll() {
		// TODO Auto-generated method stub
		try {
			return foodTypeDao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll(String typeName) {
		// TODO Auto-generated method stub
		
		try {
			return foodTypeDao.getAll(typeName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
