package io.sebbe.weekendprojectbackend.clay.moderation;

public record ResultDTO (boolean flagged, CategoriesDTO categories, CategoryScoresDTO category_scores){
}
