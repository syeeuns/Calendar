import java.util.Scanner;

public class Sum {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("두 수를 입력하세요.");
    int a = Integer.parseInt(sc.next());
    int b = Integer.parseInt(sc.next());
    System.out.printf("두 수의 합은 %d 입니다.%n", a+b);
    sc.close();
  }
}
