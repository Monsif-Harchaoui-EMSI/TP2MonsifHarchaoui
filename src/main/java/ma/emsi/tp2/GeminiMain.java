package ma.emsi.tp2;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

import java.time.Duration;

public class GeminiMain {
    public static void main(String[] args) {
        ChatLanguageModel model = GoogleAiGeminiChatModel.builder().apiKey(System.getenv("Gemini_key"))
                .modelName("gemini-1.5-flash").temperature(0.5).timeout(Duration.ofSeconds(60)).responseFormat(ResponseFormat.JSON).build();
    }
}
