package com.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.guest.jdbc.JdbcUtil;
import com.guest.model.Message;


public class MessageDao {
	private static MessageDao messageDao = new MessageDao();

	public static MessageDao getInstance() {
		return messageDao;
	}

	private MessageDao() {
	}

	public int insert(Connection conn, Message message) throws SQLException {
		// 1. 클래스 로딩 : listener 에서 이미 로딩됨
		// 2. 연결 생성 : 파라미터로 받음
		// 3. statement 생성 : 메소드 내
		// 4. 쿼리 실행 : 메소드 내
		// 5. 결과 처리 : 호출한 곳에서.
		// 6. 자원 닫기
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO guestbook_message "
					+ "(guest_name, password, message) "
					+ "values (?, ?, ?) ");
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	
}











