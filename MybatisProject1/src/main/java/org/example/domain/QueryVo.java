package org.example.domain;

import java.util.List;

public class QueryVo {
    public User user;
    public List<Integer> Ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return Ids;
    }

    public void setIds(List<Integer> ids) {
        Ids = ids;
    }
}
