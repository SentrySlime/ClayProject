package io.sebbe.weekendprojectbackend.clay.moderation;

public record CategoriesDTO (boolean sexual,
         boolean hate,
         boolean harassment,
         boolean selfHarm,
         boolean sexualMinors,
         boolean hateThreatening,
         boolean violenceGraphic,
         boolean selfHarmIntent,
         boolean selfHarmInstructions,
         boolean harassmentThreatening,
         boolean violence
) {}
