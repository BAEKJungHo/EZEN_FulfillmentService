package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.DBManager;

public class CustomerDAO {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerDAO.class);
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	
	public int verifyIdPassword(String cUserId, String password) {
		return ID_PASSWORD_MATCH;
	}
	
	public ArrayList<CustomerDTO> getAllCustomers() {
		ArrayList<CustomerDTO> cList = new ArrayList<CustomerDTO>();
		conn = DBManager.getConnection();
		String sql = "select * from customers;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CustomerDTO cDto = new CustomerDTO();
				cDto.setcId(rs.getInt(1));
				cDto.setcUserId(rs.getString(2));
				cDto.setcName(rs.getString(3));
				cDto.setcPassword(rs.getString(4));
				cList.add(cDto);
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
		return cList;
	}
	
	public void addCustomer(CustomerDTO cDto) {
		LOG.trace("addCustomer(): " + cDto.toString());
		BCrypt bc = new BCrypt();
		conn = DBManager.getConnection();
		String sql = "insert into customers(c_userId, c_name, c_password) values(?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cDto.getcUserId());
			pstmt.setString(2, cDto.getcName());
			pstmt.setString(3, cDto.getcPassword()); 
			//bc.hashpw(cDto.getcPassword(), bc.gensalt(10))
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("addCustomer() Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getLastId() {
		String cUserId = null;
		conn = DBManager.getConnection();
		String sql = "select c_userId from customers order by c_userId desc limit 1;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cUserId = rs.getString(1);
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
		return cUserId;
	}
	
	public CustomerDTO getOneCustomer(String cUserId) {
		CustomerDTO cDto = new CustomerDTO();
		conn = DBManager.getConnection();
		String sql = "select * from customers where c_userId=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cUserId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cDto.setcId(rs.getInt(1));
				cDto.setcUserId(cUserId);
				cDto.setcName(rs.getString(3));
				cDto.setcPassword(rs.getString(4));
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
		return cDto;
	}
}
