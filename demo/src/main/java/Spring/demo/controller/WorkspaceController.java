package Spring.demo.controller;

import Spring.demo.domain.Workspace;
import Spring.demo.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspaces")
public class WorkspaceController {
    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping
    public ResponseEntity<List<Workspace>> getAllWorkspaces() {
        return new ResponseEntity<>(workspaceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workspace> getWorkspaceById(@PathVariable Long id) {
        return workspaceService.findById(id)
                .map(workspace -> new ResponseEntity<>(workspace, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Workspace> createWorkspace(@RequestBody Workspace workspace) {
        return new ResponseEntity<>(workspaceService.save(workspace), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workspace> updateWorkspace(@PathVariable Long id, @RequestBody Workspace updatedWorkspace) {
        return workspaceService.findById(id).map(workspace -> {
            workspace.setName(updatedWorkspace.getName());
            workspace.setUsers(updatedWorkspace.getUsers());
            return new ResponseEntity<>(workspaceService.save(workspace), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable Long id) {
        workspaceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
