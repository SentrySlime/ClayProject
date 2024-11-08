package io.sebbe.weekendprojectbackend.clay.controller;


import io.sebbe.weekendprojectbackend.clay.service.ClayService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class ClayController {

  private final String responseString = "THIS_IS_THE_STRING_WE_RETURN";
  ClayService service;

  public ClayController(ClayService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<String> getString(){
    return ResponseEntity.ok(responseString);
  }

  @PostMapping
  public ResponseEntity<String> postString(@RequestBody String body){
    service.applyModeration(body);
    return ResponseEntity.ok(body);
  }

  @PostMapping("/new")
  public ResponseEntity<String> postNewString(@RequestBody String body){
    return ResponseEntity.ok(body);
  }

}
