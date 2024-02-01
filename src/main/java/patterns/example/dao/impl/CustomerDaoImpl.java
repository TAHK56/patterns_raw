package patterns.example.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patterns.example.dao.CustomerDao;
import patterns.example.entity.Customer;
import patterns.example.util.SourceConnection;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class CustomerDaoImpl implements CustomerDao {

    private static final Path Path_CUSTOMER_DB = FileSystems.getDefault()
            .getPath("src", "main", "resources", "customer.txt");
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Override
    public void create(Customer customer) {
        try (var writer = SourceConnection.writeToDB(Path_CUSTOMER_DB)) {
            writer.write(customer.toString());
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
