package com.lld.jirasystem.state;

public class InProgressState implements IssueState{
    @Override
    public String getStatus() {
        return "IN_PROGRESS";
    }
}
