
public class DeptDAOTest {

	public static void main(String[] args) {

		DeptDAO dao = new DeptDAO();
//		dao.insertDept(new Dept(50, "Testing", "SEOUL"));
		
		for(Dept d : dao.selectDepts()) {
			System.out.println(d.getDeptNo()+","+d.getDname()+","+d.getLoc());
		}
	}

}
