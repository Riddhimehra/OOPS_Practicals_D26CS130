abstract class Shape{
    abstract double area();
}

class Circle extends Shape{

    private double radius;
    Circle(double raduis){
        this.radius=radius;
    }
   double area(){
        return (3.14*radius*radius);
   }
}

class Triangle extends Shape{

    private double base, height;
    Triangle(double base, double height){
        this.base=base;
        this.height=height;
    }
   double area(){
        return (1.5*base*height);
   }
}

class Rectangle extends Shape{
    private double length, width;
    Rectangle(double length, double width){
        this.length=length;
        this.width=width;
    }

    double area(){
        return (length*width);
    }
}

public class ShapeDemo{
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(2.1) , new Triangle(3.1, 4.1), new Rectangle(3.1, 4.1)};

        double total=0, largest=0;
        String label = "";

        for(Shape s: shapes){
            label = s.getClass().getSimpleName();
            System.out.println("Area of "+ label + "is:-" + s.area());

            total+= s.area();

            if(largest<s.area()){
                largest=s.area();
                label = s.getClass().getSimpleName();
                System.out.println(label);
            }
        }
    }
}