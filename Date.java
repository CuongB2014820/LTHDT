package thuchanh2;

import java.util.Scanner;

public class Date {
	private int ngay,thang,nam;
	public Date(){
		ngay=1;
		thang=1;
		nam=2024;

	}
	public Date(int x,int y,int z){
		this.ngay=x;
		this.thang=y;
		this.nam=z;
	}
	public void hienThi(){
		System.out.println("Ngay "+ngay+"/"+thang+"/"+nam);
	}
	public int nhapSo(){
		Scanner kb=new Scanner(System.in);
		int n=0;
		String str;
		while(true){
			try{
				str=kb.nextLine();
				n=Integer.parseInt(str);
				return n;
			} catch (NumberFormatException e){
				System.out.println("Nhap sai, vui long nhap lai!");
			}
		}
	}
	public void nhapDate(){
		while(true){
			System.out.println("Nhap ngay:");
			ngay=nhapSo();
			System.out.println("Nhap thang:");
			thang=nhapSo();
			System.out.println("Nhap nam:");
			nam=nhapSo();
			if(hopLe()) break;
			System.out.println("Ngay/Thang/Nam khong hop le!-Nhap lai.");
		}
	}
	public boolean hopLe(){
		if(ngay<1 || thang<1 || thang>12)
			return false;
		if(thang==2 && nam%4==0)
			return (ngay<=29);
		int songaymax[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
		return ngay<=songaymax[thang];
		
	}
	public Date ngayMai(){
		if(ngay==28 && thang==2 && nam%4==0)
			return new Date(29,2,nam);
		Date kq=new Date(ngay+1,thang,nam);
		int songaymax[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(kq.ngay>songaymax[kq.thang]){
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
