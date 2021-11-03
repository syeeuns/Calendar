import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {

  private Map<Date, String> planMap;

  public Calendar() {
    planMap = new HashMap<Date, String>();
  }

  public int monthDay(int year, int month) {
    if (List.of(1, 3, 5, 7, 8, 10, 12).contains(month)) {
      return 31;
    } else if (List.of(4, 6, 9, 11).contains(month)) {
      return 30;
    } else {
      return isLeap(year) ? 29 : 28;
    }
  }

  public boolean isLeap(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
  }

  // 해당 년도의 1월1일 요일 구하기
  // 기준 1538년 1월1일 토요일
  // 일월화수목금토 0123456 index
  // 윤년이면 지난해 1월1일 + 2
  // 평년이면 +1
  public int getYearFirstDay(int year) {
    int sum = 0;
    for (int i = 1583; i < year; i++) {
      if (isLeap(i)) {
        sum += 2;
      } else {
        sum++;
      }
    }
    return (sum + 6) % 7;
  }

  // 지난달 시작이 일요일이고, 30일이라면? 1, 8, 15, 22, 29, -> 다음달 시작은 화요일
  // 일수 % 7 만큼 지난 시작요일에 더해주면 됨
  public int getMonthFirstDay(int year, int month) {
    int sum = getYearFirstDay(year);
    for (int i = 1; i < month; i++) {
      sum += monthDay(year, i) % 7;
    }
    return sum % 7;
  }

  public void printCalendar(int firstDay, int maxDay) {
    int cnt = 0;
    System.out.println("Sun Mon Tue Wed Thu Fri Sat");
    System.out.println("---------------------------");
    while (cnt < firstDay) {
      cnt++;
      System.out.print("    ");
    }
    for (int i = 1; i <= maxDay; i++) {
      cnt++;
      System.out.printf("%3d ", i);
      if (cnt % 7 == 0) {
        System.out.println();
      }
    }
    System.out.println();
  }

  public void registerPlan(String inputDate, String plan) throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
    planMap.put(date, plan);
  }

  public String searchPlan(String inputDate) throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
    String plan = planMap.get(date);
    return plan;
  }
}
