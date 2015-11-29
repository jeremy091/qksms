package com.orange.conversation.test;


import android.test.AndroidTestCase;
import android.content.ContentResolver;
import android.content.Context;

import com.moez.QKSMS.ExceedMessageSizeException;
import com.moez.QKSMS.common.google.DraftCache;
import com.moez.QKSMS.data.Contact;
import com.moez.QKSMS.data.ContactList;
import com.moez.QKSMS.data.Conversation;
import com.moez.QKSMS.data.ConversationQueryHandler;

import java.util.ArrayList;
import java.util.Collection;


public class ConversationTest extends AndroidTestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetWithContactListNormalExecution() throws Exception {
        Context context = getContext();
        boolean allowQuery = true;
        long threadId = 0;

        // The threadId passed within Cache.get(threadId) is set to null
        // Cache is a private inner class
        Conversation conv = Conversation.get(context, threadId, allowQuery);
        assertEquals(0, conv.getThreadId());

    }

    public void testStartDeleteWithConversationHandler() throws Exception {
        Context context = getContext();
        ContentResolver cr = context.getContentResolver();
        ConversationQueryHandler handler = new ConversationQueryHandler(cr);
        handler.setDeleteToken(0);
        ArrayList<Long> threadIDCollection = new ArrayList<Long>();
        long testLong = -1;
        threadIDCollection.add(testLong);
        DraftCache.init(context);
        Conversation.startDelete(handler, 3, false, threadIDCollection);

        assertEquals(3, handler.getmDeleteToken());
    }


}