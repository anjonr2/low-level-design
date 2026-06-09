package com.lld.jirasystem.state;

public class DoneState implements IssueState{
    @Override
    public String getStatus() {
        return "DONE";
    }
}
