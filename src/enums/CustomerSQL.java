package enums;

/*customerID, customerName, password, address,
city, postalcode, ssn;*/
public enum CustomerSQL {
	SIGNUP, SIGNIN, LIST, COUNT;
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch(this) {
		case SIGNUP: 
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, "
					+ "PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE)"
			       + "VALUES(?,?,?,?,?,?,?,?,?)");
			
			break;
		case SIGNIN: 
			query.append("SELECT * \n" + 
					"FROM CUSTOMERS \n" + 
					"WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ? ");
			break;
		case LIST: 
			query.append("select * \n" + 
					"from (select rownum rnum, C.* \n" + 
							"from customers C \n" + 
							"order by rnum desc) T\n" + 
					"where T.RNUM between ? and ?");
			break;
		case COUNT:
			query.append("select count(*) COUNT from customers");
			break;
		default:
			break;
		}
		return query.toString();
	}
}
