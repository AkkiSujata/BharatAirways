package Airways;
import java.util.*;
import java.sql.*;

public class DbAirways 
{
	Scanner sc=new Scanner(System.in);
	static String fname,lname,uname,pass,email;
	static String contact;
	
	/*
	 public DbAirways() throws Exception
	 {
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bharatairways","root","");
		
		
		
		
		
	 }
	 */
	public void UserAccount() throws Exception
	{	

			
			
		try
		{
			Scanner sc=new Scanner(System.in);
			 
			System.out.println("Enter Your Details");
			 
			System.out.println("Enter your First name: ");
			fname=sc.next();
				
			System.out.println("Enter your Last name: ");
			lname=sc.next();
				

			System.out.println("Enter your Email: ");
			email=sc.next();
				
			System.out.println("Enter your Contact: ");
			contact=sc.next();
					
			System.out.println("Enter your user name: ");
			uname=sc.next();
				
			System.out.println("Enter your pass: ");
			pass=sc.next();
				
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bharatairways","root","");
			 
				
		
			String q="insert into user_account(firstname,lastname,email,contact,username,password) values('"+fname+"','"+lname+"','"+email+"','"+contact+"','"+uname+"','"+pass+"')";
			

			PreparedStatement psmt=conn.prepareStatement(q);
			
			int row=psmt.executeUpdate();
			
			if(row>0) 
			{
				
				System.out.println("Data save succesfully");
			}
			else 
			{
				System.out.println("sorry");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
		


			
		
	public void Book_Tickets() throws Exception
	{
		int i,j,row;
		String Domastic[]={"Mumbai","Pune","Delhi","Nagpur","Bangalore"};
		String International[]={"Sydney","London City","Boston","Tokyo","Auckland"};
		

		Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bharatairways","root","");
		 
			
		PreparedStatement psmt;
		
		 
		int ch,ch1,ch2,ch3,ch4; //Switch cases 
		int sits=0; // Set sits variable
		int Esit=0;	// Domestic Economy class Sits
		int Bsit=0; // Domestic Business Class Sits
		int IEsit=0;//International Economy class Sits
		int IBsit=0;//International Business Class Sits
		int total_Number_of_sits=10;// Both international and domestic class sits
		int Business_class_sits=5; // Both international and business class sits
		int Economy_class_sits=5;  //Both international and Economy class sits
		int s1=total_Number_of_sits-Business_class_sits; // Business class sits are set in s1
		int s2=total_Number_of_sits-Economy_class_sits; //Economy class sits are set in s1
		int choice1,choice;
		String arrival;    //for arrival
		String  departure;  //for departure 
		String d1;// for date
		String t1;// for time
		double fare=0;// fare set 
	    double DEfare=2000;//Domestic Economy class price
		double DBfare=5000;//Domestic Business class price
		double Ifare=0;// International fare set
	    double IEfare=2000;//International Economy class price
		double IBfare=5000;//International Business class price
				
		while(true)
		{

			System.out.println("Select your Flight type:\n1:Domastic\n2:international\n3:Exit");

			ch=sc.nextInt();

			switch(ch)
			{
				case 1:

					for(i=0;i<Domastic.length;i++)
					{
						System.out.println("Domastic Flights are: "+Domastic[i]);
					}
					System.out.println("*****************************************");
					System.out.println("Select Your Arrivale locations:\n1:Mumbai\n2:Pune\n3:Delhi\n4:Nagpur\n5:Bangalore ");
					ch1=sc.nextInt();
					switch(ch1)
					{
						case 1:

							if(Domastic[0]==Domastic[0])
							{ 
								String arival="";
								String dep = Domastic[0];

								System.out.println("*****************************************");
								System.out.println("Select Your Departure locations:\n1:Pune\n2:Delhi\n3:Nagpur\n4:Bangalore ");
								choice=sc.nextInt();

								if(choice==1)
								{
									arival =Domastic[1];
									System.out.println("Your Selecting destination from Mumbai Airport to "+Domastic[1]+" Airport");

								}
								if(choice==2) 
								{	arival =Domastic[2];
									System.out.println("Your Selecting destination from Mumbai Airport to"+Domastic[2]+" Airport");

								}
								if(choice==3)
								{
									arival =Domastic[3];
									System.out.println("Your Selecting destination from Airport to"+Domastic[3]+" Airport");
								}
								if(choice==4)
								{
									arival =Domastic[4];
									System.out.println("Your Selecting destination Mumbai from Airport to"+Domastic[4]+" Airport");
								}		

								System.out.println("Enter your Departure date (dd/mm/yyyy):");
								d1=sc.next();
								System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
								t1=sc.next();
								System.out.println("Select your class:\n1:Economy class\n2:Business class");
								choice1=sc.nextInt();
								if(choice1==1)
								{
									String cls="Economy";
									System.out.println("Total numbers of sits in Economy class is: "+s1);   
									System.out.println("How much tickests You want: ");
									Esit=sc.nextInt();
									if(Esit==1)
									{
										try
										{
											String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DEfare+"','"+uname+"')";
											psmt=conn.prepareStatement(q);
									
											row=psmt.executeUpdate();
									
											if(row>0) 
											{
										
												System.out.println("your fare is :"+DEfare);
												System.out.println();
												System.out.println("Ticket booked succesfully");
											}
											else 
											{
												System.out.println("sorry");
											}
										}
										catch(Exception e)
										{
											System.out.println(e.getMessage());
										}
									
									}
									if(Esit==2)
									{
										try
										{
											fare=2*DEfare;
											String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
											psmt=conn.prepareStatement(q);

											row=psmt.executeUpdate();
											if(row>0) 
											{

											
												System.out.println("your fare is:"+fare);
												System.out.println();
												System.out.println("Ticket booked succesfully");
											}	
											else 
											{
												System.out.println("sorry");
											}
										}
										catch(Exception e)
										{
											System.out.println(e.getMessage());
										}

									}
								

									if(Esit==3)
									{
										try
										{
											fare=3*DEfare;
											String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
											psmt=conn.prepareStatement(q);

											row=psmt.executeUpdate();
											if(row>0) 
											{

											
												System.out.println("your fare is:"+fare);
												System.out.println();
												System.out.println("Ticket booked succesfully");
											}	
											else 
											{
												System.out.println("sorry");
											}
										}
										catch(Exception e)
										{
											System.out.println(e.getMessage());
										}
						
									}	


									if(Esit==4)
									{
									
										try
										{
											fare=4*DEfare;
											String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
											psmt=conn.prepareStatement(q);

											row=psmt.executeUpdate();
											if(row>0) 
											{

											
												System.out.println("your fare is:"+fare);
												System.out.println();
												System.out.println("Ticket booked succesfully");
											}	
											else 
											{
												System.out.println("sorry");
											}
										}
										catch(Exception e)
										{
											System.out.println(e.getMessage());
										}

										
									}	


									if(Esit==5)
									{
										
										try
										{
											fare=5*DEfare;
											String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
											psmt=conn.prepareStatement(q);

											row=psmt.executeUpdate();
											if(row>0) 
											{

											
												System.out.println("your fare is:"+fare);
												System.out.println();
												System.out.println("Ticket booked succesfully");
											}	
											else 
											{
												System.out.println("sorry");
											}
										}
										catch(Exception e)
										{
											System.out.println(e.getMessage());
										}

									}

									else if(Esit>5)
									{
										System.out.println("Sorry no place available: ");
									}	


								}	

							

								if(choice1==2)
								{   String cls="Business";
									System.out.println("Total numbers of sits in Business class is: "+s2);
							
									System.out.println("How much tickests You want: ");
									Bsit=sc.nextInt();
									if(Bsit==1)
									{
										try
										{
											String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DBfare+"','"+uname+"')";
											psmt=conn.prepareStatement(q);
									
											row=psmt.executeUpdate();
									
											if(row>0) 
											{
										
												System.out.println("your fare is :"+DBfare);
												System.out.println();
												System.out.println("Ticket booked succesfully");
											}
											else 
											{
												System.out.println("sorry");
											}
										}
										catch(Exception e)
										{
											System.out.println(e.getMessage());
										}

										
									}

									if(Bsit==2)
									{
										
										try
										{   fare=2*DBfare;
											String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
											psmt=conn.prepareStatement(q);
									
											row=psmt.executeUpdate();
									
											if(row>0) 
											{
										
												System.out.println("your fare is :"+fare);
												System.out.println();
												System.out.println("Ticket booked succesfully");
											}
											else 
											{
												System.out.println("sorry");
											}
										}
										catch(Exception e)
										{
											System.out.println(e.getMessage());
										}
										
									}
		
		
									if(Bsit==3)
									{
										
										try
										{   fare=3*DBfare;
											String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
											psmt=conn.prepareStatement(q);
									
											row=psmt.executeUpdate();
									
											if(row>0) 
											{
										
												System.out.println("your fare is :"+fare);
												System.out.println();
												System.out.println("Ticket booked succesfully");
											}
											else 
											{
												System.out.println("sorry");
											}
										}
										catch(Exception e)
										{
											System.out.println(e.getMessage());
										}
										
									}
		
									if(Bsit==4)
									{
										try
										{   fare=4*DBfare;
											String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
											psmt=conn.prepareStatement(q);
									
											row=psmt.executeUpdate();
									
											if(row>0) 
											{
										
												System.out.println("your fare is :"+fare);
												System.out.println();
												System.out.println("Ticket booked succesfully");
											}
											else 
											{
												System.out.println("sorry");
											}
										}
										catch(Exception e)
										{
											System.out.println(e.getMessage());
										}
		
										
			
									}
		
									if(Bsit==5)
									{
									try
									{  
										fare=5*DBfare;
										String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
										psmt=conn.prepareStatement(q);
								
										row=psmt.executeUpdate();
								
										if(row>0) 
										{
									
											System.out.println("your fare is :"+fare);
											System.out.println();
											System.out.println("Ticket booked succesfully");
										}
										else 
										{
											System.out.println("sorry");
										}
									}
									catch(Exception e)
									{
										System.out.println(e.getMessage());
									}
									
									}
										
		
									else if(Bsit>5)
									{
										System.out.println("Sits are not avilable: ");
									}
		
									}
								}
						
							break;
						
				
							case 2: 
								if(Domastic[1]==Domastic[1])
								{
									String arival="";
									String dep = Domastic[1];
									System.out.println("Select Your Departure locations:\n1:Mumbai\n2:Delhi\n3:Nagpur\n4:Bangalore ");
									choice=sc.nextInt();
	
	
	
									if(choice==1)
									{
										arival =Domastic[0];
										System.out.println("Your tickets are confirmed pune to "+Domastic[0]+" Airport");
	
									}
									if(choice==2)
									{
										arival =Domastic[2];
										System.out.println("Your tickets are confirmed pune to"+Domastic[2]+" Airport");
	
									}
									if(choice==3)
									{
										arival =Domastic[3];
										System.out.println("Your tickets are confirmed pune to"+Domastic[3]+" Airport");
									}
									if(choice==4)
									{
										arival =Domastic[4];
										System.out.println("Your tickets are confirmed pune to"+Domastic[4]+" Airport");
									}
	
	
									System.out.println("Enter your Departure date (dd/mm/yyyy):");
									d1=sc.next();
									System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
									t1=sc.next();
								
									System.out.println("Select your class:\n1:Economy class\n2:Business class");
									choice1=sc.nextInt();
									if(choice1==1)
									{ String cls="Economy";
										System.out.println("Total numbers of sits in Economy class is: "+s1);   
	
	
										System.out.println("How much tickests You want: ");
										Esit=sc.nextInt();
										if(Esit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DEfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+DEfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
	
										}
	
										if(Esit==2)
										{
											try
											{
												fare=2*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

	
										}
	
	
										if(Esit==3)
										{
											try
											{
												fare=3*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

				
	
										}
	
										if(Esit==4)
										{
											try
											{
												fare=4*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
											
										}
	
										if(Esit==5)
										{
											try
											{
												fare=5*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
	
										}
	
										else if(Esit==6)
										{
											System.out.println("Sits are not avilable: ");
										}
	
									}   
									if(choice1==2)
									{
										String cls="Business";
										System.out.println("Total numbers of sits in Economy class is: "+s2);
	
	
										System.out.println("How much tickests You want: ");
										Bsit=sc.nextInt();
										if(Bsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DBfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+DBfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
	
										}
	
										if(Bsit==2)
										{
											try
											{   fare=2*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		 
										
		
		
										}
		
		
										if(Bsit==3)
										{
											try
											{   fare=3*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										
		
										}
		
										if(Bsit==4)
										{
											try
											{   fare=4*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		 
		
										}
		
										if(Bsit==5)
										{
											try
											{  
												fare=5*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(Bsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
									}
	
								}
							break;

							case 3:
	
								if(Domastic[2]==Domastic[2])
								{	String arival="";
								String dep = Domastic[2];
								
									System.out.println("Select Your Departure locations:\n1:Mumbai\n2:Pune\n3:Nagpur\n4:Bangalore ");
									choice=sc.nextInt();
		
									if(choice==1)
									{
										arival =Domastic[0];
										System.out.println("Your tickets are confirmed Delhi Airport to "+Domastic[0]+" Airport");
		
									}
									if(choice==2)
									{	arival =Domastic[1];
										System.out.println("Your tickets are confirmed Delhi Airport to"+Domastic[1]+" Airport");
		
									}
									if(choice==3)
									{
										arival =Domastic[3];
										System.out.println("Your tickets are confirmed Delhi Airport to"+Domastic[3]+" Airport");
									}
									if(choice==4)
									{	arival =Domastic[4];
										System.out.println("Your tickets are confirmed Delhi Airport to"+Domastic[4]+" Airport");
									}		
		
		
									System.out.println("Enter your Departure date (dd/mm/yyyy):");
									d1=sc.next();
									System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
									t1=sc.next();	
		
		
									System.out.println("Select your class:\n1:Economy class\n2:Business class");
									choice1=sc.nextInt();
									if(choice1==1)
									{
										String cls="Economy";
										System.out.println("Total numbers of sits in Economy class is: "+s1);   
		
		
										System.out.println("How much tickests You want: ");
										Esit=sc.nextInt();
										if(Esit==1)
										{
										
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DEfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+DEfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

		
										}
		
										if(Esit==2)
										{
											try
											{
												fare=2*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

		
		
										}
		
		
										if(Esit==3)
										{
											try
											{
												fare=3*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(Esit==4)
										{
											try
											{
												fare=4*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(Esit==5)
										{
											try
											{
												fare=5*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(Esit==6)
										{
											System.out.println("Sits are not avilable: ");
										}
		
		
		
		
									}   
									if(choice1==2)
									{
										String cls="Business";
										System.out.println("Total numbers of sits in Business class is: "+s2);
		
										System.out.println("How much tickests You want: ");
										Bsit=sc.nextInt();
										if(Bsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DBfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+DBfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(Bsit==2)
										{
		
											try
											{   fare=2*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
											
		
										}
		
		
										if(Bsit==3)
										{
											
											try
											{   fare=3*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
											
											
										}
		
										if(Bsit==4)
										{
											try
											{   fare=4*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		 
		
										}
		
										if(Bsit==5)
										{
											try
											{  
												fare=5*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(Bsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
									}
		
		
		
		
								}
	
							break;					
					
					
							case 4:
								if(Domastic[3]==Domastic[3])
								{	String arival="";
									String dep = Domastic[3];
									
		
									System.out.println("Select Your Departure locations:\n1:Mumbai\n2:Pune\n3:Delhi\n4:Bangalore ");
									choice=sc.nextInt();
		
									if(choice==1)
									{
										arival =Domastic[0];
										System.out.println("Your tickets are confirmed Nagpur Airport to "+Domastic[0]+" Airport");
		
									}
									if(choice==2)
									{
										arival =Domastic[1];
										System.out.println("Your tickets are confirmed Nagpur Airport to"+Domastic[1]+" Airport");
		
									}
									if(choice==3)
									{
										arival =Domastic[2];
										System.out.println("Your tickets are confirmed Nagpur Airport to"+Domastic[2]+" Airport");
									}
									if(choice==4)
									{
										arival =Domastic[4];
										System.out.println("Your tickets are confirmed Nagpur Airport to"+Domastic[4]+" Airport");
									}		
		
		
									System.out.println("Enter your Departure date (dd/mm/yyyy):");
									d1=sc.next();
									System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
									t1=sc.next();
									System.out.println("Select your class:\n1:Economy class\n2:Business class");
									choice1=sc.nextInt();
									if(choice1==1)
									{	String cls="Economy";
										System.out.println("Total numbers of sits in Economy class is: "+s1);   
		
		
										System.out.println("How much tickests You want: ");
										Esit=sc.nextInt();
										if(Esit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DEfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+DEfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(Esit==2)
										{
											try
											{
												fare=2*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
		
										}
		
		
										if(Esit==3)
										{
											try
											{
												fare=3*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(Esit==4)
										{
											try
											{
												fare=4*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(Esit==5)
										{
											try
											{
												fare=5*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(Esit==6)
										{
											System.out.println("Sits are not avilable: ");
										}
		
									}   
									if(choice==2)
									{ String cls="Business";
										System.out.println("Total numbers of sits in Business class is: "+s2);
		
										System.out.println("How much tickests You want: ");
										Bsit=sc.nextInt();
										if(Bsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DBfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+DBfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(Bsit==2)
										{
											try
											{   fare=2*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
		
										}
		
		
										if(Bsit==3)
										{
		
											try
											{   fare=3*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
											
		 
		 
											
										}
		
										if(Bsit==4)
										{
											
											try
											{   fare=4*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
											
		
										}
		
										if(Bsit==5)
										{
											try
											{  
												fare=5*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(Bsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
		
									}
								}
							break;
							
							
							
							case 5:
								if(Domastic[4]==Domastic[4])
								{
									String arival="";
									String dep = Domastic[4];
									
		
									System.out.println("Select Your Departure locations:\n1:Mumbai\n2:Pune\n3:Delhi\n4:Nagpur ");
									choice=sc.nextInt();
		
									if(choice==1)
									{
										arival =Domastic[0];
										System.out.println("Your tickets are confirmed Bangalore Airport to "+Domastic[0]+" Airport");
		
									}
									if(choice==2)
									{	arival =Domastic[1];
										System.out.println("Your tickets are confirmed Bangalore Airport to"+Domastic[1]+" Airport");
		
									}
									if(choice==3)
									{
										arival =Domastic[2];
										System.out.println("Your tickets are confirmed Bangalore Airport to"+Domastic[2]+" Airport");
									}
									if(choice==4)
									{
										arival =Domastic[3];
										System.out.println("Your tickets are confirmed Bangalore Airport to"+Domastic[3]+" Airport");
									}	
		
		
									System.out.println("Enter your Departure date (dd/mm/yyyy):");
									d1=sc.next();
									System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
									t1=sc.next();
		
									System.out.println("Select your class:\n1:Economy class\n2:Business class");
									choice1=sc.nextInt();
									if(choice1==1)
									{	String cls="Economy";
										System.out.println("Total numbers of sits in Economy class is: "+s1);   
										System.out.println("How much tickests You want: ");
										Esit=sc.nextInt();
										if(Esit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DEfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+DEfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
											
		
										}
		
										if(Esit==2)
										{
											try
											{
												fare=2*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
		
										}
		
		
										if(Esit==3)
										{
											try
											{
												fare=3*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

		
										}
		
										if(Esit==4)
										{
											try
											{
												fare=4*DEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(Esit==5)
										{

											try
												{
													fare=5*DEfare;
													String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
													psmt=conn.prepareStatement(q);

													row=psmt.executeUpdate();
													if(row>0) 
													{

													
														System.out.println("your fare is:"+fare);
														System.out.println();
														System.out.println("Ticket booked succesfully");
													}	
													else 
													{
														System.out.println("sorry");
													}
												}
												catch(Exception e)
												{
													System.out.println(e.getMessage());
												}
		
										}
		
										else if(Esit==6)
										{
											System.out.println("Sits are not avilable: ");
										}
		
		
									}   
		
									if(choice1==2)
									{	String cls="Business";
										System.out.println("Total numbers of sits in Business class is: "+s2);
		
										System.out.println("How much tickests You want: ");
		
										Bsit=sc.nextInt();
										if(Bsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+DBfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+DBfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

		
										}
		
										if(Bsit==2)
										{
											try
											{   fare=2*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		 
		
		
										}
		
		
										if(Bsit==3)
										{
											try
											{   fare=3*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										
		
										}
		
										if(Bsit==4)
										{
											try
											{   fare=4*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

		
										}
		
										if(Bsit==5)
										{
											try
											{  
												fare=5*DBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+fare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+fare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(Bsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
									}
		
								}
							
							//break;
						}
					break;
					case 2:
	
						for(j=0;j<International.length;j++)
	
						{
							System.out.println("International Flights are: "+International[j]);
						}
						System.out.println("*****************************************");
						System.out.println("Select Your Arrivale locations:\n1:Sydney\n2:London City\n3:Boston\n4:Tokyo\n5:Auckland ");
						ch2=sc.nextInt();
						switch(ch2)
						{
							case 1:
								if(International[0]==International[0])
								{	String arival="";
									String dep = International[0];
	
									System.out.println("Select Your Departure locations:\n1:London city\n2:Boston\n3:Tokyo\n4:Auckland ");
									choice=sc.nextInt();
									if(choice==1)
									{
										arival=International[1];
										System.out.println("Your tickets are confirmed from Sydney Airport to "+International[1]+" Airport");
	
									}
									if(choice==2)
									{
										arival=International[2];
										System.out.println("Your tickets are confirmed from Sydney Airport to "+International[2]+" Airport");
									}
									if(choice==3)
									{	arival=International[3];
										System.out.println("Your tickets are confirmed from Sydney Airport to "+International[3]+" Airport");
									}
									if(choice==4)
									{	arival=International[4];
										System.out.println("Your tickets are confirmed from Sydney Airport to "+International[4]+" Airport");
									}	
	
									System.out.println("Enter your Departure date (dd/mm/yyyy):");
									d1=sc.next();
									System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
									t1=sc.next();
									System.out.println("Select your class:\n1:Economy class\n2:Business class");
									choice1=sc.nextInt();
									if(choice1==1)
									{	String cls="Economy";
										System.out.println("Total numbers of sits in Economy class is: "+s1);   
										System.out.println("How much tickests You want: ");
										IEsit=sc.nextInt();
										if(IEsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IEfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+"$"+IEfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
											
										}
										if(IEsit==2)
										{
											try
											{
												Ifare=2*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

											
											
											
	
										}
	
	
										if(IEsit==3)
										{
											try
											{
												Ifare=3*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										}
	
										if(IEsit==4)
										{
											try
											{
												Ifare=4*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										}
	
										if(IEsit==5)
										{
											try
											{
												Ifare=5*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										}
										else if(IEsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
	
									}   
									if(choice1==2)
									{String cls="Business";
										System.out.println("Total numbers of sits in Business class is: "+s2);
										System.out.println("How much tickests You want: ");
										IBsit=sc.nextInt();
										if(IBsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IBfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+IBfare); 	
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
	
										}
										if(IBsit==2)
										{
											try
											{   Ifare=2*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare); 
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}	
									
										}
	
										if(IBsit==3)
										{
											try
											{   Ifare=3*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

										}
										if(IBsit==4)
										{
											try
											{   Ifare=4*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

										}
											
										if(IBsit==5)
										{
											try
											{   Ifare=5*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										}
	
										else if(IBsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
	
									}
	
								}
							break;



							case 2:	
								if(International[1]==International[1])
								{
									String arival="";
									String dep = International[1];
									
									System.out.println("Select Your Departure locations:\n1:Sydney\n2:Boston\n3:Tokyo\n4:Auckland ");
									choice=sc.nextInt();
									if(choice==1)
									{		arival=International[0];
										System.out.println("Your tickets are confirmed London City Airport to "+International[0]+" Airport");
		
									}	
									if(choice==2)
									{
										arival=International[2];
										System.out.println("Your tickets are confirmed London City Airport to "+International[2]+" Airport");
									}
									if(choice==3)
									{
										arival=International[3];
										System.out.println("Your tickets are confirmed London City Airport to "+International[3]+" Airport");
									}
									if(choice==4)
									{
										arival=International[4];
										System.out.println(" Your tickets are confirmed London City Airport to "+International[4]+" Airport");
		
									} 
		
		
									System.out.println("Enter your Departure date (dd/mm/yyyy):");
									d1=sc.next();
									System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
									t1=sc.next();
		
									System.out.println("Select your class:\n1:Economy class\n2:Business class");
									choice1=sc.nextInt();
									if(choice1==1)
									{	String cls="Economy";
										System.out.println("Total numbers of sits in Economy class is: "+s1);   
		
										System.out.println("How much tickests You want: ");
										IEsit=sc.nextInt();
										if(IEsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IEfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+"$"+IEfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IEsit==2)
										{
											try
											{
												Ifare=2*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

		
		
										}
		
		
										if(IEsit==3)
										{
											try
											{
												Ifare=3*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IEsit==4)
										{
											try
											{
												Ifare=4*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IEsit==5)
										{
											try
											{
												Ifare=5*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(IEsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
									}   
									if(choice1==2)
									{ String cls="Business";
										System.out.println("Total numbers of sits in Business class is: "+s2);
										System.out.println("How much tickests You want: ");
										IBsit=sc.nextInt();
										if(IBsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IBfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+IBfare); 	
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IBsit==2)
										{
											try
											{   Ifare=2*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare); 
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
		
										}
		
		
										if(IBsit==3)
										{
											try
											{   Ifare=3*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										}
		
										if(IBsit==4)
										{
											try
											{   Ifare=4*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IBsit==5)
										{
											try
											{   Ifare=5*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(IBsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
		
									}
		
		
								}
							break;
	
							case 3:		
	
								if(International[2]==International[2])
								{	String arival="";
									String dep = International[2];
									System.out.println("Select Your Departure locations:\n1:Sydney\n2:London city\n3:Tokyo\n4:Auckland ");
									choice=sc.nextInt();
									if(choice==1)
									{	arival=International[0];
										System.out.println("Your tickets are confirmed Boston Airport to "+International[0]+" Airport");
		
									}	
									if(choice==2)
									{
										arival=International[1];
										System.out.println("Your tickets are confirmed Boston Airport to "+International[1]+" Airport");
									}
									if(choice==3)
									{
										arival=International[3];
										System.out.println("Your tickets are confirmed Boston Airport to "+International[3]+" Airport");
									}
									if(choice==4)
									{
										arival=International[4];
										System.out.println(" Your tickets are confirmed  Boston Airport to "+International[4]+" Airport");
		
									} 
		
		
									System.out.println("Enter your Departure date (dd/mm/yyyy):");
									d1=sc.next();
									System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
									t1=sc.next();
									System.out.println("Select your class:\n1:Economy class\n2:Business class");
									choice1=sc.nextInt();
									if(choice1==1)
									{	String cls="Economy";
										System.out.println("Total numbers of sits in Economy class is: "+s1);   
										System.out.println("How much tickests You want: ");
										IEsit=sc.nextInt();
										if(IEsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IEfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+"$"+IEfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IEsit==2)
										{
											try
											{
												Ifare=2*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
		
										}
		
		
										if(IEsit==3)
										{
											try
											{
												Ifare=3*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IEsit==4)
										{
											try
											{
												Ifare=4*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
											
										}
		
										if(IEsit==5)
										{
											try
											{
												Ifare=5*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(IEsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
									}   
									if(choice1==2)
									{	String cls="Business";
										System.out.println("Total numbers of sits in Business class is: "+s2);
										System.out.println("How much tickests You want: ");
										IBsit=sc.nextInt();
										if(IBsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IBfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+IBfare); 	
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IBsit==2)
										{
											try
											{   Ifare=2*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare); 
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}	
		
										}
		
		
										if(IBsit==3)
										{
											try
											{   Ifare=3*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IBsit==4)
										{
											try
											{   Ifare=4*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										
		
										}
		
										if(IBsit==5)
										{
											try
											{   Ifare=5*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										}
		
										else if(IBsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
		
		
									}
		
		
		
								}
							break;
	
	
							case 4:		
								if(International[3]==International[3])
								{
									String arival="";
									String dep = International[3];
		
									System.out.println("Select Your Departure locations:\n1:Sydney\n2:London city\n3:Boston\n4:Auckland ");
									choice=sc.nextInt();
									if(choice==1)
									{
										arival=International[0];
										System.out.println("Your tickets are confirmed Tokyo Airport to "+International[0]+" Airport");
		
									}	
									if(choice==2)
									{
										arival=International[1];
										System.out.println("Your tickets are confirmed Tokyo Airport to "+International[1]);
									}
									if(choice==3)
									{
										arival=International[2];
										System.out.println("Your tickets are confirmed Tokyo Airport to "+International[2]);
									}
									if(choice==4)
									{	arival=International[4];
										System.out.println(" Your tickets are confirmed Tokyo Airport to "+International[4]);
		
									} 
		
		
		
		
									System.out.println("Enter your Departure date (dd/mm/yyyy):");
									d1=sc.next();
									System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
									t1=sc.next();
									System.out.println("Select your class:\n1:Economy class\n2:Business class");
									choice1=sc.nextInt();
									if(choice1==1)
									{	String cls="Economy";
										System.out.println("Total numbers of sits in Economy class is: "+s1);   
										System.out.println("How much tickests You want: ");
										IEsit=sc.nextInt();
										if(IEsit==1)
										{
											
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IEfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+"$"+IEfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IEsit==2)
										{
											try
											{
												Ifare=2*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
		
										}
		
		
										if(IEsit==3)
										{
											try
											{
												Ifare=3*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IEsit==4)
										{
											try
											{
												Ifare=4*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										}
		
										if(IEsit==5)
										{
											try
											{
												Ifare=5*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										}
		
										else if(IEsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
		
									}   
									if(choice1==2)
									{String cls="Business";
										System.out.println("Total numbers of sits in Business class is: "+s2);
										System.out.println("How much tickests You want: ");
										IBsit=sc.nextInt();
										if(IBsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IBfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare); 	
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IBsit==2)
										{
											try
											{   Ifare=2*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare); 
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}	
		
		
										}
		
		
										if(IBsit==3)
										{
											try
											{   Ifare=3*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IBsit==4)
										{
											try
											{   Ifare=4*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IBsit==5)
										{
											try
											{   Ifare=5*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(IBsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
		
									}
		
		
		
		
								}
							break;
		
		
		
							case 5:		
								if(International[4]==International[4])
								{
									String arival="";
									String dep = International[4];
		
									System.out.println("Select Your Departure locations:\n1:Sydney\n2:London city\n3:Boston\n4:Tokyo ");
									choice=sc.nextInt();
									if(choice==1)
									{	
										arival=International[0];
										System.out.println("Your tickets are confirmed Auckland Airport to "+International[0]+" Airport");
		
									}	
									if(choice==2)
									{
										arival=International[1];
										System.out.println("Your tickets are confirmed Auckland Airport to "+International[1]);
									}
									if(choice==3)
									{
										arival=International[2];
										System.out.println("Your tickets are confirmed Auckland Airport  to "+International[2]);
									}
									if(choice==4)
									{
										arival=International[3];
										System.out.println(" Your tickets are confirmed  Auckland  Airport to "+International[3]);
		
									} 
		
		
		
									System.out.println("Enter your Departure date (dd/mm/yyyy):");
									d1=sc.next();
									System.out.println("Enter your Departure time in 24 hr time format (hh:mm):");
									t1=sc.next();
		
									System.out.println("Select your class:\n1:Economy class\n2:Business class");
									choice1=sc.nextInt();
									if(choice1==1)
									{	String cls="Economy";
										System.out.println("Total numbers of sits in Economy class is: "+s1);   
										System.out.println("How much tickests You want: ");
										IEsit=sc.nextInt();
										if(IEsit==1)
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IEfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your fare is :"+"$"+IEfare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IEsit==2)
										{
											try
											{
												Ifare=2*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
		
										if(IEsit==3)
										{
											try
											{
												Ifare=3*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IEsit==4)
										{
											try
											{
												Ifare=4*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										}
		
										if(IEsit==5)
										{
											try
											{
												Ifare=5*IEfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);

												row=psmt.executeUpdate();
												if(row>0) 
												{

												
													System.out.println("your fare is:"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}	
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}

		
										}
		
										else if(IEsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
									}   
									if(choice1==2)
									{	String cls="Business";
										System.out.println("Total numbers of sits in Business class is: "+s2);
		
										System.out.println("How much tickests You want: ");
										IBsit=sc.nextInt();
										if(IBsit==1)
										
										{
											try
											{
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+IBfare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+IBfare); 	
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}	
		
										}
		
										if(IBsit==2)
										{
											try
											{   Ifare=2*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare); 
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}	
												
		
		
										}
		
		
										if(IBsit==3)
										{
											try
											{   Ifare=3*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										if(IBsit==4)
										{
											try
											{   Ifare=4*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
										
		
										}
		
										if(IBsit==5)
										{
											try
											{   Ifare=5*IBfare;
												String q= "insert into flightbooking (Class,Departure_location,Arrival_location,Date,Time,Fare1,username) values('"+cls+"','"+dep+"','"+arival+"','"+d1+"','"+t1+"','"+Ifare+"','"+uname+"')";
												psmt=conn.prepareStatement(q);
										
												row=psmt.executeUpdate();
										
												if(row>0) 
												{
											
													System.out.println("your Ifare is :"+"$"+Ifare);
													System.out.println();
													System.out.println("Ticket booked succesfully");
												}
												else 
												{
													System.out.println("sorry");
												}
											}
											catch(Exception e)
											{
												System.out.println(e.getMessage());
											}
		
										}
		
										else if(IBsit>5)
										{
											System.out.println("Sits are not avilable: ");
										}
		
									}
		
		
								}
		
		
							}		
		
					break;

					case 3 :
						System.out.println("Thank You");
						System.exit(0);
					  //break;
					
				}
		}
	}
		
		void Show() throws Exception
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bharatairways","root","");
			PreparedStatement psmt;
			ResultSet rs;
			
			String q = "select * from flightbooking where username ='"+uname+"'";
			
			psmt=conn.prepareStatement(q);
			rs=psmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println("	Class: "+rs.getString("Class")+"		Fare: "+rs.getString("Fare1"));
				System.out.println("Source: "+rs.getString("Departure_location")+"		Destination: "+rs.getString("Arrival_location"));
				System.out.println("Date: "+rs.getString("Date")+"	Time: "+rs.getString("Time"));
				System.out.println();
				System.out.println("----------------------------------------------------------------------------");
				System.out.println();
			}


		}
		 

		public void Cancel_Tickets() throws Exception
			{ System.out.println("Enter your booking id");
				int bkid=sc.nextInt();
				int bcsl;
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bharatairways","root","");
			
				String q="delete from flightbooking where BookingId='"+bkid+"'";
				
				PreparedStatement psmt= conn.prepareStatement(q);
				
				int row=psmt.executeUpdate();
				
				if(row>0) {
					
					System.out.println("Data delete succesfully");
				}
				else {
					
					System.out.println("sorry");
				}
			}

	

public static void main (String args[]) throws Exception 
		{
			int ch5=0;
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bharatairways","root","");
			PreparedStatement psmt;
			ResultSet rs;
			
		
		 
			DbAirways air=new DbAirways();
	while(true)
	{
			System.out.println("1. Loging");
			System.out.println("2. Register");
			System.out.println("Enter your choice");
			ch5=sc.nextInt();
			
			switch(ch5)
			{
			case 1:
				System.out.print("Username: ");
				uname=sc.next();
			
				System.out.print("Password: ");
				pass=sc.next();
			
				System.out.println();
			
				String q3 ="select * from user_account where username='"+uname+"' and password='"+pass+"'";
				psmt=conn.prepareStatement(q3);
				rs=psmt.executeQuery();
				if(rs.next())
				{
					while(true)
					{
						System.out.println("Welcome "+rs.getString("firstname")+" "+rs.getString("lastname"));
			
						System.out.println();
				
						System.out.println("1. Book Tickets");
						System.out.println("2. Show Tickets");
						//System.out.println("3.Cancel Ticket");
						System.out.println("3.Exit");
						System.out.println("Enter your choice");
						ch5=sc.nextInt();
						
						switch(ch5)
						{
						case 1:
							air.Book_Tickets();
							break;
						case 2:
							air.Show();
							break;
						case 3:
							System.exit(0);
						}
					}
				}
				else
				{
					System.out.println("Username and Password does not match");
				}
				break;
				
			case 2:
				air.UserAccount();
				break;

			}
			
	}
	
		}				





						//air.Book_Tickets();		
}



	 
