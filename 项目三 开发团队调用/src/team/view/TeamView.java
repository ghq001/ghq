package team.view;
import org.w3c.dom.NameList;
import team.domain.Employee;
import team.domain.Programmer;
import team.service.NameListService;
import team.service.TeamException;
import team.service.TeamService;

import static team.view.TSUtility.redaInt;


public class TeamView{
    private NameListService nameLIstService=new NameListService();
    private TeamService teamService=new TeamService();
    public void enterMainMenu() {
        char menuSelection=0;
        boolean b = true;
        while (b) {
            if (menuSelection!='1') {
                listAllEmployess();
            }
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队 4-退出 请选择（1-4）：");
         menuSelection = TSUtility.readMenuSelection();
            switch (menuSelection) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("请确认是否退出（Y/N):");
                    char exit = TSUtility.readConfirmSelection();
                    if (exit == 'Y') {
                    b=false;
                    }
            }
        }
    }
    private void listAllEmployess(){//显示所有的员工信息
        System.out.println("-----------------------开发团队调度--------------------------\n");
        Employee[] employees = nameLIstService.getAllEmployees();
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        for (int i=0;i<employees.length;i++){
            System.out.println(employees[i]);
        }
        System.out.println("---------------------------------------------------------------");
    }
    private void getTeam(){
     Programmer[] team = teamService.getTeam();
        System.out.println("----------------团队成员列表---------------");
        if (team==null||team.length==0){
            System.out.println("开发团队目前没有成员！");
        }else{
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
            for (int i=0;i<teamService.getTeam().length;i++){
                System.out.println(team[i].getDatailsForTeam());
            }
        }
            System.out.println("------------------------------------------");
    }
    private void addMember(){
        System.out.println("------------------添加成员---------------");
        System.out.print("请输入员工ID：");
        int id = redaInt();
        try {
            Employee employee = nameLIstService.getEmployee(id);
                teamService.addMember(employee);
                System.out.println("添加成员成功");

        }catch (TeamException e){
            System.out.println("添加失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }
    private void deleteMember(){
        System.out.println("------------------删除成员---------------");
System.out.print("请输入要删除员工的TID：");
            int memberID=TSUtility.redaInt();
            System.out.print("请确认是否删除（Y/N）：");
          char isDelete=  TSUtility.readConfirmSelection();
            if (isDelete=='N'){
                return;
            }
        try {
            teamService.removeMember(memberID);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView teamView=new TeamView();
        teamView.enterMainMenu();
    }
}
