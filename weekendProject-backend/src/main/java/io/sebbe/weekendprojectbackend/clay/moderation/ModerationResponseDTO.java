package io.sebbe.weekendprojectbackend.clay.moderation;


import java.util.List;

public record ModerationResponseDTO(String id, String model, List<ResultDTO> results) {


}
