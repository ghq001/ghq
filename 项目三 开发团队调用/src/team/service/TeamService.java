package team.service;

import team.domain.Architect;
import team.domain.Designer;
import team.domain.Employee;
import team.domain.Programmer;

public class TeamService {


    private static int counter=1;//给memberId赋值使用
    public final int MAX_MEMBER=5;//限制开发团队的人数
    private Programmer[] team=new Programmer[MAX_MEMBER];//保存开发团队中的成员
    private int total;//记录开发团队中实际的人数
    public TeamService(){

    }
    public Programmer[] getTeam(){//获取开发团队中的成员
        Programmer[] team=new Programmer[total];
        for (int i=0;i<team.length;i++){
            team[i]=this.team[i];
        }
        return team;
    }
    public void addMember(Employee e) throws TeamException {//将指定的员工添加到成员中
        if (total>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }else if (!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }else if (isExist(e)){
            throw new TeamException("该成员已在团队中，无法添加");
        }else if (((Programmer) e).getStatus()==Status.BUSY){
            throw new TeamException("该成员已在团队中，无法添加");
        } else if (((Programmer) e).getStatus().getNAME().equals(Status.VOCATION)){
            throw new TeamException("员工正在休假，无法添加");
        }
        int numOfArch=0;
        int numOfDes=0;
        int numOfPro=0;
        for (int i=0;i<total;i++){
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else {
                numOfPro++;
            }
        }
        if (((Programmer) e) instanceof Architect){
            if (numOfArch>=1){
                throw new TeamException("团队中至多只有一名架构师");
            }
        }else if (((Programmer) e) instanceof Designer){
            if (numOfDes>=2){
                throw new TeamException("团队中至多只有两名设计师");
            }
        }else{
            if (numOfPro>=3){
                throw new TeamException("团队中至多只有三名程序员");
            }
        }
        team[total++]=((Programmer) e);
        ((Programmer) e).setStatus(Status.BUSY);
        ((Programmer) e).setMemberld(counter++);
    }

    private boolean isExist(Employee e) {
        for (int i=0;i<total;i++){
            if (team[i].getId()==e.getId()){
                return true;
            }
        }return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i=0;
       for (i=0;i<total;i++){
           if (team[i].getMemberld()==memberId){
               team[i].setStatus(Status.FREE);
               break;
           }
       }
       if (i==total){
           throw new TeamException("未找到该成员");
       }
       for(int i1=i;i1<total-1;i1++){
           team[i1]=team[i1+1];

       }   team[total-1]=null;
                total--;
    }
}

