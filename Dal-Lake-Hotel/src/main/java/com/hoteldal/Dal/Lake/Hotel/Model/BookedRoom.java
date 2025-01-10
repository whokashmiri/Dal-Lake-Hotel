package com.hoteldal.Dal.Lake.Hotel.Model;

import java.time.LocalDate;

public class BookedRoom {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private  String guestFullName;
    private  String guestEmail;
    private  int numOfAdults;
    private  int numOfChildren;
    private  int totalNumOfGuest;
    private String bookingConfirmationCode;
    private Room room;

    public void calculateTotalNumberOfGuests(){
        this.totalNumOfGuest = this.numOfAdults +this.numOfChildren;
    }


    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuests();
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuests();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
