package io.sebbe.weekendprojectbackend.clay.service;
import io.sebbe.weekendprojectbackend.clay.model.AppUser;
import io.sebbe.weekendprojectbackend.clay.model.InfoScoring;
import io.sebbe.weekendprojectbackend.clay.model.ModerationRequest;
import io.sebbe.weekendprojectbackend.clay.moderation.CategoryScoresDTO;
import io.sebbe.weekendprojectbackend.clay.moderation.ModerationResponseDTO;
import io.sebbe.weekendprojectbackend.clay.repo.AppUserRepository;
import io.sebbe.weekendprojectbackend.clay.repo.InfoScoringRepository;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import javax.swing.plaf.synth.Region;
import java.util.List;

@Service
public class UserService {

  @Value("${api.key}")
  private String apiKey;
  String url = "https://api.openai.com/v1/moderations";

  RestTemplate restTemplate;

  AppUserRepository userRepo;
  InfoScoringRepository infoRepo;

  public UserService(AppUserRepository userRepo, InfoScoringRepository infoRepo, RestTemplate restTemplate) {
    this.userRepo = userRepo;
    this.infoRepo = infoRepo;
    this.restTemplate = restTemplate;
  }

  public AppUser getAppUser (String id) {
    return userRepo.findById(id)
            .orElseThrow();
  }

  public List<AppUser> getAllAppUsers(){
    return userRepo.findAll();
  }

  @Transactional
  public void applyModerationOnInfo(AppUser body){

    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(apiKey);

    ModerationRequest moderationRequest = new ModerationRequest(body.getInfo());
    HttpEntity<ModerationRequest> entity = new HttpEntity<>(moderationRequest, headers);

    ModerationResponseDTO response = restTemplate.postForObject(url, entity, ModerationResponseDTO.class);

    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    InfoScoring infoScoring = createNewInfoScoring(response, body);

    infoScoring.setAppUser(body);
    body.setInfoScoring(infoScoring);

    saveUser(body);
  }

  public void saveUser(AppUser body){
    // FIXME : Temporarily disabling the DB access
    userRepo.save(body);
  }

  public void saveInfo(InfoScoring infoScoring){
    infoRepo.save(infoScoring);
  }

  private InfoScoring createNewInfoScoring(ModerationResponseDTO response, AppUser user){
    CategoryScoresDTO scoresDTO = response.results().get(0).category_scores();

    InfoScoring infoScoring = new InfoScoring();

    //region <setting infoScoring values>
    infoScoring.setAppUser(user);
    infoScoring.setSexual(scoresDTO.sexual());
    infoScoring.setHate(scoresDTO.hate());
    infoScoring.setHarassment(scoresDTO.harassment());
    infoScoring.setSelfHarm(scoresDTO.selfHarm());
    infoScoring.setSexualMinors(scoresDTO.sexualMinors());
    infoScoring.setHateThreatening(scoresDTO.hateThreatening());
    infoScoring.setViolenceGraphic(scoresDTO.violenceGraphic());
    infoScoring.setSelfHarmIntent(scoresDTO.selfHarmIntent());
    infoScoring.setSelfHarmInstructions(scoresDTO.selfHarmInstructions());
    infoScoring.setHarassmentThreatening(scoresDTO.harassmentThreatening());
    infoScoring.setViolence(scoresDTO.violence());

    //endregion

    return infoScoring;
  }
}