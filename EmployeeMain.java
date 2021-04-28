package day15.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
		EmployeeMain obj = new EmployeeMain();
		File f = new File("C:\\Users\\srinivas\\Desktop\\Capgemini\\Technical\\Employee Record.txt");
		Map<String,List<Employee>> map = new HashMap<String,List<Employee>>();
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			empList = obj.getEmployees(f);
		} catch (Exception e) {
			
		}
		
		//obj.displayEmployees(empList);
		//map = obj.groupEmployees(empList);
		map = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName));
		obj.displayDetails(map);
	}
    
    public List<Employee> getEmployees(File file) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(file));
    	String line = "";
    	List<Employee> list = new ArrayList<Employee>();
    	
    	while((line = br.readLine())!=null) {
    		String[] details = line.split(",");
    		Employee e = new Employee(Integer.parseInt(details[0]),details[1],details[2],Integer.parseInt(details[3]));
    		list.add(e);
    	}
    	return list;
    }
    
    
   /* public Map<String,List<Employee>> groupEmployees(List<Employee> list) {
    	Map<String,List<Employee>> map = new HashMap<String,List<Employee>>();
    	map.put("ICICI-Bank", groupBasedOnDept("ICICI-Bank",list));
    	map.put("LIC", groupBasedOnDept("LIC",list));
    	map.put("Dell", groupBasedOnDept("Dell",list));
    	map.put("HP", groupBasedOnDept("HP",list));
    	return map;
    }*/
    
    
    /*public List<Employee> groupBasedOnDept(String dept,List<Employee> list){
    	List<Employee> result = new ArrayList<>();
    	for(Employee e : list) {
    		if(dept.equals(e.getDeptName())) result.add(e);
    	}
    	return result;
    }*/
    
    
    public void displayEmployees(List<Employee> list) {
    	for (Employee e : list) {
    		System.out.println("Details of ID :" + e.getId());
    		System.out.println("Name :" + e.getName() + "\nDepartment :" + e.getDeptName() + "\nSalary :" + e.getSalary());
    		System.out.println("--------------------------");
    	}
    	  
    }

    
    public void displayDetails(Map<String,List<Employee>> map){
    	System.out.println("--Grouping based on departments--\n\n");
    	for(Map.Entry<String, List<Employee>> entry:map.entrySet()){    
            String key=entry.getKey(); 
            System.out.println("===========================");
            System.out.println("Department : " + key);
            System.out.println("===========================\n");
            for (Employee e : entry.getValue()) {
                System.out.println("ID :" +e.getId()+"\nName :"+e.getName()+"\nSalary :"+e.getSalary()); 
                System.out.println("---------------------------------------");
                
            }
            
       	}  
    }
    
}
