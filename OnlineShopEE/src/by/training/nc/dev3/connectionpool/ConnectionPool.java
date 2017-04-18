package by.training.nc.dev3.connectionpool;


import by.training.nc.dev3.constants.ConfigsConstants;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionPool {
	INSTANCE;

	private DataSource dataSource;
	private Connection connection;

	{
		try{
			InitialContext initContext = new InitialContext();
			dataSource = (DataSource) initContext.lookup(ConfigsConstants.DATABASE_SOURCE);
		}
		catch(NamingException e){
			System.out.println("error");
		}
	}

	public Connection getConnection() throws SQLException{
		connection = dataSource.getConnection();
		return connection;
	}

	public void releaseConnection(Connection connection) {
		if(connection != null){
			try {
				connection.close();
			}
			catch (SQLException e) {
				System.out.println("error");
			}
		}
	}
}