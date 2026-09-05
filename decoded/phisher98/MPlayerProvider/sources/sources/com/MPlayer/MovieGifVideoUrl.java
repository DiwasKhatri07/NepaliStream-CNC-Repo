package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/MPlayer/MovieGifVideoUrl;", "", "high", "", "base", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getHigh", "()Ljava/lang/String;", "getBase", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieGifVideoUrl {

    @NotNull
    private final String base;

    @NotNull
    private final String high;

    public static /* synthetic */ MovieGifVideoUrl copy$default(MovieGifVideoUrl movieGifVideoUrl, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = movieGifVideoUrl.high;
        }
        if ((i & 2) != 0) {
            str2 = movieGifVideoUrl.base;
        }
        return movieGifVideoUrl.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHigh() {
        return this.high;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBase() {
        return this.base;
    }

    @NotNull
    public final MovieGifVideoUrl copy(@NotNull String high, @NotNull String base) {
        return new MovieGifVideoUrl(high, base);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieGifVideoUrl)) {
            return false;
        }
        MovieGifVideoUrl movieGifVideoUrl = (MovieGifVideoUrl) other;
        return Intrinsics.areEqual(this.high, movieGifVideoUrl.high) && Intrinsics.areEqual(this.base, movieGifVideoUrl.base);
    }

    public int hashCode() {
        return (this.high.hashCode() * 31) + this.base.hashCode();
    }

    @NotNull
    public String toString() {
        return "MovieGifVideoUrl(high=" + this.high + ", base=" + this.base + ')';
    }

    public MovieGifVideoUrl(@NotNull String high, @NotNull String base) {
        this.high = high;
        this.base = base;
    }

    @NotNull
    public final String getHigh() {
        return this.high;
    }

    @NotNull
    public final String getBase() {
        return this.base;
    }
}
