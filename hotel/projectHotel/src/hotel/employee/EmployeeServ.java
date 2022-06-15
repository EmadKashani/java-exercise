package hotel.employee;

import java.util.List;

public class EmployeeServ {

    private EmployeeServ(){}

    private static EmployeeServ employeeServ = new EmployeeServ();

    public static EmployeeServ getInstance(){
        return employeeServ;
    }

    public void save(EmployeeEnti employeeEnti) throws Exception {
        try (EmployeeRepo employeeRepo = new EmployeeRepo()) {

            //employeeEnti.setSalary(employeeEnti.getSalary() - (employeeEnti.getSalary() * 10 / 100));
            employeeRepo.insert(employeeEnti);
            employeeRepo.commit();
        }
    }
    public void edit(EmployeeEnti employeeEnti) throws Exception {
        try(EmployeeRepo employeeRepo = new EmployeeRepo()){
            //employeeEnti.setSalary(employeeEnti.getSalary()-employeeEnti.getSalary()*(10/100));
            employeeRepo.update(employeeEnti);
            employeeRepo.commit();;
        }
    }
    public void remove (Long idNumber) throws Exception{
        try(EmployeeRepo employeeRepo = new EmployeeRepo()){
            employeeRepo.delete(idNumber);
            employeeRepo.commit();
        }
    }
    public List <EmployeeEnti> report() throws Exception{
        List <EmployeeEnti> employeeEntis;
        try(EmployeeRepo employeeRepo = new EmployeeRepo()){
            employeeEntis = employeeRepo.select();
        }
        return employeeEntis;
    }

}
