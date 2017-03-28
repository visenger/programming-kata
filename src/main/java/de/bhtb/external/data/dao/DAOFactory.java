package de.bhtb.external.data.dao;

import de.bhtb.external.data.dao.entities.CustomerDAO;
import de.bhtb.external.data.dao.entities.OrderDAO;
import de.bhtb.external.data.dao.flat.file.FlatFileDAOFactory;
import de.bhtb.external.data.dao.oracle.OracleDAOFactory;
import de.bhtb.external.data.dao.postgresql.PostgresqlDAOFactory;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Core J2EE Patterns - Data Access Object
 * <p>
 * <p>
 * Context
 * Access to data varies depending on the source of the data. Access to persistent storage, such as to
 * a database, varies greatly depending on the type of storage (relational databases, object-oriented databases,
 * flat files, and so forth) and the vendor implementation.
 * <p>
 * from: http://www.oracle.com/technetwork/java/dataaccessobject-138824.html
 * Problem
 * Many real-world Java 2 Platform, Enterprise Edition (J2EE) applications need to use persistent data
 * at some point. For many applications, persistent storage is implemented with different mechanisms,
 * and there are marked differences in the APIs used to access these different persistent storage mechanisms.
 * Other applications may need to access data that resides on separate systems. For example, the data may
 * reside in mainframe systems, Lightweight Directory Access Protocol (LDAP) repositories, and so forth.
 * Another example is where data is provided by services through external systems such as business-to-business
 * (B2B) integration systems, credit card bureau service, and so forth.
 * <p>
 * Typically, applications use shared distributed components such as entity beans to represent persistent data.
 * An application is considered to employ bean-managed persistence (BMP) for its entity beans when these entity
 * beans explicitly access the persistent storage-the entity bean includes code to directly access the persistent
 * storage. An application with simpler requirements may forego using entity beans and instead use session beans
 * or servlets to directly access the persistent storage to retrieve and modify the data. Or, the application
 * could use entity beans with container-managed persistence, and thus let the container handle the transaction
 * and persistent details.
 * <p>
 * Applications can use the JDBC API to access data residing in a relational database management system (RDBMS).
 * The JDBC API enables standard access and manipulation of data in persistent storage, such as a relational
 * database. The JDBC API enables J2EE applications to use SQL statements, which are the standard means
 * for accessing RDBMS tables. However, even within an RDBMS environment, the actual syntax and format of
 * the SQL statements may vary depending on the particular database product.
 * <p>
 * There is even greater variation with different types of persistent storage. Access mechanisms, supported APIs,
 * and features vary between different types of persistent stores such as RDBMS, object-oriented databases,
 * flat files, and so forth. Applications that need to access data from a legacy or disparate system (such as a mainframe,
 * or B2B service) are often required to use APIs that may be proprietary. Such disparate data sources offer
 * challenges to the application and can potentially create a direct dependency between application code and
 * data access code. When business components-entity beans, session beans, and even presentation components
 * like servlets and helper objects for JavaServer Pages (JSP) pages --need to access a data source, they can use
 * the appropriate API to achieve connectivity and manipulate the data source. But including the connectivity and
 * data access code within these components introduces a tight coupling between the components and the data source
 * implementation. Such code dependencies in components make it difficult and tedious to migrate the application
 * from one type of data source to another. When the data source changes, the components need to be changed to
 * handle the new type of data source.
 */
public abstract class DAOFactory {

    public abstract CustomerDAO getCustomerDAO() ;

    public abstract OrderDAO getOrderDAO();

    public static Optional<DAOFactory> getDAOFactory(Type type) {
        switch (type) {
            case ORACLE:
                return Optional.of(new OracleDAOFactory());
            case POSTGRESQL:
                return Optional.of(new PostgresqlDAOFactory());
            case FILE:
                return Optional.of(new FlatFileDAOFactory());
            default:
                return Optional.empty();

        }
    }

}
