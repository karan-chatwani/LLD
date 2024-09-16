package models;

public enum ParkingType {

    SMALL {
        public double getFare(long duration) {
            return 0.5 * duration;
        }
    },
    MEDIUM {
        public double getFare(long duration) {
            return 0.75 * duration;
        }
    },
    LARGE {
        public double getFare(long duration) {
            return 0.95 * duration;
        }
    };

    public abstract double getFare(long duration);
}
