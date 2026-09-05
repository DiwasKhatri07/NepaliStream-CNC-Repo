package com.IStreamFlare;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IStreamFlare/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bá\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000eHÆ\u0003J\u0090\u0002\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010IJ\u0014\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010M\u001a\u00020\nHÖ\u0081\u0004J\n\u0010N\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)¨\u0006O"}, d2 = {"Lcom/IStreamFlare/Meta;", "", "id", "", "imdb_id", "type", "poster", "logo", "background", "moviedb_id", "", "name", "description", "genre", "", "releaseInfo", "status", "runtime", "cast", "language", "country", "imdbRating", "slug", "year", "videos", "Lcom/IStreamFlare/EpisodeDetails;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getImdb_id", "getType", "getPoster", "getLogo", "getBackground", "getMoviedb_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getDescription", "getGenre", "()Ljava/util/List;", "getReleaseInfo", "getStatus", "getRuntime", "getCast", "getLanguage", "getCountry", "getImdbRating", "getSlug", "getYear", "getVideos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/IStreamFlare/Meta;", "equals", "", "other", "hashCode", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Meta {

    @Nullable
    private final String background;

    @Nullable
    private final List<String> cast;

    @Nullable
    private final String country;

    @Nullable
    private final String description;

    @Nullable
    private final List<String> genre;

    @Nullable
    private final String id;

    @Nullable
    private final String imdbRating;

    @Nullable
    private final String imdb_id;

    @Nullable
    private final String language;

    @Nullable
    private final String logo;

    @Nullable
    private final Integer moviedb_id;

    @Nullable
    private final String name;

    @Nullable
    private final String poster;

    @Nullable
    private final String releaseInfo;

    @Nullable
    private final String runtime;

    @Nullable
    private final String slug;

    @Nullable
    private final String status;

    @Nullable
    private final String type;

    @Nullable
    private final List<EpisodeDetails> videos;

    @Nullable
    private final String year;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Meta copy$default(Meta meta, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, List list, String str9, String str10, String str11, List list2, String str12, String str13, String str14, String str15, String str16, List list3, int i, Object obj) {
        List list4;
        String str17;
        String str18 = (i & 1) != 0 ? meta.id : str;
        String str19 = (i & 2) != 0 ? meta.imdb_id : str2;
        String str20 = (i & 4) != 0 ? meta.type : str3;
        String str21 = (i & 8) != 0 ? meta.poster : str4;
        String str22 = (i & 16) != 0 ? meta.logo : str5;
        String str23 = (i & 32) != 0 ? meta.background : str6;
        Integer num2 = (i & 64) != 0 ? meta.moviedb_id : num;
        String str24 = (i & 128) != 0 ? meta.name : str7;
        String str25 = (i & 256) != 0 ? meta.description : str8;
        List list5 = (i & 512) != 0 ? meta.genre : list;
        String str26 = (i & 1024) != 0 ? meta.releaseInfo : str9;
        String str27 = (i & 2048) != 0 ? meta.status : str10;
        String str28 = (i & 4096) != 0 ? meta.runtime : str11;
        List list6 = (i & 8192) != 0 ? meta.cast : list2;
        String str29 = str18;
        String str30 = (i & 16384) != 0 ? meta.language : str12;
        String str31 = (i & 32768) != 0 ? meta.country : str13;
        String str32 = (i & 65536) != 0 ? meta.imdbRating : str14;
        String str33 = (i & 131072) != 0 ? meta.slug : str15;
        String str34 = (i & 262144) != 0 ? meta.year : str16;
        if ((i & 524288) != 0) {
            str17 = str34;
            list4 = meta.videos;
        } else {
            list4 = list3;
            str17 = str34;
        }
        return meta.copy(str29, str19, str20, str21, str22, str23, num2, str24, str25, list5, str26, str27, str28, list6, str30, str31, str32, str33, str17, list4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final List<String> component10() {
        return this.genre;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getReleaseInfo() {
        return this.releaseInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final List<String> component14() {
        return this.cast;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getImdbRating() {
        return this.imdbRating;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @Nullable
    public final List<EpisodeDetails> component20() {
        return this.videos;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBackground() {
        return this.background;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getMoviedb_id() {
        return this.moviedb_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Meta copy(@Nullable String id, @Nullable String imdb_id, @Nullable String type, @Nullable String poster, @Nullable String logo, @Nullable String background, @Nullable Integer moviedb_id, @Nullable String name, @Nullable String description, @Nullable List<String> genre, @Nullable String releaseInfo, @Nullable String status, @Nullable String runtime, @Nullable List<String> cast, @Nullable String language, @Nullable String country, @Nullable String imdbRating, @Nullable String slug, @Nullable String year, @Nullable List<EpisodeDetails> videos) {
        return new Meta(id, imdb_id, type, poster, logo, background, moviedb_id, name, description, genre, releaseInfo, status, runtime, cast, language, country, imdbRating, slug, year, videos);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Meta)) {
            return false;
        }
        Meta meta = (Meta) other;
        return Intrinsics.areEqual(this.id, meta.id) && Intrinsics.areEqual(this.imdb_id, meta.imdb_id) && Intrinsics.areEqual(this.type, meta.type) && Intrinsics.areEqual(this.poster, meta.poster) && Intrinsics.areEqual(this.logo, meta.logo) && Intrinsics.areEqual(this.background, meta.background) && Intrinsics.areEqual(this.moviedb_id, meta.moviedb_id) && Intrinsics.areEqual(this.name, meta.name) && Intrinsics.areEqual(this.description, meta.description) && Intrinsics.areEqual(this.genre, meta.genre) && Intrinsics.areEqual(this.releaseInfo, meta.releaseInfo) && Intrinsics.areEqual(this.status, meta.status) && Intrinsics.areEqual(this.runtime, meta.runtime) && Intrinsics.areEqual(this.cast, meta.cast) && Intrinsics.areEqual(this.language, meta.language) && Intrinsics.areEqual(this.country, meta.country) && Intrinsics.areEqual(this.imdbRating, meta.imdbRating) && Intrinsics.areEqual(this.slug, meta.slug) && Intrinsics.areEqual(this.year, meta.year) && Intrinsics.areEqual(this.videos, meta.videos);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.moviedb_id == null ? 0 : this.moviedb_id.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + (this.releaseInfo == null ? 0 : this.releaseInfo.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.cast == null ? 0 : this.cast.hashCode())) * 31) + (this.language == null ? 0 : this.language.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.videos != null ? this.videos.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Meta(id=").append(this.id).append(", imdb_id=").append(this.imdb_id).append(", type=").append(this.type).append(", poster=").append(this.poster).append(", logo=").append(this.logo).append(", background=").append(this.background).append(", moviedb_id=").append(this.moviedb_id).append(", name=").append(this.name).append(", description=").append(this.description).append(", genre=").append(this.genre).append(", releaseInfo=").append(this.releaseInfo).append(", status=");
        sb.append(this.status).append(", runtime=").append(this.runtime).append(", cast=").append(this.cast).append(", language=").append(this.language).append(", country=").append(this.country).append(", imdbRating=").append(this.imdbRating).append(", slug=").append(this.slug).append(", year=").append(this.year).append(", videos=").append(this.videos).append(')');
        return sb.toString();
    }

    public Meta(@Nullable String id, @Nullable String imdb_id, @Nullable String type, @Nullable String poster, @Nullable String logo, @Nullable String background, @Nullable Integer moviedb_id, @Nullable String name, @Nullable String description, @Nullable List<String> list, @Nullable String releaseInfo, @Nullable String status, @Nullable String runtime, @Nullable List<String> list2, @Nullable String language, @Nullable String country, @Nullable String imdbRating, @Nullable String slug, @Nullable String year, @Nullable List<EpisodeDetails> list3) {
        this.id = id;
        this.imdb_id = imdb_id;
        this.type = type;
        this.poster = poster;
        this.logo = logo;
        this.background = background;
        this.moviedb_id = moviedb_id;
        this.name = name;
        this.description = description;
        this.genre = list;
        this.releaseInfo = releaseInfo;
        this.status = status;
        this.runtime = runtime;
        this.cast = list2;
        this.language = language;
        this.country = country;
        this.imdbRating = imdbRating;
        this.slug = slug;
        this.year = year;
        this.videos = list3;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    public final String getBackground() {
        return this.background;
    }

    @Nullable
    public final Integer getMoviedb_id() {
        return this.moviedb_id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final List<String> getGenre() {
        return this.genre;
    }

    @Nullable
    public final String getReleaseInfo() {
        return this.releaseInfo;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final List<String> getCast() {
        return this.cast;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getImdbRating() {
        return this.imdbRating;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final String getYear() {
        return this.year;
    }

    @Nullable
    public final List<EpisodeDetails> getVideos() {
        return this.videos;
    }
}
