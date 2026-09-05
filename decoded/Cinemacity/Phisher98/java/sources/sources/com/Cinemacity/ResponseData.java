package com.Cinemacity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Cinemacity/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/Cinemacity/ResponseData;", "", "meta", "Lcom/Cinemacity/ResponseData$Meta;", "<init>", "(Lcom/Cinemacity/ResponseData$Meta;)V", "getMeta", "()Lcom/Cinemacity/ResponseData$Meta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Meta", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ResponseData {

    @Nullable
    private final Meta meta;

    /* JADX WARN: Illegal instructions before constructor call */
    public ResponseData() {
        Meta meta = null;
        this(meta, 1, meta);
    }

    public static /* synthetic */ ResponseData copy$default(ResponseData responseData, Meta meta, int i, Object obj) {
        if ((i & 1) != 0) {
            meta = responseData.meta;
        }
        return responseData.copy(meta);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Meta getMeta() {
        return this.meta;
    }

    @NotNull
    public final ResponseData copy(@Nullable Meta meta) {
        return new ResponseData(meta);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResponseData) && Intrinsics.areEqual(this.meta, ((ResponseData) other).meta);
    }

    public int hashCode() {
        if (this.meta == null) {
            return 0;
        }
        return this.meta.hashCode();
    }

    @NotNull
    public String toString() {
        return "ResponseData(meta=" + this.meta + ')';
    }

    public ResponseData(@Nullable Meta meta) {
        this.meta = meta;
    }

    public /* synthetic */ ResponseData(Meta meta, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : meta);
    }

    @Nullable
    public final Meta getMeta() {
        return this.meta;
    }

    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0007efghijkBé\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0004\b$\u0010%J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\tHÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\tHÆ\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\tHÆ\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\tHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010#HÆ\u0003Jë\u0002\u0010^\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\t2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\t2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#HÆ\u0001J\u0014\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010b\u001a\u00020cHÖ\u0081\u0004J\n\u0010d\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010'R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010-R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b>\u0010-R\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b?\u0010-R\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C¨\u0006l"}, d2 = {"Lcom/Cinemacity/ResponseData$Meta;", "", "id", "", "type", "name", "imdb_id", "slug", "director", "", "writer", "description", "year", "releaseInfo", "released", "runtime", "status", "country", "imdbRating", "genres", "poster", "_rawPosterUrl", "background", "logo", "videos", "Lcom/Cinemacity/ResponseData$Meta$EpisodeDetails;", "trailers", "Lcom/Cinemacity/ResponseData$Meta$Trailer;", "trailerStreams", "Lcom/Cinemacity/ResponseData$Meta$TrailerStream;", "links", "Lcom/Cinemacity/ResponseData$Meta$Link;", "behaviorHints", "Lcom/Cinemacity/ResponseData$Meta$BehaviorHints;", "app_extras", "Lcom/Cinemacity/ResponseData$Meta$AppExtras;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/Cinemacity/ResponseData$Meta$BehaviorHints;Lcom/Cinemacity/ResponseData$Meta$AppExtras;)V", "getId", "()Ljava/lang/String;", "getType", "getName", "getImdb_id", "getSlug", "getDirector", "()Ljava/util/List;", "getWriter", "getDescription", "getYear", "getReleaseInfo", "getReleased", "getRuntime", "getStatus", "getCountry", "getImdbRating", "getGenres", "getPoster", "get_rawPosterUrl", "getBackground", "getLogo", "getVideos", "getTrailers", "getTrailerStreams", "getLinks", "getBehaviorHints", "()Lcom/Cinemacity/ResponseData$Meta$BehaviorHints;", "getApp_extras", "()Lcom/Cinemacity/ResponseData$Meta$AppExtras;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "", "other", "hashCode", "", "toString", "BehaviorHints", "Link", "Trailer", "TrailerStream", "EpisodeDetails", "AppExtras", "Cast", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Meta {

        @Nullable
        private final String _rawPosterUrl;

        @Nullable
        private final AppExtras app_extras;

        @Nullable
        private final String background;

        @Nullable
        private final BehaviorHints behaviorHints;

        @Nullable
        private final String country;

        @Nullable
        private final String description;

        @Nullable
        private final List<String> director;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final String id;

        @Nullable
        private final String imdbRating;

        @Nullable
        private final String imdb_id;

        @Nullable
        private final List<Link> links;

        @Nullable
        private final String logo;

        @Nullable
        private final String name;

        @Nullable
        private final String poster;

        @Nullable
        private final String releaseInfo;

        @Nullable
        private final String released;

        @Nullable
        private final String runtime;

        @Nullable
        private final String slug;

        @Nullable
        private final String status;

        @Nullable
        private final List<TrailerStream> trailerStreams;

        @Nullable
        private final List<Trailer> trailers;

        @Nullable
        private final String type;

        @Nullable
        private final List<EpisodeDetails> videos;

        @Nullable
        private final List<String> writer;

        @Nullable
        private final String year;

        public Meta() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Meta copy$default(Meta meta, String str, String str2, String str3, String str4, String str5, List list, List list2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List list3, String str14, String str15, String str16, String str17, List list4, List list5, List list6, List list7, BehaviorHints behaviorHints, AppExtras appExtras, int i, Object obj) {
            AppExtras appExtras2;
            BehaviorHints behaviorHints2;
            String str18 = (i & 1) != 0 ? meta.id : str;
            String str19 = (i & 2) != 0 ? meta.type : str2;
            String str20 = (i & 4) != 0 ? meta.name : str3;
            String str21 = (i & 8) != 0 ? meta.imdb_id : str4;
            String str22 = (i & 16) != 0 ? meta.slug : str5;
            List list8 = (i & 32) != 0 ? meta.director : list;
            List list9 = (i & 64) != 0 ? meta.writer : list2;
            String str23 = (i & 128) != 0 ? meta.description : str6;
            String str24 = (i & 256) != 0 ? meta.year : str7;
            String str25 = (i & 512) != 0 ? meta.releaseInfo : str8;
            String str26 = (i & 1024) != 0 ? meta.released : str9;
            String str27 = (i & 2048) != 0 ? meta.runtime : str10;
            String str28 = (i & 4096) != 0 ? meta.status : str11;
            String str29 = (i & 8192) != 0 ? meta.country : str12;
            String str30 = str18;
            String str31 = (i & 16384) != 0 ? meta.imdbRating : str13;
            List list10 = (i & 32768) != 0 ? meta.genres : list3;
            String str32 = (i & 65536) != 0 ? meta.poster : str14;
            String str33 = (i & 131072) != 0 ? meta._rawPosterUrl : str15;
            String str34 = (i & 262144) != 0 ? meta.background : str16;
            String str35 = (i & 524288) != 0 ? meta.logo : str17;
            List list11 = (i & 1048576) != 0 ? meta.videos : list4;
            List list12 = (i & 2097152) != 0 ? meta.trailers : list5;
            List list13 = (i & 4194304) != 0 ? meta.trailerStreams : list6;
            List list14 = (i & 8388608) != 0 ? meta.links : list7;
            BehaviorHints behaviorHints3 = (i & 16777216) != 0 ? meta.behaviorHints : behaviorHints;
            if ((i & 33554432) != 0) {
                behaviorHints2 = behaviorHints3;
                appExtras2 = meta.app_extras;
            } else {
                appExtras2 = appExtras;
                behaviorHints2 = behaviorHints3;
            }
            return meta.copy(str30, str19, str20, str21, str22, list8, list9, str23, str24, str25, str26, str27, str28, str29, str31, list10, str32, str33, str34, str35, list11, list12, list13, list14, behaviorHints2, appExtras2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getReleaseInfo() {
            return this.releaseInfo;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final List<String> component16() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String get_rawPosterUrl() {
            return this._rawPosterUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        public final List<EpisodeDetails> component21() {
            return this.videos;
        }

        @Nullable
        public final List<Trailer> component22() {
            return this.trailers;
        }

        @Nullable
        public final List<TrailerStream> component23() {
            return this.trailerStreams;
        }

        @Nullable
        public final List<Link> component24() {
            return this.links;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final BehaviorHints getBehaviorHints() {
            return this.behaviorHints;
        }

        @Nullable
        /* JADX INFO: renamed from: component26, reason: from getter */
        public final AppExtras getApp_extras() {
            return this.app_extras;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        public final List<String> component6() {
            return this.director;
        }

        @Nullable
        public final List<String> component7() {
            return this.writer;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        @NotNull
        public final Meta copy(@Nullable String id, @Nullable String type, @Nullable String name, @Nullable String imdb_id, @Nullable String slug, @Nullable List<String> director, @Nullable List<String> writer, @Nullable String description, @Nullable String year, @Nullable String releaseInfo, @Nullable String released, @Nullable String runtime, @Nullable String status, @Nullable String country, @Nullable String imdbRating, @Nullable List<String> genres, @Nullable String poster, @Nullable String _rawPosterUrl, @Nullable String background, @Nullable String logo, @Nullable List<EpisodeDetails> videos, @Nullable List<Trailer> trailers, @Nullable List<TrailerStream> trailerStreams, @Nullable List<Link> links, @Nullable BehaviorHints behaviorHints, @Nullable AppExtras app_extras) {
            return new Meta(id, type, name, imdb_id, slug, director, writer, description, year, releaseInfo, released, runtime, status, country, imdbRating, genres, poster, _rawPosterUrl, background, logo, videos, trailers, trailerStreams, links, behaviorHints, app_extras);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) other;
            return Intrinsics.areEqual(this.id, meta.id) && Intrinsics.areEqual(this.type, meta.type) && Intrinsics.areEqual(this.name, meta.name) && Intrinsics.areEqual(this.imdb_id, meta.imdb_id) && Intrinsics.areEqual(this.slug, meta.slug) && Intrinsics.areEqual(this.director, meta.director) && Intrinsics.areEqual(this.writer, meta.writer) && Intrinsics.areEqual(this.description, meta.description) && Intrinsics.areEqual(this.year, meta.year) && Intrinsics.areEqual(this.releaseInfo, meta.releaseInfo) && Intrinsics.areEqual(this.released, meta.released) && Intrinsics.areEqual(this.runtime, meta.runtime) && Intrinsics.areEqual(this.status, meta.status) && Intrinsics.areEqual(this.country, meta.country) && Intrinsics.areEqual(this.imdbRating, meta.imdbRating) && Intrinsics.areEqual(this.genres, meta.genres) && Intrinsics.areEqual(this.poster, meta.poster) && Intrinsics.areEqual(this._rawPosterUrl, meta._rawPosterUrl) && Intrinsics.areEqual(this.background, meta.background) && Intrinsics.areEqual(this.logo, meta.logo) && Intrinsics.areEqual(this.videos, meta.videos) && Intrinsics.areEqual(this.trailers, meta.trailers) && Intrinsics.areEqual(this.trailerStreams, meta.trailerStreams) && Intrinsics.areEqual(this.links, meta.links) && Intrinsics.areEqual(this.behaviorHints, meta.behaviorHints) && Intrinsics.areEqual(this.app_extras, meta.app_extras);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.director == null ? 0 : this.director.hashCode())) * 31) + (this.writer == null ? 0 : this.writer.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.releaseInfo == null ? 0 : this.releaseInfo.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this._rawPosterUrl == null ? 0 : this._rawPosterUrl.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.trailers == null ? 0 : this.trailers.hashCode())) * 31) + (this.trailerStreams == null ? 0 : this.trailerStreams.hashCode())) * 31) + (this.links == null ? 0 : this.links.hashCode())) * 31) + (this.behaviorHints == null ? 0 : this.behaviorHints.hashCode())) * 31) + (this.app_extras != null ? this.app_extras.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Meta(id=").append(this.id).append(", type=").append(this.type).append(", name=").append(this.name).append(", imdb_id=").append(this.imdb_id).append(", slug=").append(this.slug).append(", director=").append(this.director).append(", writer=").append(this.writer).append(", description=").append(this.description).append(", year=").append(this.year).append(", releaseInfo=").append(this.releaseInfo).append(", released=").append(this.released).append(", runtime=");
            sb.append(this.runtime).append(", status=").append(this.status).append(", country=").append(this.country).append(", imdbRating=").append(this.imdbRating).append(", genres=").append(this.genres).append(", poster=").append(this.poster).append(", _rawPosterUrl=").append(this._rawPosterUrl).append(", background=").append(this.background).append(", logo=").append(this.logo).append(", videos=").append(this.videos).append(", trailers=").append(this.trailers).append(", trailerStreams=").append(this.trailerStreams);
            sb.append(", links=").append(this.links).append(", behaviorHints=").append(this.behaviorHints).append(", app_extras=").append(this.app_extras).append(')');
            return sb.toString();
        }

        public Meta(@Nullable String id, @Nullable String type, @Nullable String name, @Nullable String imdb_id, @Nullable String slug, @Nullable List<String> list, @Nullable List<String> list2, @Nullable String description, @Nullable String year, @Nullable String releaseInfo, @Nullable String released, @Nullable String runtime, @Nullable String status, @Nullable String country, @Nullable String imdbRating, @Nullable List<String> list3, @Nullable String poster, @Nullable String _rawPosterUrl, @Nullable String background, @Nullable String logo, @Nullable List<EpisodeDetails> list4, @Nullable List<Trailer> list5, @Nullable List<TrailerStream> list6, @Nullable List<Link> list7, @Nullable BehaviorHints behaviorHints, @Nullable AppExtras app_extras) {
            this.id = id;
            this.type = type;
            this.name = name;
            this.imdb_id = imdb_id;
            this.slug = slug;
            this.director = list;
            this.writer = list2;
            this.description = description;
            this.year = year;
            this.releaseInfo = releaseInfo;
            this.released = released;
            this.runtime = runtime;
            this.status = status;
            this.country = country;
            this.imdbRating = imdbRating;
            this.genres = list3;
            this.poster = poster;
            this._rawPosterUrl = _rawPosterUrl;
            this.background = background;
            this.logo = logo;
            this.videos = list4;
            this.trailers = list5;
            this.trailerStreams = list6;
            this.links = list7;
            this.behaviorHints = behaviorHints;
            this.app_extras = app_extras;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Meta(String str, String str2, String str3, String str4, String str5, List list, List list2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List list3, String str14, String str15, String str16, String str17, List list4, List list5, List list6, List list7, BehaviorHints behaviorHints, AppExtras appExtras, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str18 = (i & 1) != 0 ? null : str;
            String str19 = (i & 2) != 0 ? null : str2;
            String str20 = (i & 4) != 0 ? null : str3;
            String str21 = (i & 8) != 0 ? null : str4;
            String str22 = (i & 16) != 0 ? null : str5;
            List list8 = (i & 32) != 0 ? null : list;
            List list9 = (i & 64) != 0 ? null : list2;
            String str23 = (i & 128) != 0 ? null : str6;
            String str24 = (i & 256) != 0 ? null : str7;
            String str25 = (i & 512) != 0 ? null : str8;
            String str26 = (i & 1024) != 0 ? null : str9;
            String str27 = (i & 2048) != 0 ? null : str10;
            String str28 = (i & 4096) != 0 ? null : str11;
            String str29 = (i & 8192) != 0 ? null : str12;
            String str30 = (i & 16384) != 0 ? null : str13;
            this(str18, str19, str20, str21, str22, list8, list9, str23, str24, str25, str26, str27, str28, str29, str30, (i & 32768) != 0 ? null : list3, (i & 65536) != 0 ? null : str14, (i & 131072) != 0 ? null : str15, (i & 262144) != 0 ? null : str16, (i & 524288) != 0 ? null : str17, (i & 1048576) != 0 ? null : list4, (i & 2097152) != 0 ? null : list5, (i & 4194304) != 0 ? null : list6, (i & 8388608) != 0 ? null : list7, (i & 16777216) != 0 ? null : behaviorHints, (i & 33554432) != 0 ? null : appExtras);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        public final List<String> getDirector() {
            return this.director;
        }

        @Nullable
        public final List<String> getWriter() {
            return this.writer;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        @Nullable
        public final String getReleaseInfo() {
            return this.releaseInfo;
        }

        @Nullable
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        public final String getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
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
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String get_rawPosterUrl() {
            return this._rawPosterUrl;
        }

        @Nullable
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        public final List<EpisodeDetails> getVideos() {
            return this.videos;
        }

        @Nullable
        public final List<Trailer> getTrailers() {
            return this.trailers;
        }

        @Nullable
        public final List<TrailerStream> getTrailerStreams() {
            return this.trailerStreams;
        }

        @Nullable
        public final List<Link> getLinks() {
            return this.links;
        }

        @Nullable
        public final BehaviorHints getBehaviorHints() {
            return this.behaviorHints;
        }

        @Nullable
        public final AppExtras getApp_extras() {
            return this.app_extras;
        }

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/Cinemacity/ResponseData$Meta$BehaviorHints;", "", "defaultVideoId", "hasScheduledVideos", "", "<init>", "(Ljava/lang/Object;Ljava/lang/Boolean;)V", "getDefaultVideoId", "()Ljava/lang/Object;", "getHasScheduledVideos", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Boolean;)Lcom/Cinemacity/ResponseData$Meta$BehaviorHints;", "equals", "other", "hashCode", "", "toString", "", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class BehaviorHints {

            @Nullable
            private final Object defaultVideoId;

            @Nullable
            private final Boolean hasScheduledVideos;

            /* JADX WARN: Illegal instructions before constructor call */
            public BehaviorHints() {
                Boolean bool = null;
                this(bool, bool, 3, bool);
            }

            public static /* synthetic */ BehaviorHints copy$default(BehaviorHints behaviorHints, Object obj, Boolean bool, int i, Object obj2) {
                if ((i & 1) != 0) {
                    obj = behaviorHints.defaultVideoId;
                }
                if ((i & 2) != 0) {
                    bool = behaviorHints.hasScheduledVideos;
                }
                return behaviorHints.copy(obj, bool);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Object getDefaultVideoId() {
                return this.defaultVideoId;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Boolean getHasScheduledVideos() {
                return this.hasScheduledVideos;
            }

            @NotNull
            public final BehaviorHints copy(@Nullable Object defaultVideoId, @Nullable Boolean hasScheduledVideos) {
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
                return Intrinsics.areEqual(this.defaultVideoId, behaviorHints.defaultVideoId) && Intrinsics.areEqual(this.hasScheduledVideos, behaviorHints.hasScheduledVideos);
            }

            public int hashCode() {
                return ((this.defaultVideoId == null ? 0 : this.defaultVideoId.hashCode()) * 31) + (this.hasScheduledVideos != null ? this.hasScheduledVideos.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "BehaviorHints(defaultVideoId=" + this.defaultVideoId + ", hasScheduledVideos=" + this.hasScheduledVideos + ')';
            }

            public BehaviorHints(@Nullable Object defaultVideoId, @Nullable Boolean hasScheduledVideos) {
                this.defaultVideoId = defaultVideoId;
                this.hasScheduledVideos = hasScheduledVideos;
            }

            public /* synthetic */ BehaviorHints(Object obj, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : bool);
            }

            @Nullable
            public final Object getDefaultVideoId() {
                return this.defaultVideoId;
            }

            @Nullable
            public final Boolean getHasScheduledVideos() {
                return this.hasScheduledVideos;
            }
        }

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/Cinemacity/ResponseData$Meta$Link;", "", "name", "", "category", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCategory", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Link {

            @Nullable
            private final String category;

            @Nullable
            private final String name;

            @Nullable
            private final String url;

            public Link() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ Link copy$default(Link link, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = link.name;
                }
                if ((i & 2) != 0) {
                    str2 = link.category;
                }
                if ((i & 4) != 0) {
                    str3 = link.url;
                }
                return link.copy(str, str2, str3);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getCategory() {
                return this.category;
            }

            @Nullable
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            @NotNull
            public final Link copy(@Nullable String name, @Nullable String category, @Nullable String url) {
                return new Link(name, category, url);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Link)) {
                    return false;
                }
                Link link = (Link) other;
                return Intrinsics.areEqual(this.name, link.name) && Intrinsics.areEqual(this.category, link.category) && Intrinsics.areEqual(this.url, link.url);
            }

            public int hashCode() {
                return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.category == null ? 0 : this.category.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Link(name=" + this.name + ", category=" + this.category + ", url=" + this.url + ')';
            }

            public Link(@Nullable String name, @Nullable String category, @Nullable String url) {
                this.name = name;
                this.category = category;
                this.url = url;
            }

            public /* synthetic */ Link(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            @Nullable
            public final String getName() {
                return this.name;
            }

            @Nullable
            public final String getCategory() {
                return this.category;
            }

            @Nullable
            public final String getUrl() {
                return this.url;
            }
        }

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/Cinemacity/ResponseData$Meta$Trailer;", "", "source", "", "type", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getType", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Trailer {

            @Nullable
            private final String name;

            @Nullable
            private final String source;

            @Nullable
            private final String type;

            public Trailer() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ Trailer copy$default(Trailer trailer, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = trailer.source;
                }
                if ((i & 2) != 0) {
                    str2 = trailer.type;
                }
                if ((i & 4) != 0) {
                    str3 = trailer.name;
                }
                return trailer.copy(str, str2, str3);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSource() {
                return this.source;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getType() {
                return this.type;
            }

            @Nullable
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @NotNull
            public final Trailer copy(@Nullable String source, @Nullable String type, @Nullable String name) {
                return new Trailer(source, type, name);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Trailer)) {
                    return false;
                }
                Trailer trailer = (Trailer) other;
                return Intrinsics.areEqual(this.source, trailer.source) && Intrinsics.areEqual(this.type, trailer.type) && Intrinsics.areEqual(this.name, trailer.name);
            }

            public int hashCode() {
                return ((((this.source == null ? 0 : this.source.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.name != null ? this.name.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Trailer(source=" + this.source + ", type=" + this.type + ", name=" + this.name + ')';
            }

            public Trailer(@Nullable String source, @Nullable String type, @Nullable String name) {
                this.source = source;
                this.type = type;
                this.name = name;
            }

            public /* synthetic */ Trailer(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            @Nullable
            public final String getSource() {
                return this.source;
            }

            @Nullable
            public final String getType() {
                return this.type;
            }

            @Nullable
            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/Cinemacity/ResponseData$Meta$TrailerStream;", "", "ytId", "", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getYtId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class TrailerStream {

            @Nullable
            private final String title;

            @Nullable
            private final String ytId;

            /* JADX WARN: Illegal instructions before constructor call */
            public TrailerStream() {
                String str = null;
                this(str, str, 3, str);
            }

            public static /* synthetic */ TrailerStream copy$default(TrailerStream trailerStream, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = trailerStream.ytId;
                }
                if ((i & 2) != 0) {
                    str2 = trailerStream.title;
                }
                return trailerStream.copy(str, str2);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getYtId() {
                return this.ytId;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            @NotNull
            public final TrailerStream copy(@Nullable String ytId, @Nullable String title) {
                return new TrailerStream(ytId, title);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TrailerStream)) {
                    return false;
                }
                TrailerStream trailerStream = (TrailerStream) other;
                return Intrinsics.areEqual(this.ytId, trailerStream.ytId) && Intrinsics.areEqual(this.title, trailerStream.title);
            }

            public int hashCode() {
                return ((this.ytId == null ? 0 : this.ytId.hashCode()) * 31) + (this.title != null ? this.title.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "TrailerStream(ytId=" + this.ytId + ", title=" + this.title + ')';
            }

            public TrailerStream(@Nullable String ytId, @Nullable String title) {
                this.ytId = ytId;
                this.title = title;
            }

            public /* synthetic */ TrailerStream(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            @Nullable
            public final String getYtId() {
                return this.ytId;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }
        }

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011¨\u0006-"}, d2 = {"Lcom/Cinemacity/ResponseData$Meta$EpisodeDetails;", "", "id", "", "name", "season", "", "episode", "thumbnail", "overview", "released", "available", "", "runtime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "getThumbnail", "getOverview", "getReleased", "getAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRuntime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/Cinemacity/ResponseData$Meta$EpisodeDetails;", "equals", "other", "hashCode", "toString", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class EpisodeDetails {

            @Nullable
            private final Boolean available;

            @Nullable
            private final Integer episode;

            @Nullable
            private final String id;

            @Nullable
            private final String name;

            @Nullable
            private final String overview;

            @Nullable
            private final String released;

            @Nullable
            private final String runtime;

            @Nullable
            private final Integer season;

            @Nullable
            private final String thumbnail;

            public EpisodeDetails() {
                this(null, null, null, null, null, null, null, null, null, 511, null);
            }

            public static /* synthetic */ EpisodeDetails copy$default(EpisodeDetails episodeDetails, String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, Boolean bool, String str6, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = episodeDetails.id;
                }
                if ((i & 2) != 0) {
                    str2 = episodeDetails.name;
                }
                if ((i & 4) != 0) {
                    num = episodeDetails.season;
                }
                if ((i & 8) != 0) {
                    num2 = episodeDetails.episode;
                }
                if ((i & 16) != 0) {
                    str3 = episodeDetails.thumbnail;
                }
                if ((i & 32) != 0) {
                    str4 = episodeDetails.overview;
                }
                if ((i & 64) != 0) {
                    str5 = episodeDetails.released;
                }
                if ((i & 128) != 0) {
                    bool = episodeDetails.available;
                }
                if ((i & 256) != 0) {
                    str6 = episodeDetails.runtime;
                }
                Boolean bool2 = bool;
                String str7 = str6;
                String str8 = str4;
                String str9 = str5;
                String str10 = str3;
                Integer num3 = num;
                return episodeDetails.copy(str, str2, num3, num2, str10, str8, str9, bool2, str7);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @Nullable
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Integer getSeason() {
                return this.season;
            }

            @Nullable
            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Integer getEpisode() {
                return this.episode;
            }

            @Nullable
            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getThumbnail() {
                return this.thumbnail;
            }

            @Nullable
            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getOverview() {
                return this.overview;
            }

            @Nullable
            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getReleased() {
                return this.released;
            }

            @Nullable
            /* JADX INFO: renamed from: component8, reason: from getter */
            public final Boolean getAvailable() {
                return this.available;
            }

            @Nullable
            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getRuntime() {
                return this.runtime;
            }

            @NotNull
            public final EpisodeDetails copy(@Nullable String id, @Nullable String name, @Nullable Integer season, @Nullable Integer episode, @Nullable String thumbnail, @Nullable String overview, @Nullable String released, @Nullable Boolean available, @Nullable String runtime) {
                return new EpisodeDetails(id, name, season, episode, thumbnail, overview, released, available, runtime);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EpisodeDetails)) {
                    return false;
                }
                EpisodeDetails episodeDetails = (EpisodeDetails) other;
                return Intrinsics.areEqual(this.id, episodeDetails.id) && Intrinsics.areEqual(this.name, episodeDetails.name) && Intrinsics.areEqual(this.season, episodeDetails.season) && Intrinsics.areEqual(this.episode, episodeDetails.episode) && Intrinsics.areEqual(this.thumbnail, episodeDetails.thumbnail) && Intrinsics.areEqual(this.overview, episodeDetails.overview) && Intrinsics.areEqual(this.released, episodeDetails.released) && Intrinsics.areEqual(this.available, episodeDetails.available) && Intrinsics.areEqual(this.runtime, episodeDetails.runtime);
            }

            public int hashCode() {
                return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.available == null ? 0 : this.available.hashCode())) * 31) + (this.runtime != null ? this.runtime.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "EpisodeDetails(id=" + this.id + ", name=" + this.name + ", season=" + this.season + ", episode=" + this.episode + ", thumbnail=" + this.thumbnail + ", overview=" + this.overview + ", released=" + this.released + ", available=" + this.available + ", runtime=" + this.runtime + ')';
            }

            public EpisodeDetails(@Nullable String id, @Nullable String name, @Nullable Integer season, @Nullable Integer episode, @Nullable String thumbnail, @Nullable String overview, @Nullable String released, @Nullable Boolean available, @Nullable String runtime) {
                this.id = id;
                this.name = name;
                this.season = season;
                this.episode = episode;
                this.thumbnail = thumbnail;
                this.overview = overview;
                this.released = released;
                this.available = available;
                this.runtime = runtime;
            }

            public /* synthetic */ EpisodeDetails(String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, Boolean bool, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : str6);
            }

            @Nullable
            public final String getId() {
                return this.id;
            }

            @Nullable
            public final String getName() {
                return this.name;
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
            public final String getThumbnail() {
                return this.thumbnail;
            }

            @Nullable
            public final String getOverview() {
                return this.overview;
            }

            @Nullable
            public final String getReleased() {
                return this.released;
            }

            @Nullable
            public final Boolean getAvailable() {
                return this.available;
            }

            @Nullable
            public final String getRuntime() {
                return this.runtime;
            }
        }

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003JO\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0007HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/Cinemacity/ResponseData$Meta$AppExtras;", "", "cast", "", "Lcom/Cinemacity/ResponseData$Meta$Cast;", "writers", "seasonPosters", "", "certification", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getCast", "()Ljava/util/List;", "getWriters", "getSeasonPosters", "getCertification", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class AppExtras {

            @Nullable
            private final List<Cast> cast;

            @Nullable
            private final String certification;

            @Nullable
            private final List<String> seasonPosters;

            @Nullable
            private final List<Object> writers;

            public AppExtras() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ AppExtras copy$default(AppExtras appExtras, List list, List list2, List list3, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = appExtras.cast;
                }
                if ((i & 2) != 0) {
                    list2 = appExtras.writers;
                }
                if ((i & 4) != 0) {
                    list3 = appExtras.seasonPosters;
                }
                if ((i & 8) != 0) {
                    str = appExtras.certification;
                }
                return appExtras.copy(list, list2, list3, str);
            }

            @Nullable
            public final List<Cast> component1() {
                return this.cast;
            }

            @Nullable
            public final List<Object> component2() {
                return this.writers;
            }

            @Nullable
            public final List<String> component3() {
                return this.seasonPosters;
            }

            @Nullable
            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getCertification() {
                return this.certification;
            }

            @NotNull
            public final AppExtras copy(@Nullable List<Cast> cast, @Nullable List<? extends Object> writers, @Nullable List<String> seasonPosters, @Nullable String certification) {
                return new AppExtras(cast, writers, seasonPosters, certification);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AppExtras)) {
                    return false;
                }
                AppExtras appExtras = (AppExtras) other;
                return Intrinsics.areEqual(this.cast, appExtras.cast) && Intrinsics.areEqual(this.writers, appExtras.writers) && Intrinsics.areEqual(this.seasonPosters, appExtras.seasonPosters) && Intrinsics.areEqual(this.certification, appExtras.certification);
            }

            public int hashCode() {
                return ((((((this.cast == null ? 0 : this.cast.hashCode()) * 31) + (this.writers == null ? 0 : this.writers.hashCode())) * 31) + (this.seasonPosters == null ? 0 : this.seasonPosters.hashCode())) * 31) + (this.certification != null ? this.certification.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "AppExtras(cast=" + this.cast + ", writers=" + this.writers + ", seasonPosters=" + this.seasonPosters + ", certification=" + this.certification + ')';
            }

            public AppExtras(@Nullable List<Cast> list, @Nullable List<? extends Object> list2, @Nullable List<String> list3, @Nullable String certification) {
                this.cast = list;
                this.writers = list2;
                this.seasonPosters = list3;
                this.certification = certification;
            }

            public /* synthetic */ AppExtras(List list, List list2, List list3, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : str);
            }

            @Nullable
            public final List<Cast> getCast() {
                return this.cast;
            }

            @Nullable
            public final List<Object> getWriters() {
                return this.writers;
            }

            @Nullable
            public final List<String> getSeasonPosters() {
                return this.seasonPosters;
            }

            @Nullable
            public final String getCertification() {
                return this.certification;
            }
        }

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/Cinemacity/ResponseData$Meta$Cast;", "", "name", "", "character", "photo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCharacter", "getPhoto", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Cast {

            @Nullable
            private final String character;

            @Nullable
            private final String name;

            @Nullable
            private final String photo;

            public Cast() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ Cast copy$default(Cast cast, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = cast.name;
                }
                if ((i & 2) != 0) {
                    str2 = cast.character;
                }
                if ((i & 4) != 0) {
                    str3 = cast.photo;
                }
                return cast.copy(str, str2, str3);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getCharacter() {
                return this.character;
            }

            @Nullable
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getPhoto() {
                return this.photo;
            }

            @NotNull
            public final Cast copy(@Nullable String name, @Nullable String character, @Nullable String photo) {
                return new Cast(name, character, photo);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Cast)) {
                    return false;
                }
                Cast cast = (Cast) other;
                return Intrinsics.areEqual(this.name, cast.name) && Intrinsics.areEqual(this.character, cast.character) && Intrinsics.areEqual(this.photo, cast.photo);
            }

            public int hashCode() {
                return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.character == null ? 0 : this.character.hashCode())) * 31) + (this.photo != null ? this.photo.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Cast(name=" + this.name + ", character=" + this.character + ", photo=" + this.photo + ')';
            }

            public Cast(@Nullable String name, @Nullable String character, @Nullable String photo) {
                this.name = name;
                this.character = character;
                this.photo = photo;
            }

            public /* synthetic */ Cast(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            @Nullable
            public final String getName() {
                return this.name;
            }

            @Nullable
            public final String getCharacter() {
                return this.character;
            }

            @Nullable
            public final String getPhoto() {
                return this.photo;
            }
        }
    }
}
