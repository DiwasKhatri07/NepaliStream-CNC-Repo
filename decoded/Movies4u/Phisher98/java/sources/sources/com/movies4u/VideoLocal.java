package com.movies4u;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Movies4u/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018Jb\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/movies4u/VideoLocal;", "", "title", "", "season", "", "episode", "overview", "thumbnail", "released", "rating", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getTitle", "()Ljava/lang/String;", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "getOverview", "getThumbnail", "getReleased", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/movies4u/VideoLocal;", "equals", "", "other", "hashCode", "toString", "Movies4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VideoLocal {

    @Nullable
    private final Integer episode;

    @Nullable
    private final String overview;

    @Nullable
    private final Double rating;

    @Nullable
    private final String released;

    @Nullable
    private final Integer season;

    @Nullable
    private final String thumbnail;

    @Nullable
    private final String title;

    public VideoLocal() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ VideoLocal copy$default(VideoLocal videoLocal, String str, Integer num, Integer num2, String str2, String str3, String str4, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoLocal.title;
        }
        if ((i & 2) != 0) {
            num = videoLocal.season;
        }
        if ((i & 4) != 0) {
            num2 = videoLocal.episode;
        }
        if ((i & 8) != 0) {
            str2 = videoLocal.overview;
        }
        if ((i & 16) != 0) {
            str3 = videoLocal.thumbnail;
        }
        if ((i & 32) != 0) {
            str4 = videoLocal.released;
        }
        if ((i & 64) != 0) {
            d = videoLocal.rating;
        }
        String str5 = str4;
        Double d2 = d;
        String str6 = str3;
        Integer num3 = num2;
        return videoLocal.copy(str, num, num3, str2, str6, str5, d2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getEpisode() {
        return this.episode;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReleased() {
        return this.released;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getRating() {
        return this.rating;
    }

    @NotNull
    public final VideoLocal copy(@Nullable String title, @Nullable Integer season, @Nullable Integer episode, @Nullable String overview, @Nullable String thumbnail, @Nullable String released, @Nullable Double rating) {
        return new VideoLocal(title, season, episode, overview, thumbnail, released, rating);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoLocal)) {
            return false;
        }
        VideoLocal videoLocal = (VideoLocal) other;
        return Intrinsics.areEqual(this.title, videoLocal.title) && Intrinsics.areEqual(this.season, videoLocal.season) && Intrinsics.areEqual(this.episode, videoLocal.episode) && Intrinsics.areEqual(this.overview, videoLocal.overview) && Intrinsics.areEqual(this.thumbnail, videoLocal.thumbnail) && Intrinsics.areEqual(this.released, videoLocal.released) && Intrinsics.areEqual(this.rating, videoLocal.rating);
    }

    public int hashCode() {
        return ((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.rating != null ? this.rating.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VideoLocal(title=" + this.title + ", season=" + this.season + ", episode=" + this.episode + ", overview=" + this.overview + ", thumbnail=" + this.thumbnail + ", released=" + this.released + ", rating=" + this.rating + ')';
    }

    public VideoLocal(@Nullable String title, @Nullable Integer season, @Nullable Integer episode, @Nullable String overview, @Nullable String thumbnail, @Nullable String released, @Nullable Double rating) {
        this.title = title;
        this.season = season;
        this.episode = episode;
        this.overview = overview;
        this.thumbnail = thumbnail;
        this.released = released;
        this.rating = rating;
    }

    public /* synthetic */ VideoLocal(String str, Integer num, Integer num2, String str2, String str3, String str4, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : d);
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    public final Integer getEpisode() {
        return this.episode;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @Nullable
    public final String getReleased() {
        return this.released;
    }

    @Nullable
    public final Double getRating() {
        return this.rating;
    }
}
