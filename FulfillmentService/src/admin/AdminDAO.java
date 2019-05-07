package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.DBManager; 

public class AdminDAO {
	private static final Logger LOG = LoggerFactory.getLogger(AdminDAO.class);
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	
	public int verifyIdPassword(String id, String password) {
		return ID_PASSWORD_MATCH;
	}
	
	public ArrayList<AdminDTO> getAllAdmins() {
		ArrayList<AdminDTO> aList = new ArrayList<AdminDTO>();
		conn = DBManager.getConnection();
		String sql = "select * from admins;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AdminDTO aDto = new AdminDTO();
				aDto.setaId(rs.getInt(1));
				aDto.setaUserId(rs.getString(2));
				aDto.setaName(rs.getString(3));
				aDto.setaPassword(rs.getString(4));
				LOG.trace(aDto.toString());
				aList.add(aDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("getAllCustomers(): Error Code : {}", e.getErrorCode());
			return null;
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return aList;
	}
	
	public String getLastId() {
		String aUserId = null;
		conn = DBManager.getConnection();
		String sql = "select a_userId from admins order by a_userId desc limit 1;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				aUserId = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("getLastId(): Error Code : {}", e.getErrorCode());
			return null;
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return aUserId;
	}
	
	public AdminDTO getOneAdmin(String aUserId) {
		AdminDTO aDto = new AdminDTO();
		conn = DBManager.getConnection();
		String sql = "select * from admins where a_userId=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aUserId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				aDto.setaId(rs.getInt(1));
				aDto.setaUserId(aUserId);
				aDto.setaName(rs.getString(3));
				aDto.setaPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("getOneCustomer(): Error Code : {}", e.getErrorCode());
			return null;
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return aDto;
	}
}
