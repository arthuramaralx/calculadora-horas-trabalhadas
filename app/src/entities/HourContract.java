package entities;

import java.util.Date;

public class HourContract {
    
    private Date date;
    private Double valuesPerHour;
    private Integer hours;

  
    public HourContract(Date date, Double valuesPerHour, Integer hours) {
        this.date = date;
        this.valuesPerHour = valuesPerHour;
        this.hours = hours;
    }

    public double totalValue() {
        return valuesPerHour * hours;
    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Double getValuesPerHour() {
        return valuesPerHour;
    }


    public void setValuesPerHour(Double valuesPerHour) {
        this.valuesPerHour = valuesPerHour;
    }


    public Integer getHours() {
        return hours;
    }


    public void setHours(Integer hours) {
        this.hours = hours;
    };

    
    
}