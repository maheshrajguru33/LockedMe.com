package MajorProject;
import java.io.*;
import java.util.*;

class Mobile implements Serializable {
	int model;
	int price;
	String coName;
	Mobile(int model,int price,String coName)throws Exception{
		this.model=model;
		this.coName=coName;
		this.price=price;
	}
	public String toString(){
		return model+" "+coName+" "+price;
	}
}

public class LockedMe {
	public static void main(String[] args)throws Exception{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("@LockedMe.com");
		System.out.println("Developed by Mahesh Rajguru");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		int choice= -1, Operation=-1,sortby=-1;
		String fname;
		ArrayList<Mobile> Mo=new ArrayList<Mobile>();
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		ListIterator li=null;
		
		
		do{	
		Scanner s=new Scanner(System.in);
		Scanner s1=new Scanner(System.in);
		
		System.out.println("..............................................................");
		System.out.println("1. Display All Files and Folder from current Location:");
		System.out.println("2. Create file:");
		System.out.println("3. Search File:");
		System.out.println("4. Delete File:");
		System.out.println("0. Exit:");
		System.out.println("..............................................................");
		try{
			System.out.println("Use the Option's:-->>>");
			choice=s.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("......Invalid Input.....Please Try again");	
		}
		
		switch(choice){
		case 1:
			File file=new File("D:\\Programming\\Java programs\\Phase1Project");
			
			String [] arr=file.list();
			
			 	for(String tmp:arr){
				System.out.println(tmp);
			 	}
		break;
		
		case 2:
			
			Scanner sc=new Scanner(System.in);   
			System.out.println("Enter the File name: ");
			String name=sc.nextLine();
			FileOutputStream fos=new FileOutputStream(name, true);
			System.out.println("File created successfuly");
			fos.close();
			
		break;	
		case 3:
			
			System.out.print("Enter File Name with Extention to search  : ");
			fname=s1.nextLine();
			
			oos=new ObjectOutputStream(new FileOutputStream(fname));
			oos.writeObject(Mo);
			oos.close();
			
			try
		      {
		         BufferedReader red = new BufferedReader(new FileReader(fname));
		         red.close();
		         File f=new File("D:\\Programming\\Java programs\\Phase1Project");

		         if(false)
		         	System.out.println(fname.equals(fname));
		         {
		        	 
		        	 System.out.println("file exists");
		        	 
		         }
				 	

		      }
		      catch(IOException e)
		      {
		            System.out.println("Exception Occurred : " + e);
		            System.out.println("File does not exist...!!");
		      }
			do{
				
				System.out.println("********************************************************");
				
				System.out.println("1.Write Data for a file");
				System.out.println("2.Display Data from a file");
				System.out.println("3.Add new Data to a file");
				System.out.println("4.Update Data to a file");
				System.out.println("5.Delete Data from a file");
				System.out.println("6.Sort Data of a file");
				System.out.println("0.Exit file");
				System.out.println("********************************************************");
				try{
					System.out.println("Operate file you created or searched");
					Operation=s.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("......Invalid Input.....Please Try again");	
				}
				
			
			switch(Operation){
			case 1:
			System.out.println("Enter Numbre of Mobiles Details to store:");
			int n=s.nextInt();
			for(int i=0;i<n;i++){
				
			System.out.println("Enter Name of Mobile company:");
			String coName=s1.nextLine();
			
			System.out.println("Enter Model number:");
			int model=s.nextInt();
			
			System.out.println("Enter Price:");
			int price=s.nextInt();
			
			Mo.add(new Mobile(model,price,coName));
			}
			oos=new ObjectOutputStream(new FileOutputStream(fname));
			oos.writeObject(Mo);
			oos.close();
			break;
			
			case 2:
				oos=new ObjectOutputStream(new FileOutputStream(fname));
				oos.writeObject(Mo);
				oos.close();
				try{
				BufferedReader red = new BufferedReader(new FileReader(fname));
		         red.close();
				ois = new ObjectInputStream(new FileInputStream(fname));
				Mo = (ArrayList<Mobile>)ois.readObject();
		         li = Mo.listIterator();
		         while(li.hasNext())
						System.out.println(li.next());
		         }
		         catch(IOException e){
		         
		        	 System.out.println("File not found");
		         }
			break;
			case 3:
				oos=new ObjectOutputStream(new FileOutputStream(fname));
				oos.writeObject(Mo);
				oos.close();
				
				System.out.println("Enter Numbre of Mobiles Details to store:");
				int k=s.nextInt();
				for(int i=0;i<k;i++){
					
				System.out.println("Enter Name of Mobile company:");
				String coName=s1.nextLine();
				
				System.out.println("Enter Model number:");
				int model=s.nextInt();
				
				System.out.println("Enter Price:");
				int price=s.nextInt();
				
				Mo.add(new Mobile(model,price,coName));
				}
				oos=new ObjectOutputStream(new FileOutputStream(fname));
				oos.writeObject(Mo);
				oos.close();
				break;
			case 4:
				oos=new ObjectOutputStream(new FileOutputStream(fname));
				oos.writeObject(Mo);
				oos.close();
				
					ois = new ObjectInputStream(new FileInputStream(fname));
					Mo = (ArrayList<Mobile>)ois.readObject();
					ois.close();
					boolean found=false;
					System.out.println("Enter model numb to Update the record");
					int model =s.nextInt();
					li= Mo.listIterator();
					while(li.hasNext()){
						Mobile m= (Mobile)li.next();
						if(m.model==model){
							System.out.println("Enter new coName");
							String coName=s1.nextLine();
							
							System.out.println("Enter new model number");
							 model=s.nextInt();
							
							System.out.println("Enter price ");
							int price=s.nextInt();
							
							li.set(new Mobile(model,price,coName));
							found=true;
							
							
						}
					}		
			break;
			case 5:
				oos=new ObjectOutputStream(new FileOutputStream(fname));
				oos.writeObject(Mo);
				oos.close();
				
					ois = new ObjectInputStream(new FileInputStream(fname));
					Mo = (ArrayList<Mobile>)ois.readObject();
					ois.close();
					boolean got=false;
					System.out.println("Enter model number to delete the record");
					model =s.nextInt();
					li= Mo.listIterator();
					while(li.hasNext()){
						Mobile m= (Mobile)li.next();
						if(m.model==model){
							li.remove();
							got=true;
						}
					}
				break;
				case 6:
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					System.out.println("Press 1 for sort by model");
					System.out.println("Press 2 for sort by price");
					System.out.println("Press 3 for sort by coName");
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					System.out.println("Enter How you want to sort:");
					sortby=s.nextInt();
					
							switch(sortby){
							case 1:
							oos=new ObjectOutputStream(new FileOutputStream(fname));
							oos.writeObject(Mo);
							oos.close();
							
							ois = new ObjectInputStream(new FileInputStream(fname));
							Mo = (ArrayList<Mobile>)ois.readObject();
							ois.close();
							
							Collections.sort(Mo, new Comparator<Mobile>(){
							public int compare(Mobile M1,Mobile M2){
								
									return M1.model -M2.model;
								}	
							});
							li= Mo.listIterator();
							while(li.hasNext()){
								System.out.println(li.next());
							}
							oos=new ObjectOutputStream(new FileOutputStream(fname));
							oos.writeObject(Mo);
							oos.close();
						break;
						case 2:
							oos=new ObjectOutputStream(new FileOutputStream(fname));
							oos.writeObject(Mo);
							oos.close();
							
							ois = new ObjectInputStream(new FileInputStream(fname));
							Mo = (ArrayList<Mobile>)ois.readObject();
							ois.close();
						
							Collections.sort(Mo, new Comparator<Mobile>(){
							public int compare(Mobile M1,Mobile M2){
								
									return M1.price -M2.price;
								}	
							});
							li= Mo.listIterator();
							while(li.hasNext()){
								System.out.println(li.next());
							}
							oos=new ObjectOutputStream(new FileOutputStream(fname));
							oos.writeObject(Mo);
							oos.close();
						break;
							
						case 3:
							oos=new ObjectOutputStream(new FileOutputStream(fname));
							oos.writeObject(Mo);
							oos.close();
							
							ois = new ObjectInputStream(new FileInputStream(fname));
							Mo = (ArrayList<Mobile>)ois.readObject();
							ois.close();
						
							Collections.sort(Mo, new Comparator<Mobile>(){
							public int compare(Mobile M1,Mobile M2){
								
									return M1.coName.compareTo(M2.coName);
								}	
							});
							li= Mo.listIterator();
							while(li.hasNext()){
								System.out.println(li.next());
								
							
							}
							oos=new ObjectOutputStream(new FileOutputStream(fname));
							oos.writeObject(Mo);
							oos.close();
						
							}	
			
			}
			}
			while(Operation!=0);
		case 4:
			System.out.print("Enter File Name with Extention to Delete  : ");
			fname=s1.nextLine();
						
			try
		      {
				BufferedReader red = new BufferedReader(new FileReader(fname));
			         red.close();
			       
			         if(false)
			         	System.out.println(fname.equals(fname));
			         {
			        	 (new File(fname)).delete();
			        	 	System.out.println("file deleted succusfully");
			        	 
			         }
			      }
			      catch(IOException e)
			      {
			            System.out.println("Exception Occurred : " + e);
			            System.out.println("File does not exist...!!");
			      }
		        
		break;	
			
		}	
		}
		while(choice!=0);
		}
	
	}

