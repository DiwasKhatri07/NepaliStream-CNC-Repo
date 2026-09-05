package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JG\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0014\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/MPlayer/MovieMxplay2;", "", "dash", "Lcom/MPlayer/MovieDash4;", "hls", "Lcom/MPlayer/MovieHls4;", "contentId", "", "validUntil", "offsetTime", "", "dvr", "", "<init>", "(Lcom/MPlayer/MovieDash4;Lcom/MPlayer/MovieHls4;Ljava/lang/String;Ljava/lang/Object;JZ)V", "getDash", "()Lcom/MPlayer/MovieDash4;", "getHls", "()Lcom/MPlayer/MovieHls4;", "getContentId", "()Ljava/lang/String;", "getValidUntil", "()Ljava/lang/Object;", "getOffsetTime", "()J", "getDvr", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieMxplay2 {

    @NotNull
    private final String contentId;

    @NotNull
    private final MovieDash4 dash;
    private final boolean dvr;

    @NotNull
    private final MovieHls4 hls;
    private final long offsetTime;

    @Nullable
    private final Object validUntil;

    public static /* synthetic */ MovieMxplay2 copy$default(MovieMxplay2 movieMxplay2, MovieDash4 movieDash4, MovieHls4 movieHls4, String str, Object obj, long j, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            movieDash4 = movieMxplay2.dash;
        }
        if ((i & 2) != 0) {
            movieHls4 = movieMxplay2.hls;
        }
        if ((i & 4) != 0) {
            str = movieMxplay2.contentId;
        }
        if ((i & 8) != 0) {
            obj = movieMxplay2.validUntil;
        }
        if ((i & 16) != 0) {
            j = movieMxplay2.offsetTime;
        }
        if ((i & 32) != 0) {
            z = movieMxplay2.dvr;
        }
        boolean z2 = z;
        long j2 = j;
        return movieMxplay2.copy(movieDash4, movieHls4, str, obj, j2, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MovieDash4 getDash() {
        return this.dash;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MovieHls4 getHls() {
        return this.hls;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContentId() {
        return this.contentId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Object getValidUntil() {
        return this.validUntil;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getOffsetTime() {
        return this.offsetTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getDvr() {
        return this.dvr;
    }

    @NotNull
    public final MovieMxplay2 copy(@NotNull MovieDash4 dash, @NotNull MovieHls4 hls, @NotNull String contentId, @Nullable Object validUntil, long offsetTime, boolean dvr) {
        return new MovieMxplay2(dash, hls, contentId, validUntil, offsetTime, dvr);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieMxplay2)) {
            return false;
        }
        MovieMxplay2 movieMxplay2 = (MovieMxplay2) other;
        return Intrinsics.areEqual(this.dash, movieMxplay2.dash) && Intrinsics.areEqual(this.hls, movieMxplay2.hls) && Intrinsics.areEqual(this.contentId, movieMxplay2.contentId) && Intrinsics.areEqual(this.validUntil, movieMxplay2.validUntil) && this.offsetTime == movieMxplay2.offsetTime && this.dvr == movieMxplay2.dvr;
    }

    public int hashCode() {
        return (((((((((this.dash.hashCode() * 31) + this.hls.hashCode()) * 31) + this.contentId.hashCode()) * 31) + (this.validUntil == null ? 0 : this.validUntil.hashCode())) * 31) + MovieMxplay2$$ExternalSyntheticBackport0.m23m(this.offsetTime)) * 31) + MovieMxplay2$$ExternalSyntheticBackport1.m24m(this.dvr);
    }

    @NotNull
    public String toString() {
        return "MovieMxplay2(dash=" + this.dash + ", hls=" + this.hls + ", contentId=" + this.contentId + ", validUntil=" + this.validUntil + ", offsetTime=" + this.offsetTime + ", dvr=" + this.dvr + ')';
    }

    public MovieMxplay2(@NotNull MovieDash4 dash, @NotNull MovieHls4 hls, @NotNull String contentId, @Nullable Object validUntil, long offsetTime, boolean dvr) {
        this.dash = dash;
        this.hls = hls;
        this.contentId = contentId;
        this.validUntil = validUntil;
        this.offsetTime = offsetTime;
        this.dvr = dvr;
    }

    @NotNull
    public final MovieDash4 getDash() {
        return this.dash;
    }

    @NotNull
    public final MovieHls4 getHls() {
        return this.hls;
    }

    @NotNull
    public final String getContentId() {
        return this.contentId;
    }

    @Nullable
    public final Object getValidUntil() {
        return this.validUntil;
    }

    public final long getOffsetTime() {
        return this.offsetTime;
    }

    public final boolean getDvr() {
        return this.dvr;
    }
}
