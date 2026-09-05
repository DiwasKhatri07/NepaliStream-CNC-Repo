package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/phisher98/StreamPlayStremioAddon;", "", "id", "", "name", "", "url", "type", "Lcom/phisher98/StreamPlayStremioAddonType;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/phisher98/StreamPlayStremioAddonType;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getUrl", "getType", "()Lcom/phisher98/StreamPlayStremioAddonType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class StreamPlayStremioAddon {
    private final long id;

    @NotNull
    private final String name;

    @NotNull
    private final StreamPlayStremioAddonType type;

    @NotNull
    private final String url;

    public static /* synthetic */ StreamPlayStremioAddon copy$default(StreamPlayStremioAddon streamPlayStremioAddon, long j, String str, String str2, StreamPlayStremioAddonType streamPlayStremioAddonType, int i, Object obj) {
        if ((i & 1) != 0) {
            j = streamPlayStremioAddon.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = streamPlayStremioAddon.name;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = streamPlayStremioAddon.url;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            streamPlayStremioAddonType = streamPlayStremioAddon.type;
        }
        return streamPlayStremioAddon.copy(j2, str3, str4, streamPlayStremioAddonType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StreamPlayStremioAddonType getType() {
        return this.type;
    }

    @NotNull
    public final StreamPlayStremioAddon copy(long id, @NotNull String name, @NotNull String url, @NotNull StreamPlayStremioAddonType type) {
        return new StreamPlayStremioAddon(id, name, url, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamPlayStremioAddon)) {
            return false;
        }
        StreamPlayStremioAddon streamPlayStremioAddon = (StreamPlayStremioAddon) other;
        return this.id == streamPlayStremioAddon.id && Intrinsics.areEqual(this.name, streamPlayStremioAddon.name) && Intrinsics.areEqual(this.url, streamPlayStremioAddon.url) && this.type == streamPlayStremioAddon.type;
    }

    public int hashCode() {
        return (((((StreamPlayStremioAddon$$ExternalSyntheticBackport0.m29m(this.id) * 31) + this.name.hashCode()) * 31) + this.url.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "StreamPlayStremioAddon(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", type=" + this.type + ')';
    }

    public StreamPlayStremioAddon(long id, @NotNull String name, @NotNull String url, @NotNull StreamPlayStremioAddonType type) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.type = type;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final StreamPlayStremioAddonType getType() {
        return this.type;
    }
}
