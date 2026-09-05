package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/MPlayer/MovieGifVideoUrlInfo;", "", "height", "", "width", "type", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeight", "()Ljava/lang/String;", "getWidth", "getType", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieGifVideoUrlInfo {

    @NotNull
    private final String height;

    @NotNull
    private final String type;

    @NotNull
    private final String url;

    @NotNull
    private final String width;

    public static /* synthetic */ MovieGifVideoUrlInfo copy$default(MovieGifVideoUrlInfo movieGifVideoUrlInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = movieGifVideoUrlInfo.height;
        }
        if ((i & 2) != 0) {
            str2 = movieGifVideoUrlInfo.width;
        }
        if ((i & 4) != 0) {
            str3 = movieGifVideoUrlInfo.type;
        }
        if ((i & 8) != 0) {
            str4 = movieGifVideoUrlInfo.url;
        }
        return movieGifVideoUrlInfo.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHeight() {
        return this.height;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getWidth() {
        return this.width;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final MovieGifVideoUrlInfo copy(@NotNull String height, @NotNull String width, @NotNull String type, @NotNull String url) {
        return new MovieGifVideoUrlInfo(height, width, type, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieGifVideoUrlInfo)) {
            return false;
        }
        MovieGifVideoUrlInfo movieGifVideoUrlInfo = (MovieGifVideoUrlInfo) other;
        return Intrinsics.areEqual(this.height, movieGifVideoUrlInfo.height) && Intrinsics.areEqual(this.width, movieGifVideoUrlInfo.width) && Intrinsics.areEqual(this.type, movieGifVideoUrlInfo.type) && Intrinsics.areEqual(this.url, movieGifVideoUrlInfo.url);
    }

    public int hashCode() {
        return (((((this.height.hashCode() * 31) + this.width.hashCode()) * 31) + this.type.hashCode()) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "MovieGifVideoUrlInfo(height=" + this.height + ", width=" + this.width + ", type=" + this.type + ", url=" + this.url + ')';
    }

    public MovieGifVideoUrlInfo(@NotNull String height, @NotNull String width, @NotNull String type, @NotNull String url) {
        this.height = height;
        this.width = width;
        this.type = type;
        this.url = url;
    }

    @NotNull
    public final String getHeight() {
        return this.height;
    }

    @NotNull
    public final String getWidth() {
        return this.width;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }
}
