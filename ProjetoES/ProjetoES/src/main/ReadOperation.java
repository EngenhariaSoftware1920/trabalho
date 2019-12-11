package main;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ReadOperation {
	private Scanner sc;
	public ReadOperation(Scanner sc) {
		this.sc = sc;
	}
	public String readString(String out){
		String s = null;
		boolean flag=true;
		while (flag) {
			try {
		       		System.out.println(out);
		        	s = sc.nextLine();
		        	if(s.length() > 0) {
		        		flag = false;
		        	}
		        	else System.out.println("String inválida!");
		        }
		        catch (InputMismatchException e) {
		            System.out.println("String inválida!");
			}
		}
		return s;
	}
	public int readInt(String out) {
		String iS = null;
		int i = -1;
		while (i == -1) {
			try {
		       		System.out.println(out);
		        	iS = sc.nextLine();
		        	i = Integer.valueOf(iS);
		        	if(i <= 0) {
		        		i = -1;
		        		System.out.println("Número inválido!");
		        	}
		        }
		        catch (NumberFormatException e) {
		            System.out.println("Número inválido!");
		        }
		}
		return i;
	}
	public LocalDate readDate(String out) {
		LocalDate d = null;
		String dS = null;
		while (d == null) {
			try {
		       		System.out.println(out);
		        	dS = sc.nextLine();
		        	d = LocalDate.parse(dS);
		        }
		        catch (Exception e) {
		            System.out.println("Data inválido!");
		        }
		}
		return d;
	}
	public LocalTime readTime(String out) {
		LocalTime t = null;
		String tS = null;
		while (t == null) {
			try {
		       		System.out.println(out);
		        	tS = sc.nextLine();
		        	t = LocalTime.parse(tS, DateTimeFormatter.ofPattern("H:mm"));
		        }
		        catch (Exception e) {
		            System.out.println("Hora inválida!");
			}
		}
		return t;
	}
}
