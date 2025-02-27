public class AudioCollage {
    /**
     * Returns a new array that rescales A[] by a multiplicative factor of
     * ALPHA.
     */
    public static double[] amplify(double[] a, double alpha) {
        int len = a.length;
        double[] amplify = new double[len];
        for (int i = 0; i < len; i += 1) {
            amplify[i] = alpha * a[i];
        }
        return amplify;
    }

    /**
     * Returns a new array that is the reverse of A[].
     */
    public static double[] reverse(double[] a) {
        int len = a.length;
        double[] reverse = new double[len];
        for (int i = 0; i < len; i += 1) {
            reverse[i] = a[len - 1 - i];
        }
        return reverse;
    }

    /**
     * Returns a new array that is the concatenation of A[] and B[].
     */
    public static double[] merge(double[] a, double[] b) {
        int aLen = a.length;
        int bLen = b.length;
        double[] merge = new double[aLen + bLen];
        System.arraycopy(a, 0, merge, 0, aLen);
        System.arraycopy(b, 0, merge, aLen, bLen);
        return merge;
    }

    /**
     * Returns a new array that is the sum of A[] and B[], padding the shorter
     * arrays with trailing 0s if necessary.
     */
    public static double[] mix(double[] a, double[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int len = Math.max(aLen, bLen);
        double[] mix = new double[len];
        System.arraycopy(a, 0, mix, 0, aLen);
        for (int i = 0; i < bLen; i += 1) {
            mix[i] += b[i];
        }
        return mix;
    }

    /**
     * Returns a new array that changes the speed by the given factor.
     */
    public static double[] changeSpeed(double[] a, double alpha) {
        int len = (int) Math.floor(a.length / alpha);
        double[] changeSpeed = new double[len];
        for (int i = 0; i < len; i += 1) {
            int idx = (int) Math.floor(i * alpha);
            changeSpeed[i] = a[idx];
        }
        return changeSpeed;
    }

    /**
     * Creates an audio collage and plays it on standard audio.
     */
    public static void main(String[] args) {
        double[] samples1 = StdAudio.read("beatbox.wav");
        double[] samples2 = StdAudio.read("exposure.wav");
        double[] samples3 = StdAudio.read("piano.wav");
        double[] samples4 = StdAudio.read("silence.wav");
        double[] samples5 = StdAudio.read("singer.wav");
        double[] mix1 = mix(samples1, samples2);
        double[] mix2 = mix(samples3, samples4);
        samples5 = reverse(samples5);
        double[] samples = merge(mix1, mix2);
        samples = mix(samples, samples5);
        double alpha = Math.random();
        samples = amplify(samples, alpha);
        alpha = Math.random();
        samples = changeSpeed(samples, alpha);
        double max = Double.NEGATIVE_INFINITY;
        int len = samples.length;
        for (int i = 0; i < len; i += 1) {
            double sample = samples[i];
            if (sample > max) {
                max = sample;
            }
        }
        for (int i = 0; i < len; i += 1) {
            samples[i] /= max;
        }
        StdAudio.play(samples);
    }
}
