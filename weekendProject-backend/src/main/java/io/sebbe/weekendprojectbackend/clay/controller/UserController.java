package io.sebbe.weekendprojectbackend.clay.controller;


import io.sebbe.weekendprojectbackend.clay.model.AppUser;
import io.sebbe.weekendprojectbackend.clay.model.UserRequestDTO;
import io.sebbe.weekendprojectbackend.clay.model.UserResponseDTO;
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

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getUserById(@PathVariable String id){

    AppUser appUser = userService.getAppUser(id);
    UserResponseDTO response = new UserResponseDTO(appUser.getId(), appUser.getName(), appUser.getGender());

    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<UserResponseDTO> postString(@RequestBody UserRequestDTO body){

    AppUser user = new AppUser(body.name(), body.gender(), body.info());
    userService.applyModerationOnInfo(user);
    UserResponseDTO response = new UserResponseDTO(user.getId(), user.getName(), user.getGender());

    return ResponseEntity.ok(response);
  }

  @PostMapping("/new")
  public ResponseEntity<String> postNewString(@RequestBody String body){
    return ResponseEntity.ok(body);
  }

}
