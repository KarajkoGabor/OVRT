package hu.kutya.car.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarEventRepository extends MongoRepository<CarCommand, String> {
}
