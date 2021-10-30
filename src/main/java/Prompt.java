import java.util.Scanner;

public class Prompt {

  private static final String PROMPT = "cal > ";

  public static void main(String[] args) {
    runPromprt();
  }

  public static void runPromprt() {
    Scanner sc = new Scanner(System.in);
    System.out.println("반복횟수를 입력하세요.");
    System.out.print("cal > ");
    int times = sc.nextInt();
    for (int i = 0; i < times; i++) {
      System.out.println("년, 월을 입력하세요. (띄어쓰기 구분)");
      System.out.print("cal > ");
      int year = Integer.parseInt(sc.next());
      int month = Integer.parseInt(sc.next());
      if (month == -1) {
        break;
      }
      if (month > 12) {
        continue;
      }
      int maxDay = Calendar.monthDay(year, month);
      System.out.printf("%d년 %d월은 %d일까지 있습니다.\n", year, month, maxDay);
      Calendar.printCalendar(Calendar.getMonthFirstDay(year, month), maxDay);
    }
    sc.close();
  }
}
