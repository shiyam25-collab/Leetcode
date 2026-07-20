class ParkingSystem {
    // Array to store the available slots for each car type.
    // Index 1 = big, 2 = medium, 3 = small.
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (slots[carType] > 0) {
            slots[carType]--;
            return true;
        }
        return false;
    }
} 
