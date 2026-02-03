package SS8.MINI_PROJECT;

public class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private double math;
    private double physics;
    private double chemistry;
    private double average;
    private String rank;

    public Student(String id, String name, int age, String gender,
                   double math, double physics, double chemistry) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        calculateAverageAndRank();
    }

    public void calculateAverageAndRank() {
        average = (math + physics + chemistry) / 3;

        if (average >= 8.0 && math >= 6.5 && physics >= 6.5 && chemistry >= 6.5) {
            rank = "Giỏi";
        } else if (average >= 6.5 && math >= 5 && physics >= 5 && chemistry >= 5) {
            rank = "Khá";
        } else if (average >= 5.0 && math >= 3.5 && physics >= 3.5 && chemistry >= 3.5) {
            rank = "Trung bình";
        } else {
            rank = "Yếu";
        }
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getAverage() { return average; }
    public String getRank() { return rank; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setMath(double math) { this.math = math; }
    public void setPhysics(double physics) { this.physics = physics; }
    public void setChemistry(double chemistry) { this.chemistry = chemistry; }

    @Override
    public String toString() {
        return String.format("%-8s %-20s %-5d %-8s %-6.2f %-6.2f %-6.2f %-6.2f %-10s",
                id, name, age, gender, math, physics, chemistry, average, rank);
    }
}

