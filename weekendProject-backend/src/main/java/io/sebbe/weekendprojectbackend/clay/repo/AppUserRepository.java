package io.sebbe.weekendprojectbackend.clay.repo;

import io.sebbe.weekendprojectbackend.clay.model.AppUser;
import org.springframework.data.repository.ListCrudRepository;

public interface AppUserRepository extends ListCrudRepository<AppUser, String> {
}