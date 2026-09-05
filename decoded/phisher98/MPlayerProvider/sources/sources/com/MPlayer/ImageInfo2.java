package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/MPlayer/ImageInfo2;", "", "density", "", "width", "", "type", "url", "height", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;J)V", "getDensity", "()Ljava/lang/String;", "getWidth", "()J", "getType", "getUrl", "getHeight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ImageInfo2 {

    @NotNull
    private final String density;
    private final long height;

    @NotNull
    private final String type;

    @NotNull
    private final String url;
    private final long width;

    public static /* synthetic */ ImageInfo2 copy$default(ImageInfo2 imageInfo2, String str, long j, String str2, String str3, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageInfo2.density;
        }
        if ((i & 2) != 0) {
            j = imageInfo2.width;
        }
        if ((i & 4) != 0) {
            str2 = imageInfo2.type;
        }
        if ((i & 8) != 0) {
            str3 = imageInfo2.url;
        }
        if ((i & 16) != 0) {
            j2 = imageInfo2.height;
        }
        return imageInfo2.copy(str, j, str2, str3, j2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getWidth() {
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

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getHeight() {
        return this.height;
    }

    @NotNull
    public final ImageInfo2 copy(@NotNull String density, long width, @NotNull String type, @NotNull String url, long height) {
        return new ImageInfo2(density, width, type, url, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageInfo2)) {
            return false;
        }
        ImageInfo2 imageInfo2 = (ImageInfo2) other;
        return Intrinsics.areEqual(this.density, imageInfo2.density) && this.width == imageInfo2.width && Intrinsics.areEqual(this.type, imageInfo2.type) && Intrinsics.areEqual(this.url, imageInfo2.url) && this.height == imageInfo2.height;
    }

    public int hashCode() {
        return (((((((this.density.hashCode() * 31) + ImageInfo2$$ExternalSyntheticBackport0.m12m(this.width)) * 31) + this.type.hashCode()) * 31) + this.url.hashCode()) * 31) + ImageInfo2$$ExternalSyntheticBackport0.m12m(this.height);
    }

    @NotNull
    public String toString() {
        return "ImageInfo2(density=" + this.density + ", width=" + this.width + ", type=" + this.type + ", url=" + this.url + ", height=" + this.height + ')';
    }

    public ImageInfo2(@NotNull String density, long width, @NotNull String type, @NotNull String url, long height) {
        this.density = density;
        this.width = width;
        this.type = type;
        this.url = url;
        this.height = height;
    }

    @NotNull
    public final String getDensity() {
        return this.density;
    }

    public final long getWidth() {
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

    public final long getHeight() {
        return this.height;
    }
}
