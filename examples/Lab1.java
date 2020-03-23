class Dog {
    String name;
    String breed;
    int age;

    public Dog(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public static void main(final String[] args) {
        final Dog newDog = new Dog("Jesper", "Husky", 4);
        System.out.printf("%s %s %d\n", newDog.name, newDog.breed, newDog.age);
    }
}

class TrainedDog extends Dog {
    String trainer;

    public TrainedDog(String name, String breed, int age, String trainer) {
        super(name, breed, age);
        this.trainer = trainer;
    }

    public static void main(String[] args) {
        final TrainedDog newTrainedDog = new TrainedDog("Jesper", "Husky", 4, "Matt");
        System.out.printf("%s %s %d %s\n", newTrainedDog.name, newTrainedDog.breed, newTrainedDog.age, newTrainedDog.trainer);
    }
}