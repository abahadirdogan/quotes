package com.quotetrack.model;

import java.time.Duration;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FeedRuleLogAction extends FeedRuleAction {
    private static final Logger LOG = Logger.getLogger(FeedRuleLogAction.class.getName());

    public FeedRuleLogAction(FeedRuleActionType trackRuleActionType, Duration inactivityDuration, Date lastActivityTime) {
        super(trackRuleActionType, inactivityDuration, lastActivityTime);
    }
    
    @Override
    protected void task(final Quote quote, final FeedRule rule) {
        LOG.info(String.format("Rule with ID %s is matched for user(%s)", rule.getID(), rule.getUser().getName()));
        LOG.info("Rule : " + rule.toString());
        LOG.info("Quote : " + quote.toString());
    }
    
}
