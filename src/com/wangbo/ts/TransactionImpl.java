package com.wangbo.ts;

import java.sql.SQLException;

import com.wangbo.util.DbUtil;

public class TransactionImpl{


	public void beginTransaction() {
		try {
			DbUtil.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void rollback() {
		try {
			DbUtil.getConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public void commit() {
		try {
			DbUtil.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
