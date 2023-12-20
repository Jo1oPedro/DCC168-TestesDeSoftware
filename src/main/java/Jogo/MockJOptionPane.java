package Jogo;

public class MockJOptionPane {
	private static String[] mockResponses;
    private static int currentIndex = 0;

    public static void setMockResponses(String... responses) {
        mockResponses = responses;
        currentIndex = 0;
    }

    public static String showInputDialog(Object message, String string, String string2, int questionMessage) {
        if (currentIndex < mockResponses.length) {
            return mockResponses[currentIndex++];
        }
        return null;
    }
}
