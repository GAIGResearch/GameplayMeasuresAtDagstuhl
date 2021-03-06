package metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    static final String LOG = "[LOGGER] ";
    static final String ERROR = "[ERROR] ";

    // Normalizes a value between its MIN and MAX.
    public static double normalise(double a_value, double a_min, double a_max)
    {
        if(a_min < a_max)
            return (a_value - a_min)/(a_max - a_min);
        else    // if bounds are invalid, then return same value
            return a_value;
    }

    // Calculate normalised entropy
    public static double normalisedEntropy(double[] entries) {
        int nbEntries = entries.length;
        HashMap<Double,Integer> occurrences = new HashMap<>();
        double key;
        for (int i=0; i<nbEntries; i++) {
            key = entries[i];
            if (occurrences.get(key) == null) {
                occurrences.put(key, 1);
            } else {
                int value = occurrences.get(key);
                occurrences.replace(key, value, value + 1);
            }
        }
        double entropy = 0.0;
        if (!occurrences.isEmpty()) {
            if (occurrences.size() > 1) {
                for (int value : occurrences.values()) {
                    double p = (double) value/nbEntries;
                    entropy -= p * Math.log(p);
                }
                return entropy / Math.log(occurrences.size());
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    // Calculate normalised entropy
    public static double normalisedEntropy(ArrayList<Integer> entries) {
        int nbEntries = entries.size();
        HashMap<Integer,Integer> occurrences = new HashMap<>();
        int key;
        for (int i=0; i<nbEntries; i++) {
            key = entries.get(i);
            if (occurrences.get(key) == null) {
                occurrences.put(key, 1);
            } else {
                int value = occurrences.get(key);
                occurrences.replace(key, value, value + 1);
            }
        }
        double entropy = 0.0;
        if (!occurrences.isEmpty()) {
            if (occurrences.size() > 1) {
                for (int value : occurrences.values()) {
                    double p = (double) value / nbEntries;
                    entropy -= p * Math.log(p);

                }
                return entropy / Math.log(occurrences.size());
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    // Calculate entropy
    public static double entropy(double[] entries) {
        int nbEntries = entries.length;
        HashMap<Double,Integer> occurrences = new HashMap<>();
        double key;
        for (int i=0; i<nbEntries; i++) {
            key = entries[i];
            if (occurrences.get(key) == null) {
                occurrences.put(key, 1);
            } else {
                int value = occurrences.get(key);
                occurrences.replace(key, value, value + 1);
            }
        }
        double entropy = 0.0;
        if (!occurrences.isEmpty()) {
            if (occurrences.size()>1) {
                for (int value : occurrences.values()) {
                    double p = (double) value / nbEntries;
                    entropy -= p * Math.log(p);
                }
            } else {
                System.err.println("All same entry in the array");
            }
        } else {
            System.err.println("Empty array for calculating entropy");
        }
        return entropy;
    }

    // Calculate entropy
    public static double entropy(ArrayList<Integer> entries) {
        int nbEntries = entries.size();
        HashMap<Integer,Integer> occurrences = new HashMap<>();
        int key;
        for (int i=0; i<nbEntries; i++) {
            key = entries.get(i);
            if (occurrences.get(key) == null) {
                occurrences.put(key, 1);
            } else {
                int value = occurrences.get(key);
                occurrences.replace(key, value, value + 1);
            }
        }
        double entropy = 0.0;
        if (!occurrences.isEmpty()) {
            if (occurrences.size() > 1) {
                for (int value : occurrences.values()) {
                    double p = (double) value / nbEntries;
                    entropy -= p * Math.log(p);
                }
            } else {
                System.err.println("All same entry in the array");
            }
        } else {
            System.err.println("Empty array for calculating entropy");
        }
        return entropy;
    }

    public static double[] differentialArray(ArrayList<Double> entries) {
        int nbEntries = entries.size();
        double[] diff = new double[nbEntries];
        if (nbEntries > 0) {
            diff[0] = 0.0;
            if (nbEntries > 1) {
                for (int i = 1; i < diff.length; i++) {
                    diff[i] = entries.get(i) - entries.get(i - 1);
                }
            }
        }
        return diff;
    }

    public static String printLogMsg(Object msg) {
        String str = "";
        if (msg instanceof double[]) {
            double[] array = (double[]) msg;
            if (array.length>0) {
                str += array[0];
                for (int i = 1; i < array.length; i++) {
                    str += "," + array[i];
                }
            }
            return str;
        }
        if (msg instanceof Double || msg instanceof Integer || msg instanceof String) {
            str += msg;
            return str;
        }
        return ("The type of object to print is not supported yet.");
    }

    public static void printLogMsgWithTag(String tag, Object msg) {
        System.out.println(LOG + tag + printLogMsg(msg));
    }

}
