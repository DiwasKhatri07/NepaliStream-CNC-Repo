package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u001e\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\rHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/MPlayer/ImageInfo;", "", "density", "", "width", "", "type", "url", "height", "genreIds", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "genre_ids", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getDensity", "()Ljava/lang/String;", "getWidth", "()J", "getType", "getUrl", "getHeight", "getGenreIds", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ImageInfo {

    @NotNull
    private final String density;

    @Nullable
    private final List<String> genreIds;
    private final long height;

    @NotNull
    private final String type;

    @NotNull
    private final String url;
    private final long width;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageInfo copy$default(ImageInfo imageInfo, String str, long j, String str2, String str3, long j2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageInfo.density;
        }
        if ((i & 2) != 0) {
            j = imageInfo.width;
        }
        if ((i & 4) != 0) {
            str2 = imageInfo.type;
        }
        if ((i & 8) != 0) {
            str3 = imageInfo.url;
        }
        if ((i & 16) != 0) {
            j2 = imageInfo.height;
        }
        if ((i & 32) != 0) {
            list = imageInfo.genreIds;
        }
        List list2 = list;
        return imageInfo.copy(str, j, str2, str3, j2, list2);
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

    @Nullable
    public final List<String> component6() {
        return this.genreIds;
    }

    @NotNull
    public final ImageInfo copy(@NotNull String density, long width, @NotNull String type, @NotNull String url, long height, @JsonProperty("genre_ids") @Nullable List<String> genreIds) {
        return new ImageInfo(density, width, type, url, height, genreIds);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageInfo)) {
            return false;
        }
        ImageInfo imageInfo = (ImageInfo) other;
        return Intrinsics.areEqual(this.density, imageInfo.density) && this.width == imageInfo.width && Intrinsics.areEqual(this.type, imageInfo.type) && Intrinsics.areEqual(this.url, imageInfo.url) && this.height == imageInfo.height && Intrinsics.areEqual(this.genreIds, imageInfo.genreIds);
    }

    public int hashCode() {
        return (((((((((this.density.hashCode() * 31) + ImageInfo$$ExternalSyntheticBackport0.m11m(this.width)) * 31) + this.type.hashCode()) * 31) + this.url.hashCode()) * 31) + ImageInfo$$ExternalSyntheticBackport0.m11m(this.height)) * 31) + (this.genreIds == null ? 0 : this.genreIds.hashCode());
    }

    @NotNull
    public String toString() {
        return "ImageInfo(density=" + this.density + ", width=" + this.width + ", type=" + this.type + ", url=" + this.url + ", height=" + this.height + ", genreIds=" + this.genreIds + ')';
    }

    public ImageInfo(@NotNull String density, long width, @NotNull String type, @NotNull String url, long height, @JsonProperty("genre_ids") @Nullable List<String> list) {
        this.density = density;
        this.width = width;
        this.type = type;
        this.url = url;
        this.height = height;
        this.genreIds = list;
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

    @Nullable
    public final List<String> getGenreIds() {
        return this.genreIds;
    }
}
