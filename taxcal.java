import java.util.*;
class taxcal {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
			System.out.println("                                           __  ______  ________ _________  ");
			System.out.println("                                          |  \\/      \\|        |        \\ ");
			System.out.println("                                           \\$|  $$$$$$| $$$$$$$\\$$$$$$$$$$ ");
			System.out.println("                                          |  | $$   \\$| $$___     | $$     ");
			System.out.println("                                          | $| $$     | $$   \\    | $$     ");
			System.out.println("                                          | $| $$   __| $$$$$$    | $$     ");
			System.out.println("                                          | $| $$__/  | $$______  | $$     ");
			System.out.println("                                          | $$\\$$    $| $$      \\ | $$     ");
			System.out.println("                                           \\$$ \\$$$$$$ \\$$$$$$$$$  \\$$     ");
			System.out.println("");
			System.out.println("");
			System.out.println(" _______             __    __  ______                _         ______    _    _     _                   _______     ____    _____     ");
			System.out.println("|__   __|     /\\     \\ \\  / / /  ____|      /\\      | |       /  ____|  | |  | |   | |          /\\     |__   __|   / __ \\  |  __ \\    ");
			System.out.println("   | |       /  \\     \\ \\/ /  | |          /  \\     | |       | |       | |  | |   | |         /  \\       | |     | |  | | | |__) |   ");
			System.out.println("   | |      / /\\ \\     >  <   | |         / /\\ \\    | |       | |       | |  | |   | |        / /\\ \\      | |     | |  | | |  _  /    ");
			System.out.println("   | |     / ____ \\   / /\\ \\  | |____    / ____ \\   | |____   | |____   | |__| |   | |____   / ____ \\     | |     | |__| | | | \\ \\    ");
			System.out.println("   |_|    /_/    \\_\\ /_/  \\_\\  \\_____|  /_/    \\_\\  |______|  \\______|   \\____/    |______| /_/    \\_\\    |_|      \\____/  |_|  \\_\\   ");
			System.out.println("");
			System.out.println("");
			System.out.println("=================================================================================================================================");
			System.out.println("");
            System.out.println("1. Withholding Tax");
            System.out.println("2. Payable Tax");
            System.out.println("3. Income Tax");
            System.out.println("4. SSCL Tax");
            System.out.println("5. Leasing Payment");
            System.out.println("6. Exit");

