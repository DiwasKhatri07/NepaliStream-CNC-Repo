package com.idlix;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IdlixProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÆ\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010BJ\u0014\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010F\u001a\u00020GHÖ\u0081\u0004J\n\u0010H\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001a¨\u0006I"}, d2 = {"Lcom/idlix/SearchApiResult;", "", "id", "", "contentType", "title", "originalTitle", "overview", "genres", "", "originalLanguage", "voteAverage", "", "viewCount", "", "popularity", "posterPath", "backdropPath", "slug", "firstAirDate", "numberOfSeasons", "releaseDate", "quality", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;DJDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getContentType", "getTitle", "getOriginalTitle", "getOverview", "getGenres", "()Ljava/util/List;", "getOriginalLanguage", "getVoteAverage", "()D", "getViewCount", "()J", "getPopularity", "getPosterPath", "getBackdropPath", "getSlug", "getFirstAirDate", "getNumberOfSeasons", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReleaseDate", "getQuality", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;DJDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/idlix/SearchApiResult;", "equals", "", "other", "hashCode", "", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SearchApiResult {

    @NotNull
    private final String backdropPath;

    @NotNull
    private final String contentType;

    @Nullable
    private final String firstAirDate;

    @NotNull
    private final List<String> genres;

    @NotNull
    private final String id;

    @Nullable
    private final Long numberOfSeasons;

    @NotNull
    private final String originalLanguage;

    @NotNull
    private final String originalTitle;

    @NotNull
    private final String overview;
    private final double popularity;

    @NotNull
    private final String posterPath;

    @Nullable
    private final String quality;

    @Nullable
    private final String releaseDate;

    @NotNull
    private final String slug;

    @NotNull
    private final String title;
    private final long viewCount;
    private final double voteAverage;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchApiResult copy$default(SearchApiResult searchApiResult, String str, String str2, String str3, String str4, String str5, List list, String str6, double d, long j, double d2, String str7, String str8, String str9, String str10, Long l, String str11, String str12, int i, Object obj) {
        String str13;
        String str14;
        String str15 = (i & 1) != 0 ? searchApiResult.id : str;
        String str16 = (i & 2) != 0 ? searchApiResult.contentType : str2;
        String str17 = (i & 4) != 0 ? searchApiResult.title : str3;
        String str18 = (i & 8) != 0 ? searchApiResult.originalTitle : str4;
        String str19 = (i & 16) != 0 ? searchApiResult.overview : str5;
        List list2 = (i & 32) != 0 ? searchApiResult.genres : list;
        String str20 = (i & 64) != 0 ? searchApiResult.originalLanguage : str6;
        double d3 = (i & 128) != 0 ? searchApiResult.voteAverage : d;
        long j2 = (i & 256) != 0 ? searchApiResult.viewCount : j;
        double d4 = (i & 512) != 0 ? searchApiResult.popularity : d2;
        String str21 = (i & 1024) != 0 ? searchApiResult.posterPath : str7;
        String str22 = str15;
        String str23 = (i & 2048) != 0 ? searchApiResult.backdropPath : str8;
        String str24 = (i & 4096) != 0 ? searchApiResult.slug : str9;
        String str25 = (i & 8192) != 0 ? searchApiResult.firstAirDate : str10;
        Long l2 = (i & 16384) != 0 ? searchApiResult.numberOfSeasons : l;
        String str26 = (i & 32768) != 0 ? searchApiResult.releaseDate : str11;
        if ((i & 65536) != 0) {
            str14 = str26;
            str13 = searchApiResult.quality;
        } else {
            str13 = str12;
            str14 = str26;
        }
        return searchApiResult.copy(str22, str16, str17, str18, str19, list2, str20, d3, j2, d4, str21, str23, str24, str25, l2, str14, str13);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final double getPopularity() {
        return this.popularity;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPosterPath() {
        return this.posterPath;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getBackdropPath() {
        return this.backdropPath;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getFirstAirDate() {
        return this.firstAirDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Long getNumberOfSeasons() {
        return this.numberOfSeasons;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @NotNull
    public final List<String> component6() {
        return this.genres;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOriginalLanguage() {
        return this.originalLanguage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final double getVoteAverage() {
        return this.voteAverage;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getViewCount() {
        return this.viewCount;
    }

    @NotNull
    public final SearchApiResult copy(@NotNull String id, @NotNull String contentType, @NotNull String title, @NotNull String originalTitle, @NotNull String overview, @NotNull List<String> genres, @NotNull String originalLanguage, double voteAverage, long viewCount, double popularity, @NotNull String posterPath, @NotNull String backdropPath, @NotNull String slug, @Nullable String firstAirDate, @Nullable Long numberOfSeasons, @Nullable String releaseDate, @Nullable String quality) {
        return new SearchApiResult(id, contentType, title, originalTitle, overview, genres, originalLanguage, voteAverage, viewCount, popularity, posterPath, backdropPath, slug, firstAirDate, numberOfSeasons, releaseDate, quality);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchApiResult)) {
            return false;
        }
        SearchApiResult searchApiResult = (SearchApiResult) other;
        return Intrinsics.areEqual(this.id, searchApiResult.id) && Intrinsics.areEqual(this.contentType, searchApiResult.contentType) && Intrinsics.areEqual(this.title, searchApiResult.title) && Intrinsics.areEqual(this.originalTitle, searchApiResult.originalTitle) && Intrinsics.areEqual(this.overview, searchApiResult.overview) && Intrinsics.areEqual(this.genres, searchApiResult.genres) && Intrinsics.areEqual(this.originalLanguage, searchApiResult.originalLanguage) && Double.compare(this.voteAverage, searchApiResult.voteAverage) == 0 && this.viewCount == searchApiResult.viewCount && Double.compare(this.popularity, searchApiResult.popularity) == 0 && Intrinsics.areEqual(this.posterPath, searchApiResult.posterPath) && Intrinsics.areEqual(this.backdropPath, searchApiResult.backdropPath) && Intrinsics.areEqual(this.slug, searchApiResult.slug) && Intrinsics.areEqual(this.firstAirDate, searchApiResult.firstAirDate) && Intrinsics.areEqual(this.numberOfSeasons, searchApiResult.numberOfSeasons) && Intrinsics.areEqual(this.releaseDate, searchApiResult.releaseDate) && Intrinsics.areEqual(this.quality, searchApiResult.quality);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.contentType.hashCode()) * 31) + this.title.hashCode()) * 31) + this.originalTitle.hashCode()) * 31) + this.overview.hashCode()) * 31) + this.genres.hashCode()) * 31) + this.originalLanguage.hashCode()) * 31) + SearchApiResult$$ExternalSyntheticBackport0.m4m(this.voteAverage)) * 31) + SearchApiResult$$ExternalSyntheticBackport1.m5m(this.viewCount)) * 31) + SearchApiResult$$ExternalSyntheticBackport0.m4m(this.popularity)) * 31) + this.posterPath.hashCode()) * 31) + this.backdropPath.hashCode()) * 31) + this.slug.hashCode()) * 31) + (this.firstAirDate == null ? 0 : this.firstAirDate.hashCode())) * 31) + (this.numberOfSeasons == null ? 0 : this.numberOfSeasons.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.quality != null ? this.quality.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchApiResult(id=").append(this.id).append(", contentType=").append(this.contentType).append(", title=").append(this.title).append(", originalTitle=").append(this.originalTitle).append(", overview=").append(this.overview).append(", genres=").append(this.genres).append(", originalLanguage=").append(this.originalLanguage).append(", voteAverage=").append(this.voteAverage).append(", viewCount=").append(this.viewCount).append(", popularity=").append(this.popularity).append(", posterPath=").append(this.posterPath).append(", backdropPath=");
        sb.append(this.backdropPath).append(", slug=").append(this.slug).append(", firstAirDate=").append(this.firstAirDate).append(", numberOfSeasons=").append(this.numberOfSeasons).append(", releaseDate=").append(this.releaseDate).append(", quality=").append(this.quality).append(')');
        return sb.toString();
    }

    public SearchApiResult(@NotNull String id, @NotNull String contentType, @NotNull String title, @NotNull String originalTitle, @NotNull String overview, @NotNull List<String> list, @NotNull String originalLanguage, double voteAverage, long viewCount, double popularity, @NotNull String posterPath, @NotNull String backdropPath, @NotNull String slug, @Nullable String firstAirDate, @Nullable Long numberOfSeasons, @Nullable String releaseDate, @Nullable String quality) {
        this.id = id;
        this.contentType = contentType;
        this.title = title;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.genres = list;
        this.originalLanguage = originalLanguage;
        this.voteAverage = voteAverage;
        this.viewCount = viewCount;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.slug = slug;
        this.firstAirDate = firstAirDate;
        this.numberOfSeasons = numberOfSeasons;
        this.releaseDate = releaseDate;
        this.quality = quality;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getContentType() {
        return this.contentType;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @NotNull
    public final String getOverview() {
        return this.overview;
    }

    @NotNull
    public final List<String> getGenres() {
        return this.genres;
    }

    @NotNull
    public final String getOriginalLanguage() {
        return this.originalLanguage;
    }

    public final double getVoteAverage() {
        return this.voteAverage;
    }

    public final long getViewCount() {
        return this.viewCount;
    }

    public final double getPopularity() {
        return this.popularity;
    }

    @NotNull
    public final String getPosterPath() {
        return this.posterPath;
    }

    @NotNull
    public final String getBackdropPath() {
        return this.backdropPath;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final String getFirstAirDate() {
        return this.firstAirDate;
    }

    @Nullable
    public final Long getNumberOfSeasons() {
        return this.numberOfSeasons;
    }

    @Nullable
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    public final String getQuality() {
        return this.quality;
    }
}
