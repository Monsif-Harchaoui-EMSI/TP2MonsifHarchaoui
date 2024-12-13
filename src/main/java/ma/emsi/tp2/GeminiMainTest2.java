package ma.emsi.tp2;


import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.PromptTemplate;

import java.time.Duration;
import java.util.Map;

public class GeminiMainTest2 {
    public static void main(String[] args) {
        // Create the ChatLanguageModel
        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("Gemini_key"))
                .modelName("gemini-1.5-flash")
                .temperature(0.5)
                .timeout(Duration.ofSeconds(60))
                .responseFormat(ResponseFormat.TEXT) // Response should be plain text for translation
                .build();

        // Creer un PromptTemplate avec une variable pour text pour le traduire
        PromptTemplate promptTemplate = PromptTemplate.from("""
                Traduisez le texte suivant en anglais:                                                   
                Text: {{text}}
                Traduction:
                """);

        // Utilise template et passer variable dynamique
        String textATraduire = "Quel est la capitale de Zimbabwe?";
        String prompt = String.valueOf(promptTemplate.apply(Map.of("text", textATraduire)));

        // Generate the response using the model
        String response = model.generate(prompt);
        System.out.println("Traduction: " + response);
    }
}