package med.voll.api.medico;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
    
}
