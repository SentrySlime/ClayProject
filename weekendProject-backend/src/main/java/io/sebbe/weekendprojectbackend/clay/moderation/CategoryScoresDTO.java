package io.sebbe.weekendprojectbackend.clay.moderation;

public record CategoryScoresDTO (double sexual,
        double hate,
        double harassment,
        double selfHarm,
        double sexualMinors,
        double hateThreatening,
        double violenceGraphic,
        double selfHarmIntent,
        double selfHarmInstructions,
        double harassmentThreatening,
        double violence
){}
