package com.lld.jirasystem.state;

public class TodoState implements IssueState{

    @Override
    public String getStatus() {
        return "TODO";
    }
}
