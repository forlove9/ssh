package dao;

import java.util.List;

import entity.FoodType;

public interface IFoodTypeDao {
	void save(FoodType footType);
	void delete(int id);
	void update(FoodType footType);
	FoodType findById(int id);
	List<FoodType> getAll();
	List<FoodType> getAll(String typeName);
	
}
