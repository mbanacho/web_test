package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.Office;

public interface OfficeRepository extends JpaRepository<Office,String> {
}
