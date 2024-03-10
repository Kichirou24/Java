// Nhap thoi gian xe vao: hh:mm dd/MM/yyyy
// Nhap thoi gian xe ra: hh:mm dd/MM/yyyy
// Nhap loai xe: 1(xe dap) 2(xe may) 3(o to)
// In ra tien gui: xe dap(500d/h) xe may(1000/h) o to(2000d/h)

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class bt1 {
	public static void main(String[] args) {
		try{
			Scanner nhap = new Scanner(System.in);
			System.out.print("Nhap thoi gian xe vao: ");
			String ngay1= nhap.nextLine();
			System.out.print("Nhap thoi gian xe ra: ");
			String ngay2= nhap.nextLine();
			System.out.print("Nhap loai xe: ");
			String type = nhap.nextLine();
			
			SimpleDateFormat f= new SimpleDateFormat("hh:mm dd/MM/yyyy"); // dinh dang lai
			
			Date d1= f.parse(ngay1); // string -> date
			Date d2= f.parse(ngay2);
			
			long hieu = d2.getTime()-d1.getTime(); // getTime() date -> ms
			
			double SoGio= hieu/3600000.0;
			  
			double TienGui = 0;
			
			if (type.equals("xe dap"))
			{
				TienGui = 500 * Math.ceil(SoGio); // Math.ceil() lam tron len
			}
			else if (type.equals("xe may"))
			{
				TienGui = 1000 * Math.ceil(SoGio);
			}
			else if (type.equals("xe o to"))
			{
				TienGui = 2000 * Math.ceil(SoGio);
			}
			  
			System.out.println("So tien gui xe la: " + TienGui);
			nhap.close();
		  } catch(Exception e){
		}
		
	}
}