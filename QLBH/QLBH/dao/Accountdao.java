package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Accountbean;

public class Accountdao {
	public ArrayList<Accountbean> getAccount() throws Exception{
		ArrayList<Accountbean> ds = new ArrayList<Accountbean>();
		try {
			KetNoidao kn = new KetNoidao();
			kn.KetNoi();
			
			String sql = "SELECT * FROM Account";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next())
			{
				String username = rs.getString("username");
				String fullname = rs.getString("fullname");
				String haspassword = rs.getString("password");
				
				ds.add(new Accountbean(username, fullname, haspassword));
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	/*
	public String hashPassword(String password) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return myHash;
	}
	*/
	public Boolean check(String username, String password) throws Exception {
		Accountdao adao = new Accountdao();
//		String myHash = hashPassword(password);
		String myHash = password;
		try {
			for (Accountbean acc : adao.getAccount())
			{
				if (acc.getUsername().equals(username) && acc.getPassword().equals(myHash))
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int register(Accountbean acc) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();			
		
		String sql = "INSERT INTO Account(username, fullname, password) VALUES(?, ?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, acc.getUsername());
		cmd.setString(2, acc.getFullname());
		
//		String myHash = hashPassword(acc.getPassword());
		String myHash = acc.getPassword();
        
		cmd.setString(3, myHash);
		
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
