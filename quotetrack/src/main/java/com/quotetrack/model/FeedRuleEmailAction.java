package com.quotetrack.model;

public class FeedRuleEmailAction extends FeedRuleAction {
    private final String targetEmail;
    
    public FeedRuleEmailAction(String targetEmail) {
        this.targetEmail = targetEmail;
    }

    public String getTargetEmail() {
        return targetEmail;
    }

    @Override
    protected void task() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
