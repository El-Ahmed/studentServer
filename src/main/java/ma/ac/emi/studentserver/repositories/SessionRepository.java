package ma.ac.emi.studentserver.repositories;

import ma.ac.emi.studentserver.entities.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SessionRepository extends MongoRepository<Session, String > {

    Optional<Session> findByQrCode(String qrCode);
}
