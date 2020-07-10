package team.service;

import team.domain.*;

public class NameListService {

      private  Employee[] employees;
        //给数组及数组元素进行初始化
    public NameListService(){
        employees=new Employee[Data.EMPLOYEES.length];

        for (int i=0;i<employees.length;i++){
           int type= Integer.parseInt(Data.EMPLOYEES[i][0]);
           int id=Integer.parseInt(Data.EMPLOYEES[i][1]);
           String name=Data.EMPLOYEES[i][2];
           int age=Integer.parseInt(Data.EMPLOYEES[i][3]);
           double salary=Double.parseDouble(Data.EMPLOYEES[i][4]);
            Equipment equipment;
          double bonus;

           switch (type){
               case Data.EMPLOYEE :
                   employees[i]=new Employee(id,name,age,salary);
                   break;
               case Data.PROGRAMMER:
                 equipment=creatEquipment(i);
                   employees[i]=new Programmer(id,name,age,salary,equipment);
                   break;
               case Data.DESIGNER:
                   equipment=creatEquipment(i);
                   bonus  =Double.parseDouble(Data.EMPLOYEES[i][5]);
                   employees[i]=new Designer(id,name,age,salary,equipment,bonus);
                   break;
               case Data.ARCHITECT:
                   equipment=creatEquipment(i);
                   bonus  =Double.parseDouble(Data.EMPLOYEES[i][5]);
                   int stock=Integer.parseInt(Data.EMPLOYEES[i][6]);
                   employees[i]=new Architect(id,name,age,salary, equipment, bonus,stock);
                   break;
           }
        }
    }
//获取指定位置员工的设备
    private Equipment creatEquipment(int index) {
        int type=Integer.parseInt(Data.EQUIPMENTS[index][0]);
       switch (type) {
           case Data.PC://21
             return new PC(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);

           case Data.NOTEBOOK://22
               return new NoteBook(Data.EQUIPMENTS[index][1],Integer.parseInt(Data.EQUIPMENTS[index][2]));

           case Data.PRINTER://23
               return new Printer(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);

       }
       return null;
    }

    public Employee[] getAllEmployees(){

        return employees;
    }
    public Employee getEmployee(int id) throws TeamException {
        for(int i=0;i<employees.length;i++){
            if (employees[i].getId()==id){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }

}
