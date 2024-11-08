package io.sebbe.weekendprojectbackend.clay.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClayService {

  RestTemplate restTemplate;

  public ClayService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  String url = "https://api.openai.com/v1/moderations";
  String testURL = "http://localhost:8080/api/new";

  public void applyModeration(String body){

    String response = restTemplate.postForObject(testURL, body, String.class);

    System.out.println("This is our response : " + response);
    //This is were we apply the openAI API moderation
  }

}
