package com.wangbo.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IObjectMap {
	public Object getObjectFromResult(ResultSet rs) throws SQLException ;
}
