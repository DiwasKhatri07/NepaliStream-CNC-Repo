package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\u001c\b\u0002\u0010'\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020(\u0018\u0001`\u0016¢\u0006\u0004\b)\u0010*J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010h\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u001d\u0010k\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u0016HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010&HÆ\u0003J\u001d\u0010q\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020(\u0018\u0001`\u0016HÆ\u0003Jð\u0002\u0010r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\b\u0002\u0010'\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020(\u0018\u0001`\u0016HÆ\u0001¢\u0006\u0002\u0010sJ\u0014\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010w\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010x\u001a\u00020\u0005HÖ\u0081\u0004R%\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R#\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(2¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R#\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R#\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R#\u0010\b\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(6¢\u0006\b\n\u0000\u001a\u0004\b5\u00101R#\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(8¢\u0006\b\n\u0000\u001a\u0004\b7\u00101R#\u0010\n\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(:¢\u0006\b\n\u0000\u001a\u0004\b9\u00101R#\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(<¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R#\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(>¢\u0006\b\n\u0000\u001a\u0004\b=\u00101R#\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(@¢\u0006\b\n\u0000\u001a\u0004\b?\u00101R#\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u00101R%\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u000f¢\u0006\n\n\u0002\u0010-\u001a\u0004\bB\u0010,R#\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR#\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\bE\u00101R#\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0012¢\u0006\b\n\u0000\u001a\u0004\bF\u00101R5\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR#\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0017¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR#\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0019¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR5\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u00168\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u001b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010HR#\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u001d¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR#\u0010\u001f\u001a\u0004\u0018\u00010 8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u001f¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR#\u0010!\u001a\u0004\u0018\u00010\"8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(!¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR#\u0010#\u001a\u0004\u0018\u00010$8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(#¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR#\u0010%\u001a\u0004\u0018\u00010&8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(%¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR5\u0010'\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020(\u0018\u0001`\u00168\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b('¢\u0006\b\n\u0000\u001a\u0004\bX\u0010H¨\u0006y"}, d2 = {"Lcom/phisher98/MediaDetail;", "", "id", "", "imdbId", "", "title", "name", "originalTitle", "originalName", "posterPath", "backdropPath", "releaseDate", "firstAirDate", "overview", "runtime", "vote_average", "original_language", "status", "genres", "Ljava/util/ArrayList;", "Lcom/phisher98/Genres;", "Lkotlin/collections/ArrayList;", "keywords", "Lcom/phisher98/KeywordResults;", "last_episode_to_air", "Lcom/phisher98/LastEpisodeToAir;", "seasons", "Lcom/phisher98/Seasons;", "videos", "Lcom/phisher98/ResultsTrailer;", "external_ids", "Lcom/phisher98/ExternalIds;", "credits", "Lcom/phisher98/Credits;", "recommendations", "Lcom/phisher98/ResultsRecommendations;", "alternative_titles", "Lcom/phisher98/ResultsAltTitles;", "production_countries", "Lcom/phisher98/ProductionCountries;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/phisher98/KeywordResults;Lcom/phisher98/LastEpisodeToAir;Ljava/util/ArrayList;Lcom/phisher98/ResultsTrailer;Lcom/phisher98/ExternalIds;Lcom/phisher98/Credits;Lcom/phisher98/ResultsRecommendations;Lcom/phisher98/ResultsAltTitles;Ljava/util/ArrayList;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getImdbId", "()Ljava/lang/String;", "imdb_id", "getTitle", "getName", "getOriginalTitle", "original_title", "getOriginalName", "original_name", "getPosterPath", "poster_path", "getBackdropPath", "backdrop_path", "getReleaseDate", "release_date", "getFirstAirDate", "first_air_date", "getOverview", "getRuntime", "getVote_average", "()Ljava/lang/Object;", "getOriginal_language", "getStatus", "getGenres", "()Ljava/util/ArrayList;", "getKeywords", "()Lcom/phisher98/KeywordResults;", "getLast_episode_to_air", "()Lcom/phisher98/LastEpisodeToAir;", "getSeasons", "getVideos", "()Lcom/phisher98/ResultsTrailer;", "getExternal_ids", "()Lcom/phisher98/ExternalIds;", "getCredits", "()Lcom/phisher98/Credits;", "getRecommendations", "()Lcom/phisher98/ResultsRecommendations;", "getAlternative_titles", "()Lcom/phisher98/ResultsAltTitles;", "getProduction_countries", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/phisher98/KeywordResults;Lcom/phisher98/LastEpisodeToAir;Ljava/util/ArrayList;Lcom/phisher98/ResultsTrailer;Lcom/phisher98/ExternalIds;Lcom/phisher98/Credits;Lcom/phisher98/ResultsRecommendations;Lcom/phisher98/ResultsAltTitles;Ljava/util/ArrayList;)Lcom/phisher98/MediaDetail;", "equals", "", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MediaDetail {

    @Nullable
    private final ResultsAltTitles alternative_titles;

    @Nullable
    private final String backdropPath;

    @Nullable
    private final Credits credits;

    @Nullable
    private final ExternalIds external_ids;

    @Nullable
    private final String firstAirDate;

    @Nullable
    private final ArrayList<Genres> genres;

    @Nullable
    private final Integer id;

    @Nullable
    private final String imdbId;

    @Nullable
    private final KeywordResults keywords;

    @Nullable
    private final LastEpisodeToAir last_episode_to_air;

    @Nullable
    private final String name;

    @Nullable
    private final String originalName;

    @Nullable
    private final String originalTitle;

    @Nullable
    private final String original_language;

    @Nullable
    private final String overview;

    @Nullable
    private final String posterPath;

    @Nullable
    private final ArrayList<ProductionCountries> production_countries;

    @Nullable
    private final ResultsRecommendations recommendations;

    @Nullable
    private final String releaseDate;

    @Nullable
    private final Integer runtime;

    @Nullable
    private final ArrayList<Seasons> seasons;

    @Nullable
    private final String status;

    @Nullable
    private final String title;

    @Nullable
    private final ResultsTrailer videos;

    @Nullable
    private final Object vote_average;

    public MediaDetail() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MediaDetail copy$default(MediaDetail mediaDetail, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num2, Object obj, String str11, String str12, ArrayList arrayList, KeywordResults keywordResults, LastEpisodeToAir lastEpisodeToAir, ArrayList arrayList2, ResultsTrailer resultsTrailer, ExternalIds externalIds, Credits credits, ResultsRecommendations resultsRecommendations, ResultsAltTitles resultsAltTitles, ArrayList arrayList3, int i, Object obj2) {
        ArrayList arrayList4;
        ResultsAltTitles resultsAltTitles2;
        Integer num3 = (i & 1) != 0 ? mediaDetail.id : num;
        String str13 = (i & 2) != 0 ? mediaDetail.imdbId : str;
        String str14 = (i & 4) != 0 ? mediaDetail.title : str2;
        String str15 = (i & 8) != 0 ? mediaDetail.name : str3;
        String str16 = (i & 16) != 0 ? mediaDetail.originalTitle : str4;
        String str17 = (i & 32) != 0 ? mediaDetail.originalName : str5;
        String str18 = (i & 64) != 0 ? mediaDetail.posterPath : str6;
        String str19 = (i & 128) != 0 ? mediaDetail.backdropPath : str7;
        String str20 = (i & 256) != 0 ? mediaDetail.releaseDate : str8;
        String str21 = (i & 512) != 0 ? mediaDetail.firstAirDate : str9;
        String str22 = (i & 1024) != 0 ? mediaDetail.overview : str10;
        Integer num4 = (i & 2048) != 0 ? mediaDetail.runtime : num2;
        Object obj3 = (i & 4096) != 0 ? mediaDetail.vote_average : obj;
        String str23 = (i & 8192) != 0 ? mediaDetail.original_language : str11;
        Integer num5 = num3;
        String str24 = (i & 16384) != 0 ? mediaDetail.status : str12;
        ArrayList arrayList5 = (i & 32768) != 0 ? mediaDetail.genres : arrayList;
        KeywordResults keywordResults2 = (i & 65536) != 0 ? mediaDetail.keywords : keywordResults;
        LastEpisodeToAir lastEpisodeToAir2 = (i & 131072) != 0 ? mediaDetail.last_episode_to_air : lastEpisodeToAir;
        ArrayList arrayList6 = (i & 262144) != 0 ? mediaDetail.seasons : arrayList2;
        ResultsTrailer resultsTrailer2 = (i & 524288) != 0 ? mediaDetail.videos : resultsTrailer;
        ExternalIds externalIds2 = (i & 1048576) != 0 ? mediaDetail.external_ids : externalIds;
        Credits credits2 = (i & 2097152) != 0 ? mediaDetail.credits : credits;
        ResultsRecommendations resultsRecommendations2 = (i & 4194304) != 0 ? mediaDetail.recommendations : resultsRecommendations;
        ResultsAltTitles resultsAltTitles3 = (i & 8388608) != 0 ? mediaDetail.alternative_titles : resultsAltTitles;
        if ((i & 16777216) != 0) {
            resultsAltTitles2 = resultsAltTitles3;
            arrayList4 = mediaDetail.production_countries;
        } else {
            arrayList4 = arrayList3;
            resultsAltTitles2 = resultsAltTitles3;
        }
        return mediaDetail.copy(num5, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, num4, obj3, str23, str24, arrayList5, keywordResults2, lastEpisodeToAir2, arrayList6, resultsTrailer2, externalIds2, credits2, resultsRecommendations2, resultsAltTitles2, arrayList4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getFirstAirDate() {
        return this.firstAirDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Object getVote_average() {
        return this.vote_average;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getOriginal_language() {
        return this.original_language;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final ArrayList<Genres> component16() {
        return this.genres;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final KeywordResults getKeywords() {
        return this.keywords;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final LastEpisodeToAir getLast_episode_to_air() {
        return this.last_episode_to_air;
    }

    @Nullable
    public final ArrayList<Seasons> component19() {
        return this.seasons;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final ResultsTrailer getVideos() {
        return this.videos;
    }

    @Nullable
    /* JADX INFO: renamed from: component21, reason: from getter */
    public final ExternalIds getExternal_ids() {
        return this.external_ids;
    }

    @Nullable
    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Credits getCredits() {
        return this.credits;
    }

    @Nullable
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final ResultsRecommendations getRecommendations() {
        return this.recommendations;
    }

    @Nullable
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final ResultsAltTitles getAlternative_titles() {
        return this.alternative_titles;
    }

    @Nullable
    public final ArrayList<ProductionCountries> component25() {
        return this.production_countries;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOriginalName() {
        return this.originalName;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBackdropPath() {
        return this.backdropPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @NotNull
    public final MediaDetail copy(@Nullable Integer id, @Nullable String imdbId, @Nullable String title, @Nullable String name, @Nullable String originalTitle, @Nullable String originalName, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String releaseDate, @Nullable String firstAirDate, @Nullable String overview, @Nullable Integer runtime, @Nullable Object vote_average, @Nullable String original_language, @Nullable String status, @Nullable ArrayList<Genres> genres, @Nullable KeywordResults keywords, @Nullable LastEpisodeToAir last_episode_to_air, @Nullable ArrayList<Seasons> seasons, @Nullable ResultsTrailer videos, @Nullable ExternalIds external_ids, @Nullable Credits credits, @Nullable ResultsRecommendations recommendations, @Nullable ResultsAltTitles alternative_titles, @Nullable ArrayList<ProductionCountries> production_countries) {
        return new MediaDetail(id, imdbId, title, name, originalTitle, originalName, posterPath, backdropPath, releaseDate, firstAirDate, overview, runtime, vote_average, original_language, status, genres, keywords, last_episode_to_air, seasons, videos, external_ids, credits, recommendations, alternative_titles, production_countries);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaDetail)) {
            return false;
        }
        MediaDetail mediaDetail = (MediaDetail) other;
        return Intrinsics.areEqual(this.id, mediaDetail.id) && Intrinsics.areEqual(this.imdbId, mediaDetail.imdbId) && Intrinsics.areEqual(this.title, mediaDetail.title) && Intrinsics.areEqual(this.name, mediaDetail.name) && Intrinsics.areEqual(this.originalTitle, mediaDetail.originalTitle) && Intrinsics.areEqual(this.originalName, mediaDetail.originalName) && Intrinsics.areEqual(this.posterPath, mediaDetail.posterPath) && Intrinsics.areEqual(this.backdropPath, mediaDetail.backdropPath) && Intrinsics.areEqual(this.releaseDate, mediaDetail.releaseDate) && Intrinsics.areEqual(this.firstAirDate, mediaDetail.firstAirDate) && Intrinsics.areEqual(this.overview, mediaDetail.overview) && Intrinsics.areEqual(this.runtime, mediaDetail.runtime) && Intrinsics.areEqual(this.vote_average, mediaDetail.vote_average) && Intrinsics.areEqual(this.original_language, mediaDetail.original_language) && Intrinsics.areEqual(this.status, mediaDetail.status) && Intrinsics.areEqual(this.genres, mediaDetail.genres) && Intrinsics.areEqual(this.keywords, mediaDetail.keywords) && Intrinsics.areEqual(this.last_episode_to_air, mediaDetail.last_episode_to_air) && Intrinsics.areEqual(this.seasons, mediaDetail.seasons) && Intrinsics.areEqual(this.videos, mediaDetail.videos) && Intrinsics.areEqual(this.external_ids, mediaDetail.external_ids) && Intrinsics.areEqual(this.credits, mediaDetail.credits) && Intrinsics.areEqual(this.recommendations, mediaDetail.recommendations) && Intrinsics.areEqual(this.alternative_titles, mediaDetail.alternative_titles) && Intrinsics.areEqual(this.production_countries, mediaDetail.production_countries);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.backdropPath == null ? 0 : this.backdropPath.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.firstAirDate == null ? 0 : this.firstAirDate.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.vote_average == null ? 0 : this.vote_average.hashCode())) * 31) + (this.original_language == null ? 0 : this.original_language.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.keywords == null ? 0 : this.keywords.hashCode())) * 31) + (this.last_episode_to_air == null ? 0 : this.last_episode_to_air.hashCode())) * 31) + (this.seasons == null ? 0 : this.seasons.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.external_ids == null ? 0 : this.external_ids.hashCode())) * 31) + (this.credits == null ? 0 : this.credits.hashCode())) * 31) + (this.recommendations == null ? 0 : this.recommendations.hashCode())) * 31) + (this.alternative_titles == null ? 0 : this.alternative_titles.hashCode())) * 31) + (this.production_countries != null ? this.production_countries.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaDetail(id=").append(this.id).append(", imdbId=").append(this.imdbId).append(", title=").append(this.title).append(", name=").append(this.name).append(", originalTitle=").append(this.originalTitle).append(", originalName=").append(this.originalName).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", releaseDate=").append(this.releaseDate).append(", firstAirDate=").append(this.firstAirDate).append(", overview=").append(this.overview).append(", runtime=");
        sb.append(this.runtime).append(", vote_average=").append(this.vote_average).append(", original_language=").append(this.original_language).append(", status=").append(this.status).append(", genres=").append(this.genres).append(", keywords=").append(this.keywords).append(", last_episode_to_air=").append(this.last_episode_to_air).append(", seasons=").append(this.seasons).append(", videos=").append(this.videos).append(", external_ids=").append(this.external_ids).append(", credits=").append(this.credits).append(", recommendations=").append(this.recommendations);
        sb.append(", alternative_titles=").append(this.alternative_titles).append(", production_countries=").append(this.production_countries).append(')');
        return sb.toString();
    }

    public MediaDetail(@Nullable Integer id, @Nullable String imdbId, @Nullable String title, @Nullable String name, @Nullable String originalTitle, @Nullable String originalName, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String releaseDate, @Nullable String firstAirDate, @Nullable String overview, @Nullable Integer runtime, @Nullable Object vote_average, @Nullable String original_language, @Nullable String status, @Nullable ArrayList<Genres> arrayList, @Nullable KeywordResults keywords, @Nullable LastEpisodeToAir last_episode_to_air, @Nullable ArrayList<Seasons> arrayList2, @Nullable ResultsTrailer videos, @Nullable ExternalIds external_ids, @Nullable Credits credits, @Nullable ResultsRecommendations recommendations, @Nullable ResultsAltTitles alternative_titles, @Nullable ArrayList<ProductionCountries> arrayList3) {
        this.id = id;
        this.imdbId = imdbId;
        this.title = title;
        this.name = name;
        this.originalTitle = originalTitle;
        this.originalName = originalName;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.releaseDate = releaseDate;
        this.firstAirDate = firstAirDate;
        this.overview = overview;
        this.runtime = runtime;
        this.vote_average = vote_average;
        this.original_language = original_language;
        this.status = status;
        this.genres = arrayList;
        this.keywords = keywords;
        this.last_episode_to_air = last_episode_to_air;
        this.seasons = arrayList2;
        this.videos = videos;
        this.external_ids = external_ids;
        this.credits = credits;
        this.recommendations = recommendations;
        this.alternative_titles = alternative_titles;
        this.production_countries = arrayList3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MediaDetail(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num2, Object obj, String str11, String str12, ArrayList arrayList, KeywordResults keywordResults, LastEpisodeToAir lastEpisodeToAir, ArrayList arrayList2, ResultsTrailer resultsTrailer, ExternalIds externalIds, Credits credits, ResultsRecommendations resultsRecommendations, ResultsAltTitles resultsAltTitles, ArrayList arrayList3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Integer num3 = (i & 1) != 0 ? null : num;
        String str13 = (i & 2) != 0 ? null : str;
        String str14 = (i & 4) != 0 ? null : str2;
        String str15 = (i & 8) != 0 ? null : str3;
        String str16 = (i & 16) != 0 ? null : str4;
        String str17 = (i & 32) != 0 ? null : str5;
        String str18 = (i & 64) != 0 ? null : str6;
        String str19 = (i & 128) != 0 ? null : str7;
        String str20 = (i & 256) != 0 ? null : str8;
        String str21 = (i & 512) != 0 ? null : str9;
        String str22 = (i & 1024) != 0 ? null : str10;
        Integer num4 = (i & 2048) != 0 ? null : num2;
        Object obj2 = (i & 4096) != 0 ? null : obj;
        String str23 = (i & 8192) != 0 ? null : str11;
        String str24 = (i & 16384) != 0 ? null : str12;
        this(num3, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, num4, obj2, str23, str24, (i & 32768) != 0 ? new ArrayList() : arrayList, (i & 65536) != 0 ? null : keywordResults, (i & 131072) != 0 ? null : lastEpisodeToAir, (i & 262144) != 0 ? new ArrayList() : arrayList2, (i & 524288) != 0 ? null : resultsTrailer, (i & 1048576) != 0 ? null : externalIds, (i & 2097152) != 0 ? null : credits, (i & 4194304) != 0 ? null : resultsRecommendations, (i & 8388608) != 0 ? null : resultsAltTitles, (i & 16777216) != 0 ? new ArrayList() : arrayList3);
    }

    @JsonProperty("id")
    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @JsonProperty("imdb_id")
    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }

    @JsonProperty("title")
    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @JsonProperty("name")
    @Nullable
    public final String getName() {
        return this.name;
    }

    @JsonProperty("original_title")
    @Nullable
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @JsonProperty("original_name")
    @Nullable
    public final String getOriginalName() {
        return this.originalName;
    }

    @JsonProperty("poster_path")
    @Nullable
    public final String getPosterPath() {
        return this.posterPath;
    }

    @JsonProperty("backdrop_path")
    @Nullable
    public final String getBackdropPath() {
        return this.backdropPath;
    }

    @JsonProperty("release_date")
    @Nullable
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @JsonProperty("first_air_date")
    @Nullable
    public final String getFirstAirDate() {
        return this.firstAirDate;
    }

    @JsonProperty("overview")
    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @JsonProperty("runtime")
    @Nullable
    public final Integer getRuntime() {
        return this.runtime;
    }

    @JsonProperty("vote_average")
    @Nullable
    public final Object getVote_average() {
        return this.vote_average;
    }

    @JsonProperty("original_language")
    @Nullable
    public final String getOriginal_language() {
        return this.original_language;
    }

    @JsonProperty("status")
    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @JsonProperty("genres")
    @Nullable
    public final ArrayList<Genres> getGenres() {
        return this.genres;
    }

    @JsonProperty("keywords")
    @Nullable
    public final KeywordResults getKeywords() {
        return this.keywords;
    }

    @JsonProperty("last_episode_to_air")
    @Nullable
    public final LastEpisodeToAir getLast_episode_to_air() {
        return this.last_episode_to_air;
    }

    @JsonProperty("seasons")
    @Nullable
    public final ArrayList<Seasons> getSeasons() {
        return this.seasons;
    }

    @JsonProperty("videos")
    @Nullable
    public final ResultsTrailer getVideos() {
        return this.videos;
    }

    @JsonProperty("external_ids")
    @Nullable
    public final ExternalIds getExternal_ids() {
        return this.external_ids;
    }

    @JsonProperty("credits")
    @Nullable
    public final Credits getCredits() {
        return this.credits;
    }

    @JsonProperty("recommendations")
    @Nullable
    public final ResultsRecommendations getRecommendations() {
        return this.recommendations;
    }

    @JsonProperty("alternative_titles")
    @Nullable
    public final ResultsAltTitles getAlternative_titles() {
        return this.alternative_titles;
    }

    @JsonProperty("production_countries")
    @Nullable
    public final ArrayList<ProductionCountries> getProduction_countries() {
        return this.production_countries;
    }
}
