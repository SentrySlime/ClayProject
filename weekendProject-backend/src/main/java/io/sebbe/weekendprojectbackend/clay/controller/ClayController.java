package io.sebbe.weekendprojectbackend.clay.controller;


import io.sebbe.weekendprojectbackend.clay.model.Clay;
import io.sebbe.weekendprojectbackend.clay.model.ClayRequestDTO;
import io.sebbe.weekendprojectbackend.clay.service.ClayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class ClayController {


  private final String responseString = "THIS_IS_THE_STRING_WE_RETURN";

  private final ClayService clayService;

  public ClayController(ClayService clayService) {
    this.clayService = clayService;
  }

  @GetMapping
  public ResponseEntity<String> getString(){
    return ResponseEntity.ok(responseString);
  }

  @PostMapping
  public ResponseEntity<Clay> postString(@RequestBody ClayRequestDTO body){

    Clay clay = new Clay(body.name(), body.gender(), body.info());
    clayService.applyModerationOnInfo(clay);

    return ResponseEntity.ok(clay);
  }

  @PostMapping("/new")
  public ResponseEntity<String> postNewString(@RequestBody String body){
    return ResponseEntity.ok(body);
  }

}
