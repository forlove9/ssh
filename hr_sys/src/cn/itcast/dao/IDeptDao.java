package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Dept;

public interface IDeptDao {
	List<Dept> getAll();

	Dept findById(int id);
}
