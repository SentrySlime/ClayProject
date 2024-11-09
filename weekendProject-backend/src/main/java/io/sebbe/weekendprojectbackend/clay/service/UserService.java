package io.sebbe.weekendprojectbackend.clay.service;
import io.sebbe.weekendprojectbackend.clay.model.AppUser;
import io.sebbe.weekendprojectbackend.clay.model.ModerationRequest;
import io.sebbe.weekendprojectbackend.clay.moderation.ModerationResponseDTO;
import io.sebbe.weekendprojectbackend.clay.repo.ClayRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@Service
public class UserService {

  @Value("${api.key}")
  private String apiKey;

  RestTemplate restTemplate;
  ClayRepository repository;

  public UserService(ClayRepository repository, RestTemplate restTemplate) {
    this.repository = repository;
    this.restTemplate = restTemplate;
  }

  String url = "https://api.openai.com/v1/moderations";
  String testURL = "http://localhost:8080/api/new";


  public ModerationResponseDTO applyModerationOnInfo(AppUser body){
    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(apiKey);

    ModerationRequest moderationRequest = new ModerationRequest(body.getInfo());

    HttpEntity<ModerationRequest> entity = new HttpEntity<>(moderationRequest, headers);

    // FIXME : commenting the openAI api call out until we add some credits

    //System.out.println("Moderation Request Payload: " + moderationRequest);
    ModerationResponseDTO response = restTemplate.postForObject(url, entity, ModerationResponseDTO.class);
    //System.out.println("This is our response from the api : \nl" + response);

    saveToRepo(body);

    return response;

  }

  public void saveToRepo(AppUser body){
    // FIXME : Temporarily disabling the DB access
    repository.save(body);
  }
}