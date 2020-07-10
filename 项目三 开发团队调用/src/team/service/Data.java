package team.service;

public class Data {
    public static final int EMPLOYEE=10;
    public static final int PROGRAMMER=11;
    public static final int DESIGNER=12;
    public static final int ARCHITECT=13;
    public static final int PC=21;
    public static final int NOTEBOOK=22;
    public static final int PRINTER=23;
    public static final String[][] EMPLOYEES={
            //职位，id，name，age，salary，bonus，stock
            {"10","1","葛昊强","22","3000"},
            {"13","2","肖可欣","32","18000","15000","2000"},
            {"11","3","李俊良","23","15000"},
            {"11","4","殷鹏","22","30000"},
            {"11","5","李友林","23","22221"},
            {"12","6","赵庆晓","25","22200","5000"},
            {"13","7","周瑜","25","25000","5000","3000"},
            {"11","8","朱容昌","27","8520"},
            {"11","9","高佳伟","24","2441"},
            {"13","10","诸葛亮","26","3554","2255","5800"},
            {"11","11","亚瑟","32","44125"},
            {"12","12","黄忠","35","22247","4800"},
    };
    public static final String[][] EQUIPMENTS={
            //PC 21 model display
            //NOTEBOOK   22   model  price
            //PRINTER  23   name  type
            {},
            {"22","联想","6000"},
            {"21","戴尔","NEC17寸"},
            {"22","华为","400"},
            {"23","小米","光热"},
            {"22","拯救者","4800"},
            {"22","华为","6000"},
            {"21","拯救者","T70"},
            {"22","小米","5800"},
            {"23","联想","R720"},
            {"22","华为","3500"},
            {"21","拯救者","三星17寸"},
    };
}
