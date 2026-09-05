package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/SuperStream/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/phisher98/CinemetaRes;", "", "meta", "Lcom/phisher98/CinemetaRes$Meta;", "<init>", "(Lcom/phisher98/CinemetaRes$Meta;)V", "getMeta", "()Lcom/phisher98/CinemetaRes$Meta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Meta", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class CinemetaRes {

    @NotNull
    private final Meta meta;

    public static /* synthetic */ CinemetaRes copy$default(CinemetaRes cinemetaRes, Meta meta, int i, Object obj) {
        if ((i & 1) != 0) {
            meta = cinemetaRes.meta;
        }
        return cinemetaRes.copy(meta);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Meta getMeta() {
        return this.meta;
    }

    @NotNull
    public final CinemetaRes copy(@NotNull Meta meta) {
        return new CinemetaRes(meta);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CinemetaRes) && Intrinsics.areEqual(this.meta, ((CinemetaRes) other).meta);
    }

    public int hashCode() {
        return this.meta.hashCode();
    }

    @NotNull
    public String toString() {
        return "CinemetaRes(meta=" + this.meta + ')';
    }

    public CinemetaRes(@NotNull Meta meta) {
        this.meta = meta;
    }

    @NotNull
    public final Meta getMeta() {
        return this.meta;
    }

    /* JADX INFO: compiled from: SuperStreamParser.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0007{|}~\u007f\u0080\u0001B±\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\b\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\b\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\b\u0012\u0006\u0010*\u001a\u00020\u0001\u0012\u0006\u0010+\u001a\u00020\u0003¢\u0006\u0004\b,\u0010-J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0001HÆ\u0003J\t\u0010\\\u001a\u00020\u0001HÆ\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00130\bHÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0016HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0019HÆ\u0003J\t\u0010g\u001a\u00020\u001bHÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\u000f\u0010n\u001a\b\u0012\u0004\u0012\u00020#0\bHÆ\u0003J\u000f\u0010o\u001a\b\u0012\u0004\u0012\u00020%0\bHÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\u000f\u0010r\u001a\b\u0012\u0004\u0012\u00020)0\bHÆ\u0003J\t\u0010s\u001a\u00020\u0001HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003Jó\u0002\u0010u\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\b2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\b2\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\b2\b\b\u0002\u0010*\u001a\u00020\u00012\b\b\u0002\u0010+\u001a\u00020\u0003HÆ\u0001J\u0014\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010y\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010z\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0011\u0010\u000b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b:\u00104R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b;\u00104R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010/R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010/R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010/R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b?\u00104R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010/R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010/R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010/R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010/R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010/R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010/R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010/R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\b¢\u0006\b\n\u0000\u001a\u0004\bN\u00104R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\b¢\u0006\b\n\u0000\u001a\u0004\bO\u00104R\u0011\u0010&\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010/R\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010/R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\b¢\u0006\b\n\u0000\u001a\u0004\bR\u00104R\u0011\u0010*\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bS\u00108R\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010/¨\u0006\u0081\u0001"}, d2 = {"Lcom/phisher98/CinemetaRes$Meta;", "", "awards", "", "background", "behaviorHints", "Lcom/phisher98/CinemetaRes$Meta$BehaviorHints;", "cast", "", "country", "description", "director", "dvdRelease", "genre", "genres", "id", "imdbRating", "imdb_id", "links", "Lcom/phisher98/CinemetaRes$Meta$Link;", "logo", "moviedb_id", "", "name", "popularities", "Lcom/phisher98/CinemetaRes$Meta$Popularities;", "popularity", "", "poster", "releaseInfo", "released", "runtime", "slug", "status", "trailerStreams", "Lcom/phisher98/CinemetaRes$Meta$TrailerStream;", "trailers", "Lcom/phisher98/CinemetaRes$Meta$Trailer;", "tvdb_id", "type", "videos", "Lcom/phisher98/CinemetaRes$Meta$Video;", "writer", "year", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/CinemetaRes$Meta$BehaviorHints;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Lcom/phisher98/CinemetaRes$Meta$Popularities;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/lang/String;)V", "getAwards", "()Ljava/lang/String;", "getBackground", "getBehaviorHints", "()Lcom/phisher98/CinemetaRes$Meta$BehaviorHints;", "getCast", "()Ljava/util/List;", "getCountry", "getDescription", "getDirector", "()Ljava/lang/Object;", "getDvdRelease", "getGenre", "getGenres", "getId", "getImdbRating", "getImdb_id", "getLinks", "getLogo", "getMoviedb_id", "()I", "getName", "getPopularities", "()Lcom/phisher98/CinemetaRes$Meta$Popularities;", "getPopularity", "()D", "getPoster", "getReleaseInfo", "getReleased", "getRuntime", "getSlug", "getStatus", "getTrailerStreams", "getTrailers", "getTvdb_id", "getType", "getVideos", "getWriter", "getYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "copy", "equals", "", "other", "hashCode", "toString", "BehaviorHints", "Link", "Popularities", "TrailerStream", "Trailer", "Video", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Meta {

        @NotNull
        private final String awards;

        @NotNull
        private final String background;

        @NotNull
        private final BehaviorHints behaviorHints;

        @NotNull
        private final List<String> cast;

        @NotNull
        private final String country;

        @NotNull
        private final String description;

        @NotNull
        private final Object director;

        @NotNull
        private final Object dvdRelease;

        @NotNull
        private final List<String> genre;

        @NotNull
        private final List<String> genres;

        @NotNull
        private final String id;

        @NotNull
        private final String imdbRating;

        @NotNull
        private final String imdb_id;

        @NotNull
        private final List<Link> links;

        @NotNull
        private final String logo;
        private final int moviedb_id;

        @NotNull
        private final String name;

        @NotNull
        private final Popularities popularities;
        private final double popularity;

        @NotNull
        private final String poster;

        @NotNull
        private final String releaseInfo;

        @NotNull
        private final String released;

        @NotNull
        private final String runtime;

        @NotNull
        private final String slug;

        @NotNull
        private final String status;

        @NotNull
        private final List<TrailerStream> trailerStreams;

        @NotNull
        private final List<Trailer> trailers;

        @NotNull
        private final String tvdb_id;

        @NotNull
        private final String type;

        @NotNull
        private final List<Video> videos;

        @NotNull
        private final Object writer;

        @NotNull
        private final String year;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Meta copy$default(Meta meta, String str, String str2, BehaviorHints behaviorHints, List list, String str3, String str4, Object obj, Object obj2, List list2, List list3, String str5, String str6, String str7, List list4, String str8, int i, String str9, Popularities popularities, double d, String str10, String str11, String str12, String str13, String str14, String str15, List list5, List list6, String str16, String str17, List list7, Object obj3, String str18, int i2, Object obj4) {
            String str19;
            Object obj5;
            String str20 = (i2 & 1) != 0 ? meta.awards : str;
            String str21 = (i2 & 2) != 0 ? meta.background : str2;
            BehaviorHints behaviorHints2 = (i2 & 4) != 0 ? meta.behaviorHints : behaviorHints;
            List list8 = (i2 & 8) != 0 ? meta.cast : list;
            String str22 = (i2 & 16) != 0 ? meta.country : str3;
            String str23 = (i2 & 32) != 0 ? meta.description : str4;
            Object obj6 = (i2 & 64) != 0 ? meta.director : obj;
            Object obj7 = (i2 & 128) != 0 ? meta.dvdRelease : obj2;
            List list9 = (i2 & 256) != 0 ? meta.genre : list2;
            List list10 = (i2 & 512) != 0 ? meta.genres : list3;
            String str24 = (i2 & 1024) != 0 ? meta.id : str5;
            String str25 = (i2 & 2048) != 0 ? meta.imdbRating : str6;
            String str26 = (i2 & 4096) != 0 ? meta.imdb_id : str7;
            List list11 = (i2 & 8192) != 0 ? meta.links : list4;
            String str27 = str20;
            String str28 = (i2 & 16384) != 0 ? meta.logo : str8;
            int i3 = (i2 & 32768) != 0 ? meta.moviedb_id : i;
            String str29 = (i2 & 65536) != 0 ? meta.name : str9;
            Popularities popularities2 = (i2 & 131072) != 0 ? meta.popularities : popularities;
            String str30 = str28;
            double d2 = (i2 & 262144) != 0 ? meta.popularity : d;
            String str31 = (i2 & 524288) != 0 ? meta.poster : str10;
            String str32 = (i2 & 1048576) != 0 ? meta.releaseInfo : str11;
            String str33 = str31;
            String str34 = (i2 & 2097152) != 0 ? meta.released : str12;
            String str35 = (i2 & 4194304) != 0 ? meta.runtime : str13;
            String str36 = (i2 & 8388608) != 0 ? meta.slug : str14;
            String str37 = (i2 & 16777216) != 0 ? meta.status : str15;
            List list12 = (i2 & 33554432) != 0 ? meta.trailerStreams : list5;
            List list13 = (i2 & 67108864) != 0 ? meta.trailers : list6;
            String str38 = (i2 & 134217728) != 0 ? meta.tvdb_id : str16;
            String str39 = (i2 & 268435456) != 0 ? meta.type : str17;
            List list14 = (i2 & 536870912) != 0 ? meta.videos : list7;
            Object obj8 = (i2 & 1073741824) != 0 ? meta.writer : obj3;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                obj5 = obj8;
                str19 = meta.year;
            } else {
                str19 = str18;
                obj5 = obj8;
            }
            return meta.copy(str27, str21, behaviorHints2, list8, str22, str23, obj6, obj7, list9, list10, str24, str25, str26, list11, str30, i3, str29, popularities2, d2, str33, str32, str34, str35, str36, str37, list12, list13, str38, str39, list14, obj5, str19);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAwards() {
            return this.awards;
        }

        @NotNull
        public final List<String> component10() {
            return this.genres;
        }

        @NotNull
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @NotNull
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @NotNull
        public final List<Link> component14() {
            return this.links;
        }

        @NotNull
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getLogo() {
            return this.logo;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final int getMoviedb_id() {
            return this.moviedb_id;
        }

        @NotNull
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Popularities getPopularities() {
            return this.popularities;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final double getPopularity() {
            return this.popularity;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBackground() {
            return this.background;
        }

        @NotNull
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final String getReleaseInfo() {
            return this.releaseInfo;
        }

        @NotNull
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getReleased() {
            return this.released;
        }

        @NotNull
        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getRuntime() {
            return this.runtime;
        }

        @NotNull
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final List<TrailerStream> component26() {
            return this.trailerStreams;
        }

        @NotNull
        public final List<Trailer> component27() {
            return this.trailers;
        }

        @NotNull
        /* JADX INFO: renamed from: component28, reason: from getter */
        public final String getTvdb_id() {
            return this.tvdb_id;
        }

        @NotNull
        /* JADX INFO: renamed from: component29, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final BehaviorHints getBehaviorHints() {
            return this.behaviorHints;
        }

        @NotNull
        public final List<Video> component30() {
            return this.videos;
        }

        @NotNull
        /* JADX INFO: renamed from: component31, reason: from getter */
        public final Object getWriter() {
            return this.writer;
        }

        @NotNull
        /* JADX INFO: renamed from: component32, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        @NotNull
        public final List<String> component4() {
            return this.cast;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCountry() {
            return this.country;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Object getDirector() {
            return this.director;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Object getDvdRelease() {
            return this.dvdRelease;
        }

        @NotNull
        public final List<String> component9() {
            return this.genre;
        }

        @NotNull
        public final Meta copy(@NotNull String awards, @NotNull String background, @NotNull BehaviorHints behaviorHints, @NotNull List<String> cast, @NotNull String country, @NotNull String description, @NotNull Object director, @NotNull Object dvdRelease, @NotNull List<String> genre, @NotNull List<String> genres, @NotNull String id, @NotNull String imdbRating, @NotNull String imdb_id, @NotNull List<Link> links, @NotNull String logo, int moviedb_id, @NotNull String name, @NotNull Popularities popularities, double popularity, @NotNull String poster, @NotNull String releaseInfo, @NotNull String released, @NotNull String runtime, @NotNull String slug, @NotNull String status, @NotNull List<TrailerStream> trailerStreams, @NotNull List<Trailer> trailers, @NotNull String tvdb_id, @NotNull String type, @NotNull List<Video> videos, @NotNull Object writer, @NotNull String year) {
            return new Meta(awards, background, behaviorHints, cast, country, description, director, dvdRelease, genre, genres, id, imdbRating, imdb_id, links, logo, moviedb_id, name, popularities, popularity, poster, releaseInfo, released, runtime, slug, status, trailerStreams, trailers, tvdb_id, type, videos, writer, year);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) other;
            return Intrinsics.areEqual(this.awards, meta.awards) && Intrinsics.areEqual(this.background, meta.background) && Intrinsics.areEqual(this.behaviorHints, meta.behaviorHints) && Intrinsics.areEqual(this.cast, meta.cast) && Intrinsics.areEqual(this.country, meta.country) && Intrinsics.areEqual(this.description, meta.description) && Intrinsics.areEqual(this.director, meta.director) && Intrinsics.areEqual(this.dvdRelease, meta.dvdRelease) && Intrinsics.areEqual(this.genre, meta.genre) && Intrinsics.areEqual(this.genres, meta.genres) && Intrinsics.areEqual(this.id, meta.id) && Intrinsics.areEqual(this.imdbRating, meta.imdbRating) && Intrinsics.areEqual(this.imdb_id, meta.imdb_id) && Intrinsics.areEqual(this.links, meta.links) && Intrinsics.areEqual(this.logo, meta.logo) && this.moviedb_id == meta.moviedb_id && Intrinsics.areEqual(this.name, meta.name) && Intrinsics.areEqual(this.popularities, meta.popularities) && Double.compare(this.popularity, meta.popularity) == 0 && Intrinsics.areEqual(this.poster, meta.poster) && Intrinsics.areEqual(this.releaseInfo, meta.releaseInfo) && Intrinsics.areEqual(this.released, meta.released) && Intrinsics.areEqual(this.runtime, meta.runtime) && Intrinsics.areEqual(this.slug, meta.slug) && Intrinsics.areEqual(this.status, meta.status) && Intrinsics.areEqual(this.trailerStreams, meta.trailerStreams) && Intrinsics.areEqual(this.trailers, meta.trailers) && Intrinsics.areEqual(this.tvdb_id, meta.tvdb_id) && Intrinsics.areEqual(this.type, meta.type) && Intrinsics.areEqual(this.videos, meta.videos) && Intrinsics.areEqual(this.writer, meta.writer) && Intrinsics.areEqual(this.year, meta.year);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.awards.hashCode() * 31) + this.background.hashCode()) * 31) + this.behaviorHints.hashCode()) * 31) + this.cast.hashCode()) * 31) + this.country.hashCode()) * 31) + this.description.hashCode()) * 31) + this.director.hashCode()) * 31) + this.dvdRelease.hashCode()) * 31) + this.genre.hashCode()) * 31) + this.genres.hashCode()) * 31) + this.id.hashCode()) * 31) + this.imdbRating.hashCode()) * 31) + this.imdb_id.hashCode()) * 31) + this.links.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.moviedb_id) * 31) + this.name.hashCode()) * 31) + this.popularities.hashCode()) * 31) + CinemetaRes$Meta$$ExternalSyntheticBackport0.m0m(this.popularity)) * 31) + this.poster.hashCode()) * 31) + this.releaseInfo.hashCode()) * 31) + this.released.hashCode()) * 31) + this.runtime.hashCode()) * 31) + this.slug.hashCode()) * 31) + this.status.hashCode()) * 31) + this.trailerStreams.hashCode()) * 31) + this.trailers.hashCode()) * 31) + this.tvdb_id.hashCode()) * 31) + this.type.hashCode()) * 31) + this.videos.hashCode()) * 31) + this.writer.hashCode()) * 31) + this.year.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Meta(awards=").append(this.awards).append(", background=").append(this.background).append(", behaviorHints=").append(this.behaviorHints).append(", cast=").append(this.cast).append(", country=").append(this.country).append(", description=").append(this.description).append(", director=").append(this.director).append(", dvdRelease=").append(this.dvdRelease).append(", genre=").append(this.genre).append(", genres=").append(this.genres).append(", id=").append(this.id).append(", imdbRating=");
            sb.append(this.imdbRating).append(", imdb_id=").append(this.imdb_id).append(", links=").append(this.links).append(", logo=").append(this.logo).append(", moviedb_id=").append(this.moviedb_id).append(", name=").append(this.name).append(", popularities=").append(this.popularities).append(", popularity=").append(this.popularity).append(", poster=").append(this.poster).append(", releaseInfo=").append(this.releaseInfo).append(", released=").append(this.released).append(", runtime=").append(this.runtime);
            sb.append(", slug=").append(this.slug).append(", status=").append(this.status).append(", trailerStreams=").append(this.trailerStreams).append(", trailers=").append(this.trailers).append(", tvdb_id=").append(this.tvdb_id).append(", type=").append(this.type).append(", videos=").append(this.videos).append(", writer=").append(this.writer).append(", year=").append(this.year).append(')');
            return sb.toString();
        }

        public Meta(@NotNull String awards, @NotNull String background, @NotNull BehaviorHints behaviorHints, @NotNull List<String> list, @NotNull String country, @NotNull String description, @NotNull Object director, @NotNull Object dvdRelease, @NotNull List<String> list2, @NotNull List<String> list3, @NotNull String id, @NotNull String imdbRating, @NotNull String imdb_id, @NotNull List<Link> list4, @NotNull String logo, int moviedb_id, @NotNull String name, @NotNull Popularities popularities, double popularity, @NotNull String poster, @NotNull String releaseInfo, @NotNull String released, @NotNull String runtime, @NotNull String slug, @NotNull String status, @NotNull List<TrailerStream> list5, @NotNull List<Trailer> list6, @NotNull String tvdb_id, @NotNull String type, @NotNull List<Video> list7, @NotNull Object writer, @NotNull String year) {
            this.awards = awards;
            this.background = background;
            this.behaviorHints = behaviorHints;
            this.cast = list;
            this.country = country;
            this.description = description;
            this.director = director;
            this.dvdRelease = dvdRelease;
            this.genre = list2;
            this.genres = list3;
            this.id = id;
            this.imdbRating = imdbRating;
            this.imdb_id = imdb_id;
            this.links = list4;
            this.logo = logo;
            this.moviedb_id = moviedb_id;
            this.name = name;
            this.popularities = popularities;
            this.popularity = popularity;
            this.poster = poster;
            this.releaseInfo = releaseInfo;
            this.released = released;
            this.runtime = runtime;
            this.slug = slug;
            this.status = status;
            this.trailerStreams = list5;
            this.trailers = list6;
            this.tvdb_id = tvdb_id;
            this.type = type;
            this.videos = list7;
            this.writer = writer;
            this.year = year;
        }

        @NotNull
        public final String getAwards() {
            return this.awards;
        }

        @NotNull
        public final String getBackground() {
            return this.background;
        }

        @NotNull
        public final BehaviorHints getBehaviorHints() {
            return this.behaviorHints;
        }

        @NotNull
        public final List<String> getCast() {
            return this.cast;
        }

        @NotNull
        public final String getCountry() {
            return this.country;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final Object getDirector() {
            return this.director;
        }

        @NotNull
        public final Object getDvdRelease() {
            return this.dvdRelease;
        }

        @NotNull
        public final List<String> getGenre() {
            return this.genre;
        }

        @NotNull
        public final List<String> getGenres() {
            return this.genres;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @NotNull
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @NotNull
        public final List<Link> getLinks() {
            return this.links;
        }

        @NotNull
        public final String getLogo() {
            return this.logo;
        }

        public final int getMoviedb_id() {
            return this.moviedb_id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final Popularities getPopularities() {
            return this.popularities;
        }

        public final double getPopularity() {
            return this.popularity;
        }

        @NotNull
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getReleaseInfo() {
            return this.releaseInfo;
        }

        @NotNull
        public final String getReleased() {
            return this.released;
        }

        @NotNull
        public final String getRuntime() {
            return this.runtime;
        }

        @NotNull
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final List<TrailerStream> getTrailerStreams() {
            return this.trailerStreams;
        }

        @NotNull
        public final List<Trailer> getTrailers() {
            return this.trailers;
        }

        @NotNull
        public final String getTvdb_id() {
            return this.tvdb_id;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final List<Video> getVideos() {
            return this.videos;
        }

        @NotNull
        public final Object getWriter() {
            return this.writer;
        }

        @NotNull
        public final String getYear() {
            return this.year;
        }

        /* JADX INFO: compiled from: SuperStreamParser.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/phisher98/CinemetaRes$Meta$BehaviorHints;", "", "defaultVideoId", "hasScheduledVideos", "", "<init>", "(Ljava/lang/Object;Z)V", "getDefaultVideoId", "()Ljava/lang/Object;", "getHasScheduledVideos", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class BehaviorHints {

            @NotNull
            private final Object defaultVideoId;
            private final boolean hasScheduledVideos;

            public static /* synthetic */ BehaviorHints copy$default(BehaviorHints behaviorHints, Object obj, boolean z, int i, Object obj2) {
                if ((i & 1) != 0) {
                    obj = behaviorHints.defaultVideoId;
                }
                if ((i & 2) != 0) {
                    z = behaviorHints.hasScheduledVideos;
                }
                return behaviorHints.copy(obj, z);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Object getDefaultVideoId() {
                return this.defaultVideoId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getHasScheduledVideos() {
                return this.hasScheduledVideos;
            }

            @NotNull
            public final BehaviorHints copy(@NotNull Object defaultVideoId, boolean hasScheduledVideos) {
                return new BehaviorHints(defaultVideoId, hasScheduledVideos);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BehaviorHints)) {
                    return false;
                }
                BehaviorHints behaviorHints = (BehaviorHints) other;
                return Intrinsics.areEqual(this.defaultVideoId, behaviorHints.defaultVideoId) && this.hasScheduledVideos == behaviorHints.hasScheduledVideos;
            }

            public int hashCode() {
                return (this.defaultVideoId.hashCode() * 31) + CinemetaRes$Meta$BehaviorHints$$ExternalSyntheticBackport0.m1m(this.hasScheduledVideos);
            }

            @NotNull
            public String toString() {
                return "BehaviorHints(defaultVideoId=" + this.defaultVideoId + ", hasScheduledVideos=" + this.hasScheduledVideos + ')';
            }

            public BehaviorHints(@NotNull Object defaultVideoId, boolean hasScheduledVideos) {
                this.defaultVideoId = defaultVideoId;
                this.hasScheduledVideos = hasScheduledVideos;
            }

            @NotNull
            public final Object getDefaultVideoId() {
                return this.defaultVideoId;
            }

            public final boolean getHasScheduledVideos() {
                return this.hasScheduledVideos;
            }
        }

        /* JADX INFO: compiled from: SuperStreamParser.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/CinemetaRes$Meta$Link;", "", "category", "", "name", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getName", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Link {

            @NotNull
            private final String category;

            @NotNull
            private final String name;

            @NotNull
            private final String url;

            public static /* synthetic */ Link copy$default(Link link, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = link.category;
                }
                if ((i & 2) != 0) {
                    str2 = link.name;
                }
                if ((i & 4) != 0) {
                    str3 = link.url;
                }
                return link.copy(str, str2, str3);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getCategory() {
                return this.category;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @NotNull
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            @NotNull
            public final Link copy(@NotNull String category, @NotNull String name, @NotNull String url) {
                return new Link(category, name, url);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Link)) {
                    return false;
                }
                Link link = (Link) other;
                return Intrinsics.areEqual(this.category, link.category) && Intrinsics.areEqual(this.name, link.name) && Intrinsics.areEqual(this.url, link.url);
            }

            public int hashCode() {
                return (((this.category.hashCode() * 31) + this.name.hashCode()) * 31) + this.url.hashCode();
            }

            @NotNull
            public String toString() {
                return "Link(category=" + this.category + ", name=" + this.name + ", url=" + this.url + ')';
            }

            public Link(@NotNull String category, @NotNull String name, @NotNull String url) {
                this.category = category;
                this.name = name;
                this.url = url;
            }

            @NotNull
            public final String getCategory() {
                return this.category;
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            @NotNull
            public final String getUrl() {
                return this.url;
            }
        }

        /* JADX INFO: compiled from: SuperStreamParser.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, d2 = {"Lcom/phisher98/CinemetaRes$Meta$Popularities;", "", "ALLIANCE", "", "EJD", "EXMD", "PXS_TEST", "moviedb", "", "stremio", "stremio_lib", "trakt", "<init>", "(IIIIDDII)V", "getALLIANCE", "()I", "getEJD", "getEXMD", "getPXS_TEST", "getMoviedb", "()D", "getStremio", "getStremio_lib", "getTrakt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Popularities {
            private final int ALLIANCE;
            private final int EJD;
            private final int EXMD;
            private final int PXS_TEST;
            private final double moviedb;
            private final double stremio;
            private final int stremio_lib;
            private final int trakt;

            public static /* synthetic */ Popularities copy$default(Popularities popularities, int i, int i2, int i3, int i4, double d, double d2, int i5, int i6, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    i = popularities.ALLIANCE;
                }
                if ((i7 & 2) != 0) {
                    i2 = popularities.EJD;
                }
                if ((i7 & 4) != 0) {
                    i3 = popularities.EXMD;
                }
                if ((i7 & 8) != 0) {
                    i4 = popularities.PXS_TEST;
                }
                if ((i7 & 16) != 0) {
                    d = popularities.moviedb;
                }
                if ((i7 & 32) != 0) {
                    d2 = popularities.stremio;
                }
                if ((i7 & 64) != 0) {
                    i5 = popularities.stremio_lib;
                }
                if ((i7 & 128) != 0) {
                    i6 = popularities.trakt;
                }
                double d3 = d2;
                double d4 = d;
                int i8 = i3;
                int i9 = i4;
                return popularities.copy(i, i2, i8, i9, d4, d3, i5, i6);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getALLIANCE() {
                return this.ALLIANCE;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getEJD() {
                return this.EJD;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getEXMD() {
                return this.EXMD;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getPXS_TEST() {
                return this.PXS_TEST;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final double getMoviedb() {
                return this.moviedb;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final double getStremio() {
                return this.stremio;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final int getStremio_lib() {
                return this.stremio_lib;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final int getTrakt() {
                return this.trakt;
            }

            @NotNull
            public final Popularities copy(int ALLIANCE, int EJD, int EXMD, int PXS_TEST, double moviedb, double stremio, int stremio_lib, int trakt) {
                return new Popularities(ALLIANCE, EJD, EXMD, PXS_TEST, moviedb, stremio, stremio_lib, trakt);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Popularities)) {
                    return false;
                }
                Popularities popularities = (Popularities) other;
                return this.ALLIANCE == popularities.ALLIANCE && this.EJD == popularities.EJD && this.EXMD == popularities.EXMD && this.PXS_TEST == popularities.PXS_TEST && Double.compare(this.moviedb, popularities.moviedb) == 0 && Double.compare(this.stremio, popularities.stremio) == 0 && this.stremio_lib == popularities.stremio_lib && this.trakt == popularities.trakt;
            }

            public int hashCode() {
                return (((((((((((((this.ALLIANCE * 31) + this.EJD) * 31) + this.EXMD) * 31) + this.PXS_TEST) * 31) + CinemetaRes$Meta$Popularities$$ExternalSyntheticBackport0.m2m(this.moviedb)) * 31) + CinemetaRes$Meta$Popularities$$ExternalSyntheticBackport0.m2m(this.stremio)) * 31) + this.stremio_lib) * 31) + this.trakt;
            }

            @NotNull
            public String toString() {
                return "Popularities(ALLIANCE=" + this.ALLIANCE + ", EJD=" + this.EJD + ", EXMD=" + this.EXMD + ", PXS_TEST=" + this.PXS_TEST + ", moviedb=" + this.moviedb + ", stremio=" + this.stremio + ", stremio_lib=" + this.stremio_lib + ", trakt=" + this.trakt + ')';
            }

            public Popularities(int ALLIANCE, int EJD, int EXMD, int PXS_TEST, double moviedb, double stremio, int stremio_lib, int trakt) {
                this.ALLIANCE = ALLIANCE;
                this.EJD = EJD;
                this.EXMD = EXMD;
                this.PXS_TEST = PXS_TEST;
                this.moviedb = moviedb;
                this.stremio = stremio;
                this.stremio_lib = stremio_lib;
                this.trakt = trakt;
            }

            public final int getALLIANCE() {
                return this.ALLIANCE;
            }

            public final int getEJD() {
                return this.EJD;
            }

            public final int getEXMD() {
                return this.EXMD;
            }

            public final int getPXS_TEST() {
                return this.PXS_TEST;
            }

            public final double getMoviedb() {
                return this.moviedb;
            }

            public final double getStremio() {
                return this.stremio;
            }

            public final int getStremio_lib() {
                return this.stremio_lib;
            }

            public final int getTrakt() {
                return this.trakt;
            }
        }

        /* JADX INFO: compiled from: SuperStreamParser.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/CinemetaRes$Meta$TrailerStream;", "", "title", "", "ytId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getYtId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class TrailerStream {

            @NotNull
            private final String title;

            @NotNull
            private final String ytId;

            public static /* synthetic */ TrailerStream copy$default(TrailerStream trailerStream, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = trailerStream.title;
                }
                if ((i & 2) != 0) {
                    str2 = trailerStream.ytId;
                }
                return trailerStream.copy(str, str2);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getYtId() {
                return this.ytId;
            }

            @NotNull
            public final TrailerStream copy(@NotNull String title, @NotNull String ytId) {
                return new TrailerStream(title, ytId);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TrailerStream)) {
                    return false;
                }
                TrailerStream trailerStream = (TrailerStream) other;
                return Intrinsics.areEqual(this.title, trailerStream.title) && Intrinsics.areEqual(this.ytId, trailerStream.ytId);
            }

            public int hashCode() {
                return (this.title.hashCode() * 31) + this.ytId.hashCode();
            }

            @NotNull
            public String toString() {
                return "TrailerStream(title=" + this.title + ", ytId=" + this.ytId + ')';
            }

            public TrailerStream(@NotNull String title, @NotNull String ytId) {
                this.title = title;
                this.ytId = ytId;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @NotNull
            public final String getYtId() {
                return this.ytId;
            }
        }

        /* JADX INFO: compiled from: SuperStreamParser.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/CinemetaRes$Meta$Trailer;", "", "source", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Trailer {

            @NotNull
            private final String source;

            @NotNull
            private final String type;

            public static /* synthetic */ Trailer copy$default(Trailer trailer, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = trailer.source;
                }
                if ((i & 2) != 0) {
                    str2 = trailer.type;
                }
                return trailer.copy(str, str2);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSource() {
                return this.source;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getType() {
                return this.type;
            }

            @NotNull
            public final Trailer copy(@NotNull String source, @NotNull String type) {
                return new Trailer(source, type);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Trailer)) {
                    return false;
                }
                Trailer trailer = (Trailer) other;
                return Intrinsics.areEqual(this.source, trailer.source) && Intrinsics.areEqual(this.type, trailer.type);
            }

            public int hashCode() {
                return (this.source.hashCode() * 31) + this.type.hashCode();
            }

            @NotNull
            public String toString() {
                return "Trailer(source=" + this.source + ", type=" + this.type + ')';
            }

            public Trailer(@NotNull String source, @NotNull String type) {
                this.source = source;
                this.type = type;
            }

            @NotNull
            public final String getSource() {
                return this.source;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }
        }

        /* JADX INFO: compiled from: SuperStreamParser.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003Jw\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006/"}, d2 = {"Lcom/phisher98/CinemetaRes$Meta$Video;", "", "episode", "", "firstAired", "", "id", "name", "number", "rating", "released", "season", "thumbnail", "tvdb_id", "description", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getEpisode", "()I", "getFirstAired", "()Ljava/lang/String;", "getId", "getName", "getNumber", "getRating", "getReleased", "getSeason", "getThumbnail", "getTvdb_id", "getDescription", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Video {

            @NotNull
            private final String description;
            private final int episode;

            @NotNull
            private final String firstAired;

            @NotNull
            private final String id;

            @NotNull
            private final String name;
            private final int number;

            @NotNull
            private final String rating;

            @NotNull
            private final String released;
            private final int season;

            @NotNull
            private final String thumbnail;
            private final int tvdb_id;

            public static /* synthetic */ Video copy$default(Video video, int i, String str, String str2, String str3, int i2, String str4, String str5, int i3, String str6, int i4, String str7, int i5, Object obj) {
                if ((i5 & 1) != 0) {
                    i = video.episode;
                }
                if ((i5 & 2) != 0) {
                    str = video.firstAired;
                }
                if ((i5 & 4) != 0) {
                    str2 = video.id;
                }
                if ((i5 & 8) != 0) {
                    str3 = video.name;
                }
                if ((i5 & 16) != 0) {
                    i2 = video.number;
                }
                if ((i5 & 32) != 0) {
                    str4 = video.rating;
                }
                if ((i5 & 64) != 0) {
                    str5 = video.released;
                }
                if ((i5 & 128) != 0) {
                    i3 = video.season;
                }
                if ((i5 & 256) != 0) {
                    str6 = video.thumbnail;
                }
                if ((i5 & 512) != 0) {
                    i4 = video.tvdb_id;
                }
                if ((i5 & 1024) != 0) {
                    str7 = video.description;
                }
                int i6 = i4;
                String str8 = str7;
                int i7 = i3;
                String str9 = str6;
                String str10 = str4;
                String str11 = str5;
                int i8 = i2;
                String str12 = str2;
                return video.copy(i, str, str12, str3, i8, str10, str11, i7, str9, i6, str8);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getEpisode() {
                return this.episode;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final int getTvdb_id() {
                return this.tvdb_id;
            }

            @NotNull
            /* JADX INFO: renamed from: component11, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getFirstAired() {
                return this.firstAired;
            }

            @NotNull
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getId() {
                return this.id;
            }

            @NotNull
            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final int getNumber() {
                return this.number;
            }

            @NotNull
            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getRating() {
                return this.rating;
            }

            @NotNull
            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getReleased() {
                return this.released;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final int getSeason() {
                return this.season;
            }

            @NotNull
            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getThumbnail() {
                return this.thumbnail;
            }

            @NotNull
            public final Video copy(int episode, @NotNull String firstAired, @NotNull String id, @NotNull String name, int number, @NotNull String rating, @NotNull String released, int season, @NotNull String thumbnail, int tvdb_id, @NotNull String description) {
                return new Video(episode, firstAired, id, name, number, rating, released, season, thumbnail, tvdb_id, description);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Video)) {
                    return false;
                }
                Video video = (Video) other;
                return this.episode == video.episode && Intrinsics.areEqual(this.firstAired, video.firstAired) && Intrinsics.areEqual(this.id, video.id) && Intrinsics.areEqual(this.name, video.name) && this.number == video.number && Intrinsics.areEqual(this.rating, video.rating) && Intrinsics.areEqual(this.released, video.released) && this.season == video.season && Intrinsics.areEqual(this.thumbnail, video.thumbnail) && this.tvdb_id == video.tvdb_id && Intrinsics.areEqual(this.description, video.description);
            }

            public int hashCode() {
                return (((((((((((((((((((this.episode * 31) + this.firstAired.hashCode()) * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.number) * 31) + this.rating.hashCode()) * 31) + this.released.hashCode()) * 31) + this.season) * 31) + this.thumbnail.hashCode()) * 31) + this.tvdb_id) * 31) + this.description.hashCode();
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Video(episode=").append(this.episode).append(", firstAired=").append(this.firstAired).append(", id=").append(this.id).append(", name=").append(this.name).append(", number=").append(this.number).append(", rating=").append(this.rating).append(", released=").append(this.released).append(", season=").append(this.season).append(", thumbnail=").append(this.thumbnail).append(", tvdb_id=").append(this.tvdb_id).append(", description=").append(this.description).append(')');
                return sb.toString();
            }

            public Video(int episode, @NotNull String firstAired, @NotNull String id, @NotNull String name, int number, @NotNull String rating, @NotNull String released, int season, @NotNull String thumbnail, int tvdb_id, @NotNull String description) {
                this.episode = episode;
                this.firstAired = firstAired;
                this.id = id;
                this.name = name;
                this.number = number;
                this.rating = rating;
                this.released = released;
                this.season = season;
                this.thumbnail = thumbnail;
                this.tvdb_id = tvdb_id;
                this.description = description;
            }

            public final int getEpisode() {
                return this.episode;
            }

            @NotNull
            public final String getFirstAired() {
                return this.firstAired;
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            public final int getNumber() {
                return this.number;
            }

            @NotNull
            public final String getRating() {
                return this.rating;
            }

            @NotNull
            public final String getReleased() {
                return this.released;
            }

            public final int getSeason() {
                return this.season;
            }

            @NotNull
            public final String getThumbnail() {
                return this.thumbnail;
            }

            public final int getTvdb_id() {
                return this.tvdb_id;
            }

            @NotNull
            public final String getDescription() {
                return this.description;
            }
        }
    }
}
