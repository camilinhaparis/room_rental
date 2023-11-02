package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy) ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out date (dd/MM/yyyy) ");
        Date checkOut = sdf.parse(sc.next());

        //data de checkout deve ser posterior a data de checkin
        if (!checkOut.after(checkIn)){  //testando checkout e antes de checkin se for da erro
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation");
            System.out.print("Check-in date (dd/MM/yyyy) ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date (dd/MM/yyyy) ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future");
            }
            else if (!checkOut.after(checkIn)) {  //testando checkout e antes de checkin se for da erro
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {
                reservation.uodateDates(checkIn,checkOut);
                System.out.println("Reservation: " + reservation);
            }

        }

        sc.close();

    }

}
