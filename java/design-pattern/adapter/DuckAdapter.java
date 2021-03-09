package adapter;

public class DuckAdapter implements Duck {

    private Dog dog;

    public DuckAdapter(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void spark() {
        this.dog.bark();
    }
}
