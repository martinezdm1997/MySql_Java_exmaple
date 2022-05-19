package connector;
import java.sql.*;
import java.util.Scanner;

//David Martinez
//This is a java project I wrote for my database class about a year ago. For the class we were expected to have java connect and make entries/pull data from mySQL. 
//The code gave options to the user of adding to the database and where. The info was randomly generated due to it not being actually used by a real company.
//The code also pulls from the database to answer pre selected question eg. List The name and Specialty of employees who have a bike with less than or equal to 2 hours of work.



public class Main {

	public static String ranname() {//returns random name out of a list of names
		String name="";
		String fname[]= {"Leo","Edwin","Kathy","Alicia","Roberta","Laurence","Jordan","Wanda","Irma","Shelly","Willard"
		,"Cora","Lorenzo","Joel","Elli","Vickie","Kaiji","Adachi","Lindsey","Irving","Stewert","Luther","Myra","Ray","Lela"
		,"Michelle","Yvonne","Taylor"};
		int x= (int)(Math.random()*(27-0+1)+0);
		name=fname[x];
		
		return name;
	}
	public static String ransknis(){//Returns a random issue for bike or a specialty for employee
		String issu;
		String listiss[]= {"Tires","Frame","Handles","Peddles","Misc"};
		int x= (int)(Math.random()*(4-0+1)+0);
		issu=listiss[x];
		
		return issu;
	}
	public static void add_emp() throws Exception {//Adds employee with random data 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/repairshop","root","password");
		Statement stmt= con.createStatement();
		String Ename;
		int salary;
		String Skill;
		Ename=ranname();
		Skill=ransknis();
		salary=(int)(Math.random()*(200000-20000+1)+20000);
		Boolean result0 = stmt.execute("Insert Into Employee(E_Name,Speciality,Salary) values ('"+ Ename +"','"+Skill+"',"+salary+")");
		
		
		System.out.println("Insert Into Employee(E_Name,Speciality,Salary) values ('"+ Ename +"','"+Skill+"',"+salary+")");
		con.close();
	}
	public static String randate() {//returns random date year is set to 2020 
		String date="2020-" ;
		int month=(int)(Math.random()*(12-1+1)+1);
		int day=(int)(Math.random()*(28-1+1)+1);
		date=date+Integer.toString(month)+"-"+Integer.toString(day);
		
		
		return date;
	}
	public static String ranadd() {//Gives a random address as a string Number is randomly geneated and street names are randomly picked and added together to make address
		String address ;
		
		int day=(int)(Math.random()*(9999-1+1)+1);
		address=Integer.toString(day)+" ";
		String adds[]= {"Grant","Madison","Hickory","Magnolia","Franklin","Linda","Cambridge","Fairview",
	    "Oxford","Victoria","Main"};
		int x= (int)(Math.random()*(10-0+1)+0);
		address=address+adds[x]+" ";
		String adds1[]= {"Lane","Drive","Road","Avenue","Street","Court"};
		int y= (int)(Math.random()*(5-0+1)+0);
		address=address+adds1[y];
		
		return address;
	}
	public static String ranpay() {//Returns random payment type
		String ranpay[]= {"Check","Credit","Debit","Cashier Check","Cash"} ;
		
		
		int x= (int)(Math.random()*(4-0+1)+0);
		
		
		return ranpay[x];
	}
	public static void add_cust() throws Exception {//Adds customer with random data
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/repairshop","root","password");
		Statement stmt= con.createStatement();
		String Cname=ranname();
		int C_Phone=(int)(Math.random()*(999999999-100000000+1)+100000000);
		String address=ranadd();
		String paytype=ranpay();
		Boolean result0 = stmt.execute("Insert Into Customer(C_Name,C_Phone,Address,Paytype) values ('"+ Cname +"',"+C_Phone+",'"+address+"','"+paytype+"')");
		System.out.println("Insert Into Customer(C_Name,C_Phone,Address,Paytype) values ('"+ Cname +"',"+C_Phone+",'"+address+"','"+paytype+"')");
		con.close();
		
	}
	public static String ranbran() {//returns a random bike brand
		String ranpay[]= {"Yeti","Woom","Trek","Tommaso","Tern","Surly","Schwinn","Salsa","Raleigh"} ;
		
		
		int x= (int)(Math.random()*(8-0+1)+0);
		
		
		return ranpay[x];
	}
	public static String ranstat() {//Returns a random status
		String ranpay[]= {"In repair","Repaired","No Repair"} ;
		
		
		int x= (int)(Math.random()*(2-0+1)+0);
		
		
		return ranpay[x];
	}
	public static void add_bike() throws Exception {//Adds bike with random data
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/repairshop","root","password");
		Statement stmt= con.createStatement();
		String Brand=ranbran();
		String Issue=ransknis();
		String B_Status=ranstat();
		Boolean result0 = stmt.execute("Insert Into Bike(Brand,Issue,B_Status) values ('"+ Brand +"','"+Issue+"','"+B_Status+"')");
		System.out.println("Insert Into Bike(C_Name,C_Phone,Address,Paytype) values ('"+ Brand +"',"+Issue+",'"+B_Status+"')");
		con.close();
	
	}
	public static void add_in() throws Exception {//Adds Brought_In where the IDs as are specified but everything else is random data
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/repairshop","root","password");
		Statement stmt= con.createStatement();
		Scanner myin = new Scanner(System.in);
		System.out.println("ID of customer who brought in bike");
		int C_id= myin.nextInt();
		System.out.println("ID of Bike brought in");
		int B_id= myin.nextInt();
		String date_rec=randate();
		int cost=(int)(Math.random()*(200-25+1)+25);
		Boolean result0 = stmt.execute("Insert Into Brought_in values ("+ B_id +","+C_id+",'"+date_rec+"',"+cost+")");
		System.out.println("Insert Into Brought_in values ("+ B_id +","+C_id+",'"+date_rec+"',"+cost+")");
		con.close();
	
	}
	public static void add_work() throws Exception {//Adds Work_On where the IDs as are specified but everything else is random data
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/repairshop","root","password");
		Statement stmt= con.createStatement();
		Scanner myin = new Scanner(System.in);
		System.out.println("ID of Employee who is working on the bike");
		int E_id= myin.nextInt();
		System.out.println("ID of Bike being worked on");
		int B_id= myin.nextInt();
		int hours=(int)(Math.random()*(10-1+1)+1);
		Boolean result0 = stmt.execute("Insert Into Work_On values ("+ B_id +","+E_id+","+hours+")");
		System.out.println("Insert Into Work_On values ("+ B_id +","+E_id+","+hours+")");
		con.close();
	
	}
	
