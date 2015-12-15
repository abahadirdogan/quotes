package com.quotetrack.model;

public class TrackRuleEmailAction extends TrackRuleAction {
    private final String targetEmail;
    
    public TrackRuleEmailAction(String targetEmail) {
        this.targetEmail = targetEmail;
    }

    public String getTargetEmail() {
        return targetEmail;
    }
    
}
