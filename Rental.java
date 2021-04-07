import java.util.Date;

public class Rental {
	void printRental() {
		System.out.print("\tTitle: " + getVideo().getTitle() + " ");
		System.out.print("\tPrice Code: " + getVideo().getPriceCode());
	}

	public enum RentalStatus {
        RENTED, RETURNED;
    }

    private Video video;
    private RentalStatus status;
    private Date rentDate;
    private Date returnDate;

    public Rental(Video video) {
        this.video = video;
        status = RentalStatus.RENTED;
        rentDate = new Date();
    }

    public Video getVideo() {
        return video;
    }

    public void returnVideo() {
        if (status == RentalStatus.RENTED) {
            this.status = RentalStatus.RETURNED;
            returnDate = new Date();
            video.setRented(false);
        }
    }

    public int getDaysRentedLimit() {
        if (getDaysRented() <= 2) return 0;
        return video.getLimit();
    }

    public int getDaysRented() {
        long diff = ((status == RentalStatus.RENTED) ? returnDate.getTime() : new Date().getTime()) - rentDate.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
    }

    public double getCharge(int daysRented) {
        double charge = 0;
        if (video.getPriceCode() == Video.VideoCode.REGULAR) {
            charge += 2;
            if (daysRented > 2)
                charge += (daysRented - 2) * 1.5;
        } else if (video.getPriceCode() == Video.VideoCode.NEW_RELEASE) {
            charge = daysRented * 3;
        }
        return charge;
    }

    public int getPoint(int daysRented) {
        int point = 0;
        point++;
        if (video.getPriceCode() == Video.VideoCode.NEW_RELEASE)
            point++;
        if (daysRented > getDaysRentedLimit())
            point -= Math.min(point, video.getLateReturnPointPenalty());
        return point;
    }

    public String getVideoTitle() {
        return video.getTitle();
    }
}
