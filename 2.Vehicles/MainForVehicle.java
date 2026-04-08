public class MainForVehicle {

    public static void main(String[] args) {

        // ---------- YOUR ORIGINAL CODE (UNCHANGED) ----------
        Vehicle defV = new Vehicle();
        printVehicleDetails(defV);

        Vehicle v2 = new Vehicle("Honda", "City", 400000.99, "HON983022");
        printVehicleDetails(v2);

        v2.start(20);
        v2.drive(0, 20, 120);

        double mileage = v2.calcTripMileage(15.0, 20.0);
        System.out.println("trip mileage :" + mileage);

        v2.stop();

        Vehicle v3 = v2;
        v3.setMfgCode("HON98765");
        v3.color = "Orange";
        printVehicleDetails(v3);

        Vehicle[] myFleet = new Vehicle[]{ defV, v2, v3 };

        for (Vehicle myV : myFleet) {
            printVehicleDetails(myV);
            myV.start(30);
            myV.drive(1, 30, 100);
        }

        // ---------- ADDED TABULAR OUTPUT ----------
        defV.fuelType = FuelType.PETROL;
        v2.fuelType = FuelType.DIESEL;
        v3.fuelType = FuelType.CNG;

        System.out.println("\n================ VEHICLE TABLE =================");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Brand", "Model", "Price", "Fuel", "Mileage", "MfgCode");
        System.out.println("--------------------------------------------------------------------------------------");

        for (Vehicle v : myFleet) {

            double mil = v.calcTripMileage(15, 1.5);

            System.out.printf("%-10s %-10s %-10.2f %-10s %-10.2f %-10s\n",
                    v.brandName,
                    v.modelName,
                    v.price,
                    v.fuelType,
                    mil,
                    v.getMfgCode());
        }

        System.out.println("--------------------------------------------------------------------------------------");
    }

    // ---------- YOUR ORIGINAL METHOD (UNCHANGED) ----------
    public static void printVehicleDetails(Vehicle v) {

        System.out.println("======Vehicle Details======");
        System.out.println("Brand Name:" + v.brandName);
        System.out.println("Model Name:" + v.modelName);
        System.out.println("Price:" + v.price);
        System.out.println("Mfg Code:" + v.getMfgCode());
        System.out.println("======End of Vehicle Details======");
    }
}