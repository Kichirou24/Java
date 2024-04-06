package bo;

import java.util.ArrayList;

import bean.Accountbean;
import dao.Accountdao;

public class Accountbo {
	Accountdao adao = new Accountdao();
	ArrayList<Accountbean> ds = new ArrayList<Accountbean>();
	
	public ArrayList<Accountbean> getAccount() throws Exception{
		ds = adao.getAccount();
		return ds;
	}
	public Boolean check(String username, String password) throws Exception{
		return adao.check(username, password);
	}
	
	public int register(Accountbean acc) throws Exception
	{
		for (Accountbean ac : adao.getAccount())
		{
			if (ac.getUsername().trim().equals(acc.getUsername().trim()))
			{
				return 0;
			}
		}
		return adao.register(acc);
	}
}