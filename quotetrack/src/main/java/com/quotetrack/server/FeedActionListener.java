/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotetrack.server;

import com.quotetrack.model.FeedRule;
import com.quotetrack.model.Quote;

public interface FeedActionListener {
    public void handleAction(final Quote quote, final FeedRule rule);
    
}
