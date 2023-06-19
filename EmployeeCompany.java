package Address;
import java.util.Random;
     class Company {
        private final String name;
        private final int wagePerHour;
        private final int fullDayHours;
        private final int workingDaysInMonth;
        private final int maxWorkingHours;

        public Company(String name, int wagePerHour, int fullDayHours, int workingDaysInMonth, int maxWorkingHours) {
            this.name = name;
            this.wagePerHour = wagePerHour;
            this.fullDayHours = fullDayHours;
            this.workingDaysInMonth = workingDaysInMonth;
            this.maxWorkingHours = maxWorkingHours;
        }

        public String getName() {
            return name;
        }

        public int getWagePerHour() {
            return wagePerHour;
        }

        public int getFullDayHours() {
            return fullDayHours;
        }

        public int getWorkingDaysInMonth() {
            return workingDaysInMonth;
        }

        public int getMaxWorkingHours() {
            return maxWorkingHours;
        }
    }

    public class EmployeeCompany {
        public static void main(String[] args) {
            Company company1 = new Company("Company 1", 20, 8, 20, 100);
            Company company2 = new Company("Company 2", 25, 8, 25, 120);

            int totalWageCompany1 = computeEmployeeWage(company1);
            System.out.println(company1.getName() + " Total wage for the month: " + totalWageCompany1);

            int totalWageCompany2 = computeEmployeeWage(company2);
            System.out.println(company2.getName() + " Total wage for the month: " + totalWageCompany2);
        }

        public static int computeEmployeeWage(Company company) {
            int totalWorkingHours = 0;
            int totalWorkingDays = 0;
            int totalWage = 0;

            while (totalWorkingDays < company.getWorkingDaysInMonth() && totalWorkingHours < company.getMaxWorkingHours()) {
                int empType = getRandomNumber(0, 2);
                int empHours = getEmployeeHours(empType, company);

                int dailyWage = calculateDailyWage(empHours, company);
                totalWage += dailyWage;
                totalWorkingHours += empHours;
                totalWorkingDays++;
            }

            return totalWage;
        }

        public static int getEmployeeHours(int empType, Company company) {
            switch (empType) {
                case 0:
                    return 0; // Employee is absent
                case 1:
                    return company.getFullDayHours(); // Employee is present for full time
                case 2:
                    return company.getFullDayHours() / 2; // Employee is present for part time
                default:
                    return 0;
            }
        }

        public static int calculateDailyWage(int empHours, Company company) {
            return empHours * company.getWagePerHour();
        }

        public static int getRandomNumber(int min, int max) {
            Random random = new Random();
            return random.nextInt((max - min) + 1) + min;
        }
    }


