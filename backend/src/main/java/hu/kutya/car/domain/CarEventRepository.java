package hu.kutya.car.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarEventRepository extends MongoRepository<CarCommand, String> {
    List<CarCommand> getByCarIdOrderByCreatedAsc(UUID carId);
}
