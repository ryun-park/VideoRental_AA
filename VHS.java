public class VHS extends Video{
    public VHS(String title, VideoCode priceCode){
        super();
        this.setTitle(title);
        this.setPriceCode(priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 2 ;
    }

    @Override
    public int getLimit() {
        return 3;
    }
}