	public static void insertq() throws Exception{//Menu to select which table you want data atted to
		Scanner myin = new Scanner(System.in);
		int mainchoice = 0;
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		while(mainchoice!=6) {
			System.out.println("What record would you like to add to?");
			System.out.println("-------------------------------------");
			System.out.println("1.Employee");
			System.out.println("2.Customer");
			System.out.println("3.Bike");
			System.out.println("4.Brought In");
			System.out.println("5.Work On");
			System.out.println("6.Exit");
			mainchoice= myin.nextInt();
			if(mainchoice==1) {
				add_emp();
				
			}
			else if(mainchoice==2) {
				
				add_cust();
			}
			else if(mainchoice==3) {
				add_bike();
				
			}
			else if(mainchoice==4) {
				
				add_in();
			}
			else if(mainchoice==5) {
				add_work();
				
			}
			else if(mainchoice!=6) {
				
				System.out.println("Not Valid Input");
			}
			
		}
		System.out.println("Done adding records");
		
	}
	public static void ansq() throws Exception{//Menu that ask and display qurries
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/repairshop","root","password");
		Statement stmt= con.createStatement();
		Scanner myin = new Scanner(System.in);
		int mainchoice = 0;
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		while(mainchoice!=9) {
			System.out.println("What record would you like to add to?");
			System.out.println("-------------------------------------");
			System.out.println("1.List the ID of bikes and status that have more than 3 hours of work complete on them");
			System.out.println("2.List the Bike ID and Status of Bikes that were received before October 2020");
			System.out.println("3.List The name and Specialty of employees who have a bike with less than or equal to 2 hours of work");
			System.out.println("4.List the name ,Speciality and Bike id of Employee whose Specialty and the bike they are " + 
			"working on issue do not match");
			System.out.println("5.Count the number of Employees by Speciality");
			System.out.println("6.Count the number of Customer by Paytype");
			System.out.println("7.List the Customers name, Customer ID ,and their estimated cost. List by cost in Descending " + 
			"order");
			System.out.println("8.List the Employees by Name ,ID, and Salary whose salary is less than 100,000. List them in " + 
			"Descending Order of salary and Ascending order of Name");
			System.out.println("9.Exit");
			mainchoice= myin.nextInt();
			if(mainchoice==1) {
				System.out.println("");
				System.out.println("");
				System.out.println("1.List the ID of bikes and status that have more than 3 hours of work complete on them");
				ResultSet result1=stmt.executeQuery("select wo.Bike_ID,B.B_Status from Work_On as wo , Bike as B where wo.Bike_ID=B.B_ID and wo.Hours>3;");
				while(result1.next()) {
					int B_id=result1.getInt("wo.Bike_ID");
					String Status= result1.getString("B.B_Status");
					System.out.println("Bike id #"+B_id+" with status "+Status+" has more than 3 hours worked on it.");
				}
			}
			else if(mainchoice==2) {
				System.out.println("");
				System.out.println("");
				System.out.println("2.List the Bike ID and Status of Bikes that were received before October 2020");
				ResultSet result2=stmt.executeQuery("select B.B_ID,B.B_Status from Bike as B, Brought_in as Bi where B.B_ID=Bi.Bike_ID and Bi.Date_Rec<'2020-10-01';");
				while(result2.next()) {
					int B_id=result2.getInt("B.B_ID");
					String Status= result2.getString("B.B_Status");
					System.out.println("Bike id #"+B_id+" with status "+Status+" that was recived before October 2020.");
				}
				
				
			}
			else if(mainchoice==3) {
				System.out.println("");
				System.out.println("");
				System.out.println("3.List The name and Specialty of employees who have a bike with less than or equal to 2 hours of work");
				ResultSet result3=stmt.executeQuery("select E.E_Name,E.Speciality From Employee as E, Work_On as wo where E.E_ID=wo.Emp_ID and wo.Hours<=2;");
				while(result3.next()) {
					String e_name=result3.getString("E.E_Name");
					String Status= result3.getString("E.Speciality");
					System.out.println("Employee named "+e_name+" with Speciality "+Status+" has worked on a bike for two hours or less.");
				}
				
			}
			else if(mainchoice==4) {
				System.out.println("");
				System.out.println("");
				System.out.println("4.List the name ,Speciality and Bike id of Employee whose Specialty and the bike they are " + 
				"working on issue do not match");
				ResultSet result4=stmt.executeQuery("select E.E_Name,E.Speciality, wo.Bike_ID From Employee as E, Work_On as wo, Bike as B"
				+ " where E.E_ID=wo.Emp_ID and B.B_ID =wo.Bike_ID and E.Speciality!=B.Issue; ");
				while(result4.next()) {
					String e_name=result4.getString("E.E_Name");
					String Status= result4.getString("E.Speciality");
					int B_id=result4.getInt("wo.Bike_ID");
					System.out.println("Employee named "+e_name+" with Speciality "+Status+" is working on bike ID #"+B_id+" where speciality of employee does not match bike issue");
				}
				
			}
			else if(mainchoice==5) {
				System.out.println("");
				System.out.println("");
				System.out.println("5.Count the number of Employees by Speciality");
				ResultSet result5=stmt.executeQuery("select E.Speciality, Count(E_ID) as Total From Employee as E Group by E.Speciality;");
				while(result5.next()) {
					
					String Status= result5.getString("E.Speciality");
					int total1=result5.getInt("Total");
					System.out.println("Speciality "+Status+" has "+total1+" total employees.");
				}
				
			}
			else if(mainchoice==6) {
				System.out.println("");
				System.out.println("");
				System.out.println("6.Count the number of Customer by Paytype");
				ResultSet result6=stmt.executeQuery("select C.Paytype, Count(C_ID) as Total From Customer as C Group by C.Paytype;");
				while(result6.next()) {
					
					String Status= result6.getString("C.Paytype");
					int total1=result6.getInt("Total");
					System.out.println("Paytype "+Status+" is being used by "+total1+" total customers.");
				}
				
			}
			else if(mainchoice==7) {
				System.out.println("");
				System.out.println("");
				System.out.println("7.List the Customers name, Customer ID ,and their estimated cost. List by cost in Descending " + 
				"order");
				ResultSet result7=stmt.executeQuery("select C.C_Name, C.C_ID, Bi.Estcost From Customer as C, Brought_in as Bi"
				+ " Where C.C_ID=Bi.Cust_ID Order by Bi.Estcost Desc;");
				while(result7.next()) {
					
					String name= result7.getString("C.C_Name");
					int cid=result7.getInt("C.C_ID");
					int est=result7.getInt("Bi.Estcost");
					System.out.println("Customer named "+name+" with ID #"+cid+" has a bike with the est cost of $"+est+".");
				}
				
			}
			else if(mainchoice==8) {
				System.out.println("");
				System.out.println("");
				System.out.println("8.List the Employees by Name ,ID, and Salary whose salary is less than 100,000. List them in " + 
				"Descending Order of salary and Ascending order of Name");
				ResultSet result8=stmt.executeQuery("select E.E_Name,E.E_ID, E.Salary From Employee as E where E.Salary<100000 Order by E.Salary Desc, E.E_Name Asc;");
				while(result8.next()) {
		
					String name= result8.getString("E.E_Name");
					int cid=result8.getInt("E.E_ID");
					int est=result8.getInt("E.Salary");
					System.out.println("Employee named "+name+" with ID #"+cid+" has a salary less than $100,000 of $"+est+".");
				}
				
			}
			else if(mainchoice!=9) {
				System.out.println("");
				System.out.println("");
				System.out.println("Not Valid Input");
			}
			
			System.out.println("");
		}
		System.out.println("Done displaying Queries");
		con.close();
	}
	
	public static void main(String[] args) throws Exception{
		
		Scanner myin = new Scanner(System.in);
		int mainchoice = 0;
		System.out.println("Welcome to the Bike shop database mangment tool!");
		System.out.println("");
		System.out.println("");
		while (mainchoice != 3 ) {
			System.out.println("What would you like to do?");
			System.out.println("--------------------------");
			System.out.println("");
			System.out.println("1.Insert Records");
			System.out.println("2.Answer Queries");
			System.out.println("3.Exit");
			mainchoice= myin.nextInt();
			if(mainchoice==1) {
				insertq();
			}

			else if(mainchoice==2) {
				ansq();
			}
			else if(mainchoice!=3) {
				System.out.println("Not Valid Input");
			}
			
			
		}
		
		System.out.println("THANK YOU FOR USING OUR DATABASE TOOL");
	
	}
		
	
	
	
}
