package br.com.restlombok.api.service;


import br.com.restlombok.api.domain.Project;
import br.com.restlombok.api.respository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll(){
        return this.projectRepository.findAll();
    }

    public Optional<Project> findById(Long id){
        return this.projectRepository.findById(id);
    }

    public Project save(Project project){
       return this.projectRepository.save(project);
    }


}
