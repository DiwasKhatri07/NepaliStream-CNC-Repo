package com.MovieBlast;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MovieBlastParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MovieBlast/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BË\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0018\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0018\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001a\u0012\u0018\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0018\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b( \u0012\u0018\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0011:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\"¢\u0006\u0004\b#\u0010$J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010F\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010:J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010.Jà\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001a2\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0018\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b( 2\u0018\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0011:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\"HÆ\u0001¢\u0006\u0002\u0010QJ\u0014\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010U\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010V\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010(R\u0015\u0010!\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010/\u001a\u0004\b>\u0010.¨\u0006W"}, d2 = {"Lcom/MovieBlast/Search;", "", "id", "", "name", "", "originalName", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "original_name", "posterPath", "poster_path", "backdropPath", "backdrop_path", "backdropPathTv", "backdrop_path_tv", "voteAverage", "", "vote_average", "subtitle", "overview", "releaseDate", "release_date", "pinned", "", "createdAt", "created_at", "updatedAt", "updated_at", "views", "type", "genreName", "genre_name", "matchScore", "match_score", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getOriginalName", "getPosterPath", "getBackdropPath", "getBackdropPathTv", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSubtitle", "()Ljava/lang/Object;", "getOverview", "getReleaseDate", "getPinned", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatedAt", "getUpdatedAt", "getViews", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "getGenreName", "getMatchScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/MovieBlast/Search;", "equals", "", "other", "hashCode", "toString", "MovieBlast"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Search {

    @Nullable
    private final String backdropPath;

    @Nullable
    private final String backdropPathTv;

    @Nullable
    private final String createdAt;

    @Nullable
    private final String genreName;
    private final long id;

    @Nullable
    private final Double matchScore;

    @NotNull
    private final String name;

    @Nullable
    private final String originalName;

    @Nullable
    private final String overview;

    @Nullable
    private final Integer pinned;

    @Nullable
    private final String posterPath;

    @Nullable
    private final String releaseDate;

    @Nullable
    private final Object subtitle;

    @NotNull
    private final String type;

    @Nullable
    private final String updatedAt;

    @Nullable
    private final Long views;

    @Nullable
    private final Double voteAverage;

    public static /* synthetic */ Search copy$default(Search search, long j, String str, String str2, String str3, String str4, String str5, Double d, Object obj, String str6, String str7, Integer num, String str8, String str9, Long l, String str10, String str11, Double d2, int i, Object obj2) {
        Double d3;
        String str12;
        long j2 = (i & 1) != 0 ? search.id : j;
        String str13 = (i & 2) != 0 ? search.name : str;
        String str14 = (i & 4) != 0 ? search.originalName : str2;
        String str15 = (i & 8) != 0 ? search.posterPath : str3;
        String str16 = (i & 16) != 0 ? search.backdropPath : str4;
        String str17 = (i & 32) != 0 ? search.backdropPathTv : str5;
        Double d4 = (i & 64) != 0 ? search.voteAverage : d;
        Object obj3 = (i & 128) != 0 ? search.subtitle : obj;
        String str18 = (i & 256) != 0 ? search.overview : str6;
        String str19 = (i & 512) != 0 ? search.releaseDate : str7;
        Integer num2 = (i & 1024) != 0 ? search.pinned : num;
        String str20 = (i & 2048) != 0 ? search.createdAt : str8;
        String str21 = (i & 4096) != 0 ? search.updatedAt : str9;
        long j3 = j2;
        Long l2 = (i & 8192) != 0 ? search.views : l;
        String str22 = (i & 16384) != 0 ? search.type : str10;
        String str23 = (i & 32768) != 0 ? search.genreName : str11;
        if ((i & 65536) != 0) {
            str12 = str23;
            d3 = search.matchScore;
        } else {
            d3 = d2;
            str12 = str23;
        }
        return search.copy(j3, str13, str14, str15, str16, str17, d4, obj3, str18, str19, num2, str20, str21, l2, str22, str12, d3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getPinned() {
        return this.pinned;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Long getViews() {
        return this.views;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getGenreName() {
        return this.genreName;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Double getMatchScore() {
        return this.matchScore;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOriginalName() {
        return this.originalName;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBackdropPath() {
        return this.backdropPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBackdropPathTv() {
        return this.backdropPathTv;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Object getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @NotNull
    public final Search copy(long id, @NotNull String name, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("backdrop_path_tv") @Nullable String backdropPathTv, @JsonProperty("vote_average") @Nullable Double voteAverage, @Nullable Object subtitle, @Nullable String overview, @JsonProperty("release_date") @Nullable String releaseDate, @Nullable Integer pinned, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt, @Nullable Long views, @NotNull String type, @JsonProperty("genre_name") @Nullable String genreName, @JsonProperty("match_score") @Nullable Double matchScore) {
        return new Search(id, name, originalName, posterPath, backdropPath, backdropPathTv, voteAverage, subtitle, overview, releaseDate, pinned, createdAt, updatedAt, views, type, genreName, matchScore);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Search)) {
            return false;
        }
        Search search = (Search) other;
        return this.id == search.id && Intrinsics.areEqual(this.name, search.name) && Intrinsics.areEqual(this.originalName, search.originalName) && Intrinsics.areEqual(this.posterPath, search.posterPath) && Intrinsics.areEqual(this.backdropPath, search.backdropPath) && Intrinsics.areEqual(this.backdropPathTv, search.backdropPathTv) && Intrinsics.areEqual(this.voteAverage, search.voteAverage) && Intrinsics.areEqual(this.subtitle, search.subtitle) && Intrinsics.areEqual(this.overview, search.overview) && Intrinsics.areEqual(this.releaseDate, search.releaseDate) && Intrinsics.areEqual(this.pinned, search.pinned) && Intrinsics.areEqual(this.createdAt, search.createdAt) && Intrinsics.areEqual(this.updatedAt, search.updatedAt) && Intrinsics.areEqual(this.views, search.views) && Intrinsics.areEqual(this.type, search.type) && Intrinsics.areEqual(this.genreName, search.genreName) && Intrinsics.areEqual(this.matchScore, search.matchScore);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((Search$$ExternalSyntheticBackport0.m0m(this.id) * 31) + this.name.hashCode()) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.backdropPath == null ? 0 : this.backdropPath.hashCode())) * 31) + (this.backdropPathTv == null ? 0 : this.backdropPathTv.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.subtitle == null ? 0 : this.subtitle.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.pinned == null ? 0 : this.pinned.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt == null ? 0 : this.updatedAt.hashCode())) * 31) + (this.views == null ? 0 : this.views.hashCode())) * 31) + this.type.hashCode()) * 31) + (this.genreName == null ? 0 : this.genreName.hashCode())) * 31) + (this.matchScore != null ? this.matchScore.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Search(id=").append(this.id).append(", name=").append(this.name).append(", originalName=").append(this.originalName).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", backdropPathTv=").append(this.backdropPathTv).append(", voteAverage=").append(this.voteAverage).append(", subtitle=").append(this.subtitle).append(", overview=").append(this.overview).append(", releaseDate=").append(this.releaseDate).append(", pinned=").append(this.pinned).append(", createdAt=");
        sb.append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(", views=").append(this.views).append(", type=").append(this.type).append(", genreName=").append(this.genreName).append(", matchScore=").append(this.matchScore).append(')');
        return sb.toString();
    }

    public Search(long id, @NotNull String name, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("backdrop_path_tv") @Nullable String backdropPathTv, @JsonProperty("vote_average") @Nullable Double voteAverage, @Nullable Object subtitle, @Nullable String overview, @JsonProperty("release_date") @Nullable String releaseDate, @Nullable Integer pinned, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt, @Nullable Long views, @NotNull String type, @JsonProperty("genre_name") @Nullable String genreName, @JsonProperty("match_score") @Nullable Double matchScore) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.backdropPathTv = backdropPathTv;
        this.voteAverage = voteAverage;
        this.subtitle = subtitle;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.pinned = pinned;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.views = views;
        this.type = type;
        this.genreName = genreName;
        this.matchScore = matchScore;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getOriginalName() {
        return this.originalName;
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
    public final Object getSubtitle() {
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
    public final Integer getPinned() {
        return this.pinned;
    }

    @Nullable
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    public final Long getViews() {
        return this.views;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getGenreName() {
        return this.genreName;
    }

    @Nullable
    public final Double getMatchScore() {
        return this.matchScore;
    }
}
