package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0004\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u000e\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\u008d\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0003\u0010\u0004\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\u0016\b\u0003\u0010\u000e\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011HÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u0006/"}, d2 = {"Lcom/phisher98/DooflixLink;", "", "id", "", "movieId", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "movie_id", "host", "", "url", "quality", "size", "order", "createdAt", "created_at", "updatedAt", "updated_at", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getMovieId", "getHost", "()Ljava/lang/String;", "getUrl", "getQuality", "getSize", "getOrder", "getCreatedAt", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class DooflixLink {

    @NotNull
    private final String createdAt;

    @NotNull
    private final String host;
    private final long id;
    private final long movieId;
    private final long order;

    @NotNull
    private final String quality;

    @NotNull
    private final String size;

    @NotNull
    private final String updatedAt;

    @NotNull
    private final String url;

    public static /* synthetic */ DooflixLink copy$default(DooflixLink dooflixLink, long j, long j2, String str, String str2, String str3, String str4, long j3, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dooflixLink.id;
        }
        return dooflixLink.copy(j, (i & 2) != 0 ? dooflixLink.movieId : j2, (i & 4) != 0 ? dooflixLink.host : str, (i & 8) != 0 ? dooflixLink.url : str2, (i & 16) != 0 ? dooflixLink.quality : str3, (i & 32) != 0 ? dooflixLink.size : str4, (i & 64) != 0 ? dooflixLink.order : j3, (i & 128) != 0 ? dooflixLink.createdAt : str5, (i & 256) != 0 ? dooflixLink.updatedAt : str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMovieId() {
        return this.movieId;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getOrder() {
        return this.order;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @NotNull
    public final DooflixLink copy(long id, @JsonProperty("movie_id") long movieId, @NotNull String host, @NotNull String url, @NotNull String quality, @NotNull String size, long order, @JsonProperty("created_at") @NotNull String createdAt, @JsonProperty("updated_at") @NotNull String updatedAt) {
        return new DooflixLink(id, movieId, host, url, quality, size, order, createdAt, updatedAt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DooflixLink)) {
            return false;
        }
        DooflixLink dooflixLink = (DooflixLink) other;
        return this.id == dooflixLink.id && this.movieId == dooflixLink.movieId && Intrinsics.areEqual(this.host, dooflixLink.host) && Intrinsics.areEqual(this.url, dooflixLink.url) && Intrinsics.areEqual(this.quality, dooflixLink.quality) && Intrinsics.areEqual(this.size, dooflixLink.size) && this.order == dooflixLink.order && Intrinsics.areEqual(this.createdAt, dooflixLink.createdAt) && Intrinsics.areEqual(this.updatedAt, dooflixLink.updatedAt);
    }

    public int hashCode() {
        return (((((((((((((((DooflixLink$$ExternalSyntheticBackport0.m15m(this.id) * 31) + DooflixLink$$ExternalSyntheticBackport0.m15m(this.movieId)) * 31) + this.host.hashCode()) * 31) + this.url.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.size.hashCode()) * 31) + DooflixLink$$ExternalSyntheticBackport0.m15m(this.order)) * 31) + this.createdAt.hashCode()) * 31) + this.updatedAt.hashCode();
    }

    @NotNull
    public String toString() {
        return "DooflixLink(id=" + this.id + ", movieId=" + this.movieId + ", host=" + this.host + ", url=" + this.url + ", quality=" + this.quality + ", size=" + this.size + ", order=" + this.order + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ')';
    }

    public DooflixLink(long id, @JsonProperty("movie_id") long movieId, @NotNull String host, @NotNull String url, @NotNull String quality, @NotNull String size, long order, @JsonProperty("created_at") @NotNull String createdAt, @JsonProperty("updated_at") @NotNull String updatedAt) {
        this.id = id;
        this.movieId = movieId;
        this.host = host;
        this.url = url;
        this.quality = quality;
        this.size = size;
        this.order = order;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public final long getId() {
        return this.id;
    }

    public final long getMovieId() {
        return this.movieId;
    }

    @NotNull
    public final String getHost() {
        return this.host;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getQuality() {
        return this.quality;
    }

    @NotNull
    public final String getSize() {
        return this.size;
    }

    public final long getOrder() {
        return this.order;
    }

    @NotNull
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    public final String getUpdatedAt() {
        return this.updatedAt;
    }
}
