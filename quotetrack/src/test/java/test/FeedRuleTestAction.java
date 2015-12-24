/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.quotetrack.model.FeedRule;
import com.quotetrack.model.FeedRuleAction;
import com.quotetrack.model.FeedRuleActionType;
import com.quotetrack.model.Quote;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author bd
 */
public class FeedRuleTestAction extends FeedRuleAction {
    public CountDownLatch counter;

    public FeedRuleTestAction (CountDownLatch counter, FeedRuleActionType trackRuleActionType, Duration inactivityDuration, Date lastActivityTime) {
        super(trackRuleActionType, inactivityDuration, lastActivityTime);
        this.counter = counter;
    }
    @Override
    protected void task(Quote quote, FeedRule rule) {
        counter.countDown();
    }
    
}
