package com.quotetrack.server.feedpublisher;

import com.quotetrack.model.Quote;

public class QuoteMessage extends Message {
    private Quote quote;

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
