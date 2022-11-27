package com.crio.starter.data;

import lombok.*;
import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data 
@Document(collection = "memes") 

public class GreetingsEntity { 

  @Id   
  String id;

  @NotBlank 
  String name;

  @NotBlank 
  String url;

  @NotBlank 
  String caption;

}
