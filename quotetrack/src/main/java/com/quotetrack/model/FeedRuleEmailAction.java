package com.quotetrack.model;

import java.time.Duration;
import java.util.Date;

public class FeedRuleEmailAction extends FeedRuleAction {
    private final String targetEmail;

    public FeedRuleEmailAction(FeedRuleActionType trackRuleActionType, Duration inactivityDuration, Date lastActivityTime, String targetEmail) {
        super(trackRuleActionType, inactivityDuration, lastActivityTime);
        this.targetEmail = targetEmail;
    }
    
    public String getTargetEmail() {
        return targetEmail;
    }

    @Override
    protected void task(final Quote quote, final FeedRule rule) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "FeedRuleEmailAction{" + "targetEmail=" + targetEmail + '}';
    }
    
    
    
}
