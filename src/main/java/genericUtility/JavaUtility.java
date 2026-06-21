package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtility {
	public String togetExpectedDate(int days){
		Date d = new Date();
		SimpleDateFormat sim =new SimpleDateFormat("dd-MM-yyyy");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String datareq = sim.format(cal.getTime());
		return datareq; 
	}

}
