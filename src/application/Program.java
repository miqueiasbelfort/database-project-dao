package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
	
		System.out.println("==== TEST 1: Seller FindById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: Seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3: Seller FindByAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n==== TEST 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		
		System.out.println("\n==== TEST 5: Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Updated Completed");
		
		System.out.println("\n==== TEST 6: Seller Delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed");
	
		
		System.out.println("==== TEST 1: Department FindById ===");
		Department departmentDep = departmentDao.findById(2);
		System.out.println(departmentDep);
		
		System.out.println("\n==== TEST 2: Department FindAll ===");
		List<Department> listDep = departmentDao.findAll();
		for(Department obj : listDep) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3: Department Insert ===");
		Department newDepartment = new Department(null, "Developers");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n==== TEST 4: Department Update ===");
		departmentDep = departmentDao.findById(6);
		departmentDep.setName("Java System");
		departmentDao.update(department);
		System.out.println("Updated Completed");
		
		System.out.println("\n==== TEST 5: Department Delete ===");
		System.out.print("Enter id for delete a departament: ");
		int idDep = sc.nextInt();
		departmentDao.deleteById(idDep);
		System.out.println("Delete Completed");
		
		sc.close();
	}

}
