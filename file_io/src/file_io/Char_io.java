package file_io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Char_io {
	public static void main(String[] args) {
		String s="hello all good afternoon";
		try
		{
			BufferedOutputStream filein=new BufferedOutputStream(new FileOutputStream("demo.txt"));
			filein.write(s.getBytes());
			filein.flush();
			System.out.println("data enter in demo.txt succefully");

		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