            System.out.print("Enter an option to continue -> ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: System.out.println("+------------------------------------------+");
						System.out.println("|             Withholding Tax              |");
						System.out.println("+------------------------------------------+");
						System.out.println("1. Rent Tax");
						System.out.println("2. Bank Interest Tax");
						System.out.println("3. Dividend Tax");
						System.out.println("4. Exit");
						System.out.print("Enter an option to continue -> ");
						int choice1 = sc.nextInt();
						switch (choice1) {
							case 1: rentTax(); break;
							case 2: bankInterestTax(); break;
							case 3: dividendTax(); break;
							case 4: System.exit(0);
						}
						break;
                case 2: payableTax(); break;
                case 3: incomeTax(); break;
                case 4: ssclTax(); break;
                case 5: System.out.println("+------------------------------------------+");
						System.out.println("|              LeasingPayment              |");
						System.out.println("+------------------------------------------+");
						System.out.println("1. Calculate Monthly Installment");
						System.out.println("2. Search leasing Category");
						System.out.println("3. Find Leasing Amount");
						System.out.println("4. Exit");
						System.out.print("Enter an option to continue -> ");
						int choice2 = sc.nextInt();
						switch (choice2) {
							case 1: monthInstallment(); break;
							case 2: searchCategory(); break;
							case 3: leasingAmount(); break;
							case 4: System.exit(0);
						}
						break;
                case 6: System.exit(0);
            }
        }
    public static void rentTax() {
		System.out.println("+------------------------------------------+");
		System.out.println("|                 rentTax                  |");
		System.out.println("+------------------------------------------+");
        System.out.print("Enter your rent: ");
        double amount = sc.nextDouble();

        if (amount <= 100000) {
            System.out.println("you  dont have to pay tax...");
        } else if(amount < 0) {
			System.out.println("Invalid input...");
		} else {
            double tax = amount * 0.10;
            System.out.println("You have to pay rent tax : " + tax);
		}
		System.out.print("Enter if you want go to home page (1/0) ");
        int ans = sc.nextInt();
        if (ans == 1) {
			main();
		} 
	}

    public static void bankInterestTax() {
		System.out.println("+------------------------------------------+");
		System.out.println("|              bankInterestTax             |");
		System.out.println("+------------------------------------------+");
        System.out.print("Enter your bank interest per year: ");
        double amount = sc.nextDouble();

        double tax = amount * 0.05;
        System.out.println("You have to pay Bank Interest Tax per year : " + tax);
    }

    public static void dividendTax() {
		System.out.println("+------------------------------------------+");
		System.out.println("|               dividendTax                |");
		System.out.println("+------------------------------------------+");
        System.out.print("Enter your Dividend per year: ");
        double amount = sc.nextDouble();

        if (amount <= 100000) {
            System.out.println("You dont have to pay Dividend Tax...");
        } else {
            double tax = amount * 0.14;
            System.out.println("You have to pay Dividend Tax per year : " + tax);
        }
    }

    public static void payableTax() {
		System.out.println("+------------------------------------------+");
		System.out.println("|               payableTax                 |");
		System.out.println("+------------------------------------------+");
        System.out.print("Enter your employee payment per month: ");
        double salary = sc.nextDouble();

        double tax = 0;

        if (salary > 100000) {
			System.out.print("You dont have to pay Payable Tax...: ");
            double remaining = salary - 100000;

            if (remaining > 41667) {
                tax += 2500;
                remaining -= 41667;
            } else {
                tax += remaining * 0.06;
                remaining = 0;
            }

            if (remaining > 0) {
                if (remaining > 41667) {
                    tax += 7500;
                    remaining -= 41667;
                } else {
                    tax += remaining * 0.12;
                    remaining = 0;
                }
            }

            if (remaining > 0) {
                if (remaining > 41667) {
                    tax += 10500;
                    remaining -= 41667;
                } else {
                    tax += remaining * 0.18;
                    remaining = 0;
                }
            }
            if (remaining > 0) {
                if (remaining > 41667) {
                    tax += 25000;
                    remaining -= 41667;
                } else {
                    tax += remaining * 0.24;
                    remaining = 0;
                }
			}
			if (remaining > 0) {
                if (remaining > 41667) {
                    tax += 37500;
                    remaining -= 41667;
                } else {
                    tax += remaining * 0.30;
                    remaining = 0;
                }
			}
			if (remaining > 0) {
                if (remaining > 41667) {
                    tax += 52500;
                    remaining -= 41667;
                } else {
                    tax += remaining * 0.36;
                    remaining = 0;
                }
			}
			if (remaining > 0) {
                tax += remaining * 0.36;
                remaining = 0;
                }
            tax = tax / 12;    
        }

        System.out.println("You have to pay Payable Tax per month :" + tax);
    }

	public static void incomeTax() {
		System.out.println("+------------------------------------------+");
		System.out.println("|               incomeTax                  |");
		System.out.println("+------------------------------------------+");
		System.out.print("Enter your total income per year: ");
		double income = sc.nextDouble();

		if (income <= 1200000) {
			System.out.println("You dont have to pay Income Tax...");
			return;
		}

		double tax = 0;
		double remaining = income - 1200000;

		if (remaining > 500000) {
			tax += 500000 * 0.06;
			remaining -= 500000;
        } else {
			tax += remaining * 0.06;
			remaining = 0;
		}

		if (remaining > 0) {
			if (remaining > 500000) {
				tax += 500000 * 0.12;
				remaining -= 500000;
			} else {
				tax += remaining * 0.12;
				remaining = 0;
			}
		}

		if (remaining > 0) {
			if (remaining > 500000) {
				tax += 500000 * 0.18;
				remaining -= 500000;
			} else {
				tax += remaining * 0.18;
				remaining = 0;
			}
		}

		if (remaining > 0) {
			if (remaining > 500000) {
				tax += 500000 * 0.24;
				remaining -= 500000;
			} else {
				tax += remaining * 0.24;
				remaining = 0;
			}
		}

		if (remaining > 0) {
			if (remaining > 500000) {
				tax += 500000 * 0.30;
				remaining -= 500000;
			} else {
				tax += remaining * 0.30;
				remaining = 0;
			}
		}

		if (remaining > 0) {
			tax += remaining * 0.36;
		}

		System.out.println("You have to pay Income Tax per year: " + tax);
	}


    public static void ssclTax() {
		System.out.println("+------------------------------------------+");
		System.out.println("|                ssclTax                   |");
		System.out.println("+------------------------------------------+");
        System.out.print("Enter Value of Goods or Service : ");
        double value = sc.nextDouble();

        double saleTax = value * 0.025;
        double afterSale = value + saleTax;

        double vat = afterSale * 0.15;

        double total = saleTax + vat;

        System.out.println(" You have to pay SSCL Tax : " + total);
    }
    
    public static void monthInstallment() {
		System.out.println("+------------------------------------------+");
		System.out.println("|            monthInstallment              |");
		System.out.println("+------------------------------------------+");
        System.out.print("Enter lease amount: ");
        double A = sc.nextDouble();

        System.out.print("Enter annual interest rate : ");
        double annualRate = sc.nextDouble();

        System.out.print("Enter number of year : ");
        int years = sc.nextInt();

        if (years > 5) {
            System.out.println("Invalid number of year... Enter the correct value again...");
            return;
        }

        int n = years * 12;
        double i = (annualRate / 100) / 12;

        double installment = (A * i) / (1 - (1 / Math.pow(1 + i, n)));

        System.out.println("You monthly installment : " + installment);
    }

    public static void searchCategory() {
		System.out.println("+------------------------------------------+");
		System.out.println("|             searchCategory               |");
		System.out.println("+------------------------------------------+");
        System.out.print("Enter lease amount: ");
        double A = sc.nextDouble();

        System.out.print("Enter annual interest rate : ");
        double annualRate = sc.nextDouble();

        double i = (annualRate / 100) / 12;

        System.out.println("\nLeasing Plans:");

        for (int years = 3; years <= 5; years++) {
            int n = years * 12;
            double installment = (A * i) / (1 - (1 / Math.pow(1 + i, n)));
            System.out.println("Your monthly installment for " + years + " year leasing plan -" + installment);
        }
    }

    public static void leasingAmount() {
		System.out.println("+------------------------------------------+");
		System.out.println("|             leasingAmount                |");
		System.out.println("+------------------------------------------+");
        System.out.print("Enter the monthly lease payment amount you can afford: ");
        double installment = sc.nextDouble();

        System.out.print("Enter annual interest rate : ");
        double annualRate = sc.nextDouble();

        System.out.print("Enter number of year : ");
        int years = sc.nextInt();

        if (years > 5) {
            System.out.println("Invalid number of year... Enter the correct value again...");
            return;
        }

        int n = years * 12;
        double i = (annualRate / 100) / 12;
        double A = installment * (1 - (1 / Math.pow(1 + i, n))) / i;
        System.out.println("You can get Lease Amount = " + A);
    }
}
