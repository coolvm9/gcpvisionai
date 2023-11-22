package fusion.example.gcp;

import com.google.cloud.translate.v3.*;

import java.io.IOException;

public class TranslateText {



    // [START translate_v3_translate_text_1]
    // Set and pass variables to overloaded translateText() method for translation.
    public static String translateText(String inp) throws IOException {
        // TODO(developer): Replace these variables before running the sample.

        String testProjectId ="neat-vent-381323";
        // Supported Languages: https://cloud.google.com/translate/docs/languages
        String targetLanguage = "English";
        String text = "ஆயிரம் தோல்விகளை நீ ஒழ் இலப்புதில் அடைந்தாலும் சற்றும் அணைக்காத, போராட்ட குணம் ஒன்று உள்ளிடன் இருக்குமேயானால் இந்த உலகில் உன் போல வெற்றியாளன் இன்னும் உாைககில நன்றி ழங்தியர்";
        text = inp;
        return translateText(testProjectId, targetLanguage, text);
    }
    // [END translate_v3_translate_text_1]

    // [START translate_v3_translate_text_2]
    // Translate text to target language.
    public static String translateText(String projectId, String targetLanguage, String text)
            throws IOException {

        String res = " ::: ";
        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (TranslationServiceClient client = TranslationServiceClient.create()) {
            // Supported Locations: `global`, [glossary location], or [model location]
            // Glossaries must be hosted in `us-central1`
            // Custom Models must use the same location as your model. (us-central1)
            LocationName parent = LocationName.of(projectId, "global");

            // Supported Mime Types: https://cloud.google.com/translate/docs/supported-formats
            TranslateTextRequest request =
                    TranslateTextRequest.newBuilder()
                            .setParent(parent.toString())
                            .setMimeType("text/plain")
                            .setTargetLanguageCode("en")
                            .addContents(text)
                            .build();

            TranslateTextResponse response = client.translateText(request);
            // Display the translation for each input text provided
            for (Translation translation : response.getTranslationsList()) {
                res = res + " ::: " + translation.getTranslatedText();
                System.out.printf("Translated text : %s\n", res);
            }
        }
        return res;
    }
    // [END translate_v3_translate_text_2]
}
