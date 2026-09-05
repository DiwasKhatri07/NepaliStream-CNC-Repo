package com.Anichi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JN\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006%"}, d2 = {"Lcom/Anichi/AnichiDownloadLink;", "", "link", "", "hls", "", "mp4", "resolutionStr", "priority", "", "src", "<init>", "(Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;JLjava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getHls", "()Z", "getMp4", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResolutionStr", "getPriority", "()J", "getSrc", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;JLjava/lang/String;)Lcom/Anichi/AnichiDownloadLink;", "equals", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiDownloadLink {
    private final boolean hls;

    @NotNull
    private final String link;

    @Nullable
    private final Boolean mp4;
    private final long priority;

    @NotNull
    private final String resolutionStr;

    @Nullable
    private final String src;

    public static /* synthetic */ AnichiDownloadLink copy$default(AnichiDownloadLink anichiDownloadLink, String str, boolean z, Boolean bool, String str2, long j, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = anichiDownloadLink.link;
        }
        if ((i & 2) != 0) {
            z = anichiDownloadLink.hls;
        }
        if ((i & 4) != 0) {
            bool = anichiDownloadLink.mp4;
        }
        if ((i & 8) != 0) {
            str2 = anichiDownloadLink.resolutionStr;
        }
        if ((i & 16) != 0) {
            j = anichiDownloadLink.priority;
        }
        if ((i & 32) != 0) {
            str3 = anichiDownloadLink.src;
        }
        String str4 = str3;
        long j2 = j;
        return anichiDownloadLink.copy(str, z, bool, str2, j2, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHls() {
        return this.hls;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getMp4() {
        return this.mp4;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getResolutionStr() {
        return this.resolutionStr;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getPriority() {
        return this.priority;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    @NotNull
    public final AnichiDownloadLink copy(@NotNull String link, boolean hls, @Nullable Boolean mp4, @NotNull String resolutionStr, long priority, @Nullable String src) {
        return new AnichiDownloadLink(link, hls, mp4, resolutionStr, priority, src);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnichiDownloadLink)) {
            return false;
        }
        AnichiDownloadLink anichiDownloadLink = (AnichiDownloadLink) other;
        return Intrinsics.areEqual(this.link, anichiDownloadLink.link) && this.hls == anichiDownloadLink.hls && Intrinsics.areEqual(this.mp4, anichiDownloadLink.mp4) && Intrinsics.areEqual(this.resolutionStr, anichiDownloadLink.resolutionStr) && this.priority == anichiDownloadLink.priority && Intrinsics.areEqual(this.src, anichiDownloadLink.src);
    }

    public int hashCode() {
        return (((((((((this.link.hashCode() * 31) + AnichiDownloadLink$$ExternalSyntheticBackport0.m0m(this.hls)) * 31) + (this.mp4 == null ? 0 : this.mp4.hashCode())) * 31) + this.resolutionStr.hashCode()) * 31) + AnichiDownloadLink$$ExternalSyntheticBackport1.m1m(this.priority)) * 31) + (this.src != null ? this.src.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnichiDownloadLink(link=" + this.link + ", hls=" + this.hls + ", mp4=" + this.mp4 + ", resolutionStr=" + this.resolutionStr + ", priority=" + this.priority + ", src=" + this.src + ')';
    }

    public AnichiDownloadLink(@NotNull String link, boolean hls, @Nullable Boolean mp4, @NotNull String resolutionStr, long priority, @Nullable String src) {
        this.link = link;
        this.hls = hls;
        this.mp4 = mp4;
        this.resolutionStr = resolutionStr;
        this.priority = priority;
        this.src = src;
    }

    @NotNull
    public final String getLink() {
        return this.link;
    }

    public final boolean getHls() {
        return this.hls;
    }

    @Nullable
    public final Boolean getMp4() {
        return this.mp4;
    }

    @NotNull
    public final String getResolutionStr() {
        return this.resolutionStr;
    }

    public final long getPriority() {
        return this.priority;
    }

    @Nullable
    public final String getSrc() {
        return this.src;
    }
}
