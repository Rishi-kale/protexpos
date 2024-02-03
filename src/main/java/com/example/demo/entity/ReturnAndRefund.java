
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "return_table")
public class ReturnAndRefund {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO )
		private Long return_id;
		
		private String Returndate;
		
		private String Reason;
		

		@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "OrderId")
		private Order  oid;
		
		public ReturnAndRefund(String returndate, String reason) {
			super();
			Returndate = returndate;
			Reason = reason;
		}
		public Long getReturn_id() {
			return return_id;
		}
		public void setReturn_id(Long return_id) {
			this.return_id = return_id;
		}
		public String getReturndate() {
			return Returndate;
		}
		public void setReturndate(String returndate) {
			Returndate = returndate;
		}
		public String getReason() {
			return Reason;
		}
		public void setReason(String reason) {
			Reason = reason;
		}
		public Order getOrderidd() {
			return oid;
		}
		public void setOrderidd(Order orderidd) {
			this.oid = orderidd;
		}
		public ReturnAndRefund() {
			super();
		}

}