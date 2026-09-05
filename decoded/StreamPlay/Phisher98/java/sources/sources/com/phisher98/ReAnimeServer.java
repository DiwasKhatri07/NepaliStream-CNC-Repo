package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\n\u001a\u00020\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003Ja\u0010\u001e\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u0016\b\u0003\u0010\n\u001a\u00020\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001J\u0014\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006$"}, d2 = {"Lcom/phisher98/ReAnimeServer;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "$id", "serverName", "dataLink", "dataType", "continue_field", "", "continue", "softsub", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()Ljava/lang/String;", "getServerName", "getDataLink", "getDataType", "getContinue_field", "()Z", "getSoftsub", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ReAnimeServer {
    private final boolean continue_field;

    @NotNull
    private final String dataLink;

    @NotNull
    private final String dataType;

    @NotNull
    private final String id;

    @NotNull
    private final String serverName;
    private final boolean softsub;

    public static /* synthetic */ ReAnimeServer copy$default(ReAnimeServer reAnimeServer, String str, String str2, String str3, String str4, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reAnimeServer.id;
        }
        if ((i & 2) != 0) {
            str2 = reAnimeServer.serverName;
        }
        if ((i & 4) != 0) {
            str3 = reAnimeServer.dataLink;
        }
        if ((i & 8) != 0) {
            str4 = reAnimeServer.dataType;
        }
        if ((i & 16) != 0) {
            z = reAnimeServer.continue_field;
        }
        if ((i & 32) != 0) {
            z2 = reAnimeServer.softsub;
        }
        boolean z3 = z;
        boolean z4 = z2;
        return reAnimeServer.copy(str, str2, str3, str4, z3, z4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getServerName() {
        return this.serverName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDataLink() {
        return this.dataLink;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDataType() {
        return this.dataType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getContinue_field() {
        return this.continue_field;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getSoftsub() {
        return this.softsub;
    }

    @NotNull
    public final ReAnimeServer copy(@JsonProperty("$id") @NotNull String id, @NotNull String serverName, @NotNull String dataLink, @NotNull String dataType, @JsonProperty("continue") boolean continue_field, boolean softsub) {
        return new ReAnimeServer(id, serverName, dataLink, dataType, continue_field, softsub);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReAnimeServer)) {
            return false;
        }
        ReAnimeServer reAnimeServer = (ReAnimeServer) other;
        return Intrinsics.areEqual(this.id, reAnimeServer.id) && Intrinsics.areEqual(this.serverName, reAnimeServer.serverName) && Intrinsics.areEqual(this.dataLink, reAnimeServer.dataLink) && Intrinsics.areEqual(this.dataType, reAnimeServer.dataType) && this.continue_field == reAnimeServer.continue_field && this.softsub == reAnimeServer.softsub;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.serverName.hashCode()) * 31) + this.dataLink.hashCode()) * 31) + this.dataType.hashCode()) * 31) + ReAnimeServer$$ExternalSyntheticBackport0.m20m(this.continue_field)) * 31) + ReAnimeServer$$ExternalSyntheticBackport0.m20m(this.softsub);
    }

    @NotNull
    public String toString() {
        return "ReAnimeServer(id=" + this.id + ", serverName=" + this.serverName + ", dataLink=" + this.dataLink + ", dataType=" + this.dataType + ", continue_field=" + this.continue_field + ", softsub=" + this.softsub + ')';
    }

    public ReAnimeServer(@JsonProperty("$id") @NotNull String id, @NotNull String serverName, @NotNull String dataLink, @NotNull String dataType, @JsonProperty("continue") boolean continue_field, boolean softsub) {
        this.id = id;
        this.serverName = serverName;
        this.dataLink = dataLink;
        this.dataType = dataType;
        this.continue_field = continue_field;
        this.softsub = softsub;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getServerName() {
        return this.serverName;
    }

    @NotNull
    public final String getDataLink() {
        return this.dataLink;
    }

    @NotNull
    public final String getDataType() {
        return this.dataType;
    }

    public final boolean getContinue_field() {
        return this.continue_field;
    }

    public final boolean getSoftsub() {
        return this.softsub;
    }
}
