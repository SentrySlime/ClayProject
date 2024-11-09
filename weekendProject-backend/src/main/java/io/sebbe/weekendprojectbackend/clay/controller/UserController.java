package io.sebbe.weekendprojectbackend.clay.controller;


import io.sebbe.weekendprojectbackend.clay.model.AppUser;
import io.sebbe.weekendprojectbackend.clay.model.UserRequestDTO;
import io.sebbe.weekendprojectbackend.clay.moderation.ModerationResponseDTO;
import io.sebbe.weekendprojectbackend.clay.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {


  private final String responseString = "THIS_IS_THE_STRING_WE_RETURN";

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<String> getString(){
    return ResponseEntity.ok(responseString);
  }

  @PostMapping
  public ResponseEntity<Boolean> postString(@RequestBody UserRequestDTO body){

    AppUser user = new AppUser(body.name(), body.gender(), body.info());
    ModerationResponseDTO responseDTO = userService.applyModerationOnInfo(user);

    return ResponseEntity.ok(responseDTO.results().get(0).flagged());
  }

  @PostMapping("/new")
  public ResponseEntity<String> postNewString(@RequestBody String body){
    return ResponseEntity.ok(body);
  }

}
