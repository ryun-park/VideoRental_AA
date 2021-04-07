import java.util.Date;

public abstract class Video {
	public enum VideoCode{
		REGULAR(1),
		NEW_RELEASE(2);
		VideoCode(int i) {
		}
	}

	public static VideoCode convertVideoCode(int priceCode){
		if(priceCode == 1) return VideoCode.REGULAR;
		else if(priceCode == 2) return VideoCode.NEW_RELEASE;
		return null;
	}

	private String title ;
	private VideoCode priceCode ;
	private Date registeredDate ;
	private boolean rented ;

	public Video() {
		this.registeredDate = new Date();
	}

	public VideoCode getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(VideoCode priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	void printVideo() {
		System.out.println("Price code: " + getPriceCode() + "\tTitle: " + getTitle());
	}

	public abstract int getLateReturnPointPenalty();

	public abstract int getLimit();

}
