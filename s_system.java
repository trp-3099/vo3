import java.util.*;
class s_system{
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.println("----------------------------------------------");
	System.out.println("|        SALARY INFORMATION SYSTEM           |");
	System.out.println("----------------------------------------------");
	System.out.println("");
	System.out.println("");
	System.out.println("[1] Calculate Income Tax");
	System.out.println("[2] Calculate Annual Bonus");
	System.out.println("[3] Calculate Loan amount");
	System.out.print("");
	System.out.print("");
	System.out.print("Enter an Option to Continue > ");
	int option = input.nextInt();
	switch (option){
		case 1 :
			System.out.println("----------------------------------------------");
			System.out.println("|            Calculate Income Tax            |");
			System.out.println("----------------------------------------------");
			System.out.print("Input Employee Name   -");
			String name = input.next();
			System.out.print("Input Employee Salary -");
			int salary = input.nextInt();
			double i_tax = 0, bi_tax = 0;
			if (salary <= 100000) {
				bi_tax = 0;
			}else if (salary <= 141667) {
				i_tax = (salary - 100000) * 0.06;
				bi_tax = i_tax;
			} else if (salary <= 183333) {
				bi_tax = (41667 * 0.06);
				i_tax = (salary - 141667) * 0.12;
				bi_tax += i_tax;
			} else if (salary <= 225000) {
				bi_tax = (41667 * 0.06) + (41666 * 0.12);
				i_tax = (salary - 183333) * 0.18;
				bi_tax += i_tax;
			} else if (salary <= 266667) {
				bi_tax = (41667 * 0.06) + (41666 * 0.12) + (41667 * 0.18);
				i_tax = (salary - 225000) * 0.24;
				bi_tax += i_tax;
			} else if (salary <= 308333) {
				bi_tax = (41667 * 0.06) + (41666 * 0.12) + (41667 * 0.18) + (41667 * 0.24);
				i_tax = (salary - 266667) * 0.30;
				bi_tax += i_tax;
			}else {
				bi_tax = (41667 * 0.06) + (41666 * 0.12) + (41667 * 0.18) + (41667 * 0.24) + (41666 * 0.30);
				i_tax = (salary - 308333) * 0.36;
				bi_tax += i_tax;
			}
			System.out.println("You have to pay Income Tax per month: " + bi_tax);
			break;
		case 2 :
			System.out.println("----------------------------------------------");
			System.out.println("|          Calculate Annual Bonus            |");
			System.out.println("----------------------------------------------");
			System.out.print("Input Employee Name   -");
			String name1 = input.next();
			System.out.print("Input Employee Salary -");
			int salary1 = input.nextInt();
			double b_amount = 0, bb_amount = 0;
			if (salary1 <= 100000) {
				bb_amount = 5000;
			} else if (salary1 <= 200000) {
				bb_amount = 5000;
				b_amount = (salary1 - 100000) * 0.10;
				bb_amount += b_amount;
			} else if (salary1 <= 300000) {
				bb_amount = (100000 * 0.10) + 5000;
				b_amount = (salary1 - 200000) * 0.15;
				bb_amount += b_amount;
			}else if (salary1 <= 400000) {
				bb_amount = (100000 * 0.10) + (100000 * 0.15) + 5000;
				b_amount = (salary1 - 300000) * 0.20;
				bb_amount += b_amount;
			} else {
				bb_amount = (100000 * 0.10) + (100000 * 0.15) + (100000 * 0.20) + 5000;
				b_amount = (salary1 - 400000) * 0.35;
				bb_amount += b_amount;
			}
			System.out.println("Annual bonus - " + bb_amount);
			break;
		case 3:
			System.out.println("----------------------------------------------");
			System.out.println("|           Calculate Loan Amount            |");
			System.out.println("----------------------------------------------");
			System.out.print("Input Employee Name   -");
			String name2 = input.next();
			System.out.print("Input Employee salary -");
			int salary2 = input.nextInt();
			if (salary2 > 50000){
				System.out.print("Enter Number of Years -");
				int year = input.nextInt();
				if (year <= 5){
					double m_amount = salary2 * 0.60;
					double rate = 0.15 / 12;
					int months = year * 12;
					double loan = m_amount * (1 - (1 / Math.pow(1 + rate, months))) / rate;
					int loan_amount = (int) loan;
					System.out.println("You can get Loan Amount : " + loan_amount);
				}
			}else{
				System.out.println("You can not get a loan because your salary lessthan Rs. 50000....");
			}
		}		
	}
}
