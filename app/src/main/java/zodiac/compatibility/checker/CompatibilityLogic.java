package zodiac.compatibility.checker;

import java.util.HashMap;
import java.util.Map;

public class CompatibilityLogic {
    private static final Map<String, Map<String, Integer>> compatibilityMap = new HashMap<>();

    static {
        // Fill compatibility data for each zodiac sign
        Map<String, Integer> ariesCompatibility = new HashMap<>();
        ariesCompatibility.put("Aries", 80);   // Self compatibility
        ariesCompatibility.put("Taurus", 50);
        ariesCompatibility.put("Gemini", 70);
        ariesCompatibility.put("Cancer", 60);
        ariesCompatibility.put("Leo", 80);
        ariesCompatibility.put("Virgo", 50);
        ariesCompatibility.put("Libra", 70);
        ariesCompatibility.put("Scorpio", 60);
        ariesCompatibility.put("Sagittarius", 80);
        ariesCompatibility.put("Capricorn", 50);
        ariesCompatibility.put("Aquarius", 70);
        ariesCompatibility.put("Pisces", 60);

        Map<String, Integer> taurusCompatibility = new HashMap<>();
        taurusCompatibility.put("Aries", 50);
        taurusCompatibility.put("Taurus", 80);  // Self compatibility
        taurusCompatibility.put("Gemini", 60);
        taurusCompatibility.put("Cancer", 70);
        taurusCompatibility.put("Leo", 50);
        taurusCompatibility.put("Virgo", 80);
        taurusCompatibility.put("Libra", 50);
        taurusCompatibility.put("Scorpio", 60);
        taurusCompatibility.put("Sagittarius", 50);
        taurusCompatibility.put("Capricorn", 70);
        taurusCompatibility.put("Aquarius", 50);
        taurusCompatibility.put("Pisces", 60);

        Map<String, Integer> geminiCompatibility = new HashMap<>();
        geminiCompatibility.put("Aries", 70);
        geminiCompatibility.put("Taurus", 60);
        geminiCompatibility.put("Gemini", 80);  // Self compatibility
        geminiCompatibility.put("Cancer", 50);
        geminiCompatibility.put("Leo", 70);
        geminiCompatibility.put("Virgo", 60);
        geminiCompatibility.put("Libra", 80);
        geminiCompatibility.put("Scorpio", 50);
        geminiCompatibility.put("Sagittarius", 70);
        geminiCompatibility.put("Capricorn", 60);
        geminiCompatibility.put("Aquarius", 80);
        geminiCompatibility.put("Pisces", 50);

        Map<String, Integer> cancerCompatibility = new HashMap<>();
        cancerCompatibility.put("Aries", 60);
        cancerCompatibility.put("Taurus", 70);
        cancerCompatibility.put("Gemini", 50);
        cancerCompatibility.put("Cancer", 80);  // Self compatibility
        cancerCompatibility.put("Leo", 60);
        cancerCompatibility.put("Virgo", 40);
        cancerCompatibility.put("Libra", 60);
        cancerCompatibility.put("Scorpio", 70);
        cancerCompatibility.put("Sagittarius", 60);
        cancerCompatibility.put("Capricorn", 50);
        cancerCompatibility.put("Aquarius", 60);
        cancerCompatibility.put("Pisces", 70);

        Map<String, Integer> leoCompatibility = new HashMap<>();
        leoCompatibility.put("Aries", 80);
        leoCompatibility.put("Taurus", 50);
        leoCompatibility.put("Gemini", 70);
        leoCompatibility.put("Cancer", 60);
        leoCompatibility.put("Leo", 80);  // Self compatibility
        leoCompatibility.put("Virgo", 50);
        leoCompatibility.put("Libra", 70);
        leoCompatibility.put("Scorpio", 60);
        leoCompatibility.put("Sagittarius", 80);
        leoCompatibility.put("Capricorn", 50);
        leoCompatibility.put("Aquarius", 70);
        leoCompatibility.put("Pisces", 60);

        Map<String, Integer> virgoCompatibility = new HashMap<>();
        virgoCompatibility.put("Aries", 50);
        virgoCompatibility.put("Taurus", 80);
        virgoCompatibility.put("Gemini", 60);
        virgoCompatibility.put("Cancer", 40);
        virgoCompatibility.put("Leo", 50);
        virgoCompatibility.put("Virgo", 80);  // Self compatibility
        virgoCompatibility.put("Libra", 50);
        virgoCompatibility.put("Scorpio", 60);
        virgoCompatibility.put("Sagittarius", 50);
        virgoCompatibility.put("Capricorn", 70);
        virgoCompatibility.put("Aquarius", 50);
        virgoCompatibility.put("Pisces", 60);

        Map<String, Integer> libraCompatibility = new HashMap<>();
        libraCompatibility.put("Aries", 70);
        libraCompatibility.put("Taurus", 50);
        libraCompatibility.put("Gemini", 80);
        libraCompatibility.put("Cancer", 60);
        libraCompatibility.put("Leo", 70);
        libraCompatibility.put("Virgo", 50);
        libraCompatibility.put("Libra", 80);  // Self compatibility
        libraCompatibility.put("Scorpio", 70);
        libraCompatibility.put("Sagittarius", 80);
        libraCompatibility.put("Capricorn", 50);
        libraCompatibility.put("Aquarius", 70);
        libraCompatibility.put("Pisces", 60);

        Map<String, Integer> scorpioCompatibility = new HashMap<>();
        scorpioCompatibility.put("Aries", 60);
        scorpioCompatibility.put("Taurus", 60);
        scorpioCompatibility.put("Gemini", 50);
        scorpioCompatibility.put("Cancer", 70);
        scorpioCompatibility.put("Leo", 60);
        scorpioCompatibility.put("Virgo", 60);
        scorpioCompatibility.put("Libra", 70);
        scorpioCompatibility.put("Scorpio", 80);  // Self compatibility
        scorpioCompatibility.put("Sagittarius", 60);
        scorpioCompatibility.put("Capricorn", 60);
        scorpioCompatibility.put("Aquarius", 70);
        scorpioCompatibility.put("Pisces", 50);

        Map<String, Integer> sagittariusCompatibility = new HashMap<>();
        sagittariusCompatibility.put("Aries", 80);
        sagittariusCompatibility.put("Taurus", 50);
        sagittariusCompatibility.put("Gemini", 70);
        sagittariusCompatibility.put("Cancer", 60);
        sagittariusCompatibility.put("Leo", 80);
        sagittariusCompatibility.put("Virgo", 50);
        sagittariusCompatibility.put("Libra", 80);
        sagittariusCompatibility.put("Scorpio", 60);
        sagittariusCompatibility.put("Sagittarius", 80);  // Self compatibility
        sagittariusCompatibility.put("Capricorn", 50);
        sagittariusCompatibility.put("Aquarius", 70);
        sagittariusCompatibility.put("Pisces", 60);

        Map<String, Integer> capricornCompatibility = new HashMap<>();
        capricornCompatibility.put("Aries", 50);
        capricornCompatibility.put("Taurus", 70);
        capricornCompatibility.put("Gemini", 60);
        capricornCompatibility.put("Cancer", 50);
        capricornCompatibility.put("Leo", 50);
        capricornCompatibility.put("Virgo", 70);
        capricornCompatibility.put("Libra", 50);
        capricornCompatibility.put("Scorpio", 60);
        capricornCompatibility.put("Sagittarius", 50);
        capricornCompatibility.put("Capricorn", 80);  // Self compatibility
        capricornCompatibility.put("Aquarius", 60);
        capricornCompatibility.put("Pisces", 70);

        Map<String, Integer> aquariusCompatibility = new HashMap<>();
        aquariusCompatibility.put("Aries", 70);
        aquariusCompatibility.put("Taurus", 50);
        aquariusCompatibility.put("Gemini", 80);
        aquariusCompatibility.put("Cancer", 60);
        aquariusCompatibility.put("Leo", 70);
        aquariusCompatibility.put("Virgo", 50);
        aquariusCompatibility.put("Libra", 70);
        aquariusCompatibility.put("Scorpio", 70);
        aquariusCompatibility.put("Sagittarius", 70);
        aquariusCompatibility.put("Capricorn", 60);
        aquariusCompatibility.put("Aquarius", 80);  // Self compatibility
        aquariusCompatibility.put("Pisces", 60);

        Map<String, Integer> piscesCompatibility = new HashMap<>();
        piscesCompatibility.put("Aries", 60);
        piscesCompatibility.put("Taurus", 60);
        piscesCompatibility.put("Gemini", 50);
        piscesCompatibility.put("Cancer", 70);
        piscesCompatibility.put("Leo", 60);
        piscesCompatibility.put("Virgo", 60);
        piscesCompatibility.put("Libra", 60);
        piscesCompatibility.put("Scorpio", 50);
        piscesCompatibility.put("Sagittarius", 60);
        piscesCompatibility.put("Capricorn", 70);
        piscesCompatibility.put("Aquarius", 60);
        piscesCompatibility.put("Pisces", 80);  // Self compatibility

        // Add all compatibility maps to the main compatibility map
        compatibilityMap.put("Aries", ariesCompatibility);
        compatibilityMap.put("Taurus", taurusCompatibility);
        compatibilityMap.put("Gemini", geminiCompatibility);
        compatibilityMap.put("Cancer", cancerCompatibility);
        compatibilityMap.put("Leo", leoCompatibility);
        compatibilityMap.put("Virgo", virgoCompatibility);
        compatibilityMap.put("Libra", libraCompatibility);
        compatibilityMap.put("Scorpio", scorpioCompatibility);
        compatibilityMap.put("Sagittarius", sagittariusCompatibility);
        compatibilityMap.put("Capricorn", capricornCompatibility);
        compatibilityMap.put("Aquarius", aquariusCompatibility);
        compatibilityMap.put("Pisces", piscesCompatibility);
    }

