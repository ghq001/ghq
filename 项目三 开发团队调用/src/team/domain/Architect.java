package team.domain;

public class Architect extends Designer {
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public String toString(){
        return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
    }
    public String getDatailsForTeam(){
        return getMemberld()+"/"+getId()+"\t\t"+getName()+"\t"+getAge()+"\t\t"+getSalary()+"\t"+"架构师\t"+getBonus()+"\t"+getStock();
    }
}
