package com.timbuchalka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.timbuchalka.Theatre.Seat;

public class Main {

    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Olympian", 8, 12);
//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//        
//        
//        
//        printList(seatCopy);
//
//        seatCopy.get(1).reserve();
//        if(theatre.reserveSeat("A02")) {
//            System.out.println("Please pay for A02");
//        } else {
//            System.out.println("Seat already reserved");
//        }
//
//        Collections.shuffle(seatCopy);
//        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seat");
//        printList(theatre.seats);
//
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println("Min seat number is " + minSeat.getSeatNumber());
//        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
//
//        sortList(seatCopy);
//        System.out.println("Printing sorted seatCopy");
//        printList(seatCopy);


//        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
//        Collections.copy(newList, theatre.seats);
        
        List<Theatre.Seat> priceSeats = new ArrayList<Seat>(theatre.seats);
        
        final Comparator<Seat> PRICE_COMPARATOR = new Comparator<Seat>() {

			@Override
			public int compare(Seat o1, Seat o2) {
				if(o1.getPrice()>o2.getPrice()) {
					return 1;
				}else if(o1.getPrice()<o2.getPrice()) {
					return -1;
				}else {
					return 0;
				}
			}
        	
		};
		Collections.sort(priceSeats, PRICE_COMPARATOR);
		for(int i=0; i<priceSeats.size(); i++) {
			System.out.println(priceSeats.get(i).getSeatNumber()+" "+priceSeats.get(i).getPrice());
		}
		
		
    }


    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("======================================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for(int i=0; i<list.size() -1; i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i).compareTo(list.get(j)) >0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }













}
