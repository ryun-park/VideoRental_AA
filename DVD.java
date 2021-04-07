public class DVD extends Video{
    public DVD(String title, VideoCode priceCode){
        super();
        this.setTitle(title);
        this.setPriceCode(priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 3 ;
    }

    @Override
    public int getLimit() {
        return 2;
    }
}
