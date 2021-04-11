package br.com.restlombok.api.input;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjectInput {
    private String title;
    private String owner;
}
