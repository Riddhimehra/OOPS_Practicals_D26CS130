import java.util.Scanner;

class Point{
    private int x;
    private int y;

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public String toString(){
        return "(" + x  + "," + y + ")";
    }

    public boolean equals(Object ob){
        Point temp = (Point)ob;
        if(this.x == temp.x && this.y == temp.y)
            return true;
        else
            return false;

    }
}

class Driver{
    public static void main(String[] args){
        Point []p = new Point[5];
        int count=0;

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<p.length; i++){
            System.out.println("please enter the values for x and y");

            // int a = sc.nextInt();
            // int b = sc.nextInt();

            p[i] = new Point(sc.nextInt() , sc.nextInt());
            System.out.println(p[i]);
        }

        for(int i=0; i<5; i++){
            for(int j=i+1; j<5; j++){
                if(p[i].equals(p[j]))
                    count++;
            }
        }

        System.out.println("Same object:- " + count);
        System.out.println("Distinct object:-" + (p.length - count));
    }
}