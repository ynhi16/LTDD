package com.sinfloo.modeloDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.khachhangInterface;
import com.sinfloo.modelo.khachhang;

@Service
public class khachhangDAO implements khachhangInterface {
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Map<String, Object>> listar() {
		List<Map<String, Object>> list = template.queryForList("select * from khachhang");
		return list;
	}

	@Override
	public List<Map<String, Object>> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(khachhang p) {
		String sql = "insert into khachhang(tenKH, gioitinh, ngaysinh, SDT, idPX, diachi, email, taikhoan, matkhau)values(?,?,?,?,?,?,?,?,?)";
		return template.update(sql, p.getTenKH(), p.getGioitinh(),p.getNgaysinh(),p.getSDT(),p.getIdPX(),p.getDiachi(),p.getEmail(),p.getTaikhoan(),p.getMatkhau());
	}

	@Override
	public int edit(khachhang p) {
		String sql="update khachhang set tenKH=?,gioitinh=?,ngaysinh=?,SDT=?,idPX=?,diachi=?,email=?,taikhoan=?,matkhau=? where idKH=?";		
		return template.update(sql,p.getTenKH(), p.getGioitinh(),p.getNgaysinh(),p.getSDT(),p.getIdPX(),p.getDiachi(),p.getEmail(),p.getTaikhoan(),p.getMatkhau(),p.getIdKH());
	}

	@Override
	public int delete(int id) {
		String sql="delete from khachhang where idKH=?";
		return template.update(sql,id);
	}
}
