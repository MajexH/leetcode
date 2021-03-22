import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingSystem {

    List<Integer> parks = new ArrayList<>();

    public ParkingSystem(int big, int medium, int small) {
        this.parks.addAll(Arrays.asList(big, medium, small));
    }

    public boolean addCar(int carType) {
        int remain = this.parks.get(carType - 1);

        if (remain == 0) return false;

        this.parks.set(carType - 1, remain - 1);
        return true;
    }
}
