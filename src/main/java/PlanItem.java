import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {

  public Date planDate;

  public String detail;

  public String peoples = "";

  public PlanItem(String date, String detail) {
    this.planDate = getDateFromString(date);
    this.detail = detail;
  }

  public Date getPlanDate() {
    return planDate;
  }

  public static Date getDateFromString(String inputDate) {
    Date date = null;
    try {
      date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  public void addPeople(String name) {
    peoples += name + ", ";
  }

  public String saveString() {
    String sdate = new SimpleDateFormat("yyyy-MM-dd").format(planDate);
    return sdate + " " + detail;
  }
}
