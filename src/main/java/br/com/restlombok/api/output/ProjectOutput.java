package br.com.restlombok.api.output;


import br.com.restlombok.api.domain.Project;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProjectOutput {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Project> projectList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Project project;
}
