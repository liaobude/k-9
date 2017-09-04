
package com.fsck.k9.controller;


import java.util.List;

import android.content.Context;

import com.fsck.k9.Account;
import com.fsck.k9.AccountStats;
import com.fsck.k9.BaseAccount;
import com.fsck.k9.mail.Message;
import com.fsck.k9.mail.Part;
import com.fsck.k9.mailstore.LocalFolder;
import com.fsck.k9.mailstore.LocalMessage;


public interface MessagingListener {
    void searchStats(AccountStats stats);

    void accountStatusChanged(BaseAccount account, AccountStats stats);
    void accountSizeChanged(Account account, long oldSize, long newSize);

    void listFoldersStarted(Account account);
    void listFolders(Account account, List<LocalFolder> folders);
    void listFoldersFinished(Account account);
    void listFoldersFailed(Account account, String message);

    void listLocalMessagesAddMessages(Account account, String folderId, List<LocalMessage> messages);

    void synchronizeMailboxStarted(Account account, String folder);
    void synchronizeMailboxHeadersStarted(Account account, String folderId);
    void synchronizeMailboxHeadersProgress(Account account, String folderId, int completed, int total);
    void synchronizeMailboxHeadersFinished(Account account, String folderId, int totalMessagesInMailbox,
            int numNewMessages);
    void synchronizeMailboxProgress(Account account, String folderId, int completed, int total);
    void synchronizeMailboxNewMessage(Account account, String folderId, Message message);
    void synchronizeMailboxRemovedMessage(Account account, String folderId, Message message);
    void synchronizeMailboxFinished(Account account, String folderId, int totalMessagesInMailbox, int numNewMessages);
    void synchronizeMailboxFailed(Account account, String folderId, String message);

    void loadMessageRemoteFinished(Account account, String folderId, String uid);
    void loadMessageRemoteFailed(Account account, String folderId, String uid, Throwable t);

    void checkMailStarted(Context context, Account account);
    void checkMailFinished(Context context, Account account);

    void sendPendingMessagesStarted(Account account);
    void sendPendingMessagesCompleted(Account account);
    void sendPendingMessagesFailed(Account account);

    void emptyTrashCompleted(Account account);

    void folderStatusChanged(Account account, String folderId, int unreadMessageCount);
    void systemStatusChanged();

    void messageDeleted(Account account, String folderId, Message message);
    void messageUidChanged(Account account, String folderId, String oldUid, String newUid);

    void setPushActive(Account account, String folderId, boolean enabled);

    void loadAttachmentFinished(Account account, Message message, Part part);
    void loadAttachmentFailed(Account account, Message message, Part part, String reason);

    void pendingCommandStarted(Account account, String commandTitle);
    void pendingCommandsProcessing(Account account);
    void pendingCommandCompleted(Account account, String commandTitle);
    void pendingCommandsFinished(Account account);

    void remoteSearchStarted(String folderId);
    void remoteSearchServerQueryComplete(String folderId, int numResults, int maxResults);
    void remoteSearchFinished(String folderId, int numResults, int maxResults, List<Message> extraResults);
    void remoteSearchFailed(String folderId, String err);

    void enableProgressIndicator(boolean enable);

    void updateProgress(int progress);
}
