package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\nHÆ\u0003JQ\u0010\u0016\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/phisher98/Authparser;", "", "accessToken", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "AccessToken", "serverId", "ServerId", "user", "Lcom/phisher98/User;", "User", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/User;)V", "getAccessToken", "()Ljava/lang/String;", "getServerId", "getUser", "()Lcom/phisher98/User;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Authparser {

    @NotNull
    private final String accessToken;

    @NotNull
    private final String serverId;

    @NotNull
    private final User user;

    public static /* synthetic */ Authparser copy$default(Authparser authparser, String str, String str2, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authparser.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = authparser.serverId;
        }
        if ((i & 4) != 0) {
            user = authparser.user;
        }
        return authparser.copy(str, str2, user);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getServerId() {
        return this.serverId;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final Authparser copy(@JsonProperty("AccessToken") @NotNull String accessToken, @JsonProperty("ServerId") @NotNull String serverId, @JsonProperty("User") @NotNull User user) {
        return new Authparser(accessToken, serverId, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Authparser)) {
            return false;
        }
        Authparser authparser = (Authparser) other;
        return Intrinsics.areEqual(this.accessToken, authparser.accessToken) && Intrinsics.areEqual(this.serverId, authparser.serverId) && Intrinsics.areEqual(this.user, authparser.user);
    }

    public int hashCode() {
        return (((this.accessToken.hashCode() * 31) + this.serverId.hashCode()) * 31) + this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "Authparser(accessToken=" + this.accessToken + ", serverId=" + this.serverId + ", user=" + this.user + ')';
    }

    public Authparser(@JsonProperty("AccessToken") @NotNull String accessToken, @JsonProperty("ServerId") @NotNull String serverId, @JsonProperty("User") @NotNull User user) {
        this.accessToken = accessToken;
        this.serverId = serverId;
        this.user = user;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final String getServerId() {
        return this.serverId;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }
}
