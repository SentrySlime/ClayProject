package io.sebbe.weekendprojectbackend.clay.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryScoresDTO (double sexual,
                                 double hate,
                                 double harassment,
                                 @JsonProperty("self-harm") double selfHarm,
                                 @JsonProperty("sexual/minors") double sexualMinors,
                                 @JsonProperty("hate/threatening") double hateThreatening,
                                 @JsonProperty("violence/graphic") double violenceGraphic,
                                 @JsonProperty("self-harm/intent") double selfHarmIntent,
                                 @JsonProperty("self-harm/instructions") double selfHarmInstructions,
                                 @JsonProperty("harassment/threatening") double harassmentThreatening,
                                 double violence,
                                 double illicit,
                                 @JsonProperty("illicit/violent") double illicitViolent
){}
