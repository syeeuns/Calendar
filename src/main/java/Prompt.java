import java.util.Scanner;

public class Prompt {

  private static final String PROMPT = "cal > ";

  public static void main(String[] args) {
    runPromprt();
  }

  public static void runPromprt() {
    printMenu();
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("명령 (1, 2, 3, h, q)");
      System.out.print(" > ");
      String cmd = sc.next();
      if (cmd.equals("1")) {
        registerPlan(sc);
      } else if (cmd.equals("2")) {
        searchPlan(sc);
      } else if (cmd.equals("3")) {
        printCalendar(sc);
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

  private static void registerPlan (Scanner sc) {
    System.out.print("[일정 등록] 날짜를 입력하세요.\n > ");
    String date = sc.nextLine();
    // 날짜 찾기 로직 추가
    System.out.print("일정을 입력하세요.\n > ");
    String schedule = sc.nextLine();
    // 일정 등록 로직 추가
    System.out.println("일정이 등록되었습니다.");
  }

  private static void searchPlan (Scanner sc) {
    System.out.print("[일정 검색] 날짜를 입력하세요.\n > ");
    String date = sc.nextLine();
    // 날짜 찾기 로직 추가
    // 일정 검색 로직 추가
  }

  private static void printCalendar(Scanner sc) {
    System.out.println("년, 월을 입력하세요. (띄어쓰기 구분)");
    System.out.print("cal > ");
    int year = Integer.parseInt(sc.next());
    int month = Integer.parseInt(sc.next());

    if (month < 1 || month > 12) {
      System.exit(0);
    }

    int maxDay = Calendar.monthDay(year, month);
    System.out.printf("%d년 %d월은 %d일까지 있습니다.\n", year, month, maxDay);
    Calendar.printCalendar(Calendar.getMonthFirstDay(year, month), maxDay);
  }
}
