package com.dudefilms;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DudeFilms/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/dudefilms/ResponseData;", "", "meta", "Lcom/dudefilms/ResponseData$Meta;", "<init>", "(Lcom/dudefilms/ResponseData$Meta;)V", "getMeta", "()Lcom/dudefilms/ResponseData$Meta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Meta", "DudeFilms"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001+B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bHÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0087\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006,"}, d2 = {"Lcom/dudefilms/ResponseData$Meta;", "", "name", "", "description", "year", "imdbRating", "genres", "", "poster", "background", "videos", "Lcom/dudefilms/ResponseData$Meta$EpisodeDetails;", "cast", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getDescription", "getYear", "getImdbRating", "getGenres", "()Ljava/util/List;", "getPoster", "getBackground", "getVideos", "getCast", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "EpisodeDetails", "DudeFilms"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Meta {

        @Nullable
        private final String background;

        @Nullable
        private final List<String> cast;

        @Nullable
        private final String description;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final String imdbRating;

        @Nullable
        private final String name;

        @Nullable
        private final String poster;

        @Nullable
        private final List<EpisodeDetails> videos;

        @Nullable
        private final String year;

        public Meta() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Meta copy$default(Meta meta, String str, String str2, String str3, String str4, List list, String str5, String str6, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = meta.name;
            }
            if ((i & 2) != 0) {
                str2 = meta.description;
            }
            if ((i & 4) != 0) {
                str3 = meta.year;
            }
            if ((i & 8) != 0) {
                str4 = meta.imdbRating;
            }
            if ((i & 16) != 0) {
                list = meta.genres;
            }
            if ((i & 32) != 0) {
                str5 = meta.poster;
            }
            if ((i & 64) != 0) {
                str6 = meta.background;
            }
            if ((i & 128) != 0) {
                list2 = meta.videos;
            }
            if ((i & 256) != 0) {
                list3 = meta.cast;
            }
            List list4 = list2;
            List list5 = list3;
            String str7 = str5;
            String str8 = str6;
            List list6 = list;
            String str9 = str3;
            return meta.copy(str, str2, str9, str4, list6, str7, str8, list4, list5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final List<String> component5() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        public final List<EpisodeDetails> component8() {
            return this.videos;
        }

        @Nullable
        public final List<String> component9() {
            return this.cast;
        }

        @NotNull
        public final Meta copy(@Nullable String name, @Nullable String description, @Nullable String year, @Nullable String imdbRating, @Nullable List<String> genres, @Nullable String poster, @Nullable String background, @Nullable List<EpisodeDetails> videos, @Nullable List<String> cast) {
            return new Meta(name, description, year, imdbRating, genres, poster, background, videos, cast);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) other;
            return Intrinsics.areEqual(this.name, meta.name) && Intrinsics.areEqual(this.description, meta.description) && Intrinsics.areEqual(this.year, meta.year) && Intrinsics.areEqual(this.imdbRating, meta.imdbRating) && Intrinsics.areEqual(this.genres, meta.genres) && Intrinsics.areEqual(this.poster, meta.poster) && Intrinsics.areEqual(this.background, meta.background) && Intrinsics.areEqual(this.videos, meta.videos) && Intrinsics.areEqual(this.cast, meta.cast);
        }

        public int hashCode() {
            return ((((((((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.cast != null ? this.cast.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Meta(name=" + this.name + ", description=" + this.description + ", year=" + this.year + ", imdbRating=" + this.imdbRating + ", genres=" + this.genres + ", poster=" + this.poster + ", background=" + this.background + ", videos=" + this.videos + ", cast=" + this.cast + ')';
        }

        public Meta(@Nullable String name, @Nullable String description, @Nullable String year, @Nullable String imdbRating, @Nullable List<String> list, @Nullable String poster, @Nullable String background, @Nullable List<EpisodeDetails> list2, @Nullable List<String> list3) {
            this.name = name;
            this.description = description;
            this.year = year;
            this.imdbRating = imdbRating;
            this.genres = list;
            this.poster = poster;
            this.background = background;
            this.videos = list2;
            this.cast = list3;
        }

        public /* synthetic */ Meta(String str, String str2, String str3, String str4, List list, String str5, String str6, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : list3);
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
        public final String getYear() {
            return this.year;
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
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        public final List<EpisodeDetails> getVideos() {
            return this.videos;
        }

        @Nullable
        public final List<String> getCast() {
            return this.cast;
        }

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/dudefilms/ResponseData$Meta$EpisodeDetails;", "", "name", "", "season", "", "episode", "thumbnail", "overview", "released", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "getThumbnail", "getOverview", "getReleased", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/dudefilms/ResponseData$Meta$EpisodeDetails;", "equals", "", "other", "hashCode", "toString", "DudeFilms"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class EpisodeDetails {

            @Nullable
            private final Integer episode;

            @Nullable
            private final String name;

            @Nullable
            private final String overview;

            @Nullable
            private final String released;

            @Nullable
            private final Integer season;

            @Nullable
            private final String thumbnail;

            public EpisodeDetails() {
                this(null, null, null, null, null, null, 63, null);
            }

            public static /* synthetic */ EpisodeDetails copy$default(EpisodeDetails episodeDetails, String str, Integer num, Integer num2, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = episodeDetails.name;
                }
                if ((i & 2) != 0) {
                    num = episodeDetails.season;
                }
                if ((i & 4) != 0) {
                    num2 = episodeDetails.episode;
                }
                if ((i & 8) != 0) {
                    str2 = episodeDetails.thumbnail;
                }
                if ((i & 16) != 0) {
                    str3 = episodeDetails.overview;
                }
                if ((i & 32) != 0) {
                    str4 = episodeDetails.released;
                }
                String str5 = str3;
                String str6 = str4;
                return episodeDetails.copy(str, num, num2, str2, str5, str6);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
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
            public final String getThumbnail() {
                return this.thumbnail;
            }

            @Nullable
            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getOverview() {
                return this.overview;
            }

            @Nullable
            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getReleased() {
                return this.released;
            }

            @NotNull
            public final EpisodeDetails copy(@Nullable String name, @Nullable Integer season, @Nullable Integer episode, @Nullable String thumbnail, @Nullable String overview, @Nullable String released) {
                return new EpisodeDetails(name, season, episode, thumbnail, overview, released);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EpisodeDetails)) {
                    return false;
                }
                EpisodeDetails episodeDetails = (EpisodeDetails) other;
                return Intrinsics.areEqual(this.name, episodeDetails.name) && Intrinsics.areEqual(this.season, episodeDetails.season) && Intrinsics.areEqual(this.episode, episodeDetails.episode) && Intrinsics.areEqual(this.thumbnail, episodeDetails.thumbnail) && Intrinsics.areEqual(this.overview, episodeDetails.overview) && Intrinsics.areEqual(this.released, episodeDetails.released);
            }

            public int hashCode() {
                return ((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.released != null ? this.released.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "EpisodeDetails(name=" + this.name + ", season=" + this.season + ", episode=" + this.episode + ", thumbnail=" + this.thumbnail + ", overview=" + this.overview + ", released=" + this.released + ')';
            }

            public EpisodeDetails(@Nullable String name, @Nullable Integer season, @Nullable Integer episode, @Nullable String thumbnail, @Nullable String overview, @Nullable String released) {
                this.name = name;
                this.season = season;
                this.episode = episode;
                this.thumbnail = thumbnail;
                this.overview = overview;
                this.released = released;
            }

            public /* synthetic */ EpisodeDetails(String str, Integer num, Integer num2, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
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
        }
    }
}
