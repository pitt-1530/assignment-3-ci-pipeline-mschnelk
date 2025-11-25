package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        int sum = 0;
    
        for (Integer b : bpms)  
            sum += b;
        
        if (sum/bpms.size() >= 140) return "HIGH";
        if (sum/bpms.size() < 140) return "LOW";
        else return "MEDIUM";
    }

    public static boolean isValidTrackTitle(String title) {
        if (title == null) return false;
        int titleLength = title.length();

        if (titleLength > 30 || titleLength < 1) return false;      

        for (int i = 0; i < titleLength; i++)
        {
            char c = title.charAt(i);
            if (c != 32 && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
                return false;
        }
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if (volumeDb > 100) return 100;
        if (volumeDb < 0) return 0;
        return volumeDb;
    }
}
