package Spring.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "workspaces")
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "workspaces")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "workspace", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MemoPage> memoPages = new HashSet<>();
}
