package day02.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable{

    private Long oid;

    private String ono;

    private String createTime;

    private BigDecimal totalPrice;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getOno() {
        return ono;
    }

    public void setOno(String ono) {
        this.ono = ono;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", ono='" + ono + '\'' +
                ", createTime='" + createTime + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
