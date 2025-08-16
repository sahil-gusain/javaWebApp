package com.grocery;
import java.util.*;
import java.util.regex.*;

//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class first_project { 
	static ArrayList<Customer> user=new ArrayList<Customer>();
	static ArrayList<Product> item=new ArrayList<Product>();
	static Scanner sc=new Scanner(System.in);
	
	static int adminId=12341234;
	static String adminPassword="Admin@12345";

	public static void main(String[] args) {
		
		user.add(new Customer(12343,"abhishek","abhiskek@tcs.com","abhishek@12345","sector 135,G.Noida","7891234560"));
		user.add(new Customer(12345,"sachin","sachin@tcs.com","sachin@12345","sector 135,G.Noida","7891234561"));
		user.add(new Customer(12341,"rohit","rohit@tcs.com","rohit@12345","sector 135,G.Noida","7891234562"));
		user.add(new Customer(12342,"rishi","rishi@tcs.com","rishi@12345","sector 135,G.Noida","7891234563"));
		user.add(new Customer(12347,"rahul","rahul.gmail.com","rahul@12345","sector 135,G.Noida","7891234564"));
		
		item.add(new Product("1-2345-6789-0","mobile","android",20,20000));
		item.add(new Product("1-2345-6789-1","tablet","IOS",15,60000));
		item.add(new Product("1-2345-6789-2","leptop","windows",20,75000));
		item.add(new Product("1-2345-6789-3","earphones","wireless",50,600));
		
		boolean flag=true;
		
		while(flag){
			System.out.println("1 for Customer pannel");
			System.out.println("2 for Admin pannel");
			System.out.println("3 for Exit");
			
			int choice=sc.nextInt();sc.nextLine();
			
			switch(choice){
			case 1: customerPannel();
			break;
			case 2: adminPannel();
			break;
			case 3: flag=false;;
			break;
			default:
				System.out.println("Please Select a valid option!");
			break;
			}
		}
		
		
	}
	
	static void customerPannel(){
		boolean flag=true;
		
		while(flag){
			System.out.println("1 for ragistration");
			System.out.println("2 for login");
			System.out.println("3 for back to previous section");
			
			int choice=sc.nextInt();sc.nextLine();	
			switch(choice){
			case 1: addUser();
			break;
			case 2: loginCustomer();
			break;
			case 3:	flag=false;
			break;
			default:
				System.out.println("Please Select a valid option!");
			break;
			}

		}
	}
	
	static void loginCustomer(){
		int idx=-1;
		System.out.println("Enter Customer Id:");
		int id=sc.nextInt();sc.nextLine();
		System.out.println("Enter Password:");
		String pass=sc.nextLine();
		boolean approval=false;
		
		for(Customer obj:user){
			idx++;
			if(obj!=null&&obj.getCustomerId()==id&&obj.getPassword().equals(pass))
			{
				approval=true;
				break;
			}	
		}
		if(approval&&user.get(idx).getActive()){
			boolean flag=true;
			
			while(flag){
				System.out.println("1 for Upadte details");
				System.out.println("2 Shoping");
				System.out.println("3 for Deactivate account");
				System.out.println("4 for back to previous section");
				
				int choice=sc.nextInt();sc.nextLine();	
				switch(choice){
				case 1: update(idx);
				break;
				case 2: buyProduct();
				break;
				case 3:{ user.get(idx).setActive(false);
					System.out.println("Your account is Deactivated");
					flag=false;
				}
				break;
				case 4:	flag=false;
				break;
				default:
					System.out.println("Please Select a valid option!");
				break;
				}
			}
		}
		else if(approval&&!user.get(idx).getActive()){
			boolean flag=true;
			while(flag){
				System.out.println("1 Activate Account");
				System.out.println("2 for back to previous section");
				
				int choice=sc.nextInt();sc.nextLine();	
				switch(choice){
				case 1: {user.get(idx).setActive(true);
					System.out.println("Your account is Activated");
					flag=false;
				}
				break;
				case 2:
					flag=false;
				break;
				default:
					System.out.println("Please Select a valid option!");
				break;
				}
			}
		}
		else{
			System.out.println("Wrong Credential");
		}
		
	}
	
	static void adminPannel(){
		if(adminAuthenticate()){
			boolean flag=true;
			while(flag){
				System.out.println("1 Search Customer by Email");
				System.out.println("2 Add or Update the Product");
				System.out.println("3 for highest price product");
				System.out.println("4 for sort the product");
				System.out.println("5 for search all Customer for the specific Domain");
				System.out.println("6 View All the Customers");
				System.out.println("7 View All the Products");
				System.out.println("8 for back to previous section");
				int choice=sc.nextInt();sc.nextLine();
				
				switch(choice){
				case 1:	searchByEmail();
				break;
				case 2:	addOrUpdateProduct();
				break;
				case 3: findMaxPriceProduct();
				break;
				case 4: sortedProduct();
				break;
				case 5:	searchByEmailDomain();
				break;
				case 6:	viewCustomer();
				break;
				case 7: viewProduct();
				break;
				case 8:	flag=false;
				break;
				default:
					System.out.println("Please Select a valid option!");
				break;
				}
			}
		}
		else{
			System.out.println("wrong credential!");
		}
		
	}
	
	static void  addUser(){
		String name;
		String email;
		String password;
		String address;
		String contact;
		boolean temp=false;
		
		do{
			if(temp)
				System.out.println("Please enter a valid name!");
			else
				System.out.println("Enter Customer name(Maximum 50 characters):");
			name=sc.nextLine();
			
			if(name.length()>0&&name.length()<=50)
				temp=false;
			else
				temp=true;
		}while(temp);
		
		temp=false;
		
		do{
			if(temp)
				System.out.println("Please enter a valid email!");
			else
				System.out.println("Enter Customer email:");
			email=sc.nextLine();
			
			if(validateEmail(email))
				temp=false;
			else
				temp=true;
		}while(temp);
		
		temp=false;
		
		
		do{
			if(temp)
				System.out.println("Please enter a valid password!");
			else
				System.out.println("Enter Customer password(Minimum 6 and Maximum 12 characters):");
			password=sc.nextLine();
			
			if(password.length()>=6&password.length()<=12)
				temp=false;
			else
				temp=true;
		}while(temp);
		
		temp=false;
		
		do{
			if(temp)
				System.out.println("Please enter a valid address:!");
			else
				System.out.println("Enter Customer address(Maximum 100 characters):");
			
			System.out.println("please enter your local area:");
			String area=sc.nextLine();
			System.out.println("please enter your city:");
			String city=sc.nextLine();
			
			address=area+","+city;
			
			
			if(address.length()>0&&address.length()<=100)
				temp=false;
			else
				temp=true;
			
		}while(temp);
		
		temp=false;
		
		do{
			if(temp)
				System.out.println("Please enter name a valid contact number!");
			else
				System.out.println("Enter Customer contact number:");
			contact=sc.nextLine();
			
			if(numberValidate(contact))
				temp=false;
			else
				temp=true;

		}while(temp);
	
		int id=genrateId();
		
		user.add(new Customer(id,name,email,password,address,contact));
		System.out.println("Customer Registration is successful for "+id);
	}
	
	
