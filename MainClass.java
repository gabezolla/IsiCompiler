import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
double  a;
double  b;
double[] d= new double[2];
String  t1;
d[0]= _key.nextDouble();
b= _key.nextDouble();
d[1]++;
while (d[1]>d[0]) {
System.out.println(d[1]);
d[1]++;
}
  }}