    public static int calculateCompatibility(String userSign, String partnerSign) {
        // Get compatibility map for user's sign
        Map<String, Integer> userCompatibility = compatibilityMap.get(userSign);
        if (userCompatibility != null) {
            // Get compatibility score for partner's sign
            Integer compatibilityScore = userCompatibility.get(partnerSign);
            if (compatibilityScore != null) {
                return compatibilityScore;
            }
        }
        // Default score if no match found (could also return -1 or throw exception based on needs)
        return 0;
    }

    public static String getCompatibilityInsights(String userSign, String partnerSign) {
        int compatibilityScore = calculateCompatibility(userSign, partnerSign);

        // Explanation about the user's and partner's zodiac signs
        String userExplanation = getZodiacSignExplanation(userSign);
        String partnerExplanation = getZodiacSignExplanation(partnerSign);

        // Generate insights based on compatibility score
        String insight;
        if (compatibilityScore >= 80) {
            insight = "You and " + partnerSign + " are highly compatible! " +
                    "Your relationship is likely to be harmonious and fulfilling.\n\n" +
                    "About " + userSign + ":\n" + userExplanation + "\n\n" +
                    "About " + partnerSign + ":\n" + partnerExplanation;
        } else if (compatibilityScore >= 70) {
            insight = "You and " + partnerSign + " have good compatibility. " +
                    "You complement each other well and share common interests.\n\n" +
                    "About " + userSign + ":\n" + userExplanation + "\n\n" +
                    "About " + partnerSign + ":\n" + partnerExplanation;
        } else if (compatibilityScore >= 60) {
            insight = "You and " + partnerSign + " have moderate compatibility. " +
                    "Your relationship may require some compromise, but it can be rewarding.\n\n" +
                    "About " + userSign + ":\n" + userExplanation + "\n\n" +
                    "About " + partnerSign + ":\n" + partnerExplanation;
        } else if (compatibilityScore >= 50) {
            insight = "You and " + partnerSign + " have fair compatibility. " +
                    "Building a strong relationship may take effort and understanding.\n\n" +
                    "About " + userSign + ":\n" + userExplanation + "\n\n" +
                    "About " + partnerSign + ":\n" + partnerExplanation;
        } else {
            insight = "You and " + partnerSign + " have low compatibility. " +
                    "Your relationship might face challenges and require significant effort.\n\n" +
                    "About " + userSign + ":\n" + userExplanation + "\n\n" +
                    "About " + partnerSign + ":\n" + partnerExplanation;
        }

        return insight;
    }

    private static String getZodiacSignExplanation(String sign) {
        switch (sign) {
            case "Aries":
                return "Aries is known for being energetic, adventurous, and enthusiastic.";
            case "Taurus":
                return "Taurus is known for being reliable, patient, and determined.";
            case "Gemini":
                return "Gemini is known for being curious, adaptable, and communicative.";
            case "Cancer":
                return "Cancer is known for being nurturing, empathetic, and protective.";
            case "Leo":
                return "Leo is known for being confident, generous, and charismatic.";
            case "Virgo":
                return "Virgo is known for being practical, diligent, and analytical.";
            case "Libra":
                return "Libra is known for being harmonious, diplomatic, and social.";
            case "Scorpio":
                return "Scorpio is known for being passionate, resourceful, and intense.";
            case "Sagittarius":
                return "Sagittarius is known for being optimistic, adventurous, and philosophical.";
            case "Capricorn":
                return "Capricorn is known for being responsible, disciplined, and ambitious.";
            case "Aquarius":
                return "Aquarius is known for being independent, inventive, and humanitarian.";
            case "Pisces":
                return "Pisces is known for being compassionate, artistic, and intuitive.";
            default:
                return "No information available.";
        }
    }
}