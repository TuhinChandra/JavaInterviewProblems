//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.HashMap;
//import java.util.Map;
//
//public class BookingService {
//    @Autowired
//    private HotelSalePriceCalculatorService hotelSalePriceCalculatorService;
//    @Autowired
//    private FlightSalePriceCalculatorService flightSalePriceCalculatorService;
//
//    public void createBooking(Long id, String saleType) {
//        //Approach #1
//        Map prices = new HashMap();
//        if (saleType.equals("hotel")) {
//            prices = hotelSalePriceCalculatorService.getHotelPrices(id);
//        } else if (saleType.equals("flights")) {
//            prices = flightSalePriceCalculatorService.getFlightPrices(id);
//        }
//        //Approach #2
//        SalePriceCalculatorService service = determineSalePriceCalculatorService(saleType);
//        Map prices = service.calculatePrice(id);
//    }
//
//}
//
//@Service
//public class HotelSalePriceCalculatorService {
//    public Map getHotelPrices(Long id) {
//        HotelSale sale = HotelSale.findById(id);
//        BigDecimal totalPrice = sale.getTotaIPrice();
//        Long number = sale.getNumberOfPeopIe();
//        BigDecimal rate1 = totalprice.divide(number, RoundingMode.HALF_EVEN);
//        BigDecimal rate2 = sale.getTotalDiscountedRate();
//        BigDecimal rate3 = rate2.divide(number, RoundingMode.HALF_EVEN);
//        Map prices = new HashMap();
//        prices.put("rate", rate1);
//        prices.put("discount", rate3);
//        return prices;
//    }
//
//}
//
//@Service
//public class FlightSalePriceCalculatorService {
//    public Map getFlightPrices(Long id) {
//        FlightSale sale = FlightSale.findById(id);
//        BigDecimal totalPrice = sale.getTotaIPrice();
//        Long number = sale.getNumberOfPeopIe();
//        BigDecimal ratel = calculatePrice(totaIPrice, number);
//        BigDecimal rate2 = sale.getTotalDiscountedRate();
//        BigDecimal rate3 = rate2.divide(number, RoundingMode.HALF_EVEN);
//        BigDecimal rate4 = sale.getBaggagePrice();
//        BigDecimal rate5 = rate4.divide(number, RoundingMode.HALF_EVEN);
//        Map prices = new HashMap();
//        prices.put("rate", ratel);
//        prices.put("discount", rate3);
//        prices.put("baggage", rate5);
//        return prices;
//    }
//}
//
//@Data
//public class HotelSale {
//
//    //members
//
//}
//
//@Data
//public class FlightSale {
//    //members
//}