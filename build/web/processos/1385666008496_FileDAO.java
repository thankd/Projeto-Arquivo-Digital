package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.File;

public class FileDAO {
	
	public boolean add(File file) {
		int added = 0;
//		try {
//			Connection con = ConnectionFactory.createConnection();
//			if (con != null) {
//				String sql = "INSERT INTO file (name, description, data) VALUES (?, ?, ?)";
//				PreparedStatement st = con.prepareStatement(sql);
//				st.setString(1, file.getName());
//				st.setString(2, file.getDescription());
//				st.setBytes(3, file.getData());
//				added = st.executeUpdate();
//				st.close();
//				con.close();
//			}
//		} catch (SQLException e) {
//			//tratar erro
//		}
//
		return added > 0;
	}

	public List list() {
		List files = new ArrayList();
//		try {
//			Connection con = ConnectionFactory.createConnection();
//			if (con != null) {
//				String sql = "SELECT * FROM file";
//				Statement st = con.createStatement();
//				ResultSet rs = st.execute(sql);
//
//				while(rs.next()){
//					File file = createFile(rs);
//					files.add(file);
//				}
//
//				st.close();
//				con.close();
//			}
//		} catch (SQLException e) {
//			//tratar erro
//		}
//
		return files;
	}

	public File getFile(long id) {
		File file = null;
//		try {
//			Connection con = ConnectionFactory.createConnection();
//			if (con != null) {
//				String sql = "SELECT * FROM file WHERE id=?";
//				PreparedStatement st = con.prepareStatement(sql);
//				st.setLong(1, id);
//				ResultSet rs = st.executeQuery();
//				if (rs.next()) {
//					file = createFile(rs);
//				}
//				rs.close();
//				st.close();
//				con.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return file;
	}

	private File createFile(ResultSet rs) throws SQLException {
		File file = new File();
		file.setData(rs.getBytes("data"));
		file.setId(rs.getLong("id"));
		file.setName(rs.getString("name"));
		file.setDescription(rs.getString("description"));

		return file;
	}
}
