import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class guiXe {
	public void doc()
	{
		try {
			FileInputStream f = new FileInputStream("input1.txt");
			InputStreamReader i = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(i);
			
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null) break;
				String[] ds = st.split("[;]");
			}
			
		} catch (Exception e)
		{
			System.out.println("Errrorrrrr doc" + e.getMessage());
		}
		
		
	}
}
