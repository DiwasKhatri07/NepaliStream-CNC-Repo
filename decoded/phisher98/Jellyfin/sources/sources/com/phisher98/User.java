package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JQ\u0010\u0014\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/phisher98/User;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Name", "serverId", "ServerId", "id", "Id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getServerId", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class User {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private final String serverId;

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = user.name;
        }
        if ((i & 2) != 0) {
            str2 = user.serverId;
        }
        if ((i & 4) != 0) {
            str3 = user.id;
        }
        return user.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getServerId() {
        return this.serverId;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final User copy(@JsonProperty("Name") @NotNull String name, @JsonProperty("ServerId") @NotNull String serverId, @JsonProperty("Id") @NotNull String id) {
        return new User(name, serverId, id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return Intrinsics.areEqual(this.name, user.name) && Intrinsics.areEqual(this.serverId, user.serverId) && Intrinsics.areEqual(this.id, user.id);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.serverId.hashCode()) * 31) + this.id.hashCode();
    }

    @NotNull
    public String toString() {
        return "User(name=" + this.name + ", serverId=" + this.serverId + ", id=" + this.id + ')';
    }

    public User(@JsonProperty("Name") @NotNull String name, @JsonProperty("ServerId") @NotNull String serverId, @JsonProperty("Id") @NotNull String id) {
        this.name = name;
        this.serverId = serverId;
        this.id = id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getServerId() {
        return this.serverId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }
}
