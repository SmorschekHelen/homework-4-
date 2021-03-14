package domain;

public class Member extends User {
    private Admin curator;

    public Member(String login, String password, Admin curator) {
        super(login, password);
        this.curator = curator;
    }
    public Admin getCurator(){
        return curator;
    }
    public void setCurator(Admin curator){
        this.curator = curator;

    }


}