static void update(int idx){
		
		boolean flag=true;
		do{
//			if(!approval){System.out.println("wrong credential"); break;}
			System.out.println("for update infomation press-");
			System.out.println("1 for name");
			System.out.println("2 for email");
			System.out.println("3 for password");
			System.out.println("4 for address");
			System.out.println("5 for contact number");
			int option=sc.nextInt();sc.nextLine();
			switch(option){
			case 1:{
				boolean temp=false;
				String name;
				
				do{
					if(temp)
						System.out.println("Please enter a valid name!");
					else
						System.out.println("Enter Customer name(Maximum 50 characters):");
					name=sc.nextLine();
					
					if(name.length()>0&&name.length()<=50)
						temp=false;
					else
						temp=true;
				}while(temp);
				user.get(idx).setName(name);
			}
			break;
			case 2:{
				boolean temp=false;
				String email;
				do{
					if(temp)
						System.out.println("Please enter a valid email!");
					else
						System.out.println("Enter Customer email:");
					email=sc.nextLine();
					
					if(validateEmail(email))
						temp=false;
					else
						temp=true;
				}while(temp);
				user.get(idx).setEmail(email);
			}
			break;
			case 3:{
				boolean temp=false;
				String password;
				do{
					if(temp)
						System.out.println("Please enter a valid password!");
					else
						System.out.println("Enter Customer password(Minimum 6 and Maximum 12 characters):");
					password=sc.nextLine();
					
					if(password.length()>=6&password.length()<=12)
						temp=false;
					else
						temp=true;
				}while(temp);
				user.get(idx).setPassword(password);
			}
			break;
			case 4:{
				boolean temp=false;
				String address;
				do{
					if(temp)
						System.out.println("Please enter a valid address!");
					else
						System.out.println("Enter Customer address(Maximum 100 characters):");
					
					System.out.println("please enter your local area:");
					String area=sc.nextLine();
					System.out.println("please enter your city");
					String city=sc.nextLine();
					
					address=area+","+city;
					
					
					if(address.length()>0&&address.length()<=100)
						temp=false;
					else
						temp=true;
					
				}while(temp);
				user.get(idx).setAddress(address);
			}
			break;
			
			case 5:{
				boolean temp=false;
				String contact;
				do{
					if(temp)
						System.out.println("Please enter name a valid contact number!");
					else
						System.out.println("Enter Customer contact number:");
					contact=sc.nextLine();
					
					if(contact.length()==10)
						temp=false;
					else
						temp=true;

				}while(temp);
				user.get(idx).setContact(contact);
			}
			break;
			default:
				System.out.println("please select a valid option!");
			}
			
			System.out.println("Your Details updated successfully");
			System.out.println("do you want to continue press 1 otherwise any number");
			int terminate=sc.nextInt();sc.nextLine();
			flag=terminate==1?true:false;
		}while(flag);
		
	}
	
	static void  addOrUpdateProduct(){
			boolean flag=true;
			while(flag){
			System.out.println("1 for add");
			System.out.println("2 for upadate");
			System.out.println("3 for back to previous section");
			int option=sc.nextInt();sc.nextLine();
			switch(option){
			case 1:
				addProduct();
			break;
			case 2:
				updateProduct();
			break;
			case 3:
				flag=false;
			break;
			default:
				System.out.println("enter a valid number!");
			break;
			}
			}
	}
	
	static void addProduct(){
		String name;
		String description;
		int quantity;
		float price;
		boolean temp=false;
		
		do{
			if(temp)
				System.out.println("Please enter a valid name!");
			else
				System.out.println("Enter Product name(Maximum 50 characters):");
			name=sc.nextLine();
			
			if(name.length()>0&&name.length()<=50)
				temp=false;
			else
				temp=true;
		}while(temp);
		
		temp=false;
		
		do{
			if(temp)
				System.out.println("Please enter a valid description!");
			else
				System.out.println("Enter Product description(Maximum 100 characters):");
			
			description=sc.nextLine();
			
			
			if(description.length()>0&&description.length()<=100)
				temp=false;
			else
				temp=true;
			
		}while(temp);
		
		temp=false;
		
		System.out.println("Enter Product quantity:");
		quantity=sc.nextInt();sc.nextLine();
		System.out.println("Enter Product price:");
		price=sc.nextFloat();sc.nextLine();
		
		String id=genratePid();
		
		item.add(new Product(id,name,description,quantity,price));
		
		System.out.println("Product added successfully!");
	}
	
	static void updateProduct(){
		System.out.println("Enter product Id:");
		String id=sc.nextLine();
		int idx=-1;
		boolean flag=false;
		for(Product obj:item){
			idx++;
			if(obj.getProdId().equals(id))
			{
				flag=true;
				break;
			}
		}
		if(flag){
			do{
				System.out.println("1 for update Product name");
				System.out.println("2 for update Product description");
				System.out.println("3 for update Product quantity");
				System.out.println("4 for update Product price");
				System.out.println("5 for back to previous section");
				int option = sc.nextInt();sc.nextLine();
				boolean temp=false;
				String name;
				String description;
				int quantity;
				float price;
				switch(option){
				case 1:{
					do{
						if(temp)
							System.out.println("Please enter a valid name!");
						else
							System.out.println("Enter Product name(Maximum 100 characters):");
						name=sc.nextLine();
						
						if(name.length()>0&&name.length()<=50)
							temp=false;
						else
							temp=true;
					}while(temp);
				item.get(idx).setName(name);
				}
				break;
				case 2:{
					do{
						if(temp)
							System.out.println("Please enter a valid description!");
						else
							System.out.println("Enter Product description(Maximum 100 characters):");
						
						description=sc.nextLine();
						
						
						if(description.length()>0&&description.length()<=100)
							temp=false;
						else
							temp=true;
						
					}while(temp);
					item.get(idx).setDescription(description);	
				}
				break;
				case 3:{
					System.out.println("Enter Product quantity:");
					quantity=sc.nextInt();sc.nextLine();
					item.get(idx).setQuantity(quantity);
				}
				break;
				case 4:{
					System.out.println("Enter Product price:");
					price=sc.nextFloat();sc.nextLine();
					item.get(idx).setPrice(price);
				}
				break;
				case 5:
				 	flag=false;
				break;
				default:
					System.out.println("please enter a valid option!");
				}
			}while(flag);
			System.out.println("Product Details update successfully");
		}
		else{
			System.out.println("Enter a valid id");
		}
	}
	
	static void searchByEmail(){
		System.out.println("Enter Email for search:");
		String mail=sc.nextLine();
		boolean flag=true;
		for(Customer obj:user){
			if(mail.equalsIgnoreCase(obj.getEmail())){
				printCustomer(obj);
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.println("No Such Customer Exist with the Given Email");
	}
	
	static void findMaxPriceProduct(){
		Product res=null;
			for(Product obj:item){
				if(res==null||obj.getPrice()>res.getPrice())
					res=obj;
			}
			if(res!=null)
				System.out.println(res.toString());
			if(item.size()==0)
					System.out.println("Product List is Empty");
	}
	
	static void sortedProduct(){
			if(item.size()==0)
				System.out.println("Product List is Empty");
			else
			{
				ArrayList<Product> forSortOnly=new ArrayList<>();
				for(Product obj:item){
					forSortOnly.add(obj);
				}
				Collections.sort(forSortOnly);
				for(Product obj:forSortOnly)
					System.out.println(obj.toString());
			}
		
	}

	static void viewCustomer(){
			for(Customer obj:user){
				System.out.println(obj.toString());
			}
	}
	
	static void viewProduct(){
			for(Product obj:item){
				System.out.println(obj.toString());
			}
	}

//	Sprint
	
	static void searchByEmailDomain(){
		
		System.out.println("Enter Email Domain");
		String domain=sc.nextLine();
		ArrayList<Customer> userListByDomain=new ArrayList<>();
		
		for(Customer obj:user){
			if(obj.getEmail().contains(domain))
				userListByDomain.add(obj);
		}
		
		 Collections.sort(userListByDomain, (a, b) -> a.getCustomerId()-b.getCustomerId());
		 
		 if(userListByDomain.size()!=0){
			 for(Customer obj:userListByDomain){
				 System.out.println(obj.getCustomerId()+"	"+obj.getName()+"	"+obj.getEmail());
			 }
		 }
		 else{
			 System.out.println("No such customer is registered with <EmailDomain>");
		 }
		
	}
	
	static void buyProduct(){
		
		int[] cart=new int[item.size()];
		boolean flag=true;
		
		do{
			System.out.println("Products are-");
			for(int i=0;i<item.size();i++){
				System.out.print(i+1+" "+item.get(i).getName()+" "+item.get(i).getPrice()+"\t");
			}
			System.out.println("\nEnter what you want to buy");
			int selection=sc.nextInt()-1;sc.nextLine();
			if(selection>=0&&selection<item.size()){
				System.out.println("Available quantity is:"+item.get(selection).getQuantity());
				System.out.println("Enter the quantity");
				int buyItem=sc.nextInt();sc.nextLine();
				if(item.get(selection).getQuantity()>=cart[selection]+buyItem){
					cart[selection]+=cart[selection]+buyItem;
				}
				else{
					System.out.println("We don't have that much quantity for this Product");
				}				
			}
			else{
				System.out.println("Please select valid Product!");
			}
			System.out.println("Do you want to buy more product press 1 otherwise any number");
			int terminate=sc.nextInt();sc.nextLine();
			flag=terminate==1?true:false;
		}while(flag);
		
		double shopingPrice=0.0;
		for(int i=0;i<cart.length;i++){
			if(cart[i]>0){
				shopingPrice+=cart[i]*item.get(i).getPrice();
			}
		}
		if(shopingPrice>0){
			System.out.println("Your shoping price:"+shopingPrice);
			System.out.println("Enter 1 for confirm order");
			System.out.println("Enter 2 for Cancel");
			
			int confirm=sc.nextInt();sc.nextLine();
			
			if(confirm==1){
				confimingOrder(cart);
				System.out.println("thank you for order");
			}
			else if(confirm==2)
				System.out.println("Your order is cancel");
			else
				System.out.println("Wrong selection\thank you for visiting");
		}
		else{
			System.out.println("You not select any item\nThank you for visiting");
		}
		
	}
	
	static void confimingOrder(int[] cart){
		for(int i=0;i<cart.length;i++){
			if(cart[i]>0){
				Product obj=item.get(i);
				obj.setQuantity(obj.getQuantity()-cart[i]);
			}
		}
	}
	
	
//	till here
	
//	Extra methods
	
	static boolean adminAuthenticate(){
		System.out.println("Please Enter Admin Id");
		int id=sc.nextInt();sc.nextLine();
		System.out.println("Please Enter password");
		String pass=sc.nextLine();
		
		return adminId==id&&adminPassword.equals(pass);
	}
	
	static int genrateId(){
		int id;

		while(true){
			boolean flag=false;
			id=(int)(Math.random()*100000);
			
			
			for(Customer obj : user){
				if(obj!=null&&obj.getCustomerId()==id)
				{
					flag=true;
					break;
				}	
			}
			if(!flag) break;
		}
		    
		return id;
	}
	
	static String genratePid(){
		String id;
		while(true){
			
			boolean flag=true;
			id=String.format("1-%04d-%04d-%1d",
					new Random().nextInt(10000),
					new Random().nextInt(10000),
					new Random().nextInt(10));
			for(Product obj:item){
				if(obj.getProdId().equals(id)){
					flag=false;
					break;
				}
			}
			if(flag)
				break;
		}
		return id;
	}
	
	static boolean validateEmail(String email){
		String emailRegex = "^(.+)@(.+)$";
		Pattern pattern=Pattern.compile(emailRegex);
		Matcher matcher=pattern.matcher(email);
		for(Customer obj:user){
			if(obj!=null&&obj.getEmail().contains(email))
				return false;
		}
		
		return matcher.matches();
	}
	
	static boolean numberValidate(String contact){
		String mobileRegex="[0-9*#+() -]*";
		Pattern pattern = Pattern.compile(mobileRegex);
		Matcher matcher = pattern.matcher(contact);
		return contact!=null&&matcher.matches();
	}
	
	static void printCustomer(Customer obj){
		System.out.println("Customer ID:"+obj.getCustomerId());
		System.out.println("Customer name:"+obj.getName());
		System.out.println("Customer Email:"+obj.getEmail());
		System.out.println("Customer Address:"+obj.getAddress());
		System.out.println("Customer Contact:"+obj.getContact());
	}
	

}