package translator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import translator.Application;
import translator.domain.TranslatedText;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TranslatorServiceTest {

    @Autowired
    TranslatorService translatorService;

    @Test
    public void translateTest() throws Exception {
        TranslatedText translatedText = translatorService.translate("en", "es", "This is a test of translation service");
        assertEquals("Esto es una prueba de servicio de traducción",translatedText.getTranslation());
    }

    @Test
    public void translateTestSpanishGerman() throws Exception {
        //Petition to the java class instead of the webservice to translate a simple text from spanish to german
        TranslatedText translatedText = translatorService.translate("es", "de", "Esto es una prueba sencilla");
        //Check that the text is translated as expected
        assertEquals("Dies ist ein einfacher test",translatedText.getTranslation());
    }

}
