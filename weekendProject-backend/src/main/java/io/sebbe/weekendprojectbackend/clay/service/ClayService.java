package io.sebbe.weekendprojectbackend.clay.service;
import io.sebbe.weekendprojectbackend.clay.model.Clay;
import io.sebbe.weekendprojectbackend.clay.model.ModerationRequest;
import io.sebbe.weekendprojectbackend.clay.repo.ClayRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@Service
public class ClayService {


  RestTemplate restTemplate;
  ClayRepository repository;

  public ClayService(ClayRepository repository, RestTemplate restTemplate) {
    this.repository = repository;
    this.restTemplate = restTemplate;
  }

  String url = "https://api.openai.com/v1/moderations";
  String testURL = "http://localhost:8080/api/new";

  public void applyModeration(String body){
    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.APPLICATION_JSON);
    //headers.setBearerAuth(apiKey);

    ModerationRequest moderationRequest = new ModerationRequest(body);
    HttpEntity<ModerationRequest> entity = new HttpEntity<>(moderationRequest, headers);

    // FIXME : commenting the openAI api call out until we add some credits

    /* String response = restTemplate.postForObject(url, entity, String.class);
    System.out.println("This is our response : \nl" + response); */

    saveToRepo(body);

  }

  public void saveToRepo(String body){
    Clay clay = new Clay();

    clay.setInput(body);

    repository.save(clay);
  }
}