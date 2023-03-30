package Spring.demo.service;

import Spring.demo.domain.Workspace;
import Spring.demo.repository.WorkspaceRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    public List<Workspace> findAll() {
        return workspaceRepository.findAll();
    }
    public Optional<Workspace> findById(Long id) {
        return workspaceRepository.findById(id);
    }
    public Workspace save(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    public void deleteById(Long id) {
        workspaceRepository.deleteById(id);
    }


}
