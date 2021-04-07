import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VRControl {
    List<Customer> customers = new ArrayList<Customer>();
    List<Video> videos = new ArrayList<Video>();
    VideoFactory videoSystem = new VideoSystem();

    public VRControl() {
    }

    public void clearRentals(String customerName) {
        Customer foundCustomer = getCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            foundCustomer.printCustomer();
            for (Rental rental : foundCustomer.getRentals()) {
                rental.printRental();
            }

            List<Rental> rentals = new ArrayList<Rental>();
            foundCustomer.setRentals(rentals);
        }
    }

    private Customer getCustomer(String customerName) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    public void returnVideo(String customerName, String videoTitle) {

        Customer foundCustomer = getCustomer(customerName);
        if (foundCustomer == null) return;

        List<Rental> customerRentals = foundCustomer.getRentals();
        for (Rental rental : customerRentals) {
            if (rental.getVideoTitle().equals(videoTitle) && rental.getVideo().isRented()) {
                rental.returnVideo();
                break;
            }
        }
    }

    void init() {
        Customer james = new Customer("James");
        Customer brown = new Customer("Brown");
        customers.add(james);
        customers.add(brown);

        Video v1 = new Video("v1", Video.CD, Video.REGULAR, new Date());
        Video v2 = new Video("v2", Video.DVD, Video.NEW_RELEASE, new Date());
        videos.add(v1);
        videos.add(v2);

        Rental r1 = new Rental(v1);
        Rental r2 = new Rental(v2);

        james.addRental(r1);
        james.addRental(r2);
    }

    public void listVideos() {
        System.out.println("List of videos");

        for (Video video : videos) {
            video.printVideo();
        }
        System.out.println("End of list");
    }

    public void listCustomers() {
        System.out.println("List of customers");
        for (Customer customer : customers) {
            customer.printCustomer();
            for (Rental rental : customer.getRentals()) {
                rental.printRental();
            }
        }
        System.out.println("End of list");
    }

    public void getCustomerReport(String customerName) {
        Customer foundCustomer = getCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            String result = foundCustomer.getReport();
            System.out.println(result);
        }
    }

    public void rentVideo(String customerName, String videoTitle) {
        Customer foundCustomer = getCustomer(customerName);

        if (foundCustomer == null) return;

        Video foundVideo = null;
        for (Video video : videos) {
            if (video.getTitle().equals(videoTitle) && !video.isRented()) {
                foundVideo = video;
                break;
            }
        }

        if (foundVideo == null) return;

        Rental rental = new Rental(foundVideo);
        foundVideo.setRented(true);
        foundCustomer.addRental(rental);
    }

    public void registerCustomer(String name) {
        Customer customer = new Customer(name);
        customers.add(customer);
    }

    public void registerVideo(String title, int videoType, int priceCode) {
        Video video = videoSystem.createVideo(title,videoType,priceCode);
        videos.add(video);
    }
}