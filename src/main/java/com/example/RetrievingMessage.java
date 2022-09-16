package com.example;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.conversations.ConversationsHistoryResponse;
import com.slack.api.model.Message;

import java.io.IOException;

public class RetrievingMessage {

    /**
     * Fetch conversation history using the ID and a TS from the last example
     */
    static void fetchMessage(String id, String token) {
        // you can get this instance via ctx.client() in a Bolt app
        MethodsClient client = Slack.getInstance().methods();
        try {
            // Call the chat.postMessage method using the built-in WebClient
            ConversationsHistoryResponse result = client.conversationsHistory(r -> r
                // The token you used to initialize your app
                .token(token)
                .channel(id)
                // Limit results
                .inclusive(true)
                .limit(1)
            );
            // There should only be one result (stored in the zeroth index)
            Message message = result.getMessages().get(0);
            // Print message text
            System.out.println(String.format("%s,%s", message.getTs(), message.getText()));
        } catch (IOException | SlackApiException e) {
            
        }
    }

    public static void main(String[] args) throws Exception {
        fetchMessage(args[0], args[1]);
    }

}