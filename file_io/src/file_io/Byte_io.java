package file_io;

import java.io.FileInputStream;

public class Byte_io {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		int ch;
		
		try {
			FileInputStream file=new FileInputStream("text.txt");
			while((ch=file.read())!=-1)
			{
				sb.append((char)ch);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			System.out.println(sb);
			
		}
	}

}
