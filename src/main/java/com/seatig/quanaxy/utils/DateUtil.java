package com.seatig.quanaxy.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具类
 * @Description 
 * @author xianw
 * @time 2019年2月20日下午2:10:55
 * @version v1.0
 */
public class DateUtil {

    public static final String LOCAL_DATE_PATTERN = "yyyy年MM月dd日";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_LONG_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String EMPTY = "";
    private static DateFormat defaultDf = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
    private static DateFormat localDf = new SimpleDateFormat(LOCAL_DATE_PATTERN);
    
    
    /**
     * 通过时间秒毫秒数判断两个时间的间隔天数（两个时间差必须大于23个小时）
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24))+1;
        return days;
    }
    
    /**   
     * 得月的最后一天   
     *    
     * @return  日期字符串
     */    
    public static String getMonthLastDayS(Date date,String format) {     
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
 	   return dateFormat.format(DateUtil.getMonthLastDay(date));
    } 
    
    /**   
     * 得月的最后一天   
     *    
     * @return  日期
     */    
    public static Date getMonthLastDay(Date date) {     
        Calendar calendar = Calendar.getInstance();     
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar     
                .getActualMaximum(Calendar.DAY_OF_MONTH));     
 	   return calendar.getTime();
    } 
    
     
     /**
      * 获取日期星期几
      * @return 中文星期几
      */
     public static String getDayofweekStr(Date date){
  	   SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
  	   return dateFm.format(date);
     }
     
     /** 
     *@param date是为则默认今天日期、可自行设置“2013-06-03”格式的日期 
     *@return  返回1是星期日、2是星期一、3是星期二、4是星期三、5是星期四、6是星期五、7是星期六 
     */  
     public static int getDayofweekInt(Date date){  
 	    Calendar cal = Calendar.getInstance();  
 	    cal.setTime(date);  
 	    return cal.get(Calendar.DAY_OF_WEEK);  
     } 
     
     
     
    
    /**
     * 获取下周一的日期  
     * @param gmtCreate
     * @return
     */
    public static Date getNextMonday(Date date) {
    	int daysub = 7-DateUtil.getDayofweekInt(date)+2;
    	return DateUtil.dateAddDays(date,daysub);
    }  
    
    
    /**
     * 获取下周一的日期的字符串  
     * @param gmtCreate
     * @return
     */
    public static String getNextMondayS(Date date,String format) {  
       SimpleDateFormat dateFormat = new SimpleDateFormat(format);
 	   return dateFormat.format(DateUtil.getNextMonday(date));
    } 
    
    
    /**
    * 得年的最后一天字符串
    * @return 日期字符串
    */    
   public static String getYearLastDayS(Date date,String format) {     
       SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	   return dateFormat.format(DateUtil.getYearLastDay(date));
   }
    
    /**
    * 得年的最后一天
    * @return 日期
    */    
   public static Date getYearLastDay(Date date) {     
	   Calendar currCal=Calendar.getInstance();    
       int currentYear = currCal.get(Calendar.YEAR);  
       return getYearLast(currentYear);  
   }
    
    /**
    * 得年的第一天
    * @return 日期
    */    
   public static Date getYearFirstDay(Date date) {     
	   Calendar currCal=Calendar.getInstance();    
       int currentYear = currCal.get(Calendar.YEAR);  
       return getYearFirst(currentYear);  
   }
   
   
    /**
    * 得年的第一天
    * @return 日期字符串
    */    
   public static String getYearFirstDayS(Date date,String format) {     
	   SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	   return dateFormat.format(DateUtil.getYearFirstDay(date));
   }
    
    
   /** 
    * 获取某年第一天日期 
    * @param year 年份 
    * @return Date 
    */  
   public static Date getYearFirst(int year){  
       Calendar calendar = Calendar.getInstance();  
       calendar.clear();  
       calendar.set(Calendar.YEAR, year);  
       Date currYearFirst = calendar.getTime();  
       return currYearFirst;  
   }  
   
   /** 
    * 获取某年最后一天日期 
    * @param year 年份 
    * @return Date 
    */  
   public static Date getYearLast(int year){  
       Calendar calendar = Calendar.getInstance();  
       calendar.clear();  
       calendar.set(Calendar.YEAR, year);  
       calendar.roll(Calendar.DAY_OF_YEAR, -1);  
       Date currYearLast = calendar.getTime();  
         
       return currYearLast;  
   }  
   
    /**
    * 得月的第一天
    * @return 日期字符串
    */    
   public static String getMonthFirstDayS(Date date,String format) {     
	   SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	   return dateFormat.format(DateUtil.getMonthFirstDay(date));
   }     
       
   
   /**
   * 得月的第一天
   * @return 日期
   */    
  public static Date getMonthFirstDay(Date date) {     
	   //获取前月的第一天
	   Calendar  cal_1=Calendar.getInstance();//获取当前日期 
	   cal_1.setTime(date);
	   cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	   return cal_1.getTime();
  }  
    
    /**
     * 根据格式获取当前日期
     * 
     * @return
     */
    public static String getNowDateS(String format) {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat(format);
        return df.format(now);
    }
    
    /**
     * 根据格式获取当前日期
     * 
     * @return
     */
    public static Date getNowDate(String format) {
        DateFormat df = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        String now = getNowDateS(format);
        return df.parse(now, pos);
    }
    
    /**
     * 字符串转时间
     * @param date
     * @param format
     * @return
     */
    public static Date stringToDate(String date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        return df.parse(date, pos);
    }
    
    /**
     * 将字符串yyyymmdd转换为yyyy-mm-dd
     * @throws ParseException 
     */
    public static String stringToString(String string, String format){
    	SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	Date date = null;
		try {
			date = sd.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return sdf.format(date);
    }
    /**
     * 时间转字符串
     * @param date 
     * @param format
     * @return
     */
    public static String dateToString (Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }
    
    /**
     * 将日期转换成中文日期
     * 
     * @param date
     * @return
     */
    public static String dateLocal(String date) {
        try {
            Date local = defaultDf.parse(date);
            return localDf.format(local);
        } catch (ParseException e) {
            return date;
        }
    }

    /**
     * 将日期转换成中文日期
     * @param date
     * @param pattern
     * @return
     */
    public static String dateLocal(String date, String pattern) {
        try {
            Date local = new SimpleDateFormat(pattern).parse(date);
            return localDf.format(local);
        } catch (ParseException e) {
            return EMPTY;
        }
    }

    /**
     * 
     * 将日期转换成中文日期
     * 
     * @param date
     * @return
     */
    public static String dateLocal(Date date) {
        return localDf.format(date);
    }

    /**
     * 获取中文日期
     * 
     * @return
     */
    public static String dateLocal() {
        return localDf.format(Calendar.getInstance().getTime());
    }
    
    /**
     * 获取指定日期n个月后的日期
     * @param date
     * @param month
     * @return
     */
    public static Date dateAddMonth(String date, int month) {
        try {
            Date begin = defaultDf.parse(date);
            return dateAddMonth(begin, month);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 计算两月相差月份  大一天算一个月
     * @param smalldate
     * @param bigdate
     * @return
     */
    public static int cacuTwoDateDifferMonth(Date smalldate,Date bigdate){
    	if(smalldate.before(bigdate)){
    		int mons = 1;
    		Date date1 = new Date(smalldate.getTime()); 
    		Date date2 = new Date(bigdate.getTime()); 
    		for (;date1.before(date2);mons++) {
    			date1 = new Date(DateUtil.dateAddMonth(smalldate, mons).getTime());
    		}
			mons--;
    		return mons;
    	}else{
    		return 0;
    	}
    }
    
    /**
     * 计算两日期相差月份 不足一月不计算
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getMonthSpace(String startDate, String endDate){
        Date d1 = stringToDate(startDate, DEFAULT_DATE_PATTERN);
        Date d2 = stringToDate(endDate, DEFAULT_DATE_PATTERN);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        int mons = (c2.get(Calendar.YEAR)*12 + c2.get(Calendar.MONTH))
                - (c1.get(Calendar.YEAR)*12 + c1.get(Calendar.MONTH));
        if (c2.get(Calendar.DATE) < c1.get(Calendar.DATE)) {
            mons--;
        }
        return mons;
    }
    
    /**
     * 获取指定日期n个月后的日期
     * @param date
     * @param month
     * @return
     */
    public static Date dateAddMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }
    
    /**
     * 获取指定日期n天后的日期
     * @param date
     * @param days
     * @return
     */
    public static Date dateAddDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
    
    /**
     * 根据类型取得日期年、月、日...的值
     * @param date
     * @param type
     * @return
     */
    public static int getValueByField(Date date, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(type);
    }
    
    /**
     * 根据类型取得日期年、月、日...的值
     * @param date
     * @param type
     * @return
     */
    public static int getValueByField(String dateStr, int type) {
        Date date = stringToDate(dateStr, DEFAULT_DATE_PATTERN);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(type);
    }
    
    /**
     * 获取指定日期n年后的日期
     * @param date
     * @param days
     * @return
     */
    public static Date dateAddYears(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    /**
     * 获取指定日期n个月后的日期
     * @param date
     * @param month
     * @return
     */
    public static String dateLocalAddMonth(String date, int month) {
        return localDf.format(dateAddMonth(date, month));
    }

    /**
     * 获取指定日期n个月后的日期
     * @param date
     * @param month
     * @return
     */
    public static String dateLocalAddMonth(Date date, int month) {
        return localDf.format(dateAddMonth(date, month));
    }

    /**
     * 比较时间大小
     * @param d1
     * @param d2
     * @return d1>d2:1 / d1<d2:-1 / d1=d2:0
     */
    public static int compareDate(Date d1, Date d2) {
        if (d1.getTime() > d2.getTime()) {
            return 1;
        } else if (d1.getTime() < d2.getTime()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    /**
     * 获取当月的最后一天
     * @param date
     * @return
     */
    public static Date getLastDayToMonth(Date date){
    	Calendar calendar = Calendar.getInstance();  
    	// 设置时间,当前时间不用设置  
    	 calendar.setTime(date);  
    	// 设置日期为本月最大日期  
    	calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
    	return calendar.getTime();
    }
    /**
     * 获取日期的最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date){
    	Calendar calendar = convert(date);
    	calendar.set(Calendar.DATE,calendar.getMaximum(Calendar.DATE));
    	return calendar.getTime();
    }
    
    /**
     * 将日期转换为日历
     * @param date
     * @return
     */
    private static Calendar convert(Date date){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	return calendar;
    }
}
