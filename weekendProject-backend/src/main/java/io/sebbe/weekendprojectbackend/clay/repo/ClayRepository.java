package io.sebbe.weekendprojectbackend.clay.repo;

import io.sebbe.weekendprojectbackend.clay.model.Clay;
import org.springframework.data.repository.ListCrudRepository;

public interface ClayRepository extends ListCrudRepository<Clay, String> {
}
