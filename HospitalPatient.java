public class HospitalPatient extends Individual {
    private int id;
    private String disease;

    public HospitalPatient(int id, String name, int age, String disease) {
        super(name, age);
        this.id = id;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public void display() {
        System.out.println("ID: " + id + ", Name: " + getName() + ", Age: " + getAge() + ", Disease: " + disease);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + getName() + " | Age: " + getAge() + " | Disease: " + disease;
    }
}
