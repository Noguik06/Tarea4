public  class ObjectType {
    
        private double verySmall;
        private double small;
        private double medium;
        private double large;
        private double veryLarge;
        private double average;
        private double variance;

        public ObjectType(){
            
        }
        
        /**
         *VerySmall attribute getter
         * @return very small value
         */
        public double getVerySmall() {
            return Math.pow(Math.E, (this.average - (2 * this.getStandardDeviation())));
        }

        /**
         *
         * @param verySmall
         */
        public void setVerySmall(double verySmall) {
            this.verySmall = verySmall;
        }

        /**
         *Small attribute getter
         * 
         * @return small value
         */
        public double getSmall() {
            return Math.pow(Math.E, (this.average - this.getStandardDeviation()));
        }

        /**
         *Small attribute setter
         * 
         * @param small
         */
        public void setSmall(double small) {
            this.small = small;
        }

        /**
         *Medium attribute getter
         * 
         * @return
         */
        public double getMedium() {
            return Math.pow(Math.E, this.average);
        }

        /**
         *Medium attribute setter
         * 
         * @param medium
         */
        public void setMedium(double medium) {
            this.medium = medium;
        }

        /**
         *Large attribute getter
         * 
         * @return
         */
        public double getLarge() {
            return Math.pow(Math.E, (this.average + this.getStandardDeviation()));
        }

        /**
         *Large attribute setter
         * 
         * @param large
         */
        public void setLarge(double large) {
            this.large = large;
        }

        /**
         *VeryLarge attribute getter
         * 
         * @return
         */
        public double getVeryLarge() {
            return Math.pow(Math.E, (this.average + (2 * this.getStandardDeviation())));
        }

        /**
         *VeryLarge attribute setter
         * 
         * @param veryLarge
         */
        public void setVeryLarge(double veryLarge) {
            this.veryLarge = veryLarge;
        }

        /**
         *Average attribute getter
         * 
         * @return
         */
        public double getAverage() {
            return average;
        }

        /**
         *Average attribute setter
         * 
         * @param average
         */
        public void setAverage(double average) {
            this.average = average;
        }

        /**
         *Variance attribute getter
         * 
         * @return
         */
        public double getVariance() {
            return variance;
        }

        /**
         *Variance attribute setter
         * 
         * @param variance
         */
        public void setVariance(double variance) {
            this.variance = variance;
        }

        /**
         *Calculates the standarDeviation using the value of the variance attribute
         * @return
         */
        public double getStandardDeviation() {
            return Math.sqrt(this.variance);
        }
    }