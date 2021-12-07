package com.sinfloo.controler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinfloo.modelo.khachhang;
import com.sinfloo.service.khachhangService;

@RestController
@RequestMapping("/khachhang")
public class khachhangController {
	@Autowired //sẽ tự động inject bean tương ứng vào vị trí được đánh dấu
	private khachhangService service;
	@GetMapping("/listar")//xử lý hàm bằng phương thức get
	public List<Map<String, Object>> listar(Model model) {
		return service.listar();
	}
	@PostMapping("/insert")
	public String save(@RequestBody khachhang p,Model model) {
		int idKH=service.add(p);
		if(idKH==0) {
			return "thêm không thành công";
		}
		return "Đã thêm thành công";
		
	}
	
	@PostMapping("/update/{idKH}")//xử  lý hàm bằng phương thức post
	public String save(@RequestBody khachhang p,@PathVariable int id,Model model) {
		p.setIdKH(id);
		int r=service.edit(p);
		if(r==0) {
			return "Không thể cập nhật";
		}
		return "câp nhật thành công";
		
	}
	@PostMapping("/delete/{idKH}")
	public String delete(@PathVariable int p,Model model) {
		int r=service.delete(p);
		if(r==0) {
			return "Xóa không thành công";
		}
		return "Đã xóa thành công";
	}
}
