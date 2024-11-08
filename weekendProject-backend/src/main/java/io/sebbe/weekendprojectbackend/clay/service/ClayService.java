package io.sebbe.weekendprojectbackend.clay.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClayService {

  RestTemplate restTemplate;

  String url = "https://api.openai.com/v1/moderations";

  public void applyModeration(String body){

    restTemplate.postForObject(url, body, MyRespon)

    //This is were we apply the openAI API moderation
  }

}
