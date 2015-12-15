package com.quotetrack.model;

public class FeedRule {
    private String ID;
    private User user;
    private String symbol;
    private FeedRuleCriteria trackRuleCriteria;
    private FeedRuleAction trackRuleAction;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public FeedRuleCriteria getTrackRuleCriteria() {
        return trackRuleCriteria;
    }

    public void setTrackRuleCriteria(FeedRuleCriteria trackRuleCriteria) {
        this.trackRuleCriteria = trackRuleCriteria;
    }

    public FeedRuleAction getTrackRuleAction() {
        return trackRuleAction;
    }

    public void setTrackRuleAction(FeedRuleAction trackRuleAction) {
        this.trackRuleAction = trackRuleAction;
    }
    
}
