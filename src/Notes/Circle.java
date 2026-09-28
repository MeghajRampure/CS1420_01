package Notes;


public class Circle {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }
    public double calculatePerimeter(int perimeter){
        return this.radius * 2 * Math.PI;
    }

    public double calculateArea(){
        return this.radius + this.radius * Math.PI;
    }

    public boolean equals(Object other){
        if(!(other instanceof Circle)){
            return false;
        }
        Circle otherCircle = (Circle) other;
        return this.radius == otherCircle.radius;
    }

}
