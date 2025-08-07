package com.shabir.problemsolving.random;

import java.util.*;

public class ShiftSolution {

    public static void main(String[] args) {

        Set<ShiftDetail> shiftDetailSet = new TreeSet<>();
    }

    private List<ShiftDetail> findContiguousShifts(List<ShiftDetail> inputShiftDetails) {

        Collections.sort(inputShiftDetails, new ShiftDetail());
        return null;
    }

    private static int compareDateTime(String sourceDateTime, String targetDateTime) {
        return 0;
    }
}

class ShiftDetail implements Comparator<ShiftDetail> {

    private Date fromShiftDateTime;
    private Date toShiftDateTime;

    public ShiftDetail() {

    }

    public ShiftDetail(Date fromShiftDateTime, Date toShiftDateTime) {
        this.fromShiftDateTime = fromShiftDateTime;
        this.toShiftDateTime = toShiftDateTime;
    }

    public int compare(ShiftDetail shiftDetail, ShiftDetail targetShiftDetail) {
        if (shiftDetail.getFromShiftDateTime().compareTo(targetShiftDetail.getFromShiftDateTime()) == 0 &&
            shiftDetail.getToShiftDateTime().compareTo(targetShiftDetail.getToShiftDateTime()) == 0) {
            return 0;
        }

        if (shiftDetail.getFromShiftDateTime().compareTo(targetShiftDetail.getFromShiftDateTime()) == 0) {
            if (shiftDetail.getToShiftDateTime().compareTo(targetShiftDetail.getToShiftDateTime()) > 0) {
                targetShiftDetail.setToShiftDateTime(shiftDetail.getToShiftDateTime());
            }
            return 0;
        }

        if (shiftDetail.getFromShiftDateTime().compareTo(targetShiftDetail.getFromShiftDateTime()) < 0) {
            if (shiftDetail.getToShiftDateTime().compareTo(targetShiftDetail.getFromShiftDateTime()) < 0) {
                return -1;
            }
            if (shiftDetail.getToShiftDateTime().compareTo(targetShiftDetail.getFromShiftDateTime()) >= 0) {
                targetShiftDetail.setFromShiftDateTime(shiftDetail.getFromShiftDateTime());
                if (shiftDetail.getToShiftDateTime().compareTo(targetShiftDetail.getToShiftDateTime()) > 0) {
                    targetShiftDetail.setToShiftDateTime(shiftDetail.getToShiftDateTime());
                }
                return 0;
            }
        }

        if (shiftDetail.getFromShiftDateTime().compareTo(targetShiftDetail.getFromShiftDateTime()) > 0) {
            if (shiftDetail.getFromShiftDateTime().compareTo(targetShiftDetail.getToShiftDateTime()) > 0) {
                return 1;
            }
            if (shiftDetail.getFromShiftDateTime().compareTo(targetShiftDetail.getToShiftDateTime()) <= 0) {
                if (shiftDetail.getToShiftDateTime().compareTo(targetShiftDetail.getToShiftDateTime()) > 0) {
                    targetShiftDetail.setToShiftDateTime(shiftDetail.getToShiftDateTime());
                }
                return 0;
            }
        }
        return 0;
    }

    public Date getFromShiftDateTime() {
        return fromShiftDateTime;
    }

    public Date getToShiftDateTime() {
        return toShiftDateTime;
    }

    public void setFromShiftDateTime(Date fromShiftDateTime) {
        this.fromShiftDateTime = fromShiftDateTime;
    }

    public void setToShiftDateTime(Date toShiftDateTime) {
        this.toShiftDateTime = toShiftDateTime;
    }
}
