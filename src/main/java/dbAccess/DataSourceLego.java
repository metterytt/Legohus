package dbAccess;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceLego {

    private final MysqlDataSource dataSource = new MysqlDataSource();

    public DataSourceLego() {
        dataSource.setServerName("159.89.99.43");
        dataSource.setPort(3306);
        dataSource.setUser("legouser");
        dataSource.setPassword("LEGO99hus");
        dataSource.setDatabaseName("legohus");
    }

    public MysqlDataSource getDataSource() {
        return dataSource;
    }

}
