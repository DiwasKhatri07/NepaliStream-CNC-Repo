package com.idlix;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b[\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bï\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010HJ\u000b\u0010u\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010}\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000eHÆ\u0003J\u0011\u0010~\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000eHÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0002\u0010dJø\u0002\u0010\u0083\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0003\u0010\u0084\u0001J\u0016\u0010\u0085\u0001\u001a\u00020$2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\u000b\u0010\u0087\u0001\u001a\u00020\u0012HÖ\u0081\u0004J\u000b\u0010\u0088\u0001\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R,\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(0¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010(R,\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(3¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010,\u001a\u0004\b2\u0010(R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R,\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(8¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010,\u001a\u0004\b7\u0010(R,\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(;¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010,\u001a\u0004\b:\u0010(R,\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(>¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010,\u001a\u0004\b=\u0010(R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R,\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(C¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010,\u001a\u0004\bB\u0010(R,\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(F¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010,\u001a\u0004\bE\u0010(R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010HR,\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(M¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010,\u001a\u0004\bK\u0010LR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bN\u0010LR,\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(Q¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010,\u001a\u0004\bP\u0010(R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010(R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010(R,\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(V¢\u0006\u000e\n\u0000\u0012\u0004\bT\u0010,\u001a\u0004\bU\u0010(R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010(R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u0010(R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010@R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010@R\u0019\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010@R,\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(_¢\u0006\u000e\n\u0000\u0012\u0004\b\\\u0010,\u001a\u0004\b]\u0010^R,\u0010\"\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(b¢\u0006\u000e\n\u0000\u0012\u0004\b`\u0010,\u001a\u0004\ba\u0010LR.\u0010#\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004r\f\b.\u0012\b\b/\u0012\u0004\b\b(f¢\u0006\u0010\n\u0002\u0010e\u0012\u0004\bc\u0010,\u001a\u0004\b#\u0010dÊ\u0001\u0003\b\u008a\u0001¨\u0006\u0089\u0001"}, d2 = {"Lcom/idlix/DetailResponse;", "", "id", "", "title", "slug", "imdbId", "tmdbId", "overview", "tagline", "posterPath", "backdropPath", "logoPath", "backdrops", "", "releaseDate", "firstAirDate", "runtime", "", "voteAverage", "popularity", "originalLanguage", "country", "status", "trailerUrl", "quality", "director", "genres", "Lcom/idlix/Genre;", "cast", "Lcom/idlix/Cast;", "seasons", "Lcom/idlix/Season;", "firstSeason", "viewCount", "isPublished", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/idlix/Season;Ljava/lang/Object;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getTitle", "getSlug", "getImdbId$annotations", "()V", "getImdbId", "Lkotlinx/serialization/SerialName;", "value", "imdb_id", "getTmdbId$annotations", "getTmdbId", "tmdb_id", "getOverview", "getTagline", "getPosterPath$annotations", "getPosterPath", "poster_path", "getBackdropPath$annotations", "getBackdropPath", "backdrop_path", "getLogoPath$annotations", "getLogoPath", "logo_path", "getBackdrops", "()Ljava/util/List;", "getReleaseDate$annotations", "getReleaseDate", "release_date", "getFirstAirDate$annotations", "getFirstAirDate", "first_air_date", "getRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVoteAverage$annotations", "getVoteAverage", "()Ljava/lang/Object;", "vote_average", "getPopularity", "getOriginalLanguage$annotations", "getOriginalLanguage", "original_language", "getCountry", "getStatus", "getTrailerUrl$annotations", "getTrailerUrl", "trailer_url", "getQuality", "getDirector", "getGenres", "getCast", "getSeasons", "getFirstSeason$annotations", "getFirstSeason", "()Lcom/idlix/Season;", "first_season", "getViewCount$annotations", "getViewCount", "view_count", "isPublished$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_published", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/idlix/Season;Ljava/lang/Object;Ljava/lang/Boolean;)Lcom/idlix/DetailResponse;", "equals", "other", "hashCode", "toString", "IdlixProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class DetailResponse {

    @Nullable
    private final String backdropPath;

    @Nullable
    private final List<String> backdrops;

    @Nullable
    private final List<Cast> cast;

    @Nullable
    private final String country;

    @Nullable
    private final String director;

    @Nullable
    private final String firstAirDate;

    @Nullable
    private final Season firstSeason;

    @Nullable
    private final List<Genre> genres;

    @Nullable
    private final String id;

    @Nullable
    private final String imdbId;

    @Nullable
    private final Boolean isPublished;

    @Nullable
    private final String logoPath;

    @Nullable
    private final String originalLanguage;

    @Nullable
    private final String overview;

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
    private final List<Season> seasons;

    @Nullable
    private final String slug;

    @Nullable
    private final String status;

    @Nullable
    private final String tagline;

    @Nullable
    private final String title;

    @Nullable
    private final String tmdbId;

    @Nullable
    private final String trailerUrl;

    @Nullable
    private final Object viewCount;

    @Nullable
    private final Object voteAverage;

    public DetailResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 268435455, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DetailResponse copy$default(DetailResponse detailResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list, String str11, String str12, Integer num, Object obj, Object obj2, String str13, String str14, String str15, String str16, String str17, String str18, List list2, List list3, List list4, Season season, Object obj3, Boolean bool, int i, Object obj4) {
        Boolean bool2;
        Object obj5;
        String str19 = (i & 1) != 0 ? detailResponse.id : str;
        String str20 = (i & 2) != 0 ? detailResponse.title : str2;
        String str21 = (i & 4) != 0 ? detailResponse.slug : str3;
        String str22 = (i & 8) != 0 ? detailResponse.imdbId : str4;
        String str23 = (i & 16) != 0 ? detailResponse.tmdbId : str5;
        String str24 = (i & 32) != 0 ? detailResponse.overview : str6;
        String str25 = (i & 64) != 0 ? detailResponse.tagline : str7;
        String str26 = (i & 128) != 0 ? detailResponse.posterPath : str8;
        String str27 = (i & 256) != 0 ? detailResponse.backdropPath : str9;
        String str28 = (i & 512) != 0 ? detailResponse.logoPath : str10;
        List list5 = (i & 1024) != 0 ? detailResponse.backdrops : list;
        String str29 = (i & 2048) != 0 ? detailResponse.releaseDate : str11;
        String str30 = (i & 4096) != 0 ? detailResponse.firstAirDate : str12;
        Integer num2 = (i & 8192) != 0 ? detailResponse.runtime : num;
        String str31 = str19;
        Object obj6 = (i & 16384) != 0 ? detailResponse.voteAverage : obj;
        Object obj7 = (i & 32768) != 0 ? detailResponse.popularity : obj2;
        String str32 = (i & 65536) != 0 ? detailResponse.originalLanguage : str13;
        String str33 = (i & 131072) != 0 ? detailResponse.country : str14;
        String str34 = (i & 262144) != 0 ? detailResponse.status : str15;
        String str35 = (i & 524288) != 0 ? detailResponse.trailerUrl : str16;
        String str36 = (i & 1048576) != 0 ? detailResponse.quality : str17;
        String str37 = (i & 2097152) != 0 ? detailResponse.director : str18;
        List list6 = (i & 4194304) != 0 ? detailResponse.genres : list2;
        List list7 = (i & 8388608) != 0 ? detailResponse.cast : list3;
        List list8 = (i & 16777216) != 0 ? detailResponse.seasons : list4;
        Season season2 = (i & 33554432) != 0 ? detailResponse.firstSeason : season;
        Object obj8 = (i & 67108864) != 0 ? detailResponse.viewCount : obj3;
        if ((i & 134217728) != 0) {
            obj5 = obj8;
            bool2 = detailResponse.isPublished;
        } else {
            bool2 = bool;
            obj5 = obj8;
        }
        return detailResponse.copy(str31, str20, str21, str22, str23, str24, str25, str26, str27, str28, list5, str29, str30, num2, obj6, obj7, str32, str33, str34, str35, str36, str37, list6, list7, list8, season2, obj5, bool2);
    }

    @SerialName("backdrop_path")
    public static /* synthetic */ void getBackdropPath$annotations() {
    }

    @SerialName("first_air_date")
    public static /* synthetic */ void getFirstAirDate$annotations() {
    }

    @SerialName("first_season")
    public static /* synthetic */ void getFirstSeason$annotations() {
    }

    @SerialName("imdb_id")
    public static /* synthetic */ void getImdbId$annotations() {
    }

    @SerialName("logo_path")
    public static /* synthetic */ void getLogoPath$annotations() {
    }

    @SerialName("original_language")
    public static /* synthetic */ void getOriginalLanguage$annotations() {
    }

    @SerialName("poster_path")
    public static /* synthetic */ void getPosterPath$annotations() {
    }

    @SerialName("release_date")
    public static /* synthetic */ void getReleaseDate$annotations() {
    }

    @SerialName("tmdb_id")
    public static /* synthetic */ void getTmdbId$annotations() {
    }

    @SerialName("trailer_url")
    public static /* synthetic */ void getTrailerUrl$annotations() {
    }

    @SerialName("view_count")
    public static /* synthetic */ void getViewCount$annotations() {
    }

    @SerialName("vote_average")
    public static /* synthetic */ void getVoteAverage$annotations() {
    }

    @SerialName("is_published")
    public static /* synthetic */ void isPublished$annotations() {
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getLogoPath() {
        return this.logoPath;
    }

    @Nullable
    public final List<String> component11() {
        return this.backdrops;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getFirstAirDate() {
        return this.firstAirDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Object getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Object getPopularity() {
        return this.popularity;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getOriginalLanguage() {
        return this.originalLanguage;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getTrailerUrl() {
        return this.trailerUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getDirector() {
        return this.director;
    }

    @Nullable
    public final List<Genre> component23() {
        return this.genres;
    }

    @Nullable
    public final List<Cast> component24() {
        return this.cast;
    }

    @Nullable
    public final List<Season> component25() {
        return this.seasons;
    }

    @Nullable
    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Season getFirstSeason() {
        return this.firstSeason;
    }

    @Nullable
    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Object getViewCount() {
        return this.viewCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component28, reason: from getter */
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
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTmdbId() {
        return this.tmdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTagline() {
        return this.tagline;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getBackdropPath() {
        return this.backdropPath;
    }

    @NotNull
    public final DetailResponse copy(@Nullable String id, @Nullable String title, @Nullable String slug, @Nullable String imdbId, @Nullable String tmdbId, @Nullable String overview, @Nullable String tagline, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String logoPath, @Nullable List<String> backdrops, @Nullable String releaseDate, @Nullable String firstAirDate, @Nullable Integer runtime, @Nullable Object voteAverage, @Nullable Object popularity, @Nullable String originalLanguage, @Nullable String country, @Nullable String status, @Nullable String trailerUrl, @Nullable String quality, @Nullable String director, @Nullable List<Genre> genres, @Nullable List<Cast> cast, @Nullable List<Season> seasons, @Nullable Season firstSeason, @Nullable Object viewCount, @Nullable Boolean isPublished) {
        return new DetailResponse(id, title, slug, imdbId, tmdbId, overview, tagline, posterPath, backdropPath, logoPath, backdrops, releaseDate, firstAirDate, runtime, voteAverage, popularity, originalLanguage, country, status, trailerUrl, quality, director, genres, cast, seasons, firstSeason, viewCount, isPublished);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetailResponse)) {
            return false;
        }
        DetailResponse detailResponse = (DetailResponse) other;
        return Intrinsics.areEqual(this.id, detailResponse.id) && Intrinsics.areEqual(this.title, detailResponse.title) && Intrinsics.areEqual(this.slug, detailResponse.slug) && Intrinsics.areEqual(this.imdbId, detailResponse.imdbId) && Intrinsics.areEqual(this.tmdbId, detailResponse.tmdbId) && Intrinsics.areEqual(this.overview, detailResponse.overview) && Intrinsics.areEqual(this.tagline, detailResponse.tagline) && Intrinsics.areEqual(this.posterPath, detailResponse.posterPath) && Intrinsics.areEqual(this.backdropPath, detailResponse.backdropPath) && Intrinsics.areEqual(this.logoPath, detailResponse.logoPath) && Intrinsics.areEqual(this.backdrops, detailResponse.backdrops) && Intrinsics.areEqual(this.releaseDate, detailResponse.releaseDate) && Intrinsics.areEqual(this.firstAirDate, detailResponse.firstAirDate) && Intrinsics.areEqual(this.runtime, detailResponse.runtime) && Intrinsics.areEqual(this.voteAverage, detailResponse.voteAverage) && Intrinsics.areEqual(this.popularity, detailResponse.popularity) && Intrinsics.areEqual(this.originalLanguage, detailResponse.originalLanguage) && Intrinsics.areEqual(this.country, detailResponse.country) && Intrinsics.areEqual(this.status, detailResponse.status) && Intrinsics.areEqual(this.trailerUrl, detailResponse.trailerUrl) && Intrinsics.areEqual(this.quality, detailResponse.quality) && Intrinsics.areEqual(this.director, detailResponse.director) && Intrinsics.areEqual(this.genres, detailResponse.genres) && Intrinsics.areEqual(this.cast, detailResponse.cast) && Intrinsics.areEqual(this.seasons, detailResponse.seasons) && Intrinsics.areEqual(this.firstSeason, detailResponse.firstSeason) && Intrinsics.areEqual(this.viewCount, detailResponse.viewCount) && Intrinsics.areEqual(this.isPublished, detailResponse.isPublished);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.tagline == null ? 0 : this.tagline.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.backdropPath == null ? 0 : this.backdropPath.hashCode())) * 31) + (this.logoPath == null ? 0 : this.logoPath.hashCode())) * 31) + (this.backdrops == null ? 0 : this.backdrops.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.firstAirDate == null ? 0 : this.firstAirDate.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.popularity == null ? 0 : this.popularity.hashCode())) * 31) + (this.originalLanguage == null ? 0 : this.originalLanguage.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.trailerUrl == null ? 0 : this.trailerUrl.hashCode())) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.director == null ? 0 : this.director.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.cast == null ? 0 : this.cast.hashCode())) * 31) + (this.seasons == null ? 0 : this.seasons.hashCode())) * 31) + (this.firstSeason == null ? 0 : this.firstSeason.hashCode())) * 31) + (this.viewCount == null ? 0 : this.viewCount.hashCode())) * 31) + (this.isPublished != null ? this.isPublished.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DetailResponse(id=").append(this.id).append(", title=").append(this.title).append(", slug=").append(this.slug).append(", imdbId=").append(this.imdbId).append(", tmdbId=").append(this.tmdbId).append(", overview=").append(this.overview).append(", tagline=").append(this.tagline).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", logoPath=").append(this.logoPath).append(", backdrops=").append(this.backdrops).append(", releaseDate=");
        sb.append(this.releaseDate).append(", firstAirDate=").append(this.firstAirDate).append(", runtime=").append(this.runtime).append(", voteAverage=").append(this.voteAverage).append(", popularity=").append(this.popularity).append(", originalLanguage=").append(this.originalLanguage).append(", country=").append(this.country).append(", status=").append(this.status).append(", trailerUrl=").append(this.trailerUrl).append(", quality=").append(this.quality).append(", director=").append(this.director).append(", genres=").append(this.genres);
        sb.append(", cast=").append(this.cast).append(", seasons=").append(this.seasons).append(", firstSeason=").append(this.firstSeason).append(", viewCount=").append(this.viewCount).append(", isPublished=").append(this.isPublished).append(')');
        return sb.toString();
    }

    public DetailResponse(@Nullable String id, @Nullable String title, @Nullable String slug, @Nullable String imdbId, @Nullable String tmdbId, @Nullable String overview, @Nullable String tagline, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String logoPath, @Nullable List<String> list, @Nullable String releaseDate, @Nullable String firstAirDate, @Nullable Integer runtime, @Nullable Object voteAverage, @Nullable Object popularity, @Nullable String originalLanguage, @Nullable String country, @Nullable String status, @Nullable String trailerUrl, @Nullable String quality, @Nullable String director, @Nullable List<Genre> list2, @Nullable List<Cast> list3, @Nullable List<Season> list4, @Nullable Season firstSeason, @Nullable Object viewCount, @Nullable Boolean isPublished) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
        this.overview = overview;
        this.tagline = tagline;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.logoPath = logoPath;
        this.backdrops = list;
        this.releaseDate = releaseDate;
        this.firstAirDate = firstAirDate;
        this.runtime = runtime;
        this.voteAverage = voteAverage;
        this.popularity = popularity;
        this.originalLanguage = originalLanguage;
        this.country = country;
        this.status = status;
        this.trailerUrl = trailerUrl;
        this.quality = quality;
        this.director = director;
        this.genres = list2;
        this.cast = list3;
        this.seasons = list4;
        this.firstSeason = firstSeason;
        this.viewCount = viewCount;
        this.isPublished = isPublished;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DetailResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list, String str11, String str12, Integer num, Object obj, Object obj2, String str13, String str14, String str15, String str16, String str17, String str18, List list2, List list3, List list4, Season season, Object obj3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str19 = (i & 1) != 0 ? null : str;
        String str20 = (i & 2) != 0 ? null : str2;
        String str21 = (i & 4) != 0 ? null : str3;
        String str22 = (i & 8) != 0 ? null : str4;
        String str23 = (i & 16) != 0 ? null : str5;
        String str24 = (i & 32) != 0 ? null : str6;
        String str25 = (i & 64) != 0 ? null : str7;
        String str26 = (i & 128) != 0 ? null : str8;
        String str27 = (i & 256) != 0 ? null : str9;
        String str28 = (i & 512) != 0 ? null : str10;
        List list5 = (i & 1024) != 0 ? null : list;
        String str29 = (i & 2048) != 0 ? null : str11;
        String str30 = (i & 4096) != 0 ? null : str12;
        Integer num2 = (i & 8192) != 0 ? null : num;
        Object obj4 = (i & 16384) != 0 ? null : obj;
        this(str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, list5, str29, str30, num2, obj4, (i & 32768) != 0 ? null : obj2, (i & 65536) != 0 ? null : str13, (i & 131072) != 0 ? null : str14, (i & 262144) != 0 ? null : str15, (i & 524288) != 0 ? null : str16, (i & 1048576) != 0 ? null : str17, (i & 2097152) != 0 ? null : str18, (i & 4194304) != 0 ? null : list2, (i & 8388608) != 0 ? null : list3, (i & 16777216) != 0 ? null : list4, (i & 33554432) != 0 ? null : season, (i & 67108864) != 0 ? null : obj3, (i & 134217728) != 0 ? null : bool);
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
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    public final String getTmdbId() {
        return this.tmdbId;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getTagline() {
        return this.tagline;
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
    public final String getLogoPath() {
        return this.logoPath;
    }

    @Nullable
    public final List<String> getBackdrops() {
        return this.backdrops;
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
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final Object getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    public final Object getPopularity() {
        return this.popularity;
    }

    @Nullable
    public final String getOriginalLanguage() {
        return this.originalLanguage;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTrailerUrl() {
        return this.trailerUrl;
    }

    @Nullable
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final String getDirector() {
        return this.director;
    }

    @Nullable
    public final List<Genre> getGenres() {
        return this.genres;
    }

    @Nullable
    public final List<Cast> getCast() {
        return this.cast;
    }

    @Nullable
    public final List<Season> getSeasons() {
        return this.seasons;
    }

    @Nullable
    public final Season getFirstSeason() {
        return this.firstSeason;
    }

    @Nullable
    public final Object getViewCount() {
        return this.viewCount;
    }

    @Nullable
    public final Boolean isPublished() {
        return this.isPublished;
    }
}
