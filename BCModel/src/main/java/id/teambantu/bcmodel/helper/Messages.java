package id.teambantu.bcmodel.helper;

import id.teambantu.bcmodel.type.MessageSenderType;
import id.teambantu.bcmodel.type.MessageType;

public class Messages {
    private String id = "";
    private MessageSenderType senderType = MessageSenderType.NONE;
    private MessageType type = MessageType.NONE;
    private long createdAt = System.currentTimeMillis();
    private String imageUrl = "";
    private String messages = "";

    public Messages() {
    }

    public Messages(String id, MessageSenderType senderType, MessageType type, long createdAt, String imageUrl, String messages) {
        this.id = id;
        this.senderType = senderType;
        this.type = type;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
        this.messages = messages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MessageSenderType getSenderType() {
        return senderType;
    }

    public void setSenderType(MessageSenderType senderType) {
        this.senderType = senderType;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id='" + id + '\'' +
                ", senderType=" + senderType +
                ", type=" + type +
                ", createdAt=" + createdAt +
                ", imageUrl='" + imageUrl + '\'' +
                ", messages='" + messages + '\'' +
                '}';
    }
}
