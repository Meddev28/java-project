package com.smssender;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.ApiKey;
import com.infobip.BaseUrl;
import com.infobip.api.SmsApi;
import com.infobip.model.SmsAdvancedTextualRequest;
import com.infobip.model.SmsDestination;
import com.infobip.model.SmsTextualMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Collections;

public class SmsSenderController {

    @FXML
    private TextField recipientField;

    @FXML
    private TextArea messageArea;

    @FXML
    private Button sendButton;

    // Replace this with your actual API key and base URL
    private static final String API_KEY = "617c2118c40c1eba38ca9096d6ddd513-7884ce14-7f73-4aab-a050-345127620077";
    private static final String BASE_URL = "https://9lv12y.api.infobip.com";

    public void initialize() {
        // You can perform any initialization here
    }

    @FXML
    private void handleSendButton() {
        String recipient = recipientField.getText();
        String message = messageArea.getText();

        // Create the API client and the Send SMS API instances.
        ApiClient apiClient = ApiClient.forApiKey(ApiKey.from(API_KEY))
                .withBaseUrl(BaseUrl.from(BASE_URL))
                .build();
        SmsApi sendSmsApi = new SmsApi(apiClient);

        // Create a message to send.
        SmsTextualMessage smsMessage = new SmsTextualMessage();
        smsMessage.addDestinationsItem(new SmsDestination().to(recipient));
        smsMessage.text(message);

        // Create a send message request.
        SmsAdvancedTextualRequest smsMessageRequest = new SmsAdvancedTextualRequest();
        smsMessageRequest.setMessages(Collections.singletonList(smsMessage));

        try {
            // Send the message.
            com.infobip.model.SmsResponse smsResponse = sendSmsApi.sendSmsMessage(smsMessageRequest).execute();
            System.out.println("SMS sent successfully. Response: " + smsResponse);

            // You can add additional logic here, e.g., show a success message to the user
        } catch (ApiException e) {
            System.out.println("Failed to send SMS. HTTP status code: " + e.responseStatusCode());
            System.out.println("Response body: " + e.rawResponseBody());

            // You can add additional error handling logic here
        }
    }
}
