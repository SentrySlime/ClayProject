package io.sebbe.weekendprojectbackend.clay.controller;


import io.sebbe.weekendprojectbackend.clay.model.*;
import io.sebbe.weekendprojectbackend.clay.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    List<AppUser> appUsers = userService.getAllAppUsers();
    List<UserResponseDTO> responseList = appUsers.stream()
            .map(appUser -> new UserResponseDTO(appUser.getId(), appUser.getName(), appUser.getGender()))
            .collect(Collectors.toList());

    return ResponseEntity.ok(responseList);
  }

  @GetMapping("/data/{id}")
  public ResponseEntity<InfoScoringResponseDTO> getDataById (@PathVariable String id) {
      InfoScoring infoScoring = userService.getDataById(id);

    InfoScoringResponseDTO responseDTO = new InfoScoringResponseDTO(
            infoScoring.getSexual(),
            infoScoring.getHate(),
            infoScoring.getHarassment(),
            infoScoring.getSelfHarm(),
            infoScoring.getSexualMinors(),
            infoScoring.getHateThreatening(),
            infoScoring.getViolenceGraphic(),
            infoScoring.getSelfHarmIntent(),
            infoScoring.getSelfHarmInstructions(),
            infoScoring.getHarassmentThreatening(),
            infoScoring.getViolence()
    );

      return ResponseEntity.ok(responseDTO);
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
