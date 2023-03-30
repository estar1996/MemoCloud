package Spring.demo.repository;

import Spring.demo.domain.MemoPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoPageRepository extends JpaRepository<MemoPage,Long> {
}
