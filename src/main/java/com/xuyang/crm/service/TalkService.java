package com.xuyang.crm.service;

import com.xuyang.crm.model.Talk;

import java.util.List;

public interface TalkService {

    public void insertTalk(Talk talk);

    public List<Talk> talkList(Talk talk);
}
