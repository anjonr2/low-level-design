package com.lld.jirasystem.state;

import com.lld.jirasystem.observer.Issue;

public interface IssueState {
    String getStatus();
    void transitionTo(Issue issue, IssueState newState);
}
