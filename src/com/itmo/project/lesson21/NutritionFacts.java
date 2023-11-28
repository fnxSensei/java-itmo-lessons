package com.itmo.project.lesson21;

public class NutritionFacts {
    private int calories;
    private int servings;
    private int fat;
    private int proteins;
    private int carbs;

    private NutritionFacts(Builder builder){
        calories=builder.calories;
        servings=builder.servings;
        fat=builder.fat;
    }


    public static class Builder {
        private int calories;
        private int servings;
        private int fat;

        public Builder (int calories) {
            this.calories=calories;
        }
        public Builder servings (int servings){
            this.servings=servings;
            return this;
        }
        public Builder fat (int fat){
            this.fat=fat;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

}