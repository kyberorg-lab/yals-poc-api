package eu.kyberorg.yals.api.models.dao;

import eu.kyberorg.yals.api.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkDao extends JpaRepository<Link, Long> {
	Optional<Link> findSingleByIdent(String linkIdent);
}
