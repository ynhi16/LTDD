package com.sinfloo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="khachhang")
@Entity
public class khachhang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idKH;
	@Column
	private String tenKH;
	@Column
	private String gioitinh;
	@Column
	private int ngaysinh;
	@Column
	private int SDT;
	@Column
	private int idPX;
	@Column
	private String diachi;
	@Column
	private String email;
	@Column
	private String taikhoan;
	@Column
	private String matkhau;
	public khachhang() {
		
	}
	public int getIdKH() {
		return idKH;
	}
	public void setIdKH(int idKH) {
		this.idKH = idKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public int getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(int ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}
	public int getIdPX() {
		return idPX;
	}
	public void setIdPX(int idPX) {
		this.idPX = idPX;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	
}
