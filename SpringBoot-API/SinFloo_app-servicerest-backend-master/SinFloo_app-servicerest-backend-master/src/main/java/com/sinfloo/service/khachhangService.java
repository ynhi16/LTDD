package com.sinfloo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.khachhangInterface;
import com.sinfloo.modelo.khachhang;
import com.sinfloo.modeloDAO.khachhangDAO;

@Service
public class khachhangService implements khachhangInterface{

	@Autowired
	khachhangDAO dao;
	
	@Override
	public List<Map<String, Object>> listar() {
		return dao.listar();
	}

	@Override
	public List<Map<String, Object>> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(khachhang p) {
		return dao.add(p);
	}

	@Override
	public int edit(khachhang p) {
		return dao.edit(p);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}

}
