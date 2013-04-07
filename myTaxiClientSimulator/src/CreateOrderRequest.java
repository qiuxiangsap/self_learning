/**
 * @author I075926 Wang, David
 * @date Mar 27, 2013
 * @author modified by I076746
 */
public class CreateOrderRequest {
	

	String user_id;
	int city_id;
	double origin_lat;
	double origin_lng;
	String origin_addrdesc;
	double dest_lng;
	double dest_lat;
	String dest_desc;
	String order_car_type;
	String req_phone_number;
	
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public double getOrigin_lat() {
		return origin_lat;
	}

	public void setOrigin_lat(double origin_lat) {
		this.origin_lat = origin_lat;
	}

	public double getOrigin_lng() {
		return origin_lng;
	}

	public void setOrigin_lng(double origin_lng) {
		this.origin_lng = origin_lng;
	}

	public String getOrigin_addrdesc() {
		return origin_addrdesc;
	}

	public void setOrigin_addrdesc(String origin_addrdesc) {
		this.origin_addrdesc = origin_addrdesc;
	}

	public double getDest_lng() {
		return dest_lng;
	}

	public void setDest_lng(double dest_lng) {
		this.dest_lng = dest_lng;
	}

	public double getDest_lat() {
		return dest_lat;
	}

	public void setDest_lat(double dest_lat) {
		this.dest_lat = dest_lat;
	}

	public String getDest_desc() {
		return dest_desc;
	}

	public void setDest_desc(String dest_desc) {
		this.dest_desc = dest_desc;
	}

	public String getOrder_car_type() {
		return order_car_type;
	}

	public void setOrder_car_type(String order_car_type) {
		this.order_car_type = order_car_type;
	}

	public String getReq_phone_number() {
		return req_phone_number;
	}

	public void setReq_phone_number(String req_phone_number) {
		this.req_phone_number = req_phone_number;
	}

	
	public boolean validateCityId(){
		boolean isValidate = true;
		try{
			int cityIdInt = Integer.valueOf(this.city_id);
		}
		catch(Exception e){
			isValidate = false;
		}
		return isValidate;
	}
	
	
	//TODO:
	// add validate check for lng lat
	public boolean validateLng() {
		return true;
	}
	public boolean validateLat() {
		return true;
	}
	public ErrorType validate() {
		ErrorType errorType = new ErrorType();
		errorType.setErrorCode(ErrorCode.OK);
		errorType.setErrorDesc("");
		if(!validateCityId()){
			errorType.setErrorCode(ErrorCode.PARAMETER_ERROR);
			errorType.setErrorDesc("Input CityId format error!");
		}
		if(!validateLng()){
			errorType.setErrorCode(ErrorCode.PARAMETER_ERROR);
			errorType.setErrorDesc("Input Lng format error!");
		}
		if(!validateLat()){
			errorType.setErrorCode(ErrorCode.PARAMETER_ERROR);
			errorType.setErrorDesc("Input Lat format error!");
		}
		return errorType;
	}
}
