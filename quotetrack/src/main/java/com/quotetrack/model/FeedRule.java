package com.quotetrack.model;

public class FeedRule {
    private String ID;
    private User user;
    private String symbol;
    private FeedRuleCriteria feedRuleCriteria;
    private FeedRuleAction feedRuleAction;

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

    public FeedRuleCriteria getFeedRuleCriteria() {
        return feedRuleCriteria;
    }

    public void setFeedRuleCriteria(FeedRuleCriteria trackRuleCriteria) {
        this.feedRuleCriteria = trackRuleCriteria;
    }

    public FeedRuleAction getFeedRuleAction() {
        return feedRuleAction;
    }

    public void setFeedRuleAction(FeedRuleAction trackRuleAction) {
        this.feedRuleAction = trackRuleAction;
    }
    
    public boolean match(final Quote quote) {
        if (!quote.getSymbol().equals(symbol))
            return false;
        if (!feedRuleCriteria.testCriteria(quote))
            return false;
        return true;
        
    }
    
}
