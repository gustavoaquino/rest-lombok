package br.com.restlombok.api.controller;


import br.com.restlombok.api.domain.Project;
import br.com.restlombok.api.input.ProjectInput;
import br.com.restlombok.api.output.ProjectOutput;
import br.com.restlombok.api.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "v1/projects", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<ProjectOutput> listar(){
        final List<Project> projectList = this.projectService.findAll();

        if(projectList.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        final ProjectOutput projectOutput = new ProjectOutput().toBuilder().projectList(projectList).build();

        return new ResponseEntity<>(projectOutput, HttpStatus.OK);
   }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectOutput> buscar(@PathVariable("id") Long id){
        final Optional<Project> project = this.projectService.findById(id);

        if(project.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        final ProjectOutput projectOutput = new ProjectOutput().toBuilder().project(project.get()).build();

        return new ResponseEntity<>(projectOutput, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectOutput> adicionar(@RequestBody ProjectInput projectInput){
        Project project = new Project().toDomain(projectInput);

        project = this.projectService.save(project);

        final ProjectOutput projectOutput = new ProjectOutput().toBuilder().project(project).build();

        return new ResponseEntity<>(projectOutput, HttpStatus.CREATED);
    }

}
