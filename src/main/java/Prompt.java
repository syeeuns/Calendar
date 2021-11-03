import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

  private static final String PROMPT = "cal > ";

  public static void main(String[] args) throws ParseException {
    Prompt prompt = new Prompt();
    prompt.runPrompt();
  }

  public void runPrompt() throws ParseException {
    printMenu();
    Scanner sc = new Scanner(System.in);
    Calendar cal = new Calendar();

    while (true) {
      System.out.println("명령 (1, 2, 3, h, q)");
      System.out.print(" > ");
      String cmd = sc.next();
      if (cmd.equals("1")) {
        cmdRegister(sc, cal);
      } else if (cmd.equals("2")) {
        cmdSearch(sc, cal);
      } else if (cmd.equals("3")) {
        printCalendar(sc, cal);
      } else if (cmd.equals("h")) {
        printMenu();
      } else if (cmd.equals("q")) {
        break;
      }
    }
    System.out.println("Bye~");
    sc.close();
  }

  public static void printMenu() {
    System.out.println("+------------------------+");
    System.out.println("| 1. 일정 등록");
    System.out.println("| 2. 일정 검색");
    System.out.println("| 3. 달력 보기");
    System.out.println("| h. 도움말 q. 종료");
    System.out.println("+------------------------+");
  }

  private static void cmdRegister (Scanner sc, Calendar cal) throws ParseException {
    System.out.println("[새 일정 등록]");
    System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
    String date = sc.next();
    sc.nextLine();
    System.out.print("일정을 입력하세요.\n > ");
    String plan = sc.nextLine();
    cal.registerPlan(date, plan);

    System.out.println("일정이 등록되었습니다.");
  }

  private static void cmdSearch(Scanner sc, Calendar cal) throws ParseException {
    System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
    String date = sc.next();
    System.out.println(cal.searchPlan(date));
  }

  private static void printCalendar(Scanner sc, Calendar cal) {
    System.out.println("년, 월을 입력하세요. (띄어쓰기 구분)");
    System.out.print("cal > ");
    int year = Integer.parseInt(sc.next());
    int month = Integer.parseInt(sc.next());

    if (month < 1 || month > 12) {
      System.exit(0);
    }

    int maxDay = cal.monthDay(year, month);
    System.out.printf("%d년 %d월은 %d일까지 있습니다.\n", year, month, maxDay);
    cal.printCalendar(cal.getMonthFirstDay(year, month), maxDay);
  }
}
