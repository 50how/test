package takebag;

import java.text.SimpleDateFormat;
import java.util.Date;

public class schoolTime {
	public static String Gettime  () {
	     
        //创建一个日期对象
        Date d=new Date();
 
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        //格式化为日期/时间字符串
        String cc=sdf.format(d);
        
        return cc;
	}

}
