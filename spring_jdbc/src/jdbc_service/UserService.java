package jdbc_service;

public class UserService {
	private UserDao userdao;

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	public void add() {
		userdao.add();
	}
}
