package br.com.restlombok.api.domain;

import br.com.restlombok.api.input.ProjectInput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private final UUID uuid = UUID.randomUUID();

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String owner;

    public Project toDomain(ProjectInput projectInput){
        final ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(projectInput, this.getClass());
    }
}
