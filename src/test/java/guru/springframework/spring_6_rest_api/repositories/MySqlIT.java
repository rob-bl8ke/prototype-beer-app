package guru.springframework.spring_6_rest_api.repositories;

import java.util.List;

// import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import guru.springframework.spring_6_rest_api.entities.Beer;
import static org.assertj.core.api.Assertions.assertThat;

// Run against a containerized MySQL instance.
@Testcontainers
@SpringBootTest
@ActiveProfiles("localmysql")

// Benchmark performance. Downside to test containers is performance!
// @Disabled

public class MySqlIT {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8");

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testListBeers() {
        List<Beer> beers = beerRepository.findAll();
        assertThat(beers.size()).isGreaterThan(0);
    }
}
