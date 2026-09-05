package com.MovieBlast;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MovieBlastParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MovieBlast/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001b\u0012\u0018\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001d\u0012\u0018\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001f¢\u0006\u0004\b \u0010!J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÌ\u0002\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001b2\u0018\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001d2\u0018\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001fHÆ\u0001¢\u0006\u0002\u0010HJ\u0014\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010L\u001a\u00020MHÖ\u0081\u0004J\n\u0010N\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b2\u0010#R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b5\u0010#R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&¨\u0006O"}, d2 = {"Lcom/MovieBlast/HomeDaum;", "", "id", "", "name", "", "posterPath", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "poster_path", "backdropPath", "backdrop_path", "backdropPathTv", "backdrop_path_tv", "voteAverage", "", "vote_average", "subtitle", "overview", "releaseDate", "release_date", "pinned", "createdAt", "created_at", "views", "type", "genreName", "genre_name", "recentViews", "recent_views", "contentType", "content_type", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getPosterPath", "getBackdropPath", "getBackdropPathTv", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSubtitle", "getOverview", "getReleaseDate", "getPinned", "getCreatedAt", "getViews", "getType", "getGenreName", "getRecentViews", "getContentType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/MovieBlast/HomeDaum;", "equals", "", "other", "hashCode", "", "toString", "MovieBlast"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HomeDaum {

    @Nullable
    private final String backdropPath;

    @Nullable
    private final String backdropPathTv;

    @Nullable
    private final String contentType;

    @Nullable
    private final String createdAt;

    @Nullable
    private final String genreName;

    @Nullable
    private final Long id;

    @Nullable
    private final String name;

    @Nullable
    private final String overview;

    @Nullable
    private final Long pinned;

    @Nullable
    private final String posterPath;

    @Nullable
    private final Long recentViews;

    @Nullable
    private final String releaseDate;

    @Nullable
    private final String subtitle;

    @Nullable
    private final String type;

    @Nullable
    private final Long views;

    @Nullable
    private final Double voteAverage;

    public HomeDaum() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public static /* synthetic */ HomeDaum copy$default(HomeDaum homeDaum, Long l, String str, String str2, String str3, String str4, Double d, String str5, String str6, String str7, Long l2, String str8, Long l3, String str9, String str10, Long l4, String str11, int i, Object obj) {
        Long l5 = (i & 1) != 0 ? homeDaum.id : l;
        return homeDaum.copy(l5, (i & 2) != 0 ? homeDaum.name : str, (i & 4) != 0 ? homeDaum.posterPath : str2, (i & 8) != 0 ? homeDaum.backdropPath : str3, (i & 16) != 0 ? homeDaum.backdropPathTv : str4, (i & 32) != 0 ? homeDaum.voteAverage : d, (i & 64) != 0 ? homeDaum.subtitle : str5, (i & 128) != 0 ? homeDaum.overview : str6, (i & 256) != 0 ? homeDaum.releaseDate : str7, (i & 512) != 0 ? homeDaum.pinned : l2, (i & 1024) != 0 ? homeDaum.createdAt : str8, (i & 2048) != 0 ? homeDaum.views : l3, (i & 4096) != 0 ? homeDaum.type : str9, (i & 8192) != 0 ? homeDaum.genreName : str10, (i & 16384) != 0 ? homeDaum.recentViews : l4, (i & 32768) != 0 ? homeDaum.contentType : str11);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getPinned() {
        return this.pinned;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Long getViews() {
        return this.views;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getGenreName() {
        return this.genreName;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Long getRecentViews() {
        return this.recentViews;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBackdropPath() {
        return this.backdropPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBackdropPathTv() {
        return this.backdropPathTv;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @NotNull
    public final HomeDaum copy(@Nullable Long id, @Nullable String name, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("backdrop_path_tv") @Nullable String backdropPathTv, @JsonProperty("vote_average") @Nullable Double voteAverage, @Nullable String subtitle, @Nullable String overview, @JsonProperty("release_date") @Nullable String releaseDate, @Nullable Long pinned, @JsonProperty("created_at") @Nullable String createdAt, @Nullable Long views, @Nullable String type, @JsonProperty("genre_name") @Nullable String genreName, @JsonProperty("recent_views") @Nullable Long recentViews, @JsonProperty("content_type") @Nullable String contentType) {
        return new HomeDaum(id, name, posterPath, backdropPath, backdropPathTv, voteAverage, subtitle, overview, releaseDate, pinned, createdAt, views, type, genreName, recentViews, contentType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeDaum)) {
            return false;
        }
        HomeDaum homeDaum = (HomeDaum) other;
        return Intrinsics.areEqual(this.id, homeDaum.id) && Intrinsics.areEqual(this.name, homeDaum.name) && Intrinsics.areEqual(this.posterPath, homeDaum.posterPath) && Intrinsics.areEqual(this.backdropPath, homeDaum.backdropPath) && Intrinsics.areEqual(this.backdropPathTv, homeDaum.backdropPathTv) && Intrinsics.areEqual(this.voteAverage, homeDaum.voteAverage) && Intrinsics.areEqual(this.subtitle, homeDaum.subtitle) && Intrinsics.areEqual(this.overview, homeDaum.overview) && Intrinsics.areEqual(this.releaseDate, homeDaum.releaseDate) && Intrinsics.areEqual(this.pinned, homeDaum.pinned) && Intrinsics.areEqual(this.createdAt, homeDaum.createdAt) && Intrinsics.areEqual(this.views, homeDaum.views) && Intrinsics.areEqual(this.type, homeDaum.type) && Intrinsics.areEqual(this.genreName, homeDaum.genreName) && Intrinsics.areEqual(this.recentViews, homeDaum.recentViews) && Intrinsics.areEqual(this.contentType, homeDaum.contentType);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.backdropPath == null ? 0 : this.backdropPath.hashCode())) * 31) + (this.backdropPathTv == null ? 0 : this.backdropPathTv.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.subtitle == null ? 0 : this.subtitle.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.pinned == null ? 0 : this.pinned.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.views == null ? 0 : this.views.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.genreName == null ? 0 : this.genreName.hashCode())) * 31) + (this.recentViews == null ? 0 : this.recentViews.hashCode())) * 31) + (this.contentType != null ? this.contentType.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HomeDaum(id=").append(this.id).append(", name=").append(this.name).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", backdropPathTv=").append(this.backdropPathTv).append(", voteAverage=").append(this.voteAverage).append(", subtitle=").append(this.subtitle).append(", overview=").append(this.overview).append(", releaseDate=").append(this.releaseDate).append(", pinned=").append(this.pinned).append(", createdAt=").append(this.createdAt).append(", views=");
        sb.append(this.views).append(", type=").append(this.type).append(", genreName=").append(this.genreName).append(", recentViews=").append(this.recentViews).append(", contentType=").append(this.contentType).append(')');
        return sb.toString();
    }

    public HomeDaum(@Nullable Long id, @Nullable String name, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("backdrop_path_tv") @Nullable String backdropPathTv, @JsonProperty("vote_average") @Nullable Double voteAverage, @Nullable String subtitle, @Nullable String overview, @JsonProperty("release_date") @Nullable String releaseDate, @Nullable Long pinned, @JsonProperty("created_at") @Nullable String createdAt, @Nullable Long views, @Nullable String type, @JsonProperty("genre_name") @Nullable String genreName, @JsonProperty("recent_views") @Nullable Long recentViews, @JsonProperty("content_type") @Nullable String contentType) {
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.backdropPathTv = backdropPathTv;
        this.voteAverage = voteAverage;
        this.subtitle = subtitle;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.pinned = pinned;
        this.createdAt = createdAt;
        this.views = views;
        this.type = type;
        this.genreName = genreName;
        this.recentViews = recentViews;
        this.contentType = contentType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HomeDaum(Long l, String str, String str2, String str3, String str4, Double d, String str5, String str6, String str7, Long l2, String str8, Long l3, String str9, String str10, Long l4, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Long l5 = (i & 1) != 0 ? null : l;
        String str12 = (i & 2) != 0 ? null : str;
        String str13 = (i & 4) != 0 ? null : str2;
        String str14 = (i & 8) != 0 ? null : str3;
        String str15 = (i & 16) != 0 ? null : str4;
        Double d2 = (i & 32) != 0 ? null : d;
        String str16 = (i & 64) != 0 ? null : str5;
        String str17 = (i & 128) != 0 ? null : str6;
        String str18 = (i & 256) != 0 ? null : str7;
        Long l6 = (i & 512) != 0 ? null : l2;
        String str19 = (i & 1024) != 0 ? null : str8;
        Long l7 = (i & 2048) != 0 ? null : l3;
        String str20 = (i & 4096) != 0 ? null : str9;
        String str21 = (i & 8192) != 0 ? null : str10;
        Long l8 = (i & 16384) != 0 ? null : l4;
        this(l5, str12, str13, str14, str15, d2, str16, str17, str18, l6, str19, l7, str20, str21, l8, (i & 32768) != 0 ? null : str11);
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    public final String getBackdropPath() {
        return this.backdropPath;
    }

    @Nullable
    public final String getBackdropPathTv() {
        return this.backdropPathTv;
    }

    @Nullable
    public final Double getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    public final Long getPinned() {
        return this.pinned;
    }

    @Nullable
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final Long getViews() {
        return this.views;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getGenreName() {
        return this.genreName;
    }

    @Nullable
    public final Long getRecentViews() {
        return this.recentViews;
    }

    @Nullable
    public final String getContentType() {
        return this.contentType;
    }
}
