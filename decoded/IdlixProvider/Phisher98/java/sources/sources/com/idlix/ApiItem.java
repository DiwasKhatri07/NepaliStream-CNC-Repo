package com.idlix;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IdlixProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b<\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010P\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u00109J\u009c\u0002\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010RJ\u0014\u0010S\u001a\u00020\u001b2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010U\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010V\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010.\u001a\u0004\b0\u0010-R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010.\u001a\u0004\b1\u0010-R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010.\u001a\u0004\b3\u0010-R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010:\u001a\u0004\b\u001c\u00109¨\u0006W"}, d2 = {"Lcom/idlix/ApiItem;", "", "id", "", "title", "slug", "posterPath", "backdropPath", "releaseDate", "firstAirDate", "voteAverage", "viewCount", "quality", "country", "runtime", "", "createdAt", "numberOfSeasons", "numberOfEpisodes", "contentType", "commentCount", "originalLanguage", "popularity", "genres", "", "Lcom/idlix/APIGenre;", "hasVideo", "", "isPublished", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getTitle", "getSlug", "getPosterPath", "getBackdropPath", "getReleaseDate", "getFirstAirDate", "getVoteAverage", "getViewCount", "()Ljava/lang/Object;", "getQuality", "getCountry", "getRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatedAt", "getNumberOfSeasons", "getNumberOfEpisodes", "getContentType", "getCommentCount", "getOriginalLanguage", "getPopularity", "getGenres", "()Ljava/util/List;", "getHasVideo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/idlix/ApiItem;", "equals", "other", "hashCode", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ApiItem {

    @Nullable
    private final String backdropPath;

    @Nullable
    private final Integer commentCount;

    @Nullable
    private final String contentType;

    @Nullable
    private final String country;

    @Nullable
    private final String createdAt;

    @Nullable
    private final String firstAirDate;

    @Nullable
    private final List<APIGenre> genres;

    @Nullable
    private final Boolean hasVideo;

    @Nullable
    private final String id;

    @Nullable
    private final Boolean isPublished;

    @Nullable
    private final Integer numberOfEpisodes;

    @Nullable
    private final Integer numberOfSeasons;

    @Nullable
    private final String originalLanguage;

    @Nullable
    private final Object popularity;

    @Nullable
    private final String posterPath;

    @Nullable
    private final String quality;

    @Nullable
    private final String releaseDate;

    @Nullable
    private final Integer runtime;

    @Nullable
    private final String slug;

    @Nullable
    private final String title;

    @Nullable
    private final Object viewCount;

    @Nullable
    private final String voteAverage;

    public ApiItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiItem copy$default(ApiItem apiItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Object obj, String str9, String str10, Integer num, String str11, Integer num2, Integer num3, String str12, Integer num4, String str13, Object obj2, List list, Boolean bool, Boolean bool2, int i, Object obj3) {
        Boolean bool3;
        Boolean bool4;
        String str14 = (i & 1) != 0 ? apiItem.id : str;
        String str15 = (i & 2) != 0 ? apiItem.title : str2;
        String str16 = (i & 4) != 0 ? apiItem.slug : str3;
        String str17 = (i & 8) != 0 ? apiItem.posterPath : str4;
        String str18 = (i & 16) != 0 ? apiItem.backdropPath : str5;
        String str19 = (i & 32) != 0 ? apiItem.releaseDate : str6;
        String str20 = (i & 64) != 0 ? apiItem.firstAirDate : str7;
        String str21 = (i & 128) != 0 ? apiItem.voteAverage : str8;
        Object obj4 = (i & 256) != 0 ? apiItem.viewCount : obj;
        String str22 = (i & 512) != 0 ? apiItem.quality : str9;
        String str23 = (i & 1024) != 0 ? apiItem.country : str10;
        Integer num5 = (i & 2048) != 0 ? apiItem.runtime : num;
        String str24 = (i & 4096) != 0 ? apiItem.createdAt : str11;
        Integer num6 = (i & 8192) != 0 ? apiItem.numberOfSeasons : num2;
        String str25 = str14;
        Integer num7 = (i & 16384) != 0 ? apiItem.numberOfEpisodes : num3;
        String str26 = (i & 32768) != 0 ? apiItem.contentType : str12;
        Integer num8 = (i & 65536) != 0 ? apiItem.commentCount : num4;
        String str27 = (i & 131072) != 0 ? apiItem.originalLanguage : str13;
        Object obj5 = (i & 262144) != 0 ? apiItem.popularity : obj2;
        List list2 = (i & 524288) != 0 ? apiItem.genres : list;
        Boolean bool5 = (i & 1048576) != 0 ? apiItem.hasVideo : bool;
        if ((i & 2097152) != 0) {
            bool4 = bool5;
            bool3 = apiItem.isPublished;
        } else {
            bool3 = bool2;
            bool4 = bool5;
        }
        return apiItem.copy(str25, str15, str16, str17, str18, str19, str20, str21, obj4, str22, str23, num5, str24, num6, num7, str26, num8, str27, obj5, list2, bool4, bool3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getNumberOfSeasons() {
        return this.numberOfSeasons;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getNumberOfEpisodes() {
        return this.numberOfEpisodes;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getCommentCount() {
        return this.commentCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getOriginalLanguage() {
        return this.originalLanguage;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Object getPopularity() {
        return this.popularity;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<APIGenre> component20() {
        return this.genres;
    }

    @Nullable
    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Boolean getHasVideo() {
        return this.hasVideo;
    }

    @Nullable
    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Boolean getIsPublished() {
        return this.isPublished;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSlug() {
        return this.slug;
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
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFirstAirDate() {
        return this.firstAirDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Object getViewCount() {
        return this.viewCount;
    }

    @NotNull
    public final ApiItem copy(@Nullable String id, @Nullable String title, @Nullable String slug, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String releaseDate, @Nullable String firstAirDate, @Nullable String voteAverage, @Nullable Object viewCount, @Nullable String quality, @Nullable String country, @Nullable Integer runtime, @Nullable String createdAt, @Nullable Integer numberOfSeasons, @Nullable Integer numberOfEpisodes, @Nullable String contentType, @Nullable Integer commentCount, @Nullable String originalLanguage, @Nullable Object popularity, @Nullable List<APIGenre> genres, @Nullable Boolean hasVideo, @Nullable Boolean isPublished) {
        return new ApiItem(id, title, slug, posterPath, backdropPath, releaseDate, firstAirDate, voteAverage, viewCount, quality, country, runtime, createdAt, numberOfSeasons, numberOfEpisodes, contentType, commentCount, originalLanguage, popularity, genres, hasVideo, isPublished);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiItem)) {
            return false;
        }
        ApiItem apiItem = (ApiItem) other;
        return Intrinsics.areEqual(this.id, apiItem.id) && Intrinsics.areEqual(this.title, apiItem.title) && Intrinsics.areEqual(this.slug, apiItem.slug) && Intrinsics.areEqual(this.posterPath, apiItem.posterPath) && Intrinsics.areEqual(this.backdropPath, apiItem.backdropPath) && Intrinsics.areEqual(this.releaseDate, apiItem.releaseDate) && Intrinsics.areEqual(this.firstAirDate, apiItem.firstAirDate) && Intrinsics.areEqual(this.voteAverage, apiItem.voteAverage) && Intrinsics.areEqual(this.viewCount, apiItem.viewCount) && Intrinsics.areEqual(this.quality, apiItem.quality) && Intrinsics.areEqual(this.country, apiItem.country) && Intrinsics.areEqual(this.runtime, apiItem.runtime) && Intrinsics.areEqual(this.createdAt, apiItem.createdAt) && Intrinsics.areEqual(this.numberOfSeasons, apiItem.numberOfSeasons) && Intrinsics.areEqual(this.numberOfEpisodes, apiItem.numberOfEpisodes) && Intrinsics.areEqual(this.contentType, apiItem.contentType) && Intrinsics.areEqual(this.commentCount, apiItem.commentCount) && Intrinsics.areEqual(this.originalLanguage, apiItem.originalLanguage) && Intrinsics.areEqual(this.popularity, apiItem.popularity) && Intrinsics.areEqual(this.genres, apiItem.genres) && Intrinsics.areEqual(this.hasVideo, apiItem.hasVideo) && Intrinsics.areEqual(this.isPublished, apiItem.isPublished);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.backdropPath == null ? 0 : this.backdropPath.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.firstAirDate == null ? 0 : this.firstAirDate.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.viewCount == null ? 0 : this.viewCount.hashCode())) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.numberOfSeasons == null ? 0 : this.numberOfSeasons.hashCode())) * 31) + (this.numberOfEpisodes == null ? 0 : this.numberOfEpisodes.hashCode())) * 31) + (this.contentType == null ? 0 : this.contentType.hashCode())) * 31) + (this.commentCount == null ? 0 : this.commentCount.hashCode())) * 31) + (this.originalLanguage == null ? 0 : this.originalLanguage.hashCode())) * 31) + (this.popularity == null ? 0 : this.popularity.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.hasVideo == null ? 0 : this.hasVideo.hashCode())) * 31) + (this.isPublished != null ? this.isPublished.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApiItem(id=").append(this.id).append(", title=").append(this.title).append(", slug=").append(this.slug).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", releaseDate=").append(this.releaseDate).append(", firstAirDate=").append(this.firstAirDate).append(", voteAverage=").append(this.voteAverage).append(", viewCount=").append(this.viewCount).append(", quality=").append(this.quality).append(", country=").append(this.country).append(", runtime=");
        sb.append(this.runtime).append(", createdAt=").append(this.createdAt).append(", numberOfSeasons=").append(this.numberOfSeasons).append(", numberOfEpisodes=").append(this.numberOfEpisodes).append(", contentType=").append(this.contentType).append(", commentCount=").append(this.commentCount).append(", originalLanguage=").append(this.originalLanguage).append(", popularity=").append(this.popularity).append(", genres=").append(this.genres).append(", hasVideo=").append(this.hasVideo).append(", isPublished=").append(this.isPublished).append(')');
        return sb.toString();
    }

    public ApiItem(@Nullable String id, @Nullable String title, @Nullable String slug, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String releaseDate, @Nullable String firstAirDate, @Nullable String voteAverage, @Nullable Object viewCount, @Nullable String quality, @Nullable String country, @Nullable Integer runtime, @Nullable String createdAt, @Nullable Integer numberOfSeasons, @Nullable Integer numberOfEpisodes, @Nullable String contentType, @Nullable Integer commentCount, @Nullable String originalLanguage, @Nullable Object popularity, @Nullable List<APIGenre> list, @Nullable Boolean hasVideo, @Nullable Boolean isPublished) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.releaseDate = releaseDate;
        this.firstAirDate = firstAirDate;
        this.voteAverage = voteAverage;
        this.viewCount = viewCount;
        this.quality = quality;
        this.country = country;
        this.runtime = runtime;
        this.createdAt = createdAt;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
        this.contentType = contentType;
        this.commentCount = commentCount;
        this.originalLanguage = originalLanguage;
        this.popularity = popularity;
        this.genres = list;
        this.hasVideo = hasVideo;
        this.isPublished = isPublished;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ApiItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Object obj, String str9, String str10, Integer num, String str11, Integer num2, Integer num3, String str12, Integer num4, String str13, Object obj2, List list, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str14 = (i & 1) != 0 ? null : str;
        String str15 = (i & 2) != 0 ? null : str2;
        String str16 = (i & 4) != 0 ? null : str3;
        String str17 = (i & 8) != 0 ? null : str4;
        String str18 = (i & 16) != 0 ? null : str5;
        String str19 = (i & 32) != 0 ? null : str6;
        String str20 = (i & 64) != 0 ? null : str7;
        String str21 = (i & 128) != 0 ? null : str8;
        Object obj3 = (i & 256) != 0 ? null : obj;
        String str22 = (i & 512) != 0 ? null : str9;
        String str23 = (i & 1024) != 0 ? null : str10;
        Integer num5 = (i & 2048) != 0 ? null : num;
        String str24 = (i & 4096) != 0 ? null : str11;
        Integer num6 = (i & 8192) != 0 ? null : num2;
        Integer num7 = (i & 16384) != 0 ? null : num3;
        this(str14, str15, str16, str17, str18, str19, str20, str21, obj3, str22, str23, num5, str24, num6, num7, (i & 32768) != 0 ? null : str12, (i & 65536) != 0 ? null : num4, (i & 131072) != 0 ? null : str13, (i & 262144) != 0 ? null : obj2, (i & 524288) != 0 ? null : list, (i & 1048576) != 0 ? null : bool, (i & 2097152) != 0 ? null : bool2);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
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
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    public final String getFirstAirDate() {
        return this.firstAirDate;
    }

    @Nullable
    public final String getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    public final Object getViewCount() {
        return this.viewCount;
    }

    @Nullable
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final Integer getNumberOfSeasons() {
        return this.numberOfSeasons;
    }

    @Nullable
    public final Integer getNumberOfEpisodes() {
        return this.numberOfEpisodes;
    }

    @Nullable
    public final String getContentType() {
        return this.contentType;
    }

    @Nullable
    public final Integer getCommentCount() {
        return this.commentCount;
    }

    @Nullable
    public final String getOriginalLanguage() {
        return this.originalLanguage;
    }

    @Nullable
    public final Object getPopularity() {
        return this.popularity;
    }

    @Nullable
    public final List<APIGenre> getGenres() {
        return this.genres;
    }

    @Nullable
    public final Boolean getHasVideo() {
        return this.hasVideo;
    }

    @Nullable
    public final Boolean isPublished() {
        return this.isPublished;
    }
}
