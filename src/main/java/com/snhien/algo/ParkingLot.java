package com.snhien.algo;

/*
Design and implement a parking lot
-1 entry
-1 exit
-ticket has parking slot # to use
-1 floor (maybe multiple later)
*/

import java.util.*;

public class ParkingLot{
	public static class ParkingSlot{
	    Integer slotId;
	    String licenseNumber;
	    
	    public ParkingSlot(int id){
	        slotId = id;
	    }
	    
	    public void setLicenseNumber(String ln){
	        licenseNumber = ln;
	    }
	    
	    @Override
	    public int hashCode(){
	        return slotId;
	    }
	    
	    @Override
	    public boolean equals(Object other){
	    	if (other instanceof ParkingSlot){
	    		return (this.slotId == ((ParkingSlot)other).slotId &&
	    				this.licenseNumber.equals(((ParkingSlot) other).licenseNumber));
	    	}
	    	return false;
	    }
	}

    Set<ParkingSlot> availableSlots;
    Set<ParkingSlot> usedSlots;
    
    public ParkingLot(int nSlots){
        availableSlots = new HashSet<ParkingSlot>();
        usedSlots = new HashSet<ParkingSlot>();
        for (int i=0; i<nSlots; i++){
        	ParkingSlot slot = new ParkingSlot(i+1);
            availableSlots.add(slot);
        }
    }
    
    //On entry
    public ParkingSlot getAvailableSlot(String ln){
        if(availableSlots==null || availableSlots.size()==0){
            return null;
        }
        ParkingSlot res = availableSlots.iterator().next();
        availableSlots.remove(res);
        res.setLicenseNumber(ln);
        usedSlots.add(res);
        return (res);
    }
    
    
    //On exit
    public void returnSlot(ParkingSlot slot){
        usedSlots.remove(slot);
        slot.setLicenseNumber(null);
        availableSlots.add(slot);
    }
    
    
    public static void main(String args[]){
    	ParkingSlot s1 = new ParkingSlot(1);
    	s1.setLicenseNumber("ABC");
    	ParkingSlot s2 = new ParkingSlot(1);
    	s2.setLicenseNumber("XYZ");
    	Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
    	slots.add(s1);
    	System.out.println("Containts s2=" + slots.contains(s2));
    	slots.add(s2);
    	Iterator<ParkingSlot> it = slots.iterator();
    	while(it.hasNext()){
    		ParkingSlot slot = it.next();
    		System.out.println("parkingSlot " + slot.licenseNumber );
    	}
    }
   
}