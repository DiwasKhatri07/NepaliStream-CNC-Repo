package com.idlix;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006'"}, d2 = {"Lcom/idlix/RedeemRes;", "", "kind", "", "claim", "redeemUrl", "videoId", "title", "durationSec", "", "viewerTier", "maxHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "getKind", "()Ljava/lang/String;", "getClaim", "getRedeemUrl", "getVideoId", "getTitle", "getDurationSec", "()J", "getViewerTier", "getMaxHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class RedeemRes {

    @NotNull
    private final String claim;
    private final long durationSec;

    @NotNull
    private final String kind;
    private final long maxHeight;

    @NotNull
    private final String redeemUrl;

    @NotNull
    private final String title;

    @NotNull
    private final String videoId;

    @NotNull
    private final String viewerTier;

    public static /* synthetic */ RedeemRes copy$default(RedeemRes redeemRes, String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = redeemRes.kind;
        }
        if ((i & 2) != 0) {
            str2 = redeemRes.claim;
        }
        if ((i & 4) != 0) {
            str3 = redeemRes.redeemUrl;
        }
        if ((i & 8) != 0) {
            str4 = redeemRes.videoId;
        }
        if ((i & 16) != 0) {
            str5 = redeemRes.title;
        }
        if ((i & 32) != 0) {
            j = redeemRes.durationSec;
        }
        if ((i & 64) != 0) {
            str6 = redeemRes.viewerTier;
        }
        if ((i & 128) != 0) {
            j2 = redeemRes.maxHeight;
        }
        String str7 = str6;
        long j3 = j;
        String str8 = str4;
        String str9 = str5;
        String str10 = str3;
        return redeemRes.copy(str, str2, str10, str8, str9, j3, str7, j2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClaim() {
        return this.claim;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRedeemUrl() {
        return this.redeemUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getDurationSec() {
        return this.durationSec;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getViewerTier() {
        return this.viewerTier;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getMaxHeight() {
        return this.maxHeight;
    }

    @NotNull
    public final RedeemRes copy(@NotNull String kind, @NotNull String claim, @NotNull String redeemUrl, @NotNull String videoId, @NotNull String title, long durationSec, @NotNull String viewerTier, long maxHeight) {
        return new RedeemRes(kind, claim, redeemUrl, videoId, title, durationSec, viewerTier, maxHeight);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RedeemRes)) {
            return false;
        }
        RedeemRes redeemRes = (RedeemRes) other;
        return Intrinsics.areEqual(this.kind, redeemRes.kind) && Intrinsics.areEqual(this.claim, redeemRes.claim) && Intrinsics.areEqual(this.redeemUrl, redeemRes.redeemUrl) && Intrinsics.areEqual(this.videoId, redeemRes.videoId) && Intrinsics.areEqual(this.title, redeemRes.title) && this.durationSec == redeemRes.durationSec && Intrinsics.areEqual(this.viewerTier, redeemRes.viewerTier) && this.maxHeight == redeemRes.maxHeight;
    }

    public int hashCode() {
        return (((((((((((((this.kind.hashCode() * 31) + this.claim.hashCode()) * 31) + this.redeemUrl.hashCode()) * 31) + this.videoId.hashCode()) * 31) + this.title.hashCode()) * 31) + RedeemRes$$ExternalSyntheticBackport0.m1m(this.durationSec)) * 31) + this.viewerTier.hashCode()) * 31) + RedeemRes$$ExternalSyntheticBackport0.m1m(this.maxHeight);
    }

    @NotNull
    public String toString() {
        return "RedeemRes(kind=" + this.kind + ", claim=" + this.claim + ", redeemUrl=" + this.redeemUrl + ", videoId=" + this.videoId + ", title=" + this.title + ", durationSec=" + this.durationSec + ", viewerTier=" + this.viewerTier + ", maxHeight=" + this.maxHeight + ')';
    }

    public RedeemRes(@NotNull String kind, @NotNull String claim, @NotNull String redeemUrl, @NotNull String videoId, @NotNull String title, long durationSec, @NotNull String viewerTier, long maxHeight) {
        this.kind = kind;
        this.claim = claim;
        this.redeemUrl = redeemUrl;
        this.videoId = videoId;
        this.title = title;
        this.durationSec = durationSec;
        this.viewerTier = viewerTier;
        this.maxHeight = maxHeight;
    }

    @NotNull
    public final String getKind() {
        return this.kind;
    }

    @NotNull
    public final String getClaim() {
        return this.claim;
    }

    @NotNull
    public final String getRedeemUrl() {
        return this.redeemUrl;
    }

    @NotNull
    public final String getVideoId() {
        return this.videoId;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final long getDurationSec() {
        return this.durationSec;
    }

    @NotNull
    public final String getViewerTier() {
        return this.viewerTier;
    }

    public final long getMaxHeight() {
        return this.maxHeight;
    }
}
