package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/MPlayer/MovieTrailerPreview;", "", "url", "", "previewImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getPreviewImage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieTrailerPreview {

    @NotNull
    private final String previewImage;

    @NotNull
    private final String url;

    public static /* synthetic */ MovieTrailerPreview copy$default(MovieTrailerPreview movieTrailerPreview, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = movieTrailerPreview.url;
        }
        if ((i & 2) != 0) {
            str2 = movieTrailerPreview.previewImage;
        }
        return movieTrailerPreview.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPreviewImage() {
        return this.previewImage;
    }

    @NotNull
    public final MovieTrailerPreview copy(@NotNull String url, @NotNull String previewImage) {
        return new MovieTrailerPreview(url, previewImage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieTrailerPreview)) {
            return false;
        }
        MovieTrailerPreview movieTrailerPreview = (MovieTrailerPreview) other;
        return Intrinsics.areEqual(this.url, movieTrailerPreview.url) && Intrinsics.areEqual(this.previewImage, movieTrailerPreview.previewImage);
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.previewImage.hashCode();
    }

    @NotNull
    public String toString() {
        return "MovieTrailerPreview(url=" + this.url + ", previewImage=" + this.previewImage + ')';
    }

    public MovieTrailerPreview(@NotNull String url, @NotNull String previewImage) {
        this.url = url;
        this.previewImage = previewImage;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getPreviewImage() {
        return this.previewImage;
    }
}
