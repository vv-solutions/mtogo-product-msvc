package dk.vv.mtogo.product.msvc.repositories;

import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ProductRepositoryTestResource implements QuarkusTestResourceLifecycleManager {
    PostgreSQLContainer postgreSQLContainer;

    @Override
    public Map<String, String> start() {
        postgreSQLContainer = new PostgreSQLContainer("postgres:11-alpine");
        postgreSQLContainer.withInitScript("/sql/init.sql");
//        postgreSQLContainer.withExposedPorts(5432);
        postgreSQLContainer.withDatabaseName("product");
        postgreSQLContainer.withUsername("vv");
        postgreSQLContainer.withPassword("test");

//        Consumer<CreateContainerCmd> cmd = e ->{
//            e.withPortBindings(new PortBinding(Ports.Binding.bindPort(5432), new ExposedPort(5432)));
//        };
//
//        postgreSQLContainer.withCreateContainerCmdModifier(cmd);

        postgreSQLContainer.start();


        Map<String, String> conf = new HashMap<>();
        conf.put("quarkus.datasource.jdbc.url", postgreSQLContainer.getJdbcUrl()+"?currentSchema=product");
        conf.put("quarkus.datasource.username", postgreSQLContainer.getUsername());
        conf.put("quarkus.datasource.password", postgreSQLContainer.getPassword());
//        System.setProperty("quarkus.datasource.url", postgreSQLContainer.getJdbcUrl()+"?currentSchema=product");
//        System.setProperty("quarkus.datasource.username", postgreSQLContainer.getUsername());
//        System.setProperty("quarkus.datasource.password", postgreSQLContainer.getPassword());

        return conf;
    }

    @Override
    public void stop() {
        postgreSQLContainer.stop();
    }
}
