package com.crio.starter.controller;

import com.crio.starter.data.GreetingsEntity;
import com.crio.starter.exchange.GetMemesResponse;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.service.GreetingsService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

  @Autowired
  private GreetingsService mservice;
  
  @PostMapping("/memes/")
  public ResponseEntity<PostMemeResponse> StoreMeme(@Valid @RequestBody GreetingsEntity meme) {

    boolean isPresent = mservice.addMeme(meme);

    PostMemeResponse response = new PostMemeResponse(meme.getId()); 

    if (isPresent) return new ResponseEntity<>(HttpStatus.CONFLICT); 
    else return new ResponseEntity<>(response, HttpStatus.CREATED);
  }


  @GetMapping("/memes/")
  public List<GreetingsEntity> GetAllMemes() {

    GetMemesResponse memelistobj = mservice.getMemes();

    return memelistobj.getMemelist();
    
  }

  
  @GetMapping("/memes/{id}")
  public ResponseEntity<GreetingsEntity> GetMemeById(@PathVariable String id) {

    Optional<GreetingsEntity> memeInfo = mservice.getMeme(id);

    if (memeInfo.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else
      return new ResponseEntity<>(memeInfo.get(), HttpStatus.CREATED);
  }

}
