package service;

import java.util.List;

import entity.FoodType;

public interface IFoodTypeService {
	void save(FoodType foodType);
	void update(FoodType foodType);
	void delete(int id);
	FoodType findById(int id);
	List<FoodType> getAll();
	List<FoodType> getAll(String typeName);
}
