package mypkg.bean;

public class Order {
	private int oid;
	private String mid;
	private String orderdate;
	private String remark;
	public final int getOid() {
		return oid;
	}
	public final void setOid(int oid) {
		this.oid = oid;
	}
	public final String getMid() {
		return mid;
	}
	public final void setMid(String mid) {
		this.mid = mid;
	}
	public final String getOrderdate() {
		return orderdate;
	}
	public final void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public final String getRemark() {
		return remark;
	}
	public final void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", mid=" + mid + ", orderdate=" + orderdate + ", remark=" + remark + "]";
	}
	public Order() {
		super();
	}
	
	
	
	
}